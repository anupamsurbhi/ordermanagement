package org.fastspring.pizza.app.ordermanagement.model;


import java.sql.Timestamp;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@Data
@Component
@Scope("prototype")
@JsonRootName(value = "orders")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pizza {
	
    private Integer code ;	
    private String description;
    private Double price ;
    private Integer inventory ;	
    private Timestamp lastchangets;


}
