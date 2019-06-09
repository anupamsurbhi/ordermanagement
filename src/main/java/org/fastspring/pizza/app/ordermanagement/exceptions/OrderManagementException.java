package org.fastspring.pizza.app.ordermanagement.exceptions;

import org.fastspring.pizza.app.ordermanagement.errorcodes.ErrorCodes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class OrderManagementException extends RuntimeException {}
	


