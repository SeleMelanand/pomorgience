package com.quantum.qa.pages;

import org.openqa.selenium.WebElement;
import com.quantum.qa.wrappers.Quantumwrappers;

public class Loginpage extends Quantumwrappers {
	
	// On this page locator values are retrieved from the object.properties file during run time.
	
	public Loginpage enterusername() {
		WebElement username = locateelement(prop.getProperty("locator.username"), prop.getProperty("username.id"));
		entervalue(username, prop.getProperty("application.uname"));
		return this;
	}
	
	public Loginpage enterpassword() {
		WebElement password = locateelement(prop.getProperty("locator.password"),prop.getProperty("password.id"));
		entervalue(password, prop.getProperty("application.passcode"));
		return this;

	}

	public Homepage clicklogin() {
		WebElement loginbutton = locateelement(prop.getProperty("locator.login"), prop.getProperty("login.id"));
		clickelement(loginbutton);
		return new Homepage();
	}

}
