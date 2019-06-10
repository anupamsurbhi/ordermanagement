package org.fastspring.pizza.app.ordermanagement.NormalTestFlow;

import org.fastspring.pizza.app.ordermanagement.model.Deals;
import org.fastspring.pizza.app.ordermanagement.model.Pizza;
import org.fastspring.pizza.app.ordermanagement.model.Toppings;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@WebMvcTest(ManageTestCases.class)
public class ManageTestCases {

	// Inquiry Test cases

	@Test
	public void testAddToppings() throws URISyntaxException {

		ResponseEntity<String> result = null;
		Map<String, String> temp = new HashMap<String, String>();
		temp.put("description", "Juni");
		temp.put("price", "8.00");
		temp.put("inventory", "1");

		final String url = String.format(
				"http://localhost:8181/manage/addtoppings?description=blue cheese toppings&price=1.12&inventory=1");

		RestTemplate restTemplate = new RestTemplate();

		HttpEntity<Toppings> requestEntity = null;
		HttpEntity<Toppings> response = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Toppings.class, temp);

		// Verify request succeed
		Assert.assertEquals(true, (response.getBody().getInventory() == 1) ? true : false);
		Assert.assertEquals(true, (response.getBody().getStatus().equals("SUCCESS")) ? true : false);

	}

	@Test
	public void testAddPizza() throws URISyntaxException {

		Map<String, String> temp = new HashMap<String, String>();

		final String url = String.format(
				"http://localhost:8181/manage/addpizza?description=Purple Cheese Pizza - small&price=8.9&inventory=1");

		RestTemplate restTemplate = new RestTemplate();

		HttpEntity<Pizza> requestEntity = null;
		HttpEntity<Pizza> response = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Pizza.class, temp);

		// Verify request succeed
		Assert.assertEquals(true, (response.getBody().getInventory() == 1) ? true : false);
		Assert.assertEquals(true, (response.getBody().getStatus().equals("SUCCESS")) ? true : false);

	}

	@Test
	public void testAddDeal() throws URISyntaxException {

		Map<String, String> temp = new HashMap<String, String>();

		final String url = String.format(
				"http://localhost:8181/manage/adddeal?description=My deals 22&DealPercent=22&StartDate=2019-01-01&EndDate=2019-09-09");

		RestTemplate restTemplate = new RestTemplate();

		HttpEntity<Deals> requestEntity = null;
		HttpEntity<Deals> response = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Deals.class, temp);

		// Verify request succeed
		Assert.assertEquals(true, (response.getBody().getPercent().toString().equals("22.0")) ? true : false);
		Assert.assertEquals(true, (response.getBody().getStatus().equals("SUCCESS")) ? true : false);

	}

}