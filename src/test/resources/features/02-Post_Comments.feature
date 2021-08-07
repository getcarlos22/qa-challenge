Feature: Get post comments
  As an admin
  I should be able to fetch comments of individual posts
  @Id=2.1
  Scenario: "Get post comments" response schema should match with specification
    Given a blog post by user "Delphine"
    When I call the endpoint to get comments for a post
    And the schema should match with the specification defined in "post_comments.json"

  @Id=2.2
  Scenario: Should be able to get comments for a post
    Given a blog post by user "Delphine"
    When I call the endpoint to get comments for a post
    Then all comments for the post should be returned

  @Id=2.3
  Scenario: Emails in the comments should be in proper format
    Given a blog post by user "Delphine"
    When I retrieve comments for each post
    Then each comment should have an associated valid mailId

  @Id=2.4 @SmokeTest
  Scenario: Empty response should be returned when searching for comments with non-existent postId
    When I call the endpoint to get comments for a non-existent post
    Then empty response should be returned