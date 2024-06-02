Feature: Login functionality

  Scenario: Login with valid username and wrong password
    Given I am on the login page
    When I login with username "Admin" and password "wrong#P@ssw0rd"
    Then I should see "Invalid credentials" error message
