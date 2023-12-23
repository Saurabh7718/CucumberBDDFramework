Feature:Customer

Background: Steps for common all scenarios
Given User Launch Chrome browser
When User opens URL "http://admin-demo.nopcommerce.com/login"
And User enters Email as "admin@yourstore.com" and Password as "admin"
And Click on Login
Then user can view Dashboard

	 
	@sanity @regression1
	Scenario: Add New customer
	
    When user clicks on customers Menu
    And click on customers Menu Item
    And click on Add new button
    Then user can view Add new customer page
    When user enter customer info
    And click on save button
    Then user can view confirmation message "The new customer has been added successfully"
    And logout 
    And close browser
    
    
 	@DelayBetweenScenarios
 	@regression
    Scenario: Search customer by email
	
    When user clicks on customers Menu
    And click on customers Menu Item
    And Enter customer Email
    When click on search button
    Then User should found Email in the search table
    And close browser
    
    @DelayBetweenScenarios
    @regression
    Scenario: Search customer by Name
	
    When user clicks on customers Menu
    And click on customers Menu Item
    And Enter customer FirstName
    And Enter customer LastName
    When click on search button
    Then User should found Name in the search table
    And close browser
    
    
    
    
 
    