package com.we2seek.webgreetings.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class LoginForm extends Composite {

    private static LoginFormUiBinder binder = GWT.create(LoginFormUiBinder.class);
    @UiField
    TextBox loginTextBox;
    @UiField
    TextBox passwordTextBox;
    @UiField
    Button submitButton;

    public LoginForm() {
        initWidget(binder.createAndBindUi(this));
    }

    interface LoginFormUiBinder extends UiBinder<Widget, LoginForm> {
    }
}