package com.quantum.qa.pages;

import java.util.List;

import org.apache.xerces.impl.xpath.XPath;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.stylesheets.LinkStyle;

import com.quantum.qa.wrappers.Quantumwrappers;

public class thirdpartyorderingscreen extends Quantumwrappers {
	WebDriverWait wait = new WebDriverWait(driver, 30);

	public thirdpartyorderingscreen movetoproductlist() {
		clickelement(locateelement("id", "tabKeyDates"));
		return this;
	}

	public thirdpartyorderingscreen selectcreditorder() {
		clickelement(locateelement("xpath", "//input[@id='ProductCategoryList_123']"));
		return this;
	}

	public thirdpartyorderingscreen selectorderproducts() {
		clickelement(locateelement("xpath", "//div[@id='divProductList']/section/div/div[2]/span[2]"));
		wait.until(ExpectedConditions.elementToBeClickable(locateelement("xpath", "//span[@id='btnSubmit']")));
		return this;
	}

	public thirdpartyorderingscreen selectsubmitorder() throws InterruptedException {
		clickelement(locateelement("xpath", "//span[@id='btnSubmit']"));

		List<WebElement> tablelist = null;
		int i;
		do {
			driver.navigate().refresh();
			pageloadstate();
			tablelist = getlistofelements("//table[@role='treegrid']//tbody/tr");
			i = tablelist.size();
			
		} while (i <= 0);
		return this;
	}

	public thirdpartyorderingscreen navigatesalesmenu() {
		WebElement salesmenu = locateelement("xpath", "//a[@id='eOrigination']");
		mouseover(salesmenu);
		return this;
	}

	// a[@id='eOrigination_NewProductPricing']
	public ProductAndPricing navigateppe() {
		WebElement ppemenu = locateelement("id", "eOrigination_NewProductPricing");
		mouseoverclick(ppemenu);
		return new ProductAndPricing();

	}

}
