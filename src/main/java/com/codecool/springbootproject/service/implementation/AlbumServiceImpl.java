package com.codecool.springbootproject.service.implementation;

import com.codecool.springbootproject.model.Album;
import com.codecool.springbootproject.repository.AlbumRepository;
import com.codecool.springbootproject.service.AlbumService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class AlbumServiceImpl implements AlbumService {

    AlbumRepository albumRepository;

    @Autowired
    public AlbumServiceImpl(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public List<Album> findAllAlbums() {
        return (List<Album>) albumRepository.findAll();
    }

    @Override
    public Optional<Album> getAlbumById(int id) {
        return albumRepository.findById(id);
    }

    @Override
    public void deleteAlbumById(int id) {
        albumRepository.deleteById(id);
    }

    @Override
    public long getAlbumCount() {
        return albumRepository.count();
    }
}
