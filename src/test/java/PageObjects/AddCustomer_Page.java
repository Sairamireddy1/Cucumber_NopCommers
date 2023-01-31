package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomer_Page {

	public WebDriver ldriver;
	
	public AddCustomer_Page(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
	}
	
	By customer_menu= By.xpath("//body/div[3]/aside[1]/div[1]/div[4]/div[1]/div[1]/nav[1]/ul[1]/li[4]/a[1]/p[1]/i[1]");
	By customermenu_item= By.xpath("//body/div[3]/aside[1]/div[1]/div[4]/div[1]/div[1]/nav[1]/ul[1]/li[4]/ul[1]/li[1]/a[1]");

	By addnew_btn= By.xpath("//a[@class='btn btn-primary']");
	
	By email_field= By.xpath("//input[@id='Email' and @name='Email']");
	By password_field= By.xpath("//input[@id='Password']");
	By FName_field= By.xpath("//input[@id='FirstName']");
	By LName_field= By.xpath("//input[@id='LastName']");
	By Male_btn= By.xpath("//input[@id='Gender_Male']");
	By Female_btn= By.xpath("//input[@id='Gender_Female']");
	By DOB_field= By.xpath("//input[@id='DateOfBirth']");
	By CompanyName_field= By.xpath("//input[@id='Company']");
	By Tax_Exemption= By.xpath("//input[@id='IsTaxExempt']");
	
	By delete_cust_role= By.xpath("//body/div[3]/div[1]/form[1]/section[1]/div[1]/div[1]/nop-cards[1]/nop-card[1]/div[1]/div[2]/div[10]/div[2]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/span[2]");
	By CustomerRole_field= By.xpath("//body/div[3]/div[1]/form[1]/section[1]/div[1]/div[1]/nop-cards[1]/nop-card[1]/div[1]/div[2]/div[10]/div[2]/div[1]/div[1]/div[1]/div[1]");
	By Role_Vendors= By.xpath("//li[contains(text(),'Vendors')]");
	By Role_Administrators= By.xpath("//li[contains(text(),'Administrators')]");
	By Role_Moderators= By.xpath("//li[@id='1f6d5037-0807-432e-9996-eab95c569292']");
	By Role_Guests= By.xpath("//li[contains(text(),'Guests')]");
	By Role_Registered= By.xpath("//li[contains(text(),'Registered')]");
	
	By ManagerVendor = By.xpath("//select[@id='VendorId']");
	By active= By.xpath("//input[@id='Active']");
	By Admin_comment= By.xpath("//textarea[@id='AdminComment']");
	
	By save_btn= By.xpath("//button[@type='submit' and @name='save']");

	public String GetPageTitle() {
		return ldriver.getTitle();
	}
	
	public void ClickoncustomerMenu()
	{
		ldriver.findElement(customer_menu).click();
	}
	public void clickonCustomersMenuItem()
	{
		ldriver.findElement(customermenu_item).click();
	}
	public void click_addnew()
	{
		ldriver.findElement(addnew_btn).click();
	}
	public void setEmail(String email)
	{
		ldriver.findElement(email_field).sendKeys(email);
	}
	public void setPassword(String password)
	{
		ldriver.findElement(password_field).sendKeys(password);
	}
	public void setFname(String Fname)
	{
		ldriver.findElement(FName_field).sendKeys(Fname);
	}
	public void setLname(String Lname)
	{
		ldriver.findElement(LName_field).sendKeys(Lname);
	}
	
	public void setGender(String gender)
	{
		if(gender.equals("male")) {
			ldriver.findElement(Male_btn).click();
		}
		else if(gender.equals("female")) {
			ldriver.findElement(Female_btn).click();
		}
		else {
			ldriver.findElement(Male_btn);
		}
	}
	
	public void setDOB(String dob) {
		ldriver.findElement(DOB_field).sendKeys(dob);
	}
	
	public void setCompanyName(String Cname) {
		ldriver.findElement(CompanyName_field).sendKeys(Cname);
	}
	
	public void istaxExempt(String check) {
		if(check.equals("yes")) {
			ldriver.findElement(Tax_Exemption).click();
		}
	}
	
	public void setcustomerRoles(String role) throws InterruptedException
	{
		if(!role.equals("Registered"))
		{
			ldriver.findElement(delete_cust_role).click();
		}
		
		ldriver.findElement(CustomerRole_field).click();

		WebElement listitem;
		Thread.sleep(3000);
		
		if(role.equals("Administrators"))
		{
			listitem=ldriver.findElement(Role_Administrators);
		}
		else if(role.equals("Forum Moderators"))
		{
			listitem=ldriver.findElement(Role_Moderators);
		}
		else if(role.equals("Guests"))
		{
			listitem=ldriver.findElement(Role_Guests);
		}
		else if(role.equals("Registered"))
		{
			listitem=ldriver.findElement(Role_Registered);
		}
		else if(role.equals("Vendor"))
		{
			listitem=ldriver.findElement(Role_Vendors);
		}
		else
		{
			listitem=ldriver.findElement(Role_Guests);
		}
		listitem.click();
		
//		JavascriptExecutor js= (JavascriptExecutor)ldriver;
//		js.executeScript("arguments[0].click();", listitem);
	}
	
	public void setManagerOfVendor(String value)
	{
		Select drp = new Select(ldriver.findElement(ManagerVendor));
		ldriver.findElement(ManagerVendor).click();
		drp.selectByVisibleText(value);
	}
	
	public void setAdminComment(String comment) {
		ldriver.findElement(Admin_comment).sendKeys(comment);
	}
	
	public void ClickOnSave() {
		ldriver.findElement(save_btn).click();;
	}
}
