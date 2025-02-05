package com.lstech.workshopmongodb.dto;

import java.io.Serializable;

import com.lstech.workshopmongodb.domain.User;

public class AuthorDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	
	public AuthorDTO() {
	}
	
	public AuthorDTO(User obj) {
		id = obj.getId();
	}
}
