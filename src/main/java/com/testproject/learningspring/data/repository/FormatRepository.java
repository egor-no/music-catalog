package com.testproject.learningspring.data.repository;
import com.testproject.learningspring.data.entity.Format;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormatRepository extends CrudRepository<Format, Long>  {

    Iterable<Format> findAllByLabel(String label);

    Iterable<Format> findAllByAlbumId(Long AlbumId);

}
