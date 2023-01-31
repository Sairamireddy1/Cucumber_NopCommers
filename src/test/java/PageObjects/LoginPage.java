package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id="Email") @CacheLookup WebElement txtEmail;
	@FindBy(xpath="//input[@id='Password']") @CacheLookup WebElement txtPWD;
	@FindBy(xpath = "//button[contains(text(),'Log in')]") @CacheLookup WebElement btnLogin;
	@FindBy(xpath = "//a[contains(text(),'Logout')]") @CacheLookup WebElement btnLogout;
	
	public void setUserName(String uname)
	{
		txtEmail.clear();
		txtEmail.sendKeys(uname);
	}
	
	public void setPassword(String pwd)
	{
		txtPWD.clear();
		txtPWD.sendKeys(pwd);
	}
	
	public void clickLogin()
	{
		btnLogin.click();
	}
	
	public void clickLogout()
	{
		btnLogout.click();
	}


}
