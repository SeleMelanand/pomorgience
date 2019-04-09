package com.quantum.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.quantum.qa.wrappers.Quantumwrappers;

public class Borrowerdetails extends Quantumwrappers {
	WebDriverWait wait = new WebDriverWait(driver, 30);
	// using pagefactory elements are getting loaded.
	// Initializing the page objects.
	public Borrowerdetails() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = "tabBorrowerInfoNx")
	private WebElement borrowerinfotab;

	@FindBy(how = How.ID, using = "SYS_DOCUMENTARY_CIP_REVIEW_COMPLETED")
	private WebElement elementborrowerpage;

	public Borrowerdetails gotonameaddresstab() {
		borrowerinfotab.click();
		wait.until(ExpectedConditions.elementToBeClickable(elementborrowerpage));
		return this;
	}

	@FindBy(how = How.XPATH, using = "//input[contains(@displayname,'Authorization Received from Borrower') and @value='true']")
	private WebElement creditpullauthorization;

	public Borrowerdetails authorisetopullcredit() {
		clickelement(creditpullauthorization);
		return this;
	}

	@FindBy(how = How.XPATH, using = "//select[contains(@id,'EstimatedFICOScore_EstimatedFICOScore')]")
	private WebElement creditscore;

	public Borrowerdetails selectcreditscore() {
		selectbyvisibletext(creditscore, "Very Good: 750 - 799");
		return this;
	}

	@FindBy(how = How.XPATH, using = "// input[contains(@id,'FromDate') and contains(@class,'editDate')]")
	private WebElement dateofliving;

	public Borrowerdetails enterdate() {
		dateofliving.sendKeys("05/05/2015");
		return this;
	}

	@FindBy(how = How.ID, using = "fwkSave")
	private WebElement savebutton;

	@FindBy(how = How.XPATH, using = "//img[@id='imgAjaxResultTick']/../font")
	private WebElement savemessage;

	public Borrowerdetails clicksave() throws InterruptedException {
		clickelement(savebutton);
		wait.until(ExpectedConditions.textToBePresentInElement(savemessage, "Data saved successfully!"));
		pageloadstate();

		return this;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='divBorrowers']/div/table//table//tr[3]/td[3]/a")
	private WebElement navigatecoborrower;

	public Borrowerdetails navigatecoboorower() throws InterruptedException {
		clickelement(navigatecoborrower);
		pageloadstate();

		return this;
	}

	@FindBy(how = How.XPATH, using = "//img[@id='img_UtilitiesmenuId']")
	private WebElement utilitymenu;

	public Borrowerdetails navigateutilitiesmenu() {
		mouseover(utilitymenu);
		return this;
	}

	@FindBy(how = How.XPATH, using = "//a[@id='eSupplyChainManagement_ProductOrderingNew']")
	private WebElement providerselectionmenu;
	
	public thirdpartyorderingscreen navigateProductOrderingNewmenu() throws InterruptedException {
		mouseoverclick(providerselectionmenu);
		pageloadstate();
		return new thirdpartyorderingscreen();
	}

}
