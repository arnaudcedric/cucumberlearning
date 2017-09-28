Feature: Login in to page

  Scenario: login Test

    Given I navigate to the login
    And I enter the following credentials
      | username | password |
      | Talla    | pepe0001 |
      | Arnaud   | pepe0002 |
      | Soup     | pepe0003 |
      | Cedric   | pepe0004 |
    And Press enter
    Then i should be in on the dashboard