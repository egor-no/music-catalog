package com.testproject.learningspring.business.service;

import com.testproject.learningspring.business.domain.ArtistDAO;
import com.testproject.learningspring.data.entity.Artist;
import com.testproject.learningspring.data.repository.AlbumRepository;
import com.testproject.learningspring.data.repository.ArtistRepository;
import com.testproject.learningspring.data.repository.FormatRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArtistService {

    private final ArtistRepository artistRepository;
    public final AlbumRepository albumRepository;
    public final FormatRepository formatRepository;

    public ArtistService(ArtistRepository artistRepository, AlbumRepository albumRepository, FormatRepository formatRepository) {
        this.artistRepository = artistRepository;
        this.albumRepository = albumRepository;
        this.formatRepository = formatRepository;
    }

    public List<ArtistDAO> getArtistsInfo(Long artistId) {
        List<ArtistDAO> artists = new ArrayList<>();
        Iterable<Artist> source;
        if (artistId!=null) {
            List<Long> templist = new ArrayList<>();
            templist.add(artistId);
            source = artistRepository.findAllById(templist);
        } else
            source = artistRepository.findAll();
        source.forEach(artist -> {
            artists.add(makeDAO(artist));
        });
        return artists;
    }

    private ArtistDAO makeDAO (Artist artist) {
        ArtistDAO artistDAO = new ArtistDAO();
        artistDAO.setBio(artist.getBio());
        artistDAO.setCountry(artist.getCountry());
        artistDAO.setName(artist.getName());
        return artistDAO;
    }

}
