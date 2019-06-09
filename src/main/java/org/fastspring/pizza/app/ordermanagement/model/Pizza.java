package org.fastspring.pizza.app.ordermanagement.model;


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
public class Pizza {
	
    private Integer code ;	
    private String description;
    private Double price ;
    private Integer inventory ;	
    private Timestamp lastchangets;
    private String status;
	private String message;


}
