package com.pageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{

	WebDriver ldriver;
	public LoginPage (WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//a[text()='Log in']")
	WebElement loginLink;
	
	@FindBy(xpath="//h1[contains(text(),'Welcome, Please Sign In!')]")
	WebElement welcomeMessage;
	
	@FindBy(xpath="//input[@id='Email']")
	WebElement email;
	
	@FindBy(xpath="//input[@name='Password']")
	WebElement password;
	
	@FindBy(xpath="//input[@class='button-1 login-button']")
	WebElement loginButton;
	
	@FindBy(xpath="//a[contains(text(),'mail.com')]")
	WebElement accountEmail;
	
	
	
	
	public void clickloginLink()
	{	
		loginLink.click();
		
	}
	
	public String verifywelcomeMessage()
	{
		String Message = welcomeMessage.getText();
		return Message;
	}
	
	public void setemail(String email1)
	{
		email.sendKeys(email1);
	}
	
	public void setpassword(String password1)
	{
		password.sendKeys(password1);
	}
	
	public void clickloginButton()
	{
		loginButton.click();
	}
	
	public String getaccountEmail()
	{
		String AccountEmail = accountEmail.getText();
		return AccountEmail;
	}
}
