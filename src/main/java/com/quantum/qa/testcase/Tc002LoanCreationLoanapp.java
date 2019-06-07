package com.quantum.qa.testcase;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.quantum.qa.pages.Loginpage;
import com.quantum.qa.wrappers.Quantumwrappers;

@Test(groups = {"samplerun"})
public class Tc002LoanCreationLoanapp extends Quantumwrappers{
	
	@BeforeClass
	public void teescasedata() {
		testcase = "Tc002LoanCreationLoanapp";
		testcasename 	= "TC002 - LoanApp - Loan Creation";
		testcasedescription = "Creating loan using Loan App functionality";
	}
	
	@Test(groups = {"samplerun"})
	//@Test(groups= {"smoketest"})
	public void createloanapplication() throws InterruptedException, IOException {
		new Loginpage()
		.enterusername()
		.enterpassword()
		.clicklogin();
		
		
		
		
		
		// trying to change the code and push it so that it triggers test in jenjins
		
		/*.navigatesalesmenu()
		.naviapplicationmenu()
		.naviquickappmenu()
		.bfname("Penny")
		.blname("Public ")
		.bssn("999-60-3000")
		.estficoscore()
		.proertystate();
		.proertytype()
		.occupancytype()
		.estimatedvalue()
		.loanpurpose()
		.loanamount()
		.saveloan()
		.getloannumber()
		.verifytext(testcase);*/
		
	}
	

}
