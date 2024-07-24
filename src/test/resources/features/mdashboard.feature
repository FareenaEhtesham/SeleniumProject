Feature: Automate Dashboard page

  Scenario: Verify product details on the dashboard page
    Given user is on dashboard page
    And count total no of products available
    When click on any product detail view should be open
    Then verify detail view of the product
    When click on Add to Cart of the product
    Then verify button is clickable
    Then verify product has been successfully added
