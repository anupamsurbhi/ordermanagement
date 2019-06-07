package org.fastspring.pizza.app.ordermanagement.controller;

import java.io.InvalidClassException;
import java.sql.Date;
import java.util.List;

import org.fastspring.pizza.app.ordermanagement.model.Deals;
import org.fastspring.pizza.app.ordermanagement.model.Orders;
import org.fastspring.pizza.app.ordermanagement.model.Pizza;
import org.fastspring.pizza.app.ordermanagement.model.Toppings;
import org.fastspring.pizza.app.ordermanagement.service.ManageService;
import org.fastspring.pizza.app.ordermanagement.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(description = "Managed Operations - Add topping, pizza /Update inventory")
@RequestMapping("/manage")
public class ManagerAPI {

	@Autowired
	Deals deal;

	@Autowired
	Pizza pizza;

	@Autowired
	Toppings topping;

	@Autowired
	ManageService manageService;

	@ApiOperation(value = "get all pizza")
	@RequestMapping(value = "/getpizza", method = RequestMethod.GET, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Pizza> getPizza() {
		return manageService.getPizza();
	}

	@ApiOperation(value = "add pizza")
	@RequestMapping(value = "/addpizza", method = RequestMethod.PUT, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public Pizza addPizza(@RequestParam String description, @RequestParam Double price,
			@RequestParam Integer inventory) {

		pizza.setDescription(description);
		pizza.setInventory(inventory);
		pizza.setPrice(price);

		return manageService.addPizza(pizza);
	}

	@ApiOperation(value = "get all toppings")
	@RequestMapping(value = "/gettoppings", method = RequestMethod.GET, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Toppings> getToppings() {
		return manageService.getToppings();
	}

	@ApiOperation(value = "add toppings")
	@RequestMapping(value = "/addtoppings", method = RequestMethod.PUT, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public Toppings addToppings(@RequestParam String description, @RequestParam Double price,
			@RequestParam Integer inventory) {

		topping.setDescription(description);
		topping.setInventory(inventory);
		topping.setPrice(price);

		return manageService.addTopping(topping);
	}

	@SuppressWarnings("deprecation")
	@ApiOperation(value = "get all deals")
	@RequestMapping(value = "/getdeals", method = RequestMethod.GET, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Deals> getDeals() throws InvalidClassException {
		return manageService.getDeals();
	}
}
