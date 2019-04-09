package com.quantum.qa.pages;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.quantum.qa.wrappers.Quantumwrappers;
import com.quantum.qa.wrappers.Reporter;

public class Filesummary extends Quantumwrappers {
	public String loannumber;
	WebDriverWait wait = new WebDriverWait(driver, 30);

	public Filesummary getloannumber() throws InterruptedException, IOException {
		WebElement filesummaryloannum = locateelement("xpath", "//div[@id='FilesummaryLoanNumber']/a");
		wait.until(ExpectedConditions.visibilityOf(filesummaryloannum));

		WebElement loannum = locateelement("xpath", "//div[@id='FilesummaryLoanNumber']/a ");
		loannumber = gettext(loannum);
		System.out.println("Loan number generated is : " + loannumber);
		
		
		FileInputStream fis1 = new FileInputStream("./testdata/loanData.xlsx");
		XSSFWorkbook	workbook1 = new XSSFWorkbook(fis1);
		XSSFSheet worksheet1 = workbook1.getSheet("Sheet1");
		int rowcount = worksheet1.getLastRowNum() + 1;
		XSSFRow row = worksheet1.createRow(rowcount);
		row.createCell(0).setCellValue(loannumber);
		FileOutputStream fos1 = new FileOutputStream(".//testdata/loanData.xlsx");
		workbook1.write(fos1);
		System.out.println("Value written in excel sheet");
		return this;
	}

	public Filesummary verifytext(String tcname) throws IOException {
		//loannumber.contains("[0-9]") && loannumber.length()==10
		String regexvalue = "[0-9]{10}";
		if (loannumber.matches(regexvalue)) {
			status = "Pass";
			System.out.println("Status of the given testcase is : "+tcname+" - " + status);

		} else {
			status = "Fail";
			System.out.println("Status of the given testcase is : " +tcname+" - " + status);
		}
					
		Reporter.takesnapshot(status);
		return this;
	}

	
	
	public  Borrowerdetails gotoborrowertab() {
		WebElement borrowermenu = locateelement("id", "dock4_eFile_BorrowerView");
		borrowermenu.click();
				
		wait.until(ExpectedConditions.elementToBeClickable(locateelement("xpath", "//a[text()='Add']")));
		
		
		return new Borrowerdetails();
	}

			
}
