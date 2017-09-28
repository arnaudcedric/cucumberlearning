@LoginTest
Feature: Logging into SISTraderApp using Ashsish video

  Scenario: Logging into sistrader

    Given user go to "http://qa.data3.sis.tv:8080/SISTrader/traderUI/index" on "mozilla"
    And I enter "username" as "arnaud"
    And I enter "password" as "pepe0007"
    And I click on login "button"
    Then Login should be "success"