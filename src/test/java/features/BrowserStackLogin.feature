@BrowserStackDemo
Feature: BrowserStack Demo Site

  @ValidScenario
  Scenario: Verify BrowserStack login feature with valid credentials
    Given I am on BrowserStackDemo home page
    When I click 'Sign In' button on home page
    And I select Username on login page
    And I select Password on login page
    And I click Login button on login page
    Then I verify that user is able to Login into the application with valid credential

  @InvalidScenario
  Scenario: Verify BrowserStack login feature with Invalid credentials
    Given I am on BrowserStackDemo home page
    When I click 'Sign In' button on home page
    And I select invalid Username on login page
    And I select invalid Password on login page
    And I click Login button on login page
    Then I verify that error message "Your account has been locked." is displayed




