package com.we2seek.webgreetings.client;


import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class Index implements EntryPoint {

    public void onModuleLoad() {
        LoginForm loginForm = new LoginForm();
        Label itWorksLabel = new Label("GWT: It works...");
        RootPanel.get().add(itWorksLabel);
        RootPanel.get().add(loginForm);
    }
}
