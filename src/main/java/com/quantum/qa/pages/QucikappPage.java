package com.quantum.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.quantum.qa.wrappers.Genericwrappers;

public class QucikappPage extends Genericwrappers {

	//private WebElement ;

	public QucikappPage bfname(String name) {
		WebElement bfname = locateelement("id", "PrimaryBorrower_BorrowerFirstName_QQ_BorrowerFirstName_QQ");
		entervalue(bfname, name);
		return this;

	}

	public QucikappPage blname(String name) {
		WebElement blname = locateelement("id", "PrimaryBorrower_BorrowerLastName_QQ_BorrowerLastName_QQ");
		entervalue(blname, name);
		return this;

	}

	public QucikappPage bssn(String ssnvalue) {
		WebElement bssn = locateelement("id", "PrimaryBorrower_SSNNo_SSNNo_New");
		entervalue(bssn, ssnvalue);
		return this;
	}

	public QucikappPage estficoscore() {
		WebElement estfico = locateelement("id", "PrimaryBorrower_EstimatedFICOScore_EstimatedFICOScore");
		selectbyvisibletext(estfico, "Very Good: 750 - 799");
		return this;
	}

	public QucikappPage proertystate() {
		WebElement propstate = locateelement("id", "Property_PropertyState");
		selectbyvisibletext(propstate, "CA");
		return this;
	}

	public QucikappPage proertycounty() {
		WebElement propcounty = locateelement("id", "Property_PropertyCounty");
		selectbyvisibletext(propcounty, "SAN DIEGO");
		return this;
	}

	public QucikappPage proertytype() {
		WebElement proptype = locateelement("id", "Property_PropertyType_PropertyType");
		selectbyvisibletext(proptype, "SFR Attached");
		return this;
	}

	public QucikappPage occupancytype() {
		WebElement occtype = locateelement("id", "Property_PropertyOccupancyType_PropertyOccupancyType");
		selectbyvisibletext(occtype, "Primary Residence");
		return this;
	}

	public QucikappPage loanpurpose() {
		WebElement lnpurpose = locateelement("id", "Loan_LoanPurpose_LoanPurpose");
		selectbyvisibletext(lnpurpose, "Purchase");
		return this;
	}

	public QucikappPage estimatedvalue() {
		WebElement blname = locateelement("id", "Property_EstimatedValue_EstimatedValue");
		entervalue(blname, "500000");
		return this;
	}

	public QucikappPage loanamount() {
		WebElement loanamt = locateelement("id", "Loan_LoanAmount_LoanAmount");
		entervalue(loanamt, "350000");
		return this;
	}

	public Filesummary saveloan() {
		WebElement saveasreferral = locateelement("xpath", "//div[@id='globalfooter1']//button[5]");
		clickelement(saveasreferral);
		return new Filesummary();

	}

	public QucikappPage searchprogram() {
		WebElement searchpro = locateelement("xpath", "//button[text()='Search Program'][2]");
		searchpro.click();
		return this;
	}

	public Filesummary selecteligibleprog() throws InterruptedException {
		int counter=0;
		List<WebElement> programlist = getlistofelements("//div[@id='Eligiblegrid']/table/tbody/tr/td[5]");

		for (int i = 0; i <= programlist.size(); i++) {
			if (programlist.get(i).getText().contains("3/1 Year NonConvertible") == true) {
				counter = i;
				System.out.println(counter);
				break;
			}

		}
		System.out.println(counter);
		
		WebElement eligibleprogram = locateelement("xpath", "// div[@id='Eligiblegrid']/table/tbody/tr["+ counter +"]/td[6]");
		eligibleprogram.click();
		
		Thread.sleep(3000);
		
		WebElement selectspecificprogram = locateelement("id", "SaveProgramFloat");
		selectspecificprogram.click();
		return new Filesummary();
		

	}

}
