Feature: Automate Login Page

  Scenario: Login with correct Username & Password
    Given User is on the login page
    When click on username field and add name
    Then click on Password field and add password
    Then click on SignIn button
    And user successfully redirects to the dashboard page
