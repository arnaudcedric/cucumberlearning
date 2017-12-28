Feature: get event
  Scenario: get a particular event from the trading services

    Given user is authenticated And provides an "2521774"
#    Then Assert response Body 2521774
#
#    Then name a child Cedric

  Scenario: User get event pricing from the trading services

    Given user wants to get event pricing with id "2522316"
    Then the response code for trading is "200"