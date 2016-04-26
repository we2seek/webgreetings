package com.we2seek.webgreetings.server.auth;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AbstractAuthenticationEvent;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;

// This class calls when login-event fires
public class CustomAuthListener implements ApplicationListener<AbstractAuthenticationEvent> {

    // Just save to log all auth attempts
    final static Logger logger = Logger.getLogger(CustomAuthListener.class.getCanonicalName());

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

        logger.debug(builder.toString());
    }
}