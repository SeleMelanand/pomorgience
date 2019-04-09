package com.quantum.qa.wrappers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.Select;

import listenerutils.EventListerner;

public class Genericwrappers {

	public static WebDriver driver;
	public String states;
	public static String testcase;
	public static String filepath;
	public static Properties prop;
	public static File inputfil;
	public static FileReader fr;
	public static EventFiringWebDriver efwebdriver; 
	public static EventListerner eventlisterner;

	
	
	public void loaddata() {	
		try {
			prop = new Properties();
			FileInputStream fiscp = new FileInputStream("./config/object.properties");
			prop.load(fiscp);
		} catch (FileNotFoundException e) {
			System.out.println("File not present in the respective folder");
		} catch (IOException e) {
			System.out.println("IO exception ocured");
			e.printStackTrace();
		}
		
	}	
	
	
	public void invokeapp() {

		//String url = prop.getProperty("locator.login");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		//following four lines of code is used to get the logs using listerner class 
		efwebdriver = new EventFiringWebDriver(driver);
		eventlisterner = new EventListerner(); 
		efwebdriver.register(eventlisterner);
		driver = efwebdriver;
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(prop.getProperty("application.url"));
		
	}

	public WebElement locateelement(String locatordetails, String locatorvalue) {
		WebElement ele = null;
		try {
			switch (locatordetails) {
			case "id":
				//ele = driver.findElementById(locatorvalue);--- remote web driver
				ele = driver.findElement(By.id(locatorvalue));
				break;

			case "class":
				ele =driver.findElement(By.className(locatorvalue)); 
				//driver.findElementByClassName(locatorvalue);
				break;
			// return
			case "name":
				ele = driver.findElement(By.name(locatorvalue));
				//driver.findElementByName(locatorvalue);
				break;
			// return
			case "linktext":
				ele = driver.findElement(By.linkText(locatorvalue)); 
				//driver.findElementByLinkText(locatorvalue);
				break;
			// return
			case "partiallinktext":
				ele =driver.findElement(By.partialLinkText(locatorvalue)); 
				//driver.findElementByPartialLinkText(locatorvalue);
				break;
			// return
			case "xpath":
				ele = driver.findElement(By.xpath(locatorvalue)); 
				//driver.findElementByXPath(locatorvalue);
				break;
			// return
			}

		} catch (Exception e) {
			System.out.println(locatorvalue + " : Exception occured while identifying element - " + e);
		}
		return ele;

	}

	public void unreadalertbutton() {
		
		int i= driver.findElements(By.xpath("//div[@id='divPopupAlert']/div[2]/table/tbody/tr//div[2]//img")).size();
				//findElementsByXPath("//div[@id='divPopupAlert']/div[2]/table/tbody/tr//div[2]//img").size();
		
		if (i!=0) {
			WebElement UnreadAlertclose = locateelement("xpath", "//div[@id='divPopupAlert']/div[2]/table/tbody/tr//div[2]//img");
			UnreadAlertclose.click();
		}
	}

	public void entervalue(WebElement element, String textvalue) {
		unreadalertbutton();
		try {
			element.clear();
			element.sendKeys(textvalue);
		} catch (Exception e) {
			System.out.println(element + " : Exception occured while entering the value : " + e);

		}

	}

	public void entervalueandclick(WebElement element, String textvalue) {
		unreadalertbutton();
		try {
			element.clear();
			element.sendKeys(textvalue, Keys.ENTER);
		} catch (Exception e) {
			System.out.println(element + " : Exception occured while entering the value : " + e);

		}

	}

	public void clickelement(WebElement element) {
		unreadalertbutton();
		try {
			element.click();
		} catch (Exception e) {
			System.out.println(element + " : Exception occured while entering the value : " + e);
		}
	}

	public String gettext(WebElement element) {
		unreadalertbutton();
		String textvalue = null;
		try {
			textvalue = element.getText();
			System.out.println("retrieved value is : " + textvalue);
		} catch (Exception e) {
			System.out.println(element + " : Exception occured while entering the value : " + e);

		}
		return textvalue;
	}

	public void selectbyvisibletext(WebElement element, String textvalue) {
		unreadalertbutton();
		try {
			Select svtid = new Select(element);
			svtid.selectByVisibleText(textvalue);
		} catch (Exception e) {
			System.out.println(element + " : Exception occured while entering the value : " + e);

		}

	}

	public List<WebElement> getlistofelements(String textvalue) {
		unreadalertbutton();
		List<WebElement> listvalue = null;;
		try {
			listvalue = driver.findElements(By.xpath(textvalue));
					//findElementsByXPath(textvalue);
		} catch (Exception e) {
			System.out.println(textvalue+ " : Exception occured while entering the value : " + e);

		}
		return listvalue;
	}

	
	
	
	public void mouseover(WebElement element) {
		unreadalertbutton();
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	public void mouseoverclick(WebElement element) {
		unreadalertbutton();
		Actions action = new Actions(driver);
		action.moveToElement(element).click().build().perform();
	}

	public void pagedown(WebElement specificfield) {
		JavascriptExecutor jse =  (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView();",specificfield);
		
	}
	
	public void browserclose() throws InterruptedException {
		Thread.sleep(4000);
		WebElement logoutbutton = locateelement("id", "atLogout");
		logoutbutton.click();
		driver.close();
	}
	
	
	public void switchintoframe(String locator, String value) {
		WebElement framename = locateelement(locator, value);
		driver.switchTo().frame(framename);
		System.out.println("Control switched in to respective frame");
	}

	public void switchtobasewindow() {
		driver.switchTo().defaultContent();
		System.out.println("Control switched to base window");
	}
	
	public void pagerefresh() {
		driver.navigate().refresh();
		
	}
	public void pageloadstate() throws InterruptedException {
		// get the state whether page is loading or not
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String states = null;
		do {
			states = js.executeScript("return document.readyState").toString();
			System.out.println("page loading please wait... ");
			Thread.sleep(1500);
		} while (states == "complete" );
		
		System.out.println("page loaded sucessfully: " + states);

	}
	
	
	
	
}
