Feature:Pet Store API Regression Tests

  Scenario: User Information Retrieval
    When I make a get request to user module

  Scenario: Get Store Inventory
    When I make a get request for inventory to store module
    Then I make a get request for finding pet with ID 1000