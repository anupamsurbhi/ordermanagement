package org.fastspring.pizza.app.ordermanagement.service;


import java.util.List;

import org.fastspring.pizza.app.ordermanagement.DAO.OrdersDAO;
import org.fastspring.pizza.app.ordermanagement.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrdersService {

	@Autowired
	OrdersDAO ordersDAO;

	public List<Orders> getOrders() {
		return ordersDAO.getOrders();
	}
	
	public Orders placeOrder(Orders order) {
		return ordersDAO.placeOrder(order);
	}

}