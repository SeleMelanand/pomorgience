package com.quantum.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.quantum.qa.wrappers.Genericwrappers;

public class Fileuploadpage extends Genericwrappers {

	// using pagefactory elements are getting loaded.
	// Initializing the page objects.
	public Fileuploadpage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//input[contains(@id,'ctlFileUpload')]")
	private WebElement choosefile;

	@FindBy(how = How.XPATH, using = "//input[contains(@id,'btnUploadFile')]")
	private WebElement upload;

	public Filesummary clickupload(String loannumber) throws InterruptedException {
		choosefile.sendKeys("D:\\a - cudirect\\fnmuploadforautomation\\" + loannumber + ".fnm");
		Thread.sleep(3000);
		upload.click();
		return new Filesummary();
	}

}
