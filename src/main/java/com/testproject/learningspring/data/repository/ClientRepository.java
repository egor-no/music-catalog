package com.testproject.learningspring.data.repository;

import com.testproject.learningspring.data.entity.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long>  {

    Iterable<Client> getClientByClientId(Long clientId);

}
