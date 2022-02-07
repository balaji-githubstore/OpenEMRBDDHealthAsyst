Feature: HA

  Scenario: Test Case 1
    Given I have the excel with keywords in sheet ''
    When I try to run
    Then I should get the result as 'Passed'

  Scenario: Test Case 1
    Given I have browser
    When I try to run enter username 'bala'
    And I pick the data from the excel 'D:\check.xlsx' and sheetname 'sheet1'
    Then I should get the result as 'Passed'
