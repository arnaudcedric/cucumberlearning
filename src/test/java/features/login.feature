Feature: Login in to page

  Scenario Outline: login Test

    Given I navigate to the login
    And I enter the following credentials
      | username | password | address    |
      | Talla    | pepe0001 | <address1> |
      | Arnaud   | pepe0002 | <address2> |
      | Soup     | pepe0003 | <address3> |
      | Cedric   | pepe0004 | <address4> |
    And Press enter
    Then i should be in on the dashboard
    Examples:
      | address1 | address2 | address3 | address4 |
      | douala   | yde      | limbe    | buea     |
      | london   | manU     | everton  | leeds    |