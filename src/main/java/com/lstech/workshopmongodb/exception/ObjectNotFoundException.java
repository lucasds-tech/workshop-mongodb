package com.lstech.workshopmongodb.exception;

public class ObjectNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ObjectNotFoundException(String msg) { // SOBREPOSICAO
		super(msg);
	}
}
