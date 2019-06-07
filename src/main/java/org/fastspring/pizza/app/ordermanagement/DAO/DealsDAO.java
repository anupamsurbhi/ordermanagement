package org.fastspring.pizza.app.ordermanagement.DAO;

import java.util.List;

import org.fastspring.pizza.app.ordermanagement.model.Deals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@PropertySource("${fastspring.sql.path}")
public class DealsDAO {
	
	@Autowired
	List<Deals> deals;
	
	@Autowired
	Deals deal;
	
	@Autowired
	private NamedParameterJdbcTemplate dealDAO;

	@Autowired
	private Environment env;
	
	public List<Deals> getDeals()
	{
		String query = env.getProperty("GET_DEALS");
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		
		try {
			deals = dealDAO.query(query, paramMap, BeanPropertyRowMapper.newInstance(Deals.class));
			System.out.println(" pass");

		} catch (Exception e) {
			System.out.println(" Failed");

		}

		return deals;
	}
	
	public Deals getDealsByCode(Integer dealCode)
	{
		String query = env.getProperty("GET_DEALS_ID");
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("code", dealCode);

		
		try {
			deal = dealDAO.query(query, paramMap, BeanPropertyRowMapper.newInstance(Deals.class)).get(0);
			System.out.println(" pass");

		} catch (Exception e) {
			System.out.println(" Failed");

		}

		return deal;
	}

}
