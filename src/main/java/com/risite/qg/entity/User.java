package com.risite.qg.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Data
public class User extends BaseEntity{
	private String username;
	private String password;
	private String mobile;
	@DBRef
	private Role role;

	public User(String username, String password, String mobile, Role role) {
		this.username = username;
		this.password = password;
		this.mobile = mobile;
		this.role = role;
	}
}