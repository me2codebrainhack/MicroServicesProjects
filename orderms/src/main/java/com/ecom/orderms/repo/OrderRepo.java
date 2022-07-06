package com.ecom.orderms.repo;

import com.ecom.orderms.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order,Integer> { }
