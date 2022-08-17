package com.testproject.learningspring.data.repository;


import com.testproject.learningspring.data.entity.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository  extends CrudRepository<Order, Long> {

    Iterable<Order> findOrderByClientId(Long clientID);
}
