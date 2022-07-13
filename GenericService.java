package com.comp.ws;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public abstract class GenericService {
	
	protected ResponseEntity<Object> toSuccess(Object object) {
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(object);
	}
	protected ResponseEntity<Object> toError400(Object data) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(data);
	}
}
