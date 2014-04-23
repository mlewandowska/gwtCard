package com.gwt.card.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.gwt.card.client.DataService;
import com.gwt.card.shared.Data;

public class DataServiceImpl extends RemoteServiceServlet implements DataService {

	private Data data = new Data("Marta", "Lewandowska", "Ulica", "Gdańsk", "80-000", "grammarnazi",
			"666-000-666", "www.grammmar.nazi.de", "grammar@nazi.de", 
			"http://2.bp.blogspot.com/-ne8lPYIz980/UvKmgjBL6fI/AAAAAAAANoE/jfwk-bZYK74/s1600/pan+da.jpg");
	
	@Override
	public Data getData() {
		return data;
	}

	@Override
	public void setData(Data d) {
		data.setCity(d.getCity());
		data.setName(d.getName());
		data.setLastName(d.getLastName());
		data.setStreet(d.getStreet());
		data.setCode(d.getCode());
		data.setProf(d.getProf());
		data.setTel(d.getTel());
		data.setEmail(d.getEmail());
		data.setWww(d.getWww());
		data.setPhoto(d.getPhoto());
		
	}

}
