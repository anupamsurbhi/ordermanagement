package org.fastspring.pizza.app.ordermanagement.model;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;


@Data
@Component
@Scope("prototype")
@JsonRootName(value = "orders")
@JsonInclude(Include.NON_NULL)
public class Orders {

	private Integer orderNumber ;
	private String firstName;
	private String lastName;
	private Double finalAmount;
	private Double beforeDiscount;
	private Double discount;
	private Integer dealCode;
	private Date orderDate;
	private Time orderTime;
	private Timestamp lastChangeTS;
	private String status;
	private String message;


	
}
