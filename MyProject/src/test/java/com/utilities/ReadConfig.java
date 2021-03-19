package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	
	public ReadConfig()
	{
		File file = new File("./config.properties");
		try 
		{
			FileInputStream fis= new FileInputStream(file);
			pro = new Properties();
			pro.load(fis);
			
		}
		catch(Exception e)
		{
			System.out.println(e.getStackTrace());
		}
	}

	public String getApplicationUrl()
	{
		String url = pro.getProperty("url");
		return url;
	}
	
	public String getEmail() 
	{
		String email = pro.getProperty("email");
		return email;
	}
	
	public String getPassword() 
	{
		String password = pro.getProperty("password");
		return password;
	}
	
	public String getChromePath() 
	{
		String chromePath = pro.getProperty("chromePath");
		return chromePath;
	}
	
	
}
