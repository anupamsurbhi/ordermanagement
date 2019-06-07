package org.fastspring.pizza.app.ordermanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.fastspring.pizza.app.ordermanagement.AppConstants;
import org.fastspring.pizza.app.ordermanagement.AppConstants.*;
import org.fastspring.pizza.app.ordermanagement.DAO.DealsDAO;
import org.fastspring.pizza.app.ordermanagement.DAO.OrdersDAO;
import org.fastspring.pizza.app.ordermanagement.DAO.PizzaDAO;
import org.fastspring.pizza.app.ordermanagement.DAO.ToppingsDAO;
import org.fastspring.pizza.app.ordermanagement.model.Deals;
import org.fastspring.pizza.app.ordermanagement.model.Orders;
import org.fastspring.pizza.app.ordermanagement.model.Pizza;
import org.fastspring.pizza.app.ordermanagement.model.Toppings;
import org.fastspring.pizza.app.ordermanagement.request.OrderRequest;
import org.fastspring.pizza.app.ordermanagement.request.RequestPizza;
import org.fastspring.pizza.app.ordermanagement.request.RequestToppings;
import org.fastspring.pizza.app.ordermanagement.response.OrderResponse;
import org.fastspring.pizza.app.ordermanagement.response.ResponsePizza;
import org.fastspring.pizza.app.ordermanagement.response.ResponseToppings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersService {

	@Autowired
	AppConstants appConstant;
	
	@Autowired
	OrdersDAO ordersDAO;

	@Autowired
	ToppingsDAO toppingsDAO;

	@Autowired
	List<ResponseToppings> pizzaTopping;

	@Autowired
	PizzaDAO pizzaDAO;

	@Autowired
	DealsDAO dealsDAO;
	
	@Autowired
	Deals deal;

	@Autowired
	Toppings topping;

	@Autowired
	Orders inOrder;

	@Autowired
	Pizza pizza;

	@Autowired
	OrderResponse orderResponse;

	public List<Orders> getOrders() {
		return ordersDAO.getOrders();
	}

	@SuppressWarnings("null")
	public OrderResponse placeOrder(OrderRequest orderreq) {

		Double toppingsSum = 0.0;
		Double totalBefore = 0.0;
		Double dealDiscount = 0.0;
		List<ResponsePizza> PizzaOut = new ArrayList<ResponsePizza>();
		for (RequestPizza pizza : orderreq.getPizza()) {

			pizzaTopping = toppingPriceCalc(pizza.getTopping());
			toppingsSum = pizzaTopping.stream().map(x -> x.getToppingPrice()).reduce((double) 0, Double::sum);
			ResponsePizza myPizza = pizzaPriceCalc(pizza);
			myPizza.setTopping(pizzaTopping);
			myPizza.setToppingCostForPizza(toppingsSum);
			myPizza.setTotalPizzaCost(toppingsSum + myPizza.getPizzaCost());
			totalBefore += myPizza.getTotalPizzaCost();
			PizzaOut.add(myPizza);
		}
		inOrder.setBeforeDiscount(totalBefore);
		inOrder.setDealCode(orderreq.getDealcode());
		deal = dealsDAO.getDealsByCode(orderreq.getDealcode());
		Double dealPercent = deal.getPercent();
		dealDiscount = totalBefore * dealPercent * appConstant.percent;
		inOrder.setDiscount(dealDiscount);
		inOrder.setFinalAmount(totalBefore - dealDiscount);
		inOrder.setFirstName(orderreq.getFirstName());
		inOrder.setLastName(orderreq.getLastName());
		inOrder.setOrderNumber(ordersDAO.getNextOrderNum() + 1);

		orderResponse.setPizzasInOrder(PizzaOut);
		orderResponse.setDiscountAmount(dealDiscount);
		orderResponse.setDealDescription(deal.getDescription());
		orderResponse.setDiscountPercent(dealPercent);
		orderResponse.setTotalBeforeDiscount(totalBefore);
		orderResponse.setFinalBillAmount(totalBefore - dealDiscount);
		orderResponse.setFirstName(orderreq.getFirstName());
		orderResponse.setLastName(orderreq.getLastName());
		ordersDAO.insertOrder(inOrder);

		return orderResponse;
	}

	@SuppressWarnings("null")
	public ResponsePizza pizzaPriceCalc(RequestPizza inPizza) {
		pizza = pizzaDAO.preparePizza(inPizza.getPizzaCode());
		ResponsePizza myPizza = new ResponsePizza(pizza.getCode(), pizza.getDescription(), null, pizza.getPrice(), 0.00,
				0.00);
		return myPizza;
	}

	@SuppressWarnings("null")
	public List<ResponseToppings> toppingPriceCalc(List<RequestToppings> toppings) {
		List<ResponseToppings> pizzaToppings = new ArrayList<ResponseToppings>();
		Double totalToppings = 0.00;
		for (RequestToppings t1 : toppings) {
			topping = toppingsDAO.addToppingToPizza(t1.getToppingcode());
			ResponseToppings toppingTemp = new ResponseToppings(topping.getCode(), topping.getDescription(),
					topping.getPrice());
			pizzaToppings.add(toppingTemp);
			totalToppings += topping.getPrice();
		}
		return pizzaToppings;
	}

}