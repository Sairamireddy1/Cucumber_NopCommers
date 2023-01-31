package Step_Definitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.AddCustomer_Page;
import PageObjects.LoginPage;
import io.cucumber.java.en.*;

public class Steps extends Base_Class{
	
	@Given("launch chrome browser")
	public void launch_chrome_browser() {
		System.setProperty("webdriver.chrome.driver", ".//Driver//chromedriver.exe");
		driver=new ChromeDriver();
		
		LP=new LoginPage(driver);
		
	}

	@When("user open URL {string}")
	public void user_open_url(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}
 
	@When("user enter Email as {string} and password as {string}")
	public void user_enter_email_as_and_password_as(String email, String pwd) {
		LP.setUserName(email);
		LP.setPassword(pwd);
	}

	@When("click on Login")
	public void click_on_login() {
		LP.clickLogin();
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String pageTitle) {
		
		if(driver.getPageSource().contains("Login was unsuccessful."))
		{
			driver.close();
			Assert.assertTrue(false);
		}else
		{
			Assert.assertEquals(pageTitle, driver.getTitle());
		}
	}

	@When("user click on logout link")
	public void user_click_on_logout_link() throws InterruptedException {
		Thread.sleep(3000);
		LP.clickLogout();
	}

	@Then("close browser")
	public void close_browser() {
		driver.close();
	}

	//Adding customer
	
	@Then("user can view Dashboard")
	public void user_can_view_dashboard() {
	    Add_Customer= new AddCustomer_Page(driver);
	    Assert.assertEquals("Dashboard / nopCommerce administration", Add_Customer.GetPageTitle());
	}
	@When("user click on customer menu")
	public void user_click_on_customer_menu() throws InterruptedException {
		Thread.sleep(2000);
		Add_Customer.ClickoncustomerMenu();
	}
	@When("click on customer menu item")
	public void click_on_customer_menu_item() throws InterruptedException {
		Thread.sleep(2000);
		Add_Customer.clickonCustomersMenuItem();
	}
	@When("click on add new button")
	public void click_on_add_new_button() throws InterruptedException {
		Thread.sleep(2000);
	    Add_Customer.click_addnew();
	}
	@Then("user can view add new customer page")
	public void user_can_view_add_new_customer_page() {
		Assert.assertEquals("Add a new customer / nopCommerce administration", Add_Customer.GetPageTitle());
	}
	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
		Thread.sleep(2000);
		String email=randomString()+"@gmail.com";
		Add_Customer.setEmail(email);
		Add_Customer.setPassword("test123");
		Add_Customer.setFname(email+"1");
		Add_Customer.setLname(email+"2");
		Add_Customer.setGender("male");
		Add_Customer.setDOB("01/01/1997");
		Add_Customer.setCompanyName(email);
		Add_Customer.istaxExempt("yes");
		Add_Customer.setcustomerRoles("Guests");
		Add_Customer.setManagerOfVendor("Vendor 1");
		Add_Customer.setAdminComment(email+email+email+email);
	}
	@When("click on save button")
	public void click_on_save_button() {
	    Add_Customer.ClickOnSave();
	}
	@Then("user can view confirmation message {string}")
	public void user_can_view_confirmation_message(String msg) throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully."));
	}

}
