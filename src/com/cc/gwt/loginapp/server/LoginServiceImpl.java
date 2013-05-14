package com.cc.gwt.loginapp.server;

import com.cc.gwt.loginapp.client.LoginService;
import com.cc.gwt.loginapp.shared.LoginSubject;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class LoginServiceImpl extends RemoteServiceServlet implements LoginService {

	private static final long serialVersionUID = 1L;

	@Override
	public void login(LoginSubject subject) throws IllegalArgumentException {
		if(isValid(subject)) {
			// do some server side process... and let the client base on the Async Callback
			System.out.println("OK");
		} else {
			throw new IllegalArgumentException("Unknown LoginSubject! Validation failed on Server Side!");
		}

	}

	private boolean isValid(LoginSubject subject) {
		return subject.getUsername().equals("cclaudiu") && new String(subject.getPassword()).contains("cclaudiu");
	}
}
