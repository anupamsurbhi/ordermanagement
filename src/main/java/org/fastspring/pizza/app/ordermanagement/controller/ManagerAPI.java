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
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manage")
public class ManagerAPI {

	@Autowired
	Deals deal;
	
	@Autowired
	Toppings topping;
	
	@Autowired
	ManageService manageService;
	
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/getdeals", 
			method = RequestMethod.GET, 
			consumes = { MediaType.APPLICATION_JSON_VALUE, 
						 MediaType.APPLICATION_XML_VALUE }, 
			produces = { MediaType.APPLICATION_JSON_VALUE, 
					     MediaType.APPLICATION_XML_VALUE })
	public List<Deals> getDeals() throws InvalidClassException {
		return manageService.getDeals();
	}
	
	@RequestMapping(value = "/gettoppings", 
			method = RequestMethod.GET, 
			consumes = { MediaType.APPLICATION_JSON_VALUE, 
						 MediaType.APPLICATION_XML_VALUE }, 
			produces = { MediaType.APPLICATION_JSON_VALUE, 
					     MediaType.APPLICATION_XML_VALUE })
	public List<Toppings> getToppings()  {
		return manageService.getToppings();
	}
	
	@RequestMapping(value = "/getpizza", 
			method = RequestMethod.GET, 
			consumes = { MediaType.APPLICATION_JSON_VALUE, 
						 MediaType.APPLICATION_XML_VALUE }, 
			produces = { MediaType.APPLICATION_JSON_VALUE, 
					     MediaType.APPLICATION_XML_VALUE })
	public List<Pizza> getPizza()  {
		return manageService.getPizza();
	}
}
