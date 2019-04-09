package com.quantum.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.quantum.qa.wrappers.Genericwrappers;

public class Homepage extends Genericwrappers {
	WebDriverWait wait = new WebDriverWait(driver, 30);

	//using pagefactory elements are getting loaded.	

	// Initializing the page objects.
	public Homepage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[@id='eOrigination']")
	private WebElement salesmenu;

	public Homepage navigatesalesmenu() {
		mouseover(salesmenu);
		return this;
	}

	@FindBy(how = How.XPATH, using = "//a[@id='eOrigination_QuickApp']")
	private WebElement applicationmenu;

	public Homepage naviapplicationmenu() {
		mouseover(applicationmenu);
		return this;
	}

	@FindBy(how = How.XPATH, using = "//a[@id='QuickApp_Index']")
	private WebElement fullappmenu;

	public QucikappPage naviquickappmenu() {
		mouseoverclick(fullappmenu);
		return new QucikappPage();
	}

	@FindBy(how = How.XPATH, using = "//a[@id='QuickApp_UploadTransactionPage']")
	private WebElement fileuploadmenu;

	public Fileuploadpage navifileuploadmenu() {
		mouseoverclick(fileuploadmenu);
		return new Fileuploadpage();

	}

	@FindBy(how = How.ID, using = "main-search-box")
	private WebElement loantext;

	@FindBy(how = How.ID, using = "FilesummaryLoanNumber")
	private WebElement filesummaryloannumtext;

	public Filesummary loansearch(String loannum) {
		loantext.sendKeys(loannum);
		wait.until(ExpectedConditions.visibilityOf(filesummaryloannumtext));
		return new Filesummary();
	}

}
