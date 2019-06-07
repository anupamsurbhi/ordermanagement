package org.fastspring.pizza.app.ordermanagement.service;

import java.util.List;

import org.fastspring.pizza.app.ordermanagement.DAO.DealsDAO;
import org.fastspring.pizza.app.ordermanagement.DAO.OrdersDAO;
import org.fastspring.pizza.app.ordermanagement.DAO.PizzaDAO;
import org.fastspring.pizza.app.ordermanagement.DAO.ToppingsDAO;
import org.fastspring.pizza.app.ordermanagement.model.Orders;
import org.fastspring.pizza.app.ordermanagement.model.Toppings;
import org.fastspring.pizza.app.ordermanagement.request.OrderRequest;
import org.fastspring.pizza.app.ordermanagement.request.RequestPizza;
import org.fastspring.pizza.app.ordermanagement.request.RequestToppings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersService {

	@Autowired
	OrdersDAO ordersDAO;

	@Autowired
	ToppingsDAO toppingsDAO;

	@Autowired
	PizzaDAO pizzaDAO;

	@Autowired
	DealsDAO dealsDAO;

	@Autowired
	Toppings topping;

	@Autowired
	Orders inOrder;

	public List<Orders> getOrders() {
		return ordersDAO.getOrders();
	}

	@SuppressWarnings("null")
	public Orders placeOrder(OrderRequest orderreq) {

		Double toppingsSum = 0.0;
		Double pizzaSum = 0.0;
		Double totalBefore = 0.0;
		Double dealDiscount = 0.0;
		for (RequestPizza pizza : orderreq.getPizza()) {

			pizzaSum += pizzaDAO.getPizzaPrice(pizza.getPizzaCode()).getPrice();
			toppingsSum += toppingPriceCalc(pizza.getTopping());
		}
		totalBefore = pizzaSum + toppingsSum;
		inOrder.setBeforeDiscount(totalBefore);
		inOrder.setDealCode(orderreq.getDealcode());
		dealDiscount = totalBefore * dealsDAO.getDealsByCode(orderreq.getDealcode()).getPercent() *0.01;
		inOrder.setDiscount(dealDiscount);
		inOrder.setFinalAmount(totalBefore - dealDiscount);
		inOrder.setFirstName(orderreq.getFirstName());
		inOrder.setLastName(orderreq.getLastName());
		inOrder.setOrderNumber(ordersDAO.getNextOrderNum()+1);
		return ordersDAO.insertOrder(inOrder);
	}

	@SuppressWarnings("null")
	public Double toppingPriceCalc(List<RequestToppings> toppings) {
		Double totalToppings = 0.00;
		for (RequestToppings t1 : toppings) {
			totalToppings += toppingsDAO.getTopping(t1.getToppingcode()).getPrice();

		}
		return totalToppings;
	}

}