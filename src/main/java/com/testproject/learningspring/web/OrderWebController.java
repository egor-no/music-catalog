package com.testproject.learningspring.web;

import com.testproject.learningspring.business.domain.OrderDAO;
import com.testproject.learningspring.business.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderWebController {

    private final OrderService orderService;

    @Autowired
    public OrderWebController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public String getOrders(@RequestParam(value="clientId", required = true)Long clientId, Model model) {
        List<OrderDAO> orders = this.orderService.getOrderForClient(clientId);
        model.addAttribute("orders", orders);
        return "orders";
    }
}
