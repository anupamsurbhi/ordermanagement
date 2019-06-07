package org.fastspring.pizza.app.ordermanagement.response;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class ResponseToppings {

	private Integer toppingCode;
	private String description; 
	private Double toppingPrice;
	
}
