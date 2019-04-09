package com.quantum.qa.pages;

import org.openqa.selenium.WebElement;

import com.quantum.qa.wrappers.Genericwrappers;

public class Fileuploadpage extends Genericwrappers{
	
	public Filesummary clickupload(String loannumber) throws InterruptedException {
		WebElement choosefile = locateelement("xpath", "//input[contains(@id,'ctlFileUpload')]");
		choosefile.sendKeys("D:\\a - cudirect\\fnmuploadforautomation\\"+ loannumber+".fnm");
		Thread.sleep(3000);		
		WebElement upload = locateelement("xpath", "//input[contains(@id,'btnUploadFile')]");
		upload.click();
		return new Filesummary();
		
	}

}
