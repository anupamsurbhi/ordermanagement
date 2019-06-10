package org.fastspring.pizza.app.ordermanagement.controller;

import java.io.InvalidClassException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
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
@Api("Managed Operations - Add topping, pizza /Update inventory")
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

	@ApiOperation(value = "add pizza")
	@RequestMapping(value = "/addpizza", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE })
	public Pizza addPizza(@RequestParam String description, @RequestParam Double price,
			@RequestParam Integer inventory) {

		pizza.setDescription(description);
		pizza.setInventory(inventory);
		pizza.setPrice(price);

		return manageService.addPizza(pizza);
	}

	@ApiOperation(value = "update pizza inv")
	@RequestMapping(value = "/updatepizzainv", method = RequestMethod.POST,  produces = { MediaType.APPLICATION_JSON_VALUE })
	public Pizza updatePizzaInv(@RequestParam Integer pizzacode, @RequestParam Integer inventory) {

		pizza.setInventory(inventory);
		pizza.setCode(pizzacode);

		return manageService.updatePizzaInv(pizza);
	}

	@ApiOperation(value = "add toppings")
	@RequestMapping(value = "/addtoppings", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE })
	public Toppings addToppings(@RequestParam String description, @RequestParam Double price,
			@RequestParam Integer inventory) {

		topping.setDescription(description);
		topping.setInventory(inventory);
		topping.setPrice(price);

		return manageService.addTopping(topping);
	}

	@ApiOperation(value = "update toppings inventory")
	@RequestMapping(value = "/updatetoppinginv", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public Toppings updateToppingInv(@RequestParam Integer ToppingCode, @RequestParam Integer inventory) {

		topping.setInventory(inventory);
		topping.setCode(ToppingCode);

		return manageService.updateToppingInv(topping);
	}

	@ApiOperation(value = "add deal")
	@RequestMapping(value = "/adddeal", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE })
	public Deals addDeal(@RequestParam String description, @RequestParam Double DealPercent,
			@RequestParam String StartDate, @RequestParam String EndDate) {

		deal.setDescription(description);
		deal.setDealstartdate(Date.valueOf(StartDate));
		deal.setDealenddate(Date.valueOf(EndDate));

		deal.setPercent(DealPercent);

		return manageService.addDeal(deal);
	}

}
