package br.com.sgm.integracao.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -2800361792842929947L;

	public ResourceNotFoundException(String exception) {
		super(exception);
	}
}
