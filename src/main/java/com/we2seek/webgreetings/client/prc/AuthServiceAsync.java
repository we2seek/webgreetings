package com.we2seek.webgreetings.client.prc;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface AuthServiceAsync {
    void retrieveUserName(AsyncCallback<String> async);
}
