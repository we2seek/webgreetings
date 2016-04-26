package com.we2seek.webgreetings.client.prc;

import com.google.gwt.user.client.rpc.RemoteService;

public interface AuthService extends RemoteService {
    String retrieveUserName();
}
