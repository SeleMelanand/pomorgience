package com.quantum.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.quantum.qa.wrappers.Quantumwrappers;

public class ProductAndPricing extends Quantumwrappers{
	WebDriverWait wait1 = new WebDriverWait(driver, 80);


	public ProductAndPricing selectpro() throws InterruptedException {
		clickelement(locateelement("xpath", "//button[text()='Search Program']"));
		wait1.until(ExpectedConditions.visibilityOf(locateelement("xpath", "//td[text()='Eligible']")));
		pageloadstate();
		return this;
	}
	
	public ProductAndPricing selecteligibleprog() throws InterruptedException {
		int counter, i =0;
		List<WebElement> programlist = getlistofelements("//div[@id='Eligiblegrid']/table/tbody/tr/td[5]");

		for (i = 0; i <= programlist.size(); i++) {
			if (programlist.get(i).getText().contains("5/1 Year LIBOR") == true) {
				counter = i;
				System.out.println(counter);
				break;
			}
			
		}
		counter=i+1; 
		
		System.out.println(counter);
		
		WebElement eligibleprogram = locateelement("xpath", "// div[@id='Eligiblegrid']/table/tbody/tr["+ counter +"]/td[6]");
		eligibleprogram.click();
		
		Thread.sleep(3000);
		
		WebElement selectspecificprogram = locateelement("id", "SYS_PPE_SAVE");
		
		selectspecificprogram.click();
		List<WebElement> lockrsponseelements = getlistofelements("//div[@id='MN-data']/div[4]/table//table//tr");
		wait1.until(ExpectedConditions.visibilityOfAllElements(lockrsponseelements));
		System.out.println("Rate lock done for the loan");
		
		return this;					
	}
	
	public ProductAndPricing navigatesalesmenu() {
		WebElement salesmenu = locateelement("xpath", "//a[@id='eOrigination']");
		mouseover(salesmenu);
		return this;
	}
	
	public Workflow navigateworkflow() {
		mouseoverclick(locateelement("id", "eOrigination_Origination_WorkFlow_New"));		
		wait1.until(ExpectedConditions.visibilityOf(locateelement("xpath", "//div[@id='WorkflowContainer']")));
		
		
	return new Workflow();
	}
	
	
	
	
	
	
	
	
	
}
