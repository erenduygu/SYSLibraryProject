Feature: Users should be able to login

  Scenario: Login with valid credentials
    When the user logged in as a "librarian"
    Then the page title should be "Library"

