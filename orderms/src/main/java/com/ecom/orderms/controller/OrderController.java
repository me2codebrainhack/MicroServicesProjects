package com.ecom.orderms.controller;

import com.ecom.orderms.model.Order;
import com.ecom.orderms.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(name="/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/getOrderDetails")
    public Order getOrderDetails(int id){
        Order orderDetails = orderService.getOrderDetails(id);
        return orderDetails;
    }

    @PostMapping("/createOrder")
    public Order createOrder(@RequestBody Order order){
        Order setOrder;
        setOrder = orderService.createOrder(order);
        return setOrder;
    }

}
