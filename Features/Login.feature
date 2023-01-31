Feature: Login

Scenario: Successfull login with valid credentials
		Given launch chrome browser
		When user open URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
		And user enter Email as "admin@yourstore.com" and password as "admin"
		And click on Login
		Then page title should be "Dashboard / nopCommerce administration"
		When user click on logout link
		Then page title should be "Your store. Login"
		And close browseer
		
	Scenario Outline: Login Data Driven
		Given launch chrome browser
		When user open URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
		And user enter Email as "<email>" and password as "<password>"
		And click on Login
		Then page title should be "Dashboard / nopCommerce administration"
		When user click on logout link
		Then page title should be "Your store. Login"
		And close browseer
		
		Examples:
			| email | password |
			|admin@yourstore.com | admin |
			|admin1@yourstore.com | admin |
