package org.fastspring.pizza.app.ordermanagement.DAO;

import java.util.List;

import org.fastspring.pizza.app.ordermanagement.model.Toppings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@PropertySource("${fastspring.sql.path}")
public class ToppingsDAO {

	@Autowired
	List<Toppings> toppings;

	@Autowired
	Toppings topping;

	@Autowired
	private NamedParameterJdbcTemplate toppingDAO;

	@Autowired
	private Environment env;

	public List<Toppings> getToppings() {
		String query = env.getProperty("GET_TOPPINGS");
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		try {
			toppings = toppingDAO.query(query, paramMap, BeanPropertyRowMapper.newInstance(Toppings.class));
			System.out.println(" pass");

		} catch (Exception e) {
			System.out.println(" Failed");

		}

		return toppings;
	}

	public Toppings getTopping(Integer toppingId) {
		String query = env.getProperty("GET_TOPPINGS_ID");
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("code", toppingId);

		try {
			toppings = toppingDAO.query(query, paramMap, BeanPropertyRowMapper.newInstance(Toppings.class));
			topping = toppings.get(0);
			System.out.println(" pass");

		} catch (Exception e) {
			System.out.println(" Failed");

		}

		return topping;
	}
	
	public Toppings addToppingToPizza(Integer toppingId) {
		String query = env.getProperty("GET_TOPPINGS_ID");
		String updateQuery = env.getProperty("UPDATE_TOPPING_INV");

		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("code", toppingId);

		try {
			toppings = toppingDAO.query(query, paramMap, BeanPropertyRowMapper.newInstance(Toppings.class));
			topping = toppings.get(0);
			toppingDAO.update(updateQuery, paramMap);
			System.out.println(" pass");

		} catch (Exception e) {
			System.out.println(" Failed");

		}

		return topping;
	}

	public Integer maxToppingCode() {
		String query = env.getProperty("GET_TOPPING_MAX");
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		try {
			topping = toppingDAO.query(query, paramMap, BeanPropertyRowMapper.newInstance(Toppings.class)).get(0);
			System.out.println(" pass");

		} catch (Exception e) {
			System.out.println(" Failed");

		}

		return topping.getCode();
	}

	public Toppings addTopping(Toppings inTopping) {
		String query = env.getProperty("ADD_PIZZA");
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("code", inTopping.getCode());
		paramMap.addValue("desc", inTopping.getDescription());
		paramMap.addValue("price", inTopping.getPrice());
		paramMap.addValue("active", "Y");
		paramMap.addValue("inv", inTopping.getInventory());

		try {
			toppingDAO.update(query, paramMap);
			System.out.println(" pass");

		} catch (Exception e) {
			System.out.println(" Failed" + e);

		}

		return inTopping;
	}

}
