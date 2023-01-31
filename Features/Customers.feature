Feature: Customer
	  
	Scenario: Add a new customer
		Given launch chrome browser
		When user open URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
		And user enter Email as "admin@yourstore.com" and password as "admin"
		And click on Login
		Then user can view Dashboard
		When user click on customer menu
		And click on customer menu item
		And click on add new button
		Then user can view add new customer page
		When User enter customer info
		And click on save button
		Then ser can view confirmation message "The new customer has been added successfully"
		And close browser
		
