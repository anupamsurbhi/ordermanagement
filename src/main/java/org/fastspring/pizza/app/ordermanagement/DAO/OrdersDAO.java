package org.fastspring.pizza.app.ordermanagement.DAO;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.fastspring.pizza.app.ordermanagement.constants.AppConstants;
import org.fastspring.pizza.app.ordermanagement.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@PropertySource("${fastspring.sql.path}")
public class OrdersDAO {

	@Autowired
	List<Orders> orders;

	@Autowired
	AppConstants appConstants;

	@Autowired
	Orders order;

	@Autowired
	private NamedParameterJdbcTemplate ordersDAO;

	@Autowired
	private Environment env;

	public List<Orders> getAllOrders() {
		String query = env.getProperty("GET_ORDERS");
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		try {
			orders = ordersDAO.query(query, paramMap, BeanPropertyRowMapper.newInstance(Orders.class));
			orders.get(0).setStatus(appConstants.pass);

		} catch (Exception e) {
			orders.get(0).setStatus(appConstants.fail);
			orders.get(0).setMessage(e.getMessage());

		}

		return orders;
	}

	
	public Integer getNextOrderNum() {
		String query = env.getProperty("GET_ORDER_MAX");
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		try {
			order = ordersDAO.query(query, paramMap, BeanPropertyRowMapper.newInstance(Orders.class)).get(0);
			System.out.println(" pass");

		} catch (Exception e) {
			order.setStatus(appConstants.fail);
			order.setMessage(e.getMessage());

		}

		return order.getOrderNumber();
	}

	public Orders insertOrder(Orders inOrder) {
		String query = env.getProperty("POST_ORDER");

		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		inOrder.setOrderDate(new Date(System.currentTimeMillis()));
		inOrder.setOrderTime(new Time(System.currentTimeMillis()));
		inOrder.setLastChangeTS(new Timestamp(System.currentTimeMillis()));

		paramMap.addValue("ordernum", inOrder.getOrderNumber());
		paramMap.addValue("fname", inOrder.getFirstName());
		paramMap.addValue("lname", inOrder.getLastName());
		paramMap.addValue("finalAmt", inOrder.getFinalAmount());
		paramMap.addValue("beforeDis", inOrder.getBeforeDiscount());
		paramMap.addValue("dis", inOrder.getDiscount());
		paramMap.addValue("dcode", inOrder.getDealCode());
		paramMap.addValue("oDate", inOrder.getOrderDate());
		paramMap.addValue("oTime", inOrder.getOrderTime());
		paramMap.addValue("ts", inOrder.getLastChangeTS());

		// ordersDAO.update(query, paramMap);
		try {
			int updRec = ordersDAO.update(query, paramMap);
			System.out.println(" pass" + updRec);

		} catch (Exception e) {
			inOrder.setStatus(appConstants.fail);
			inOrder.setMessage(e.getMessage());
		}

		return inOrder;
	}
}
