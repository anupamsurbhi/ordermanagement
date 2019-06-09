package org.fastspring.pizza.app.ordermanagement.controller;

import java.io.InvalidClassException;
import java.util.List;

import org.fastspring.pizza.app.ordermanagement.model.Deals;
import org.fastspring.pizza.app.ordermanagement.model.Pizza;
import org.fastspring.pizza.app.ordermanagement.model.Toppings;
import org.fastspring.pizza.app.ordermanagement.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api("Inquiry Operations - get topping, pizza, deals  ")
@RequestMapping("/inquiry")
public class InquiryAPI {

	@Autowired
	Deals deal;

	@Autowired
	Pizza pizza;

	@Autowired
	Toppings topping;

	@Autowired
	ManageService manageService;

	@ApiOperation(value = "get all pizza")
	@RequestMapping(value = "/getallpizza", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Pizza> getPizza() {
		return manageService.getPizza();
	}

	@ApiOperation(value = "get all toppings")
	@RequestMapping(value = "/getalltoppings", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public List<Toppings> getToppings() {
		return manageService.getToppings();
	}

	@ApiOperation(value = "get all deals")
	@RequestMapping(value = "/getalldeals", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Deals> getDeals() throws InvalidClassException {
		return manageService.getDeals();
	}
}
