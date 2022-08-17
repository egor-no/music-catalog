package com.testproject.learningspring.data.repository;

import com.testproject.learningspring.data.entity.Order;
import com.testproject.learningspring.data.entity.OrderItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemsRepository extends CrudRepository<OrderItem, Long>  {

    Iterable<OrderItem> findOrderItemsByOrderId(Long orderId);

}
