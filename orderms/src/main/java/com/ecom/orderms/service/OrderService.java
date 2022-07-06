package com.ecom.orderms.service;

import com.ecom.orderms.model.Order;
import com.ecom.orderms.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    public Order getOrderDetails(int id){
        List<Order> orderDetails = orderRepo.findAll();
        Order order = new Order();
        for(int i=0;i<orderDetails.size();i++){
            if(orderDetails.get(i).getId()==id){
                order = orderDetails.get(i);
                break;
            }
        }
        return order;
    }

    public Order createOrder(Order order){
        orderRepo.save(order);
        return order;
    }
}
