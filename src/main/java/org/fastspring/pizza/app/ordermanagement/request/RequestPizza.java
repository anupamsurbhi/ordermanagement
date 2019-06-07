package org.fastspring.pizza.app.ordermanagement.request;

import java.util.List;

import lombok.Data;

@Data
public class RequestPizza {
	
	private Integer pizzaCode;
	private List<RequestToppings> topping;

}
