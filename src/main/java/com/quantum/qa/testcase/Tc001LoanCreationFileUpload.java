package com.quantum.qa.testcase;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.quantum.qa.pages.Loginpage;
import com.quantum.qa.wrappers.Genericwrappers;
import com.quantum.qa.wrappers.Quantumwrappers;

@Test(groups = {"smoketest","EndtoEnd"})
public class Tc001LoanCreationFileUpload extends Quantumwrappers{
	 

	 
	@BeforeClass
	public void teescasedata() {
		testcase = "Tc001LoanCreationFileUpload";
		testcasename 	= "TC001 - LoanApp - Loan creation - fnm file";
		testcasedescription = "Creating loan using fnmfile";
	}
	
	
	@Test(groups = {"smoketest","EndtoEnd"})
	public void createloanfilupload() throws InterruptedException, IOException {
		new Loginpage()
		.enterusername()
		.enterpassword()
		.clicklogin()
		.navigatesalesmenu()
		.naviapplicationmenu()
		.navifileuploadmenu()
		.clickupload("3110001040")
		.getloannumber()
		.verifytext(testcase);
		
		//System.out.println("loan program executed successfully for TC001");
		
		
	}

}
