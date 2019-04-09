package com.quantum.qa.wrappers;

import java.io.IOException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

public class Quantumwrappers extends Genericwrappers {
	
	public static String testcasename,status, testcasedescription, loanvalue;

	@BeforeTest(alwaysRun = true)
	public void htmlreportgenerator() throws IOException {
		loaddata();
		Reporter.htmlreportgen();	
		
	}

	
	
	@BeforeMethod(alwaysRun = true)
	public void launchapp() {
		Reporter.htmltestgen();
		invokeapp();
	}

	//@AfterMethod(alwaysRun = true)
	public void closeapp() throws InterruptedException, IOException {
		browserclose();
	}

	
	@AfterSuite(alwaysRun = true)
	public void reportclose() {
		Reporter.endresult();	
	}
	
	
	
	
	
	
	
	
	
}
