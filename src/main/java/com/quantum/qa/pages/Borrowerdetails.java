package com.quantum.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.quantum.qa.wrappers.Quantumwrappers;

public class Borrowerdetails extends Quantumwrappers {
	WebDriverWait wait = new WebDriverWait(driver, 30);

	public Borrowerdetails gotonameaddresstab() {
		locateelement("id", "tabBorrowerInfoNx").click();

		wait.until(
				ExpectedConditions.elementToBeClickable(locateelement("id", "SYS_DOCUMENTARY_CIP_REVIEW_COMPLETED")));
		return this;
	}

	public Borrowerdetails authorisetopullcredit() {
		clickelement(locateelement("xpath",
				"//input[contains(@displayname,'Authorization Received from Borrower') and @value='true']"));

		return this;
	}

	public Borrowerdetails selectcreditscore() {

		selectbyvisibletext(locateelement("xpath", "//select[contains(@id,'EstimatedFICOScore_EstimatedFICOScore')]"),
				"Very Good: 750 - 799");

		return this;
	}

	public Borrowerdetails enterdate() {
		
		entervalue(locateelement("xpath", "// input[contains(@id,'FromDate') and contains(@class,'editDate')]"), "05/05/2015");
		return this;
	}
	
	
	public Borrowerdetails clicksave() throws InterruptedException {
		clickelement(locateelement("id", "fwkSave"));

		wait.until(ExpectedConditions.textToBePresentInElement(locateelement("xpath", "//img[@id='imgAjaxResultTick']/../font"), "Data saved successfully!"));
		pageloadstate();
		return this;
	}
	
	
	public Borrowerdetails navigatecoboorower() throws InterruptedException {
		clickelement(locateelement("xpath", "//div[@id='divBorrowers']/div/table//table//tr[3]/td[3]/a"));
		pageloadstate();
		
		return this;
	}
	
	
	public Borrowerdetails navigateutilitiesmenu() {
		WebElement utilitymenu = locateelement("xpath", "//img[@id='img_UtilitiesmenuId']");
		mouseover(utilitymenu);
		return this;
	}
	
	public thirdpartyorderingscreen navigateProductOrderingNewmenu() throws InterruptedException {
		WebElement providerselectionmenu = locateelement("xpath", "//a[@id='eSupplyChainManagement_ProductOrderingNew']");
		mouseoverclick(providerselectionmenu);
		pageloadstate();
		return new thirdpartyorderingscreen();
	}
	

	
	
	
	

}
