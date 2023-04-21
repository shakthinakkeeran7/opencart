Feature: Login Functionality

  As a user,
  I want to be able to login to the e-commerce website,
  So that I can access my account and make purchases.
   Background:
    Given I am on the login page to contine
	
	
	@test2
  Scenario: Successful login with valid email and password
    
    When I enter my valid "5858mgnn@justdefinition.com" and "Shakthi#123"
    And I click the login button
    Then I should be redirected to the account page "https://www.partycity.com/account?registration=false"
	
	Scenario: Successful Logout
    Given I am logged in to the account page
    When I click on the Sign Out button
    Then I should be logged out and redirected to the "https://www.partycity.com" Home page


 	Scenario: Failed login with invalid email and password
 
    When I enter my valid "5858mgnn@justdefinitions.com" and "Shakthi#1234"
    And I click the login button
    Then I should see an error message indicating the login failed "We're sorry, there is an error with your email and/or password. Please try again"
    
   
  