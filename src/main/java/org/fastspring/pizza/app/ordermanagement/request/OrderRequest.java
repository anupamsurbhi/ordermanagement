package org.fastspring.pizza.app.ordermanagement.request;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@Data
@Component
@Scope("prototype")
@JsonRootName(value = "orderpizza")
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderRequest {
	private String firstName;
	private String lastName;
	private List<RequestPizza> pizza;
	private Integer dealcode;
}
