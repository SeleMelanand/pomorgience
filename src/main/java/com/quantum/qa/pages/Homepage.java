package com.quantum.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.quantum.qa.wrappers.Genericwrappers;

public class Homepage extends Genericwrappers {
	WebDriverWait wait = new WebDriverWait(driver, 30);

	public Homepage navigatesalesmenu() {
		WebElement salesmenu = locateelement("xpath", "//a[@id='eOrigination']");
		mouseover(salesmenu);
		return this;

	}

	public Homepage naviapplicationmenu() {
		WebElement applicationmenu = locateelement("xpath","//a[@id='eOrigination_QuickApp']");
		mouseover(applicationmenu);
		return this;
	}

	
	public QucikappPage naviquickappmenu() {
		WebElement fullappmenu = locateelement("xpath", "//a[@id='QuickApp_Index']");
		mouseoverclick(fullappmenu);
		return new QucikappPage();
	}
	
	
	public Fileuploadpage navifileuploadmenu() {
		WebElement fileuploadmenu = locateelement("xpath", "//a[@id='QuickApp_UploadTransactionPage']");
		mouseoverclick(fileuploadmenu);
		return new Fileuploadpage();		
		
	}
	
	public Filesummary loansearch(String loannum) {
		
		entervalueandclick(locateelement("id", "main-search-box"), loannum);
		
		wait.until(ExpectedConditions.visibilityOf(locateelement("id", "FilesummaryLoanNumber")));
		return new Filesummary();
	}
	

}
