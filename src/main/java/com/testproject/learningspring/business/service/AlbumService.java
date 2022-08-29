package com.testproject.learningspring.business.service;

import com.testproject.learningspring.business.domain.AlbumDAO;
import com.testproject.learningspring.data.entity.Album;
import com.testproject.learningspring.data.repository.AlbumRepository;
import com.testproject.learningspring.data.repository.ArtistRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlbumService {

    private final AlbumRepository albumRepository;
    private final ArtistRepository artistRepository;
    private final CatalogService catalogService;

    public AlbumService(AlbumRepository albumRepository, ArtistRepository artistRepository, CatalogService catalogService) {
        this.albumRepository = albumRepository;
        this.artistRepository = artistRepository;
        this.catalogService = catalogService;
    }

    public List<AlbumDAO> getAlbums(Long albumId) {
        List<AlbumDAO> target = new ArrayList<>();
        Iterable<Album> source;
        if (albumId != null)
            source = albumRepository.getAlbumsByAlbumId(albumId);
        else
            source = albumRepository.findAll();
        source.forEach(album -> {
            target.add(makeDAO(album));
        });
        return target;
    }

    private AlbumDAO makeDAO(Album album) {
        AlbumDAO albumDAO = new AlbumDAO();
        albumDAO.setArtist(artistRepository.findById(album.getArtistID()).get().getName());
        albumDAO.setYear(album.getYear());
        albumDAO.setInfo(album.getInfo());
        albumDAO.setName(album.getTitle());
        albumDAO.setAlbumId(album.getAlbumId());
        albumDAO.setItems(catalogService.getCatalog(null, null, album.getAlbumId()));
        return albumDAO;
    }
}