Feature: Login

  
  @sanity12 @regression
  
  Scenario: Successful Login with Valid Credentials
    Given User Launch Chrome browser
    When User opens URL "http://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on Log out link
    Then Page Title should be "Your store. Login"
    And close browser

  
  #@regression12
  #Scenario Outline: Successful Login with Valid Credentials DDT
    
   # Given User Launch Chrome browser
   # When User opens URL "http://admin-demo.nopcommerce.com/login"
   # And User enters Email as "<email>" and Password as "<password>"
    #And Click on Login
    #Then Page Title should be "Dashboard / nopCommerce administration"
   # When User click on Log out link
    #Then Page Title should be "Your store. Login"
    #And close browser

    #Examples:
     # | email                   | password |
     # | admin@yourstore.com     | admin    |
      #| test12@yourstore.com    | admin    |
