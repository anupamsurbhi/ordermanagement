package org.fastspring.pizza.app.ordermanagement.response;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@Data
@Component
@Scope("prototype")
@JsonRootName(value = "PizzaRecipt")
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderResponse {
	private String firstName;
	private String lastName;
	private List<ResponsePizza> pizzasInOrder;
	private Double totalBeforeDiscount;
	private Double discountPercent;
	private String dealDescription;
	private Double discountAmount;
	private Double finalBillAmount;

}
