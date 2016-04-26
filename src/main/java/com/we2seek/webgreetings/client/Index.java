package com.we2seek.webgreetings.client;


import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.we2seek.webgreetings.client.prc.AuthService;
import com.we2seek.webgreetings.client.prc.AuthServiceAsync;

public class Index implements EntryPoint {

    private final AuthServiceAsync authService = GWT.create(AuthService.class);

    public void onModuleLoad() {
        RootPanel.get().add(new Label("GWT: It works..."));
        authService.retrieveUserName(new AsyncCallback<String>() {
            @Override
            public void onFailure(Throwable error) {
                Window.alert("Remote procedure call failure...");
            }

            @Override
            public void onSuccess(String result) {
                RootPanel.get().add(new Label(result));
            }
        });
    }
}
