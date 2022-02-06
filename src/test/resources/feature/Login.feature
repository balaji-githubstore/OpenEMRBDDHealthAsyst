@login
Feature: Login
  In order to maintain the medical records
  As a user
  I would like access the OpenEMR portal
  
  Background:
	Given I have browser with OpenEMR page

  @invalid @high
  Scenario: Invalid Credential 	
    When I enter username as 'bala'
    And I enter password as 'dina'
    And I select language as 'English (Indian)'
    And I click on login
    Then I should get the error as 'Invalid username or password'

  @valid
  Scenario: Valid Credential
    When I enter username as '<username>'
    And I enter password as '<password>'
    And I select language as '<language>'
    And I click on login
    Then I should get access to portal with title as 'OpenEMR'

    Examples: 
      | username   | password   | language         |
      | admin      | pass       | English (Indian) |
      | physician  | physician  | Dutch            |
      | accountant | accountant | Dutch            |

