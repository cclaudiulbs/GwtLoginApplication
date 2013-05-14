package com.cc.gwt.loginapp.client;

import com.cc.gwt.loginapp.shared.LoginSubject;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("login")
public interface LoginService extends RemoteService {
	
	void login(LoginSubject subject) throws IllegalArgumentException;

}
