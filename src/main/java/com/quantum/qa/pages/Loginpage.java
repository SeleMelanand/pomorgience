package com.quantum.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.quantum.qa.wrappers.Quantumwrappers;

public class Loginpage extends Quantumwrappers {

	/*@FindBy(how=How.ID, using="")
	private WebElement uname;
	
	
	@FindBy(how=How.ID, using="")
	private WebElement securitycode;*/
	
	//@FindBy(how=How.ID, using="ctl00_cphContent_LoginButton")
	//String value = prop.getProperty("login.id");
	
	@FindBy(id = "ctl00_cphContent_LoginButton")
	private WebElement login;
	
	
	//Initializing the page objects.
	public Loginpage() {
		PageFactory.initElements(driver, this);
	}
	
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
		login.click();
		/*WebElement loginbutton = locateelement(prop.getProperty("locator.login"), prop.getProperty("login.id"));
		clickelement(loginbutton);*/
		return new Homepage();
	}
	
	
	

}
