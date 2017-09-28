Feature: sistraderApp

  Scenario Outline: I am login into traderApp

    Given I enter "<username>" and "<password>"

    And click on login button

    Examples:
      | username | password |
      | admin    | password |
      | arnaud   | pepe0001 |