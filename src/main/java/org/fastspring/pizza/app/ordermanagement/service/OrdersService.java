package org.fastspring.pizza.app.ordermanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.fastspring.pizza.app.ordermanagement.constants.*;
import org.fastspring.pizza.app.ordermanagement.errorcodes.ErrorCodes;
import org.fastspring.pizza.app.ordermanagement.exceptions.OrderManagementException;
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
	ErrorCodes errors;

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
		return ordersDAO.getAllOrders();
	}

	@SuppressWarnings("null")
	public OrderResponse placeOrder(OrderRequest orderreq) {

		Double toppingsSum = 0.0;
		Double totalBefore = 0.0;
		Double dealDiscount = 0.0;
		List<ResponsePizza> PizzaOut = new ArrayList<ResponsePizza>();
		for (RequestPizza pizza : orderreq.getPizza()) {
			ResponsePizza myPizza = pizzaPriceCalc(pizza);
			if (myPizza.getPizzaErrorCode() == "SUCCESS") {
				if (pizza.getTopping() != null) {
				pizzaTopping = toppingPriceCalc(pizza.getTopping());
				toppingsSum = pizzaTopping.stream().map(x -> x.getToppingPrice()).reduce((double) 0, Double::sum);
				myPizza.setTopping(pizzaTopping);
				}
				myPizza.setToppingCostForPizza(toppingsSum);
				myPizza.setTotalPizzaCost(toppingsSum + myPizza.getPizzaCost()); 
				totalBefore += myPizza.getTotalPizzaCost();
			}
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
		pizza = pizzaDAO.getPizzaPrice(inPizza.getPizzaCode());
		ResponsePizza myPizza = null;
		if (pizza.getInventory() <= 0) {
			myPizza = new ResponsePizza(pizza.getCode(), pizza.getDescription(), null, 0.00, 0.00, 0.00,
					errors.pizzaErrorCode, errors.pizzaInvIssue);
		} else {
			myPizza = new ResponsePizza(pizza.getCode(), pizza.getDescription(), null, pizza.getPrice(), 0.00, 0.00,
					"SUCCESS", "SUCCESS");
			pizza.setInventory(pizza.getInventory()-1);
			pizzaDAO.updatePizzaInv(pizza);
		} 
		return myPizza;
	}

	@SuppressWarnings("null")
	public List<ResponseToppings> toppingPriceCalc(List<RequestToppings> toppings) {
		List<ResponseToppings> pizzaToppings = new ArrayList<ResponseToppings>();
		Double totalToppings = 0.00;
		ResponseToppings toppingTemp = null;

		for (RequestToppings t1 : toppings) {
			topping = toppingsDAO.getTopping(t1.getToppingcode());

			if (topping.getInventory() <= 0) {
				toppingTemp = new ResponseToppings(topping.getCode(), topping.getDescription(), 0.00,
						errors.toppingErrorCode, errors.toppingInvIssue);
			} else {
				toppingTemp = new ResponseToppings(topping.getCode(), topping.getDescription(), topping.getPrice(),
						"SUCCESS", "SUCCESS");
				topping = toppingsDAO.updateToppingInv(t1.getToppingcode(),topping.getInventory()-1);

			}

			pizzaToppings.add(toppingTemp);
			totalToppings += topping.getPrice();

		}

		return pizzaToppings;
	}

}