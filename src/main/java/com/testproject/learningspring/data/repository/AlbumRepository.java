package com.testproject.learningspring.data.repository;
import com.testproject.learningspring.data.entity.Album;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends CrudRepository<Album, Long>  {

    Iterable<Album> getAlbumsByArtistID(Long artistId);

    Iterable<Album> getAlbumsByAlbumId(Long albumId);
}
