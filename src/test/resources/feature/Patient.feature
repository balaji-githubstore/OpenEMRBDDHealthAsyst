@patient
Feature: Patient
  In order to maintain the patients records
  As a admin
  I would like access the OpenEMR portal

  @high
  Scenario Outline: Add Patient
    Given I have browser with OpenEMR page
    When I enter username as '<username>'
    And I enter password as '<password>'
    And I select language as 'English (Indian)'
    And I click on login
    And I click on patient-client
    And I click on patient
    And I click on Add New Patient
    And I fill the form
      | firstname   | lastname   | dob   | gender   |
      | <firstname> | <lastname> | <dob> | <gender> |
    And I click on create new patient
    And I click on confirm create new patient
    And I store the text and handle the alert box
    And I click on happy birthday if available
    Then the alert text should contains  '<expectedAlert>'
    And I should get the added patient name '<expectedName>'

    Examples: 
      | username | password | firstname | lastname | dob        | gender | expectedAlert | expectedName                         |
      | admin    | pass     | john      | wick     | 2022-02-05 | Male   | Tobacco       | Medical Record Dashboard - John Wick |
      | admin    | pass     | peter     | ken      | 2022-02-07 | Male   | Tobacco       | Medical Record Dashboard - Peter Ken |

