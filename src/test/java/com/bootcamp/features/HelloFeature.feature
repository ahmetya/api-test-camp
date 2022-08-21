Feature: Hello Feature

  Scenario: First Cucumber Implementation
    Given I have logged in with a unrestricted registered user to the page
    Then I should see welcome popup
    When I click to the account button
    Then I should see the account details
    And  I should introduce myself as "MEHMET"
    And My cats name is "Nohut"
    When My age is 35
    Then System says you are too old

  Scenario Outline: Multiple Execution Example
    When My cats name is "<name>" and its age is <age>
    Examples:
      | name    | age |
      | nohut   | 5   |
