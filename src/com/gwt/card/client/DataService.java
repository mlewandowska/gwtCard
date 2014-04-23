package com.gwt.card.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.gwt.card.shared.Data;

@RemoteServiceRelativePath("data")
public interface DataService extends RemoteService {
	
	Data getData();
	
	void setData(Data data);

}
