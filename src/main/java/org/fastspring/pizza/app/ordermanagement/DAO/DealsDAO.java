package org.fastspring.pizza.app.ordermanagement.DAO;

import java.util.List;

import org.fastspring.pizza.app.ordermanagement.constants.AppConstants;
import org.fastspring.pizza.app.ordermanagement.model.Deals;
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
public class DealsDAO {

	@Autowired
	List<Deals> deals;

	@Autowired
	AppConstants appConstants;

	@Autowired
	Deals deal;

	@Autowired
	private NamedParameterJdbcTemplate dealDAO;

	@Autowired
	private Environment env;

	public List<Deals> getDeals() {
		String query = env.getProperty("GET_DEALS");
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		try {
			deals = dealDAO.query(query, paramMap, BeanPropertyRowMapper.newInstance(Deals.class));
			deals.get(0).setStatus(appConstants.pass);

		} catch (Exception e) {
			deals.get(0).setStatus(appConstants.fail);
			deals.get(0).setMessage(e.getMessage());

		}

		return deals;
	}

	public Deals getDealsByCode(Integer dealCode) {
		String query = env.getProperty("GET_DEALS_ID");
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("code", dealCode);

		try {
			deal = dealDAO.query(query, paramMap, BeanPropertyRowMapper.newInstance(Deals.class)).get(0);
			deal.setStatus(appConstants.pass);
		} catch (Exception e) {
			deal.setPercent(0.00);
			deal.setDescription("No Deal Added");
			deal.setStatus(appConstants.fail);
			deal.setMessage(e.getMessage());

		}

		return deal;
	}
	
	public Integer getDealMax() {
		String query = env.getProperty("GET_DEAL_MAX");
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		try {
			deals = dealDAO.query(query, paramMap, BeanPropertyRowMapper.newInstance(Deals.class));
			deals.get(0).setStatus(appConstants.pass);

		} catch (Exception e) {
			deals.get(0).setStatus(appConstants.fail);
			deals.get(0).setMessage(e.getMessage());
			deals.get(0).setCode(0);
		}

		return deals.get(0).getCode();
	}
	
	public Deals addDeal(Deals inDeal) {
		String query = env.getProperty("ADD_DEAL");
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		paramMap.addValue("code", inDeal.getCode());
		paramMap.addValue("desc", inDeal.getDescription());
		paramMap.addValue("percent", inDeal.getPercent());
		paramMap.addValue("start", inDeal.getDealstartdate());
		paramMap.addValue("end", inDeal.getDealenddate());

		try {
			dealDAO.update(query, paramMap);
			inDeal.setStatus(appConstants.pass);

		} catch (Exception e) {
			inDeal.setStatus(appConstants.fail);
			inDeal.setMessage(e.getMessage());

		}

		return inDeal;
	}

}
