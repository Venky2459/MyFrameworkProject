package myPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Assignment {
	
	@Test
	public void test()
	 {
	try 
	{
	System.setProperty("webdriver.chrome.driver","D:\\D\\Softwares\\drivers\\chromedriver_win32_89\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
		
	// 1. Navigate to URL : http://demowebshop.tricentis.com/
	driver.get("http://demowebshop.tricentis.com");
	driver.manage().window().maximize();
	//--------------------
	
	// 2. Click on Login button
	WebElement loginLink = driver.findElement(By.linkText("Log in"));
	loginLink.click();
	//--------------------
	
	////h1[contains(text(),'Welcome, Please Sign In!')]
	// 3. Validate “Welcome, Please Sign In!” message
	WebElement SignInMsg = driver.findElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
	
	String actualMsg = SignInMsg.getText();
	Assert.assertEquals(actualMsg, "Welcome, Please Sign In!");
	/*if (actualMsg.equals("Welcome, Please Sign In!"))
	{
		System.out.println("Welcome message is matching ");
	}
	else {
		System.out.println("Welcome message is not matching ");
	}*/
	//--------------------
	
	//4. Log in with given credentials
	
	WebElement email = driver.findElement(By.xpath("//input[@id='Email']"));
	email.sendKeys("atest@gmail.com");
	WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
	password.sendKeys("Docsis@1234");
	WebElement loginButton = driver.findElement(By.xpath("//body/div[4]/div[1]/div[4]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/form[1]/div[5]/input[1]"));
	loginButton.click();
	
	//--------------------
	
	// 5. Validate the user account ID on top right
	WebElement account = driver.findElement(By.xpath("//a[contains(text(),'atest@gmail.com')]"));
	String AccountID = account.getText();
	Assert.assertEquals(AccountID, "atest@gmail.com");
	/*if (AccountID.equals("atest@gmail.com"))
	{
		System.out.println("account ID is matching ");
	}
	else {
		System.out.println("account ID is not matching ");
	}*/
	//--------------------
	
	//6. Clear the shopping cart
	try
	{
	driver.findElement(By.xpath("//span[contains(text(),'Shopping cart')]")).click();
	driver.findElement(By.xpath("//tbody/tr[1]/td[1]/input[1]")).click();
	driver.findElement(By.xpath("//body/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/input[1]")).click();
	WebElement CartStatus = driver.findElement(By.xpath("//div[contains(text(),'Your Shopping Cart is empty!')]"));
	String CartStatus1 = CartStatus.getText();
	Assert.assertEquals(CartStatus1, "Your Shopping Cart is empty!");
	/*if (CartStatus1.equals("Your Shopping Cart is empty!"))
	{
		System.out.println("Shopping cart is cleared");
	}
	else {
		System.out.println("Shopping cart is not cleared");
	}*/
	}
	catch(Exception e)
	{
		
	}
	//--------------------
	// 7. Select “Books” from Categories
	driver.findElement(By.linkText("BOOKS")).click();
	
	//------------------
	// 8. Select a book from the list displayed
	driver.findElement(By.linkText("Computing and Internet")).click();
	
	//9. Get the price details and enter the quantity (more than one)
	WebElement Qty = driver.findElement(By.cssSelector("#addtocart_13_EnteredQuantity"));
	Qty.clear();
	Qty.sendKeys("2");
	
	// 10. Click on “Add to cart”
	driver.findElement(By.xpath("//input[@id='add-to-cart-button-13']")).click();
	Thread.sleep(2000);
	//11. Validate “The product has been added to shopping cart” message
	String productadded = driver.findElement(By.xpath("//body/div[@id='bar-notification']/p[1]")).getText();
	Assert.assertEquals(productadded, "The product has been added to your shopping cart");
	/*if (productadded.equals("The product has been added to your shopping cart"))
	{
		System.out.println("Product is added");
	}
	else {
		System.out.println("Product is not added");
	}*/
	driver.findElement(By.xpath("//body/div[@id='bar-notification']/span[1]")).click();
	Thread.sleep(2000);
	// 12. Click on “shopping cart” on top right and validate the “Sub-Total” Price for selected book.
	driver.findElement(By.xpath("//span[contains(text(),'Shopping cart')]")).click();
	
	//13. Click on “Check-out”
	
	driver.findElement(By.xpath("//input[@id='termsofservice']")).click();
	driver.findElement(By.xpath("//button[@id='checkout']")).click();
	
	//14. Select “New Address” From “Billing Address” drop down.
	WebElement billingAddress = driver.findElement(By.xpath("//select[@id='billing-address-select']"));
	Select BillingAddress = new Select(billingAddress);
	Thread.sleep(4000);
	BillingAddress.selectByVisibleText("New Address");
	
	Thread.sleep(1000);
	WebElement firstName = driver.findElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"));
	firstName.clear();
	firstName.sendKeys("Test123");
	WebElement lastName= driver.findElement(By.xpath("//input[@id='BillingNewAddress_LastName']"));
	lastName.clear();
	lastName.sendKeys("Test123");
	WebElement eMail =driver.findElement(By.xpath("//input[@id='BillingNewAddress_Email']"));
	eMail.clear();
	eMail.sendKeys("Test123@gmail.com");
	//country selection
	WebElement country = driver.findElement(By.xpath("//select[@id='BillingNewAddress_CountryId']"));
	Select CountrySelection = new Select(country);
	Thread.sleep(4000);
	CountrySelection.selectByVisibleText("India");
	driver.findElement(By.xpath("//input[@id='BillingNewAddress_City']")).sendKeys("Hyd");
	driver.findElement(By.xpath("//input[@id='BillingNewAddress_Address1']")).sendKeys("Vinukoda");
	driver.findElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']")).sendKeys("500000");
	driver.findElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']")).sendKeys("9876543210");
	
	//15. Fill all mandatory fields in “Billing Address” and click “Continue”
	Thread.sleep(2000);
	driver.findElement(By.xpath("//body/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/input[1]")).click();
	Thread.sleep(2000);
	//16. Select the “Shipping Address” as same as “Billing Address” from “Shipping Address” drop down and click on “Continue”
	WebElement shippingAddress = driver.findElement(By.xpath("//select[@id='shipping-address-select']"));
	Select ShippingAddress = new Select(shippingAddress);
	Thread.sleep(3000);
	ShippingAddress.selectByIndex(6);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//body/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/ol[1]/li[2]/div[2]/div[1]/input[1]")).click();
	Thread.sleep(1000);
	//17. Select the shipping method as “Next Day Air” and click on “Continue”
	driver.findElement(By.xpath("//input[@id='shippingoption_1']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//body/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/input[1]")).click();
	Thread.sleep(1000);
	//18. Choose the payment method as COD (Cash on delivery) and click on “Continue”
	driver.findElement(By.xpath("//input[@id='paymentmethod_0']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//body/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/input[1]")).click();
	Thread.sleep(1000);
	//19. Validate the message “You will pay by COD” and click on “Continue”
	String paymentInfo = driver.findElement(By.xpath("//tbody//tr//td//p")).getText();
	Assert.assertEquals(paymentInfo, "You will pay by COD");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//body/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/ol[1]/li[5]/div[2]/div[1]/input[1]")).click();
	
	//20. Click on “Confirm Order”
	Thread.sleep(2000);
	driver.findElement(By.xpath("//body/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[2]/input[1]")).click();
	
	//21. Validate the message “Your order has been successfully processed!” and print the Order number
	Thread.sleep(1000);
	String confirmMsg = driver.findElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]")).getText();
	Assert.assertEquals(confirmMsg, "Your order has been successfully processed!");
	//String OrderNo = driver.findElement(By.xpath("//li[contains(text(),'Order number: 888175')]")).getText();
	//System.out.println("Order Number is: "+OrderNo);
	Thread.sleep(1000);
	//22. Click on “Continue” and log out from the application 
	driver.findElement(By.xpath("//body/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[2]/input[1]")).click();
	Thread.sleep(1000);
	driver.findElement(By.linkText("Log out")).click();
	driver.close();
	}
	catch(Exception e) {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
}
