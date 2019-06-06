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
	
	public List<Toppings> getToppings()
	{
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

}