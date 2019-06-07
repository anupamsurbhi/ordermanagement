package org.fastspring.pizza.app.ordermanagement.DAO;

import java.util.List;

import org.fastspring.pizza.app.ordermanagement.model.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@PropertySource("${fastspring.sql.path}")
public class PizzaDAO {
	
	@Autowired
	List<Pizza> pizzas;
	
	@Autowired
	Pizza pizza;

	@Autowired
	private NamedParameterJdbcTemplate pizzaDAO;

	@Autowired
	private Environment env;
	
	public List<Pizza> getPizza()
	{
		String query = env.getProperty("GET_PIZZA");
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		
		
		try {
			pizzas = pizzaDAO.query(query, paramMap, BeanPropertyRowMapper.newInstance(Pizza.class));
			System.out.println(" pass");

		} catch (Exception e) {
			System.out.println(" Failed");

		}

		return pizzas;
	}
	
	
	public Pizza getPizzaPrice(Integer pizzaCode)
	{
		String query = env.getProperty("GET_PIZZA_ID");
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("code", pizzaCode);
		try {
			pizzas =  pizzaDAO.query(query, paramMap, BeanPropertyRowMapper.newInstance(Pizza.class));
			pizza = pizzas.get(0);
			System.out.println(" pass");

		} catch (Exception e) {
			System.out.println(" Failed");

		}

		return pizza;
	}
	
	
	public Integer maxPizzaCode()
	{
		String query = env.getProperty("GET_PIZZA_MAX");
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		
		
		try {
			pizza = pizzaDAO.query(query, paramMap, BeanPropertyRowMapper.newInstance(Pizza.class)).get(0);
			System.out.println(" pass");

		} catch (Exception e) {
			System.out.println(" Failed");

		}

		return pizza.getCode();
	}
	
	public Pizza addPizza(Pizza inPizza)
	{
		String query = env.getProperty("ADD_PIZZA");
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("code", inPizza.getCode());
		paramMap.addValue("desc", inPizza.getDescription());
		paramMap.addValue("price", inPizza.getPrice());
		paramMap.addValue("inv", inPizza.getInventory());


		try {
			pizzaDAO.update(query, paramMap);
			System.out.println(" pass");

		} catch (Exception e) {
			System.out.println(" Failed" + e);

		}

		return inPizza;
	}
}
