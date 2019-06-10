package org.fastspring.pizza.app.ordermanagement.NormalTestFlow;

import org.fastspring.pizza.app.ordermanagement.OrdermanagementApplication;
import org.fastspring.pizza.app.ordermanagement.model.Deals;
import org.fastspring.pizza.app.ordermanagement.model.Pizza;
import org.fastspring.pizza.app.ordermanagement.model.Toppings;
import org.fastspring.pizza.app.ordermanagement.request.OrderRequest;
import org.fastspring.pizza.app.ordermanagement.request.RequestPizza;
import org.fastspring.pizza.app.ordermanagement.request.RequestToppings;
import org.fastspring.pizza.app.ordermanagement.response.OrderResponse;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(classes = OrdermanagementApplication.class)
public class OrderTestCases {

	// Inquiry Test cases

	@Test
	public void testAddToppings() throws URISyntaxException {

		ResponseEntity<String> result = null;
		Map<String, String> temp = new HashMap<String, String>();
		temp.put("description", "Juni");
		temp.put("price", "8.00");
		temp.put("inventory", "1");

		final String url = String.format(
				"http://localhost:8181/order/placeorder");

		RestTemplate restTemplate = new RestTemplate();

		OrderRequest orderReq = new OrderRequest();
		RequestToppings top = new RequestToppings();
		top.setToppingcode(2001);
		RequestPizza piz = new RequestPizza();
		piz.setPizzaCode(1001);
		List<RequestPizza> pizza = new ArrayList<RequestPizza>();
		List<RequestToppings> toppings = new ArrayList<RequestToppings>();
		toppings.add(top);
		pizza.add(piz);
		orderReq.setPizza(pizza);
		orderReq.setFirstName("Fast");
		orderReq.setLastName("Spring");
		orderReq.setDealcode(3006);
	    HttpHeaders headers = new HttpHeaders();

		HttpEntity<OrderRequest> requestEntity = new HttpEntity<OrderRequest>(orderReq, headers);;
		HttpEntity<OrderResponse> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, OrderResponse.class, temp);

		// Verify request succeed
		Assert.assertEquals(true, (response.getBody().getFirstName().equals("Fast")) ? true : false);
		Assert.assertEquals(true, (response.getBody().getPizzasInOrder().get(0).getPizzaErrorCode().equals("SUCCESS")) ? true : false);

	}


	

}