package Step_Definitions;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import PageObjects.AddCustomer_Page;
import PageObjects.LoginPage;

public class Base_Class {

	public WebDriver driver;
	public LoginPage LP;
	public AddCustomer_Page Add_Customer;
	
	public static String randomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return(generatedString);
	}
}
