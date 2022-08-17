package com.testproject.learningspring.business.service;


import com.testproject.learningspring.business.domain.OrderDAO;
import com.testproject.learningspring.data.entity.Order;
import com.testproject.learningspring.data.entity.Client;
import com.testproject.learningspring.data.entity.OrderItem;
import com.testproject.learningspring.data.repository.ClientRepository;
import com.testproject.learningspring.data.repository.OrderItemsRepository;
import com.testproject.learningspring.data.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ClientRepository clientRepository;
    private final OrderItemsRepository itemsRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, ClientRepository clientRepository,
            OrderItemsRepository itemsRepostory) {
        this.orderRepository = orderRepository;
        this.clientRepository = clientRepository;
        this.itemsRepository = itemsRepostory;
    }

    public List<OrderDAO> getOrderForClient(Long clientID) {
        Iterable<Order> allorders = this.orderRepository.findOrderByClientId(clientID);
        List<OrderDAO> orders = new ArrayList<>();
        allorders.forEach(order -> {
            OrderDAO orderdomain = new OrderDAO();
            Client client = clientRepository.findById(clientID).get();
            orderdomain.setFirstName(client.getFirstName());
            orderdomain.setLastName(client.getLastName());
            orderdomain.setAddress(client.getAddress());
            Map<Long, Integer> items = new HashMap<>();
            Iterable<OrderItem> iterate = itemsRepository.findOrderItemsByOrderId(order.getOrderId());
            iterate.forEach(item -> {
                items.put(item.getFormatId(), item.getQuantity());
            });
            orderdomain.setItems(items);
            orders.add(orderdomain);
        });
        return orders;
    }
}
