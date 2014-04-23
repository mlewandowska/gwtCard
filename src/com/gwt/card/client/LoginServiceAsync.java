package com.gwt.card.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface LoginServiceAsync {

	void login(String userName, String passwd, AsyncCallback<Boolean> callback);

}
