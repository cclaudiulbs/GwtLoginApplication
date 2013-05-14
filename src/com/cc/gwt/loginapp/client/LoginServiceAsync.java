package com.cc.gwt.loginapp.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

import com.cc.gwt.loginapp.shared.LoginSubject;

public interface LoginServiceAsync {
	
	void login(LoginSubject subject, AsyncCallback callback);

}
