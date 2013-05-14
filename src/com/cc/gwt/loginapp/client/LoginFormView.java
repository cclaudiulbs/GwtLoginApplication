package com.cc.gwt.loginapp.client;

import com.cc.gwt.loginapp.shared.LoginSubject;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class LoginFormView implements EntryPoint {

	private final TextBox usernameBox = new TextBox();
	private final PasswordTextBox passwordBox = new PasswordTextBox();
	private final Button submitButton = new Button("Submit");
	private final Button cancelButton = new Button("Cancel");
	private final VerticalPanel mainPanel = new VerticalPanel();
	private final HorizontalPanel buttonsPanel = new HorizontalPanel();

	public LoginFormView() {
	}

	@Override
	public void onModuleLoad() {
		buildLoginForm();
	}

	private void buildLoginForm() {
		mainPanel.add(usernameBox);
		mainPanel.add(passwordBox);

		buttonsPanel.add(submitButton);
		buttonsPanel.add(cancelButton);

		mainPanel.add(buttonsPanel);
		mainPanel.add(buttonsPanel);

		cancelButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				resetLoginForm();
			}
		});

		submitButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				handleSubmitEvent(event);
			}
		});

		RootPanel.get("gwtloginapplication_id").add(mainPanel);
	}

	private void handleSubmitEvent(ClickEvent event) {

		LoginServiceAsync asyncService = (LoginServiceAsync) GWT
				.create(LoginService.class);
		AsyncCallback callback = new AsyncCallback() {

			@Override
			public void onSuccess(Object result) {
				Window.alert("Callback was invoked after a successfull Login Service for user: "
						+ usernameBox.getText());
			}

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Callback was invoked after a failing Login Service for user: "
						+ usernameBox.getText()
						+ ", Error is: "
						+ caught.getMessage());
			}
		};

		LoginSubject subject = new LoginSubject();
		subject.setUsername(usernameBox.getText());
		subject.setPassword(passwordBox.getText().toCharArray());

		asyncService.login(subject, callback);
	}

	private void resetLoginForm() {
		usernameBox.setText("");
		passwordBox.setText("");
		usernameBox.setFocus(true);
		Window.alert("Login Form has been reseted!");
	}
}