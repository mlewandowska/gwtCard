package com.gwt.card.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.gwt.card.shared.Data;

public interface DataServiceAsync {

	void getData(AsyncCallback<Data> callback);

	void setData(Data data, AsyncCallback<Void> callback);

}
