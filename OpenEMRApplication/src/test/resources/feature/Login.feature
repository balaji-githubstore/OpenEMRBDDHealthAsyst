Feature: Login
		In order to maintain the medical records
		As a user
		I would like access the OpenEMR portal
		
Scenario: Valid Credential 
Given I have browser with OpenEMR page 
When I enter username as 'admin'
And I enter password as 'pass'
And I select language as 'English (Indian)'
And I click on login
Then I should get access to portal with title as 'OpenEMR'

Scenario: Invalid Credential
Given I have browser with OpenEMR page
When I enter username as 'bala'
And I enter password as 'dina'
And I select language as 'English (Indian)'
And I click on login
Then I should get the error as 'Invalid username or password'
		
		

		

 