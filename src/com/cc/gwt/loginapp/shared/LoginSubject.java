package com.cc.gwt.loginapp.shared;

import java.io.Serializable;

public class LoginSubject implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String username;
	private char[] password;
	
	public LoginSubject() { }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public char[] getPassword() {
		return password;
	}

	public void setPassword(char[] password) {
		this.password = password;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
