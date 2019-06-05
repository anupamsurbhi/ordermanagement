package org.fastspring.pizza.app.ordermanagement.controller;

import java.io.InvalidClassException;

import org.fastspring.pizza.app.ordermanagement.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class OrderStatus {

	@Autowired
	Order order;

	@RequestMapping(value = "/getorderstatus", method = RequestMethod.GET, consumes = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
					MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })

	public Order addItemsToRegistry() throws InvalidClassException {

		return order;

	}
}
