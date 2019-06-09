package org.fastspring.pizza.app.ordermanagement;

import org.fastspring.pizza.app.ordermanagement.model.Deals;
import org.fastspring.pizza.app.ordermanagement.model.Pizza;
import org.fastspring.pizza.app.ordermanagement.model.Toppings;
import org.springframework.beans.factory.annotation.Autowired;

public class TestHelper {
	
	@Autowired
	static Deals deal;

	@Autowired
	static Pizza pizza;

	@Autowired
	static Toppings topping;
	
	public static final Integer ITEM_ID_NORMAL_1 = 105439867;

	public static Pizza buildPizza() {
		return pizza;
	}

	public static Toppings buildTopping() {
		// TODO Auto-generated method stub
		return topping;
	}

	public static Deals buildDeal() {
		// TODO Auto-generated method stub
		return deal;
	}


}
