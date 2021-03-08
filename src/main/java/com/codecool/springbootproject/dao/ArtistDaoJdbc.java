package com.codecool.springbootproject.dao;

import com.codecool.springbootproject.model.SongModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("")
@Component
public class ArtistDaoJdbc implements ArtistDao {

    private static DataSource dataSource;
    private static ArtistDaoJdbc instance = null;

    @Autowired
    ArtistDaoJdbc(DataSource dataSource) {
        ArtistDaoJdbc.dataSource = dataSource;
    }

    public static ArtistDaoJdbc getInstance() {
        if (instance == null) {
            instance = new ArtistDaoJdbc(dataSource);
        }
        return instance;
    }

    @Override
    public List<SongModel> getArtistSongs(long id) {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "SELECT name, date, duration\n" +
                    "FROM\n" +
                    "  (SELECT song.name, song.date, song.duration, artist.id\n" +
                    "  FROM song\n" +
                    "  LEFT JOIN song_artist ON song.id = song_artist.song_id\n" +
                    "  LEFT JOIN artist ON artist.id = song_artist.artist_id)\n" +
                    "WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();
            List<SongModel> songList = new ArrayList<>();

            while (resultSet.next()){
                songList.add(new SongModel(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getDate("date"),
                        resultSet.getDouble("duration")));
            }
            return songList; // return supplierList with all suppliers
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
