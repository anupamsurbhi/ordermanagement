package org.fastspring.pizza.app.ordermanagement.response;


import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class ResponsePizza {
	
	private Integer pizzaCode;
	private String pizzaDiscription;
	private List<ResponseToppings> topping;
	private Double pizzaCost;
	private Double toppingCostForPizza;
	private Double TotalPizzaCost;

}
