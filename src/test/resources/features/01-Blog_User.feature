Feature: Get user details
  As an admin user
  I should be able to get details of individual blog users

  @Id=1.1 @SmokeTest
  Scenario: "Get user details" response schema should match with specification
    When I call the get user details endpoint for user "Delphine"
    Then user details should be retrieved
    And the schema should match with the specification defined in "user_details.json"

  @Id=1.2 @Regression
  Scenario: Should be able to get user details
    When I call the get user details endpoint for user "Delphine"
    Then user details should be retrieved
    And username should be "Delphine"

  @Id=1.3
  Scenario: Empty response should be returned while searching for a non-existent user
    When I call the get user details endpoint for non-existent user
    Then empty response should be returned