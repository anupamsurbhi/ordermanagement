package org.fastspring.pizza.app.ordermanagement.controller;



import org.fastspring.pizza.app.ordermanagement.model.Deals;
import org.fastspring.pizza.app.ordermanagement.model.Pizza;
import org.fastspring.pizza.app.ordermanagement.model.Toppings;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(ControllerTest.class)
public class ControllerTest {

   @Test
   public void testGetAllDeals() throws URISyntaxException
   {
       RestTemplate restTemplate = new RestTemplate();
        
       final String baseUrl = "http://localhost:8181/inquiry/getalldeals";
       URI uri = new URI(baseUrl);
    
       ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
        
       
       //Verify request succeed
       Assert.assertEquals(200, result.getStatusCodeValue());
       Assert.assertEquals(true, result.getBody().contains("code"));
       Assert.assertEquals(true, result.getBody().contains("percent"));
       Assert.assertEquals(true, result.getBody().contains("status"));


   }
   
   @Test
   public void testGetAllpizza() throws URISyntaxException
   {
       RestTemplate restTemplate = new RestTemplate();
        
       final String baseUrl = "http://localhost:8181/inquiry/getallpizza";
       URI uri = new URI(baseUrl);
    
       ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
        
       
       //Verify request succeed
       Assert.assertEquals(200, result.getStatusCodeValue());
       Assert.assertEquals(true, result.getBody().contains("code"));
       Assert.assertEquals(true, result.getBody().contains("description"));
       Assert.assertEquals(true, result.getBody().contains("inventory"));
       Assert.assertEquals(true, result.getBody().contains("price"));
       Assert.assertEquals(true, result.getBody().contains("status"));


   }
   
   
   @Test
   public void testGetAllToppings() throws URISyntaxException
   {
       RestTemplate restTemplate = new RestTemplate();
        
       final String baseUrl = "http://localhost:8181/inquiry/getalltoppings";
       URI uri = new URI(baseUrl);
    
       ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
        
       
       //Verify request succeed
       Assert.assertEquals(200, result.getStatusCodeValue());
       Assert.assertEquals(true, result.getBody().contains("code"));
       Assert.assertEquals(true, result.getBody().contains("description"));
       Assert.assertEquals(true, result.getBody().contains("inventory"));
       Assert.assertEquals(true, result.getBody().contains("price"));
       Assert.assertEquals(true, result.getBody().contains("status"));


   }
   
   @Test
   public void testOrder() throws URISyntaxException
   {
       RestTemplate restTemplate = new RestTemplate();
        
       final String baseUrl = "http://localhost:8181/order/getallorders";
       URI uri = new URI(baseUrl);
    
       ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
        
       
       //Verify request succeed
       Assert.assertEquals(200, result.getStatusCodeValue());
       Assert.assertEquals(true, result.getBody().contains("orderNumber"));
       Assert.assertEquals(true, result.getBody().contains("firstName"));
       Assert.assertEquals(true, result.getBody().contains("lastName"));
       Assert.assertEquals(true, result.getBody().contains("finalAmount"));
       Assert.assertEquals(true, result.getBody().contains("status"));

   }
}