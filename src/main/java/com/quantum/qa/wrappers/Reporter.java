package com.quantum.qa.wrappers;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Reporter extends Quantumwrappers{
	
	protected static ExtentHtmlReporter html;
	protected static ExtentReports extent;
	protected static ExtentTest test;
	
	public static void takesnapshot(String status) throws IOException {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy/ss");
		Date date = new Date();
		String currentdate = dateFormat.format(date);
		String dateformat = currentdate.replace("/", "");
		filepath = dateformat+testcase+".jpeg";
		
		try {
			FileUtils.copyFile(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE),
					new File("./reports/"+filepath));
		} catch (WebDriverException e) {
			System.out.println("Webdriver exception occured while taking screenshot");
		} catch (IOException e) {
			System.out.println("File not found exception occured while takign screenshot");
		}
		
		test.addScreenCaptureFromPath("./../reports/"+filepath);
		if (status.equalsIgnoreCase("pass")) {
			test.log(Status.PASS, "Testcase passed successfully");
		} else {
			test.log(Status.FAIL, "Testcase Failed!!!!!!!!!");
		}
		
		//return filepath;
	}
	
	
	public static void htmlreportgen() {
		html = new ExtentHtmlReporter("./reports/smoketestresult102019.html");
		html.setAppendExisting(true);
		extent = new ExtentReports();
		extent.attachReporter(html);
	}

	public static void htmltestgen() {
		test = extent.createTest(testcasename, testcasedescription);
		test.assignAuthor("Anand");
		test.assignCategory("sanity");
	}
	
	public static void endresult() {
		
		extent.flush();
	}
	
	 	
	
	
}
