Feature: API call to retrieve student

#  Scenario: Given student exist user makes API call for student
#
#    Given user make an API Get request to retrieve student "student/101"
#    Then the response code is "404"

  Scenario Outline:
    Given user make an API Get request to retrieve student "<student>"
    Then the response code is "<statuscode>"
    Examples:
      | student      | statuscode |
      | /student/eee | 400        |
      | /student/102 | 404        |
      | /student/103 | 404        |
      | /student/104 | 404        |
      | /student/105 | 404        |
      | /student/106 | 404        |
      | /student/107 | 404        |
      | /studen/ftgh | 404        |
