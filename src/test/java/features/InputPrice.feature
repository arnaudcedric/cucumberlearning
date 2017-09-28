@InputPrice
Feature: InputPrice Enter Price

  Scenario: First test

    Given I navigate to login page
    And I enter username as "cedric" and password as "pepe0007"
    And Click on login button
    Then I should be on the user form page