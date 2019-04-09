package com.quantum.qa.testcase;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.quantum.qa.pages.Loginpage;
import com.quantum.qa.wrappers.DataproviderLoanData;
import com.quantum.qa.wrappers.Quantumwrappers;

@Test(groups = {"smoketest","EndtoEnd"})
public class Tc004loanSalestoProcessing extends Quantumwrappers{
	
	@BeforeClass
	public void teescasedata() {
		testcase = "Tc004loaninsales";
		testcasename 	= "TC004 - Sales activity in Loan";
		testcasedescription = "Necessary details entered, placed Credit order, AUS Order and submitted to Processing";
		
		loanvalue = DataproviderLoanData.getSheet("Sheet1"); 
		
	}
	
	
	
	@Test(groups = {"EndtoEnd"})
	public void salesactivity() throws InterruptedException, IOException {
		
		new Loginpage()
		.enterusername()
		.enterpassword()
		.clicklogin()
		.loansearch(loanvalue)
		.gotoborrowertab()
		.gotonameaddresstab()
		.authorisetopullcredit()
		.selectcreditscore()
		.enterdate()
		.clicksave()
		.navigatecoboorower()
		.authorisetopullcredit()
		.selectcreditscore()
		.enterdate()
		.clicksave()
		.navigateutilitiesmenu()
		.navigateProductOrderingNewmenu()
		.movetoproductlist()
		.selectcreditorder()
		.selectorderproducts()
		.selectsubmitorder()
		.navigatesalesmenu()
		.navigateppe()
		.selectpro()
		.selecteligibleprog()
		.navigatesalesmenu()
		.navigateworkflow()
		.clearsubmitprecondition("Processing")
		.submitprocessing()
		.verifytext(testcase);
		
		//System.out.println("loan program executed successfully for TC004");
		
		
		
		
	}


}
