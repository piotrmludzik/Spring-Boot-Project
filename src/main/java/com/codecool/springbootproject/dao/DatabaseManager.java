package com.codecool.springbootproject.dao;

import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.SQLException;

@Component
public class DatabaseManager {

    private final ArtistDao artistDao ;
    private final DataSource dataSource ;

    @Autowired
    public DatabaseManager(ArtistDao artistDao, DataSource dataSource) {
        this.artistDao = artistDao;
        this.dataSource = dataSource;
    }

    public void setup() throws SQLException {
        dataSource = connect();
    }

    private DataSource connect() throws SQLException {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        String dbName = System.getenv("PSQL_DB_NAME");
        String user = System.getenv("PSQL_USER_NAME");
        String password = System.getenv("PSQL_PASSWORD");

        dataSource.setDatabaseName(dbName);
        dataSource.setUser(user);
        dataSource.setPassword(password);

        System.out.println("Trying to connect");
        dataSource.getConnection().close();
        System.out.println("Connection ok.");

        return dataSource;
    }
}






