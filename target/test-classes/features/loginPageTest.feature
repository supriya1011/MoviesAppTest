Feature: Test LoginPage
  As a user of Movies website
  I want to visit on the WebPage
  So that I can access all movies


  Scenario: Test LoginPage UI
    Given I want to visit on login page and verify Website logo
    When I want to verify Heading on form Login
    And I want to verify UserName Label Text USERNAME
    But I want to verify Password Label Text PASSWORD
    Then I want to verify login button


  Scenario: Test LoginPage Functionality
    Given I want to login with empty input Field
    When I want to verify error-msg with empty username
    And I want to verify error-msg with empty password
    But I want to test login with Invalid cred
    Then I want to test login with valid cred Successfully