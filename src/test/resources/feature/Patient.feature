@patient
Feature: Patient
  In order to maintain the patients records
  As a admin
  I would like access the OpenEMR portal

  @high
  Scenario: Add Patient
    Given I have browser with OpenEMR page
    When I enter username as 'admin'
    And I enter password as 'pass'
    And I select language as 'English (Indian)'
    And I click on login
    And I click on patient-client
    And I click on patient
    And I click on Add New Patient
    And I fill the form
      | firstname | lastname | dob        | gender |
      | John      | Wick     | 2022-02-05 | Male   |
    And I click on create new patient
    And I click on confirm create new patient
    And I store the text and handle the alert box
    And I click on happy birthday if available
    Then the alert text should contains  'Tobacco'
    And I should get the added patient name 'John Wick'

    
  
    
    
    