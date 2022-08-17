package com.testproject.learningspring.business.service;

import com.testproject.learningspring.business.domain.CatalogItem;
import com.testproject.learningspring.data.entity.*;
import com.testproject.learningspring.data.repository.AlbumRepository;
import com.testproject.learningspring.data.repository.ArtistRepository;
import com.testproject.learningspring.data.repository.FormatRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CatalogService {

    private final AlbumRepository albumRepository;
    private final ArtistRepository artistRepository;
    private final FormatRepository formatRepository;

    public CatalogService(AlbumRepository albumRepository, ArtistRepository artistRepository, FormatRepository formatRepository) {
        this.albumRepository = albumRepository;
        this.artistRepository = artistRepository;
        this.formatRepository = formatRepository;
    }

    public List<CatalogItem> getCatalog(Long artistId, String label, Long albumId) {
        List<CatalogItem> catalog = new ArrayList<>();

        Iterable<Format> formats = null;

        if (label != null)
            formats = formatRepository.findAllByLabel(label);
        else if (albumId != null)
            formats = formatRepository.findAllByAlbumId(albumId);
        else
            formats = formatRepository.findAll();



        formats.forEach(format -> {
            Album parentAlbum = albumRepository.findById(format.getAlbumId()).get();
            if (artistId == null || artistId.equals(parentAlbum.getArtistID())) {
                CatalogItem item = new CatalogItem();
                item.setLabel(format.getLabel());
                item.setNotes(format.getNotes());
                item.setReleaseDate(format.getReleaseDate());
                item.setPrice(format.getPrice());
                item.setImg(format.getImg());
                item.setFormat(format.getFormat());

                item.setAlbumId(parentAlbum.getAlbumId());
                item.setAlbumName(parentAlbum.getTitle());
                item.setArtistId(parentAlbum.getArtistID());
                item.setArtistName(artistRepository.findById(parentAlbum.getArtistID()).get().getName());
                catalog.add(item);
            }
        });
        return catalog;
    }
}
