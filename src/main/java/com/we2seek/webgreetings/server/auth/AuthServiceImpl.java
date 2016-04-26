package com.we2seek.webgreetings.server.auth;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.we2seek.webgreetings.client.prc.AuthService;
import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthServiceImpl extends RemoteServiceServlet implements AuthService {

    private static final Logger logger = Logger.getLogger(AuthServiceImpl.class.getCanonicalName());

    @Override
    public String retrieveUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            logger.warn("Can\'t get user auth context. Possible user not logged in.");
            return "Anonymous user";
        } else {
            return (String) authentication.getPrincipal();
        }
    }
}