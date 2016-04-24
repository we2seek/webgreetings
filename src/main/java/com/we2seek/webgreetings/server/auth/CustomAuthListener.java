package com.we2seek.webgreetings.server.auth;

import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AbstractAuthenticationEvent;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import sun.rmi.runtime.Log;

public class CustomAuthListener implements ApplicationListener<AbstractAuthenticationEvent> {


    @Override
    public void onApplicationEvent(AbstractAuthenticationEvent event) {
        final StringBuilder builder = new StringBuilder();
        builder.append("Authentication event ");
        builder.append(event.getClass().getSimpleName());
        builder.append(": ");
        builder.append(event.getAuthentication().getDetails());
        builder.append("; details: ");

        if (event instanceof AbstractAuthenticationFailureEvent) {
            builder.append("; exception: ");
            builder.append(((AbstractAuthenticationFailureEvent) event).getException().getMessage());
        }

    }
}