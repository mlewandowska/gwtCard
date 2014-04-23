package com.gwt.card.client;

import org.apache.commons.logging.Log;

import sun.security.krb5.internal.PAData;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.ImageElement;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.safehtml.shared.SafeUri;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

public class GwtCard implements EntryPoint {

	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";
	
	LoginServiceAsync loginService = GWT.create(LoginService.class);

	public void onModuleLoad() {
		DOM.getElementById("wrapper3").getStyle().setDisplay(Display.NONE);
		//tutaj nasz kod
		final Button loginBtn = new Button("Zaloguj się");
		final Button logoutBtn = new Button("Wyloguj się");
		Button saveBtn = new Button("Zapisz");
		
		Label nameLabel = new Label("Marta");
		Label lastNameLabel = new Label("Lewandowska");
		//Label addressLabel = new Label("ul. Ulica 1/0 70-777 Nigdzie");
		Label streetLabel = new Label("ul. Ulica 1/0");
		Label codeLabel = new Label("70-777");
		Label cityLabel = new Label("Nigdzie");
		Label telephoneLabel = new Label("900 000 000");
		Label emailLabel = new Label("email@address.pl");
		Label wwwLabel = new Label("www.panda.net");
		Label profLabel = new Label("Zawód");
		
		final TextBox userNameTb = new TextBox();
		final PasswordTextBox passwdTb = new PasswordTextBox();
		
		Image img = new Image();
		
		img.setUrl("http://2.bp.blogspot.com/-ne8lPYIz980/UvKmgjBL6fI/AAAAAAAANoE/jfwk-bZYK74/s1600/pan+da.jpg");
		
		img.setHeight("200px");
		img.setWidth("200px");
		
		RootPanel.get("userName").add(userNameTb);
		RootPanel.get("passwd").add(passwdTb);
		
		RootPanel.get("pandaHolder").add(img);
		RootPanel.get("btnHolder").add(loginBtn);
		RootPanel.get("btnHolder").add(logoutBtn);
		logoutBtn.setVisible(false);
		RootPanel.get("saveBtn").add(saveBtn);
		
		RootPanel.get("nameLabel").add(nameLabel);
		RootPanel.get("lastNameLabel").add(lastNameLabel);
		RootPanel.get("profLabel").add(profLabel);
		//RootPanel.get("addressLabel").add(addressLabel);
		RootPanel.get("streetLabel").add(streetLabel);
		RootPanel.get("codeLabel").add(codeLabel);
		RootPanel.get("cityLabel").add(cityLabel);
		RootPanel.get("telephoneLabel").add(telephoneLabel);
		RootPanel.get("emailLabel").add(emailLabel);
		RootPanel.get("wwwLabel").add(wwwLabel);
		
		//edycja
		TextBox pandaTb = new TextBox();
		TextBox nameTb = new TextBox();
		TextBox lastNameTb = new TextBox();
		TextBox streetTb = new TextBox();
		TextBox codeTb = new TextBox();
		TextBox cityTb = new TextBox();
		TextBox telephoneTb = new TextBox();
		TextBox emailTb = new TextBox();
		TextBox wwwTb = new TextBox();
		TextBox profTb = new TextBox();
		
		RootPanel.get("imageTb").add(pandaTb);
		RootPanel.get("streetTb").add(streetTb);
		RootPanel.get("codeTb").add(codeTb);
		RootPanel.get("cityTb").add(cityTb);
		RootPanel.get("telephoneTb").add(telephoneTb);
		RootPanel.get("emailTb").add(emailTb);
		RootPanel.get("wwwTb").add(wwwTb);
		RootPanel.get("profTb").add(profTb);
		RootPanel.get("nameTb").add(nameTb);
		RootPanel.get("lastNameTb").add(lastNameTb);
		
		loginBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				String userName = userNameTb.getText();
				String passwd = passwdTb.getText();
				
				loginService.login(userName, passwd, new AsyncCallback<Boolean>() {
					
					@Override
					public void onSuccess(Boolean result) {
						loginBtn.setVisible(false);
						logoutBtn.setVisible(true);
						userNameTb.setVisible(false);
						passwdTb.setVisible(false);
						DOM.getElementById("wrapper").getStyle().setDisplay(Display.NONE);
						DOM.getElementById("wrapper3").getStyle().setDisplay(Display.BLOCK);
					}
					
					@Override
					public void onFailure(Throwable caught) {
						userNameTb.setText("NOPE!");	
					}
				});
			}
		});

		logoutBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				loginBtn.setVisible(true);
				logoutBtn.setVisible(false);
				userNameTb.setVisible(true);
				passwdTb.setVisible(true);
				DOM.getElementById("wrapper").getStyle().setDisplay(Display.BLOCK);
				DOM.getElementById("wrapper3").getStyle().setDisplay(Display.NONE);
			}
		});
	}
}
