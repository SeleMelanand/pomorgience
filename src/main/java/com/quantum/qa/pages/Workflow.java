package com.quantum.qa.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.quantum.qa.wrappers.Quantumwrappers;
import com.quantum.qa.wrappers.Reporter;

public class Workflow extends Quantumwrappers {

	WebDriverWait wait1 = new WebDriverWait(driver, 120);

	public Workflow clearsubmitprecondition(String clearcondition) throws InterruptedException {

		clickelement(locateelement("xpath", "//span[@id='workflowCollapseExpand']/i"));
		Thread.sleep(2000);
		mouseover(locateelement("xpath", "(//li[@id='liActionTemplate'])[1]/a/span"));

		List<WebElement> preconditionlist = getlistofelements("(//li[@id='liActionTemplate'])[1]/div//span");

		System.out.println("number of preconditions  available : " + preconditionlist.size());

		for (WebElement eachcondition : preconditionlist) {
			System.out.println(eachcondition.getText());

			String precondition = eachcondition.getText();

			if (precondition.contains("Document (s) are not received")) {
				System.out.println("Going to upload the doucments for required document");
				
				pagedown(locateelement("xpath", "(//li[@id='liAction'])[1]/a/span"));

				clickelement(locateelement("xpath", "//span[@data-field='Name']/span/span[2]"));

				mouseoverclick(locateelement("xpath", "(//li[text()='Contains'])[2]"));

				entervalueandclick(locateelement("xpath", "//span[@role='presentation']/input"), "borrowers");

				List<WebElement> listofreqdocs = getlistofelements("//div[@id='gridRequiredDocs']/div[3]//tbody/tr");
				System.out.println("Total number of rows in req docs: " + listofreqdocs.size());

				for (int i = 1; i <= listofreqdocs.size(); i++) {
					clickelement(locateelement("xpath", "(//input[@id='chkReqDocument'])[" + i + "]"));
					clickelement(locateelement("xpath", "(//div[contains(@id,'divReqDocAction')])[" + i + "]/a[3]"));
					Thread.sleep(5000);
					switchintoframe("id", "umbModalBoxIframe");

					wait1.until(ExpectedConditions
							.visibilityOf(locateelement("xpath", "//div[@id='MasterCloseBtn']//td//button[4]")));

					WebElement choosefile = locateelement("xpath", "//input[@id='uploadFile']");
					choosefile.sendKeys(
							"D:\\a - cudirect\\fnmuploadforautomation\\documentupload\\Purchase Contract.pdf");
					Thread.sleep(3000);
					clickelement(locateelement("id", "fwkSave"));
					switchtobasewindow();
					Thread.sleep(3000);

				}

				System.out.println("for loop execution completed");
				pagerefresh();
				

			} else {

				System.out.println("Going to Clear the necessary conditions");

				WebElement conditionfiltername = locateelement("xpath",
						"//div[@id='gridConditions']/div[3]//thead//th[12]");
				String textvalue = conditionfiltername.getAttribute("title");

				pagedown(locateelement("xpath", "(//li[@id='liCondition'])[2]/a/span"));

				if (textvalue.equalsIgnoreCase("Prior To")) {
					WebElement conditionfilter = locateelement("xpath",
							"//div[@id='gridConditions']/div[3]//thead//th[12]//span");
					conditionfilter.click();

					WebElement clearconditionstate = locateelement("xpath", "//span[text()='--Select Value--']");
					clearconditionstate.click();
					//System.out.println("Select value is selected");

					mouseoverclick(locateelement("xpath",
							"(//div[@class='k-animation-container'])[1]/form/div[2]//ul/li[15]"));

					List<WebElement> listofvalue = getlistofelements(
							"(//div[@class='k-animation-container'])[1]/form/div[2]//ul/li");
					for (WebElement value : listofvalue) {
						String tetvalue = value.getText();
						if (tetvalue.equalsIgnoreCase(clearcondition)) {
							value.click();
						}

					}

					WebElement filterselect = locateelement("xpath", "//button[text()='Filter']");
					filterselect.click();

				}

				clickelement(locateelement("id", "cb_ConditionsAll"));

				mouseover(locateelement("id", "liActions"));
				mouseoverclick(locateelement("id", "liClear"));
				System.out.println("Conditions cleared successfully");

			}

		

		}
		clickelement(locateelement("xpath", "//span[text()='Workflow']"));
		clickelement(locateelement("xpath", "//span[@id='workflowCollapseExpand']/i"));

		return this;
	}

	public Workflow workflowmaximise() {
		WebElement maxworkflowbutton = locateelement("xpath",
				"//div[@id='WorkflowContainer']/table/tbody//table//span/i");
		clickelement(maxworkflowbutton);
		return this;
	}
	
	public Workflow submitprocessing() throws InterruptedException {
		clickelement(locateelement("id", "SYS_ORG_SUBMIT"));
		
		pageloadstate();		
		return this;
		
		
	}
	
	
	public  Workflow verifytext(String tcname) throws IOException {
		
		String textvalue = locateelement("xpath", "//div[@id='contentdiv']/div[1]/table//td[1]").getText();
		if(textvalue.contains("Processing")) {	
			status = "Pass";
			System.out.println("Loan submitted to processor successfully");
		}else {
			status = "Fail";
			System.out.println("Loan submitted to processor but status not updated successfully");
		}
									
		Reporter.takesnapshot(status);
		return this;
	}
	
	
	
	

}
