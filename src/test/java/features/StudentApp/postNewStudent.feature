Feature: create new student

  Scenario: post new student
    Given user create new student with firstName as "Arnaud5" LastName as "Talla5" email as "c@gmail.com5" programme as "Testing Automation" with path "student/"
      | course     |
      | C#         |
      | java       |
      | javascript |
      | jmeter     |
    Then the response code is "201"


  Scenario:user can not post new student
    Given user create new student with firstName as "Arnaud5" LastName as "Talla5" email as "c@gmail.com5" programme as "Testing Automation" with path "student/"
      | course     |
      | C#         |
      | java       |
      | javascript |
      | jmeter     |
    Then the response code is "500"
    Then the response message is "{"error":"Email address already exists"}"

#    Scenario Outline: post new student 2
#      Given user create new student with firstName as "<firstName>" LastName as "<LastName>" email as "<email>" programme as "<programme>" with path "<path>"
#        | course     |
#        | C#         |
#        | java       |
#        | javascript |
#        | jmeter     |
#      Then the response code is "<responseCode>"
#      Examples:
#        | firstName | LastName | email             | programme       | path     | responseCode |
#        | Arnaud1   | Cedric1  | cedric@gmail.com1 | Test Automation | student/ | 500          |
#        | Arnaud2   | Cedric2  | cedric@gmail.com2 | Test Automation | student/ | 500          |
#        | Arnaud3   | Cedric3  | cedric@gmail.com3 | Test Automation | student/ | 500          |
#        | Arnaud4   | Cedric4  | cedric@gmail.com4 | Test Automation | student/ | 500          |

