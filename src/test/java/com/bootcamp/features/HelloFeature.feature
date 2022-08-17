Feature: Hello Feature
  Scenario: First Cucumber Implementation
    Given I have logged in with a unrestricted registered user to the page
    Then I should see welcome popup
    When I click to the account button
    Then I should see the account details