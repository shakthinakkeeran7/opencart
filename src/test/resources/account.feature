Feature: Create Account on Party City Website
Background:
    Given I am on the login page to contine
	
	
  Scenario:  click on the "Create Account" button
    And I enter my first name as "Shakthi"
    And I enter my last name as "Nakkeeran"
    And I enter my email address as "john.doe@example.com"
    And I enter my password as "Password#123"
 		And I enter Confoirm password as "Password#123"
		And I select the Send me email checkbox for notification    
		And I click on the Create Account button
    Then I should see a success message "https://www.partycity.com/account?registration=submitted"

  Scenario: User cannot create an account with an existing email address
    Given I am on the Party City website
    When I click on the "Account" link in the header
    And I click on the "Create Account" button
    And I enter my first name as "Jane"
    And I enter my last name as "Doe"
    And I enter an existing email address
    And I enter my password as "password123"
    And I click on the "Create Account" button
    Then I should see an error message saying that the email address already exists
