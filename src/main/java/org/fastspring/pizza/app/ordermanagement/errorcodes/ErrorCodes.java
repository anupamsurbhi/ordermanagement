package org.fastspring.pizza.app.ordermanagement.errorcodes;

import org.springframework.stereotype.Component;

@Component
public class ErrorCodes {

	public String toppingInvIssue = "Topping Inventory is low - Unable to fullfill";
	public String pizzaInvIssue = "Pizza Inventory is low - Unable to fullfill";

	public String toppingErrorCode = "ERR_TOP_1001";
	public String pizzaErrorCode = "ERR_PIZ_2001";

}
