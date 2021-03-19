package com.testCases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.utilities.ReadConfig;

public class CommonMethods {
	ReadConfig readConfig = new ReadConfig();
	
	public String applicationUrl= readConfig.getApplicationUrl();
	public String Email = readConfig.getEmail();
	public String Password = readConfig.getPassword();
	public String chromeLocation = readConfig.getChromePath();
	
	public static WebDriver driver;
	public static Logger logger;
	
	@BeforeClass
	public void setUp()
	{
		logger = Logger.getLogger("My Project");
		PropertyConfigurator.configure("./log4j.properties");	
		
		System.setProperty("webdriver.chrome.driver", chromeLocation);
		driver = new ChromeDriver();
		driver.get(applicationUrl);
		
	}
	@AfterClass 
	public void tearDown()
	{
		driver.quit();
	}
	

}
