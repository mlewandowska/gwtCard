package com.gwt.card.client;

import org.apache.commons.logging.Log;

import com.gwt.card.shared.Data;
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
	
	DataServiceAsync dataService = GWT.create(DataService.class);
	
	void renderPublic(final Label nameLabel, final Label lastNameLabel, final Label streetLabel, final Label codeLabel,
			final Label cityLabel, final Label telephoneLabel, final Label emailLabel, final Label wwwLabel, 
			final Label profLabel, final Image img){
		
		dataService.getData(new AsyncCallback<Data>() {

			@Override
			public void onFailure(Throwable caught) {
				//do sth with err
			}

			@Override
			public void onSuccess(Data result) {
				nameLabel.setText(result.getName());
				lastNameLabel.setText(result.getLastName());
				streetLabel.setText(result.getStreet());
				codeLabel.setText(result.getCode());
				cityLabel.setText(result.getCity());
				telephoneLabel.setText(result.getTel());
				emailLabel.setText(result.getEmail());
				wwwLabel.setText(result.getWww());
				profLabel.setText(result.getProf());
				img.setUrl(result.getPhoto());
			}
		});
		
	}
	
	void renderPrivate(final TextBox pandaTb, final TextBox nameTb, final TextBox lastNameTb, final TextBox streetTb,
			final TextBox codeTb, final TextBox cityTb, final TextBox telephoneTb, final TextBox emailTb, final TextBox wwwTb, 
			final TextBox profTb){
		
		dataService.getData(new AsyncCallback<Data>() {

			@Override
			public void onFailure(Throwable caught) {
				//do sth with err
			}

			@Override
			public void onSuccess(Data result) {
				pandaTb.setText(result.getPhoto());
				nameTb.setText(result.getName());
				lastNameTb.setText(result.getLastName());
				streetTb.setText(result.getStreet());
				codeTb.setText(result.getCode());
				cityTb.setText(result.getCity());
				telephoneTb.setText(result.getTel());
				emailTb.setText(result.getEmail());
				wwwTb.setText(result.getWww());
				profTb.setText(result.getProf());
			}
		});
	}

	public void onModuleLoad() {
		DOM.getElementById("wrapper3").getStyle().setDisplay(Display.NONE);
		//tutaj nasz kod
		final Button loginBtn = new Button("Zaloguj się");
		final Button logoutBtn = new Button("Wyloguj się");
		Button saveBtn = new Button("Zapisz");
		
		final Label nameLabel = new Label("Marta");
		final Label lastNameLabel = new Label("Lewandowska");
		//Label addressLabel = new Label("ul. Ulica 1/0 70-777 Nigdzie");
		final Label streetLabel = new Label("ul. Ulica 1/0");
		final Label codeLabel = new Label("70-777");
		final Label cityLabel = new Label("Nigdzie");
		final Label telephoneLabel = new Label("900 000 000");
		final Label emailLabel = new Label("email@address.pl");
		final Label wwwLabel = new Label("www.panda.net");
		final Label profLabel = new Label("Zawód");
		
		final TextBox userNameTb = new TextBox();
		final PasswordTextBox passwdTb = new PasswordTextBox();
		
		final Image img = new Image();
		
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
		final TextBox pandaTb = new TextBox();
		final TextBox nameTb = new TextBox();
		final TextBox lastNameTb = new TextBox();
		final TextBox streetTb = new TextBox();
		final TextBox codeTb = new TextBox();
		final TextBox cityTb = new TextBox();
		final TextBox telephoneTb = new TextBox();
		final TextBox emailTb = new TextBox();
		final TextBox wwwTb = new TextBox();
		final TextBox profTb = new TextBox();
		
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
		
		renderPublic(nameLabel, lastNameLabel, streetLabel, codeLabel, cityLabel, telephoneLabel, 
				emailLabel, wwwLabel, profLabel, img);
		
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
						renderPrivate(pandaTb, nameTb, lastNameTb, streetTb, codeTb, cityTb, telephoneTb, emailTb, wwwTb, profTb);
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
				renderPublic(nameLabel, lastNameLabel, streetLabel, codeLabel, cityLabel, telephoneLabel, emailLabel, wwwLabel, profLabel, img);
			}
		});
	}
}
