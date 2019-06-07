package org.fastspring.pizza.app.ordermanagement.service;

import java.util.List;

import org.fastspring.pizza.app.ordermanagement.DAO.DealsDAO;
import org.fastspring.pizza.app.ordermanagement.DAO.OrdersDAO;
import org.fastspring.pizza.app.ordermanagement.DAO.PizzaDAO;
import org.fastspring.pizza.app.ordermanagement.DAO.ToppingsDAO;
import org.fastspring.pizza.app.ordermanagement.model.Deals;
import org.fastspring.pizza.app.ordermanagement.model.Orders;
import org.fastspring.pizza.app.ordermanagement.model.Pizza;
import org.fastspring.pizza.app.ordermanagement.model.Toppings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManageService {

	@Autowired
	PizzaDAO pizzaDAO;

	@Autowired
	ToppingsDAO toppingsDAO;

	@Autowired
	DealsDAO dealsDAO;

	public List<Toppings> getToppings() {
		return toppingsDAO.getToppings();
	}

	public Toppings addTopping(Toppings inTopping) {
		inTopping.setCode(toppingsDAO.maxToppingCode() + 1);
		return toppingsDAO.addTopping(inTopping);
	}

	public List<Deals> getDeals() {
		return dealsDAO.getDeals();
	}

	public List<Pizza> getPizza() {
		return pizzaDAO.getPizza();
	}

	public Pizza addPizza(Pizza inPizza) {
		inPizza.setCode(pizzaDAO.maxPizzaCode() + 1);
		return pizzaDAO.addPizza(inPizza);
	}
}