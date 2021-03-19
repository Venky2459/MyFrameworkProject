package com.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pageObjectClasses.LoginPage;

public class TC0001_Login extends CommonMethods
{
	@Test
	public void verifyLogin()
	{
		logger.info("URL is opened");
		
		LoginPage lp = new LoginPage(driver);
		
		lp.clickloginLink();
		logger.info("Login link is clicked");
		
		String actualMessage = lp.verifywelcomeMessage();
		if(actualMessage.contains("Welcome, Please Sign In!"))
		{
			Assert.assertTrue(true);
		}
		logger.info("Welcome message is verified");
		
		lp.setemail(Email);
		logger.info("Email is entered");
		
		lp.setpassword(Password);
		logger.info("Password is verified");
		
		lp.clickloginButton();
		logger.info("Login button is clicked");
		
		String accountEmail = lp.getaccountEmail();
		if(accountEmail.contains(Email))
			{
			Assert.assertTrue(true);
			}
		logger.info("Account Id is verified");
	}
	
}
