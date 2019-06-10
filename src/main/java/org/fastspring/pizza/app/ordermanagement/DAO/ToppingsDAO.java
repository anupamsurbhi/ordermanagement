package org.fastspring.pizza.app.ordermanagement.DAO;

import java.util.List;

import org.fastspring.pizza.app.ordermanagement.constants.AppConstants;
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
	AppConstants appConstants;

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
			toppings.get(0).setStatus(appConstants.pass);

		} catch (Exception e) {
			toppings.get(0).setStatus(appConstants.fail);
			toppings.get(0).setMessage(e.getMessage());
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
			topping.setStatus(appConstants.pass);

		} catch (Exception e) {
			topping.setStatus(appConstants.fail);
			topping.setMessage(e.getMessage());
		}

		return topping;
	}

	public Toppings updateToppingInv(Integer toppingId, Integer inv) {
		String updateQuery = env.getProperty("UPDATE_TOPPING_INV");

		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("code", toppingId);
		paramMap.addValue("inv", inv);

		try {
			toppingDAO.update(updateQuery, paramMap);
			topping.setStatus(appConstants.pass);

		} catch (Exception e) {
			topping.setStatus(appConstants.fail);
			topping.setMessage(e.getMessage());
		}

		return topping;
	}

	public Integer maxToppingCode() {
		String query = env.getProperty("GET_TOPPING_MAX");
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		try {
			topping = toppingDAO.query(query, paramMap, BeanPropertyRowMapper.newInstance(Toppings.class)).get(0);
			topping.setStatus(appConstants.pass);

		} catch (Exception e) {
			topping.setStatus(appConstants.fail);
			topping.setMessage(e.getMessage());
		}

		return topping.getCode();
	}

	public Toppings addTopping(Toppings inTopping) {
		String query = env.getProperty("ADD_TOPPINGS");
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("code", inTopping.getCode());
		paramMap.addValue("desc", inTopping.getDescription());
		paramMap.addValue("price", inTopping.getPrice());
		paramMap.addValue("active", "Y");
		paramMap.addValue("inv", inTopping.getInventory());

		try {
			toppingDAO.update(query, paramMap);
			inTopping.setStatus(appConstants.pass);

		} catch (Exception e) {
			inTopping.setStatus(appConstants.fail);
			inTopping.setMessage(e.getMessage());
		}

		return inTopping;
	}

	public Toppings updateTopping(Toppings inTopping) {
		String query = env.getProperty("UPDATE_TOPPING_INV");
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("code", inTopping.getCode());
		paramMap.addValue("inv", inTopping.getInventory());

		try {
			toppingDAO.update(query, paramMap);
			inTopping.setStatus(appConstants.pass);
		} catch (Exception e) {
			inTopping.setStatus(appConstants.fail);
			inTopping.setMessage(e.getMessage());

		}

		return inTopping;
	}

}
