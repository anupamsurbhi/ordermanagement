package org.fastspring.pizza.app.ordermanagement.controller;

import java.io.InvalidClassException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.fastspring.pizza.app.ordermanagement.model.Orders;
import org.fastspring.pizza.app.ordermanagement.request.OrderRequest;
import org.fastspring.pizza.app.ordermanagement.request.RequestPizza;
import org.fastspring.pizza.app.ordermanagement.request.RequestToppings;
import org.fastspring.pizza.app.ordermanagement.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderAPI {

	@Autowired
	Orders orders;
	
	@Autowired
	OrdersService ordersService;
	
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/getorderstatus", 
			method = RequestMethod.GET, 
			consumes = { MediaType.APPLICATION_JSON_VALUE, 
						 MediaType.APPLICATION_XML_VALUE }, 
			produces = { MediaType.APPLICATION_JSON_VALUE, 
					     MediaType.APPLICATION_XML_VALUE })
	public List<Orders> getOrderStatus() throws InvalidClassException {
		return ordersService.getOrders();
	

	}
	
	@RequestMapping(value = "/placeorder", 
			method = RequestMethod.POST, 
			consumes = { MediaType.APPLICATION_JSON_VALUE, 
						 MediaType.APPLICATION_XML_VALUE }, 
			produces = { MediaType.APPLICATION_JSON_VALUE, 
					     MediaType.APPLICATION_XML_VALUE })
	public Orders placeOrder(@RequestBody OrderRequest order)  {

		return ordersService.placeOrder(order);
	

	}
}
