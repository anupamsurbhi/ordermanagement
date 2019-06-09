package org.fastspring.pizza.app.ordermanagement.controller;

import java.io.InvalidClassException;
import java.util.List;

import org.fastspring.pizza.app.ordermanagement.model.Orders;
import org.fastspring.pizza.app.ordermanagement.request.OrderRequest;
import org.fastspring.pizza.app.ordermanagement.response.OrderResponse;
import org.fastspring.pizza.app.ordermanagement.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderAPI {

	@Autowired
	Orders orders;

	@Autowired
	OrdersService ordersService;

	@RequestMapping(value = "/getallorders", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public List<Orders> getOrderStatus() throws InvalidClassException {
		return ordersService.getOrders();

	}

	@RequestMapping(value = "/placeorder", method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public OrderResponse placeOrder(@RequestBody OrderRequest order) {

		return ordersService.placeOrder(order);

	}
}
