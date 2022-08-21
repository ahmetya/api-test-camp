Feature:Pet Store API Regression Tests

  Scenario: User Information Retrieval
    When I make a get request to user module

  Scenario: Get Store Inventory
    When I make a get request for inventory to store module

  Scenario Outline: Get Pet Details with ID
    Then I make a get request for finding pet with ID <petID>
    Examples:
      | petID |
      | 1000  |
      | 1000  |
      | 1000  |

    Scenario: Create New User
      When I make a new post request to user module
      Then I should see new user is created
