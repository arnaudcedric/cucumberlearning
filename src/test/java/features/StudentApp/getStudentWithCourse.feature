Feature: Get student with specific Course
#  Scenario: Given a user does an API for student with a specific programme

#    Given I make an API Get request to retrieve student "/list" and enter parameters as "programme" and "Financial Analysis"
#    And enters parameters as "programme" and "Financial Analysis"
#    Then the response code is "200"

  Scenario Outline: Given a user does an API for student with a specific programme with Limits
    Given I make an API Get request to retrieve student "<path>" and enter parameters as "<programme>" and "<course>" with limit value "<limitValue>"
    Then the response code is "<status code>"

    Examples:
      | path          | status code | programme | course                 | limitValue |
      | /student/list | 200         | programme | Financial Analysis     | 1          |
      | /student/list | 400         | programme | Financial Analysis     | [          |
      | /student/list | 400         | programme | Financial Analysis     | vrsfvsv    |
      | /student/list | 200         | programme | Mechanical Engineering | 2          |
