package com.quantum.qa.testcase;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.quantum.qa.pages.Loginpage;
import com.quantum.qa.wrappers.Quantumwrappers;

@Test(groups = {"smoketest"})
public class Tc003ReferralProgramSelection extends Quantumwrappers {
	@BeforeClass
	public void teescasedata() {
		testcase = "Tc003ReferralProgramSelection";
		testcasename 	= "TC003 - LoanApp - Loan with referral program";
		testcasedescription = "Creating loan using Loan App functionality and dselecting a referal loan program";	
		}
	
	@Test(groups = {"smoketest"})
	public void loanwithreferalprogram() throws InterruptedException, IOException {
				
		new Loginpage()
		.enterusername()
		.enterpassword()
		.clicklogin()
		.navigatesalesmenu()
		.naviapplicationmenu()
		.naviquickappmenu()
		.bfname("Penny")
		.blname("Public")
		.bssn("999-60-3000")
		.estficoscore()
		.proertystate()
		.proertycounty()
		.proertytype()
		.occupancytype()
		.estimatedvalue()
		.loanpurpose()
		.loanamount()
		.searchprogram()
		.selecteligibleprog()
		.getloannumber()
		.verifytext(testcase);
		
		
		
	}
	

}
