package com.gwt.card.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.gwt.card.client.LoginService;

public class LoginServiceImpl extends RemoteServiceServlet implements LoginService {

	String user = "Marta";
	String password = "marta123";
	
	@Override
	public Boolean login(String userName, String passwd) {
		return ( user.compareTo(userName) == 0 && password.compareTo(passwd) == 0 );
	}

}
