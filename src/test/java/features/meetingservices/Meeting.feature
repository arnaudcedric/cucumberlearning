Feature: Get meeting

  Scenario: I get meeting as cedric

    Given I have courses with id 2
      | java   |
      | python |

    And I have courses with id 4
      | microsoft  |
      | ccna       |
      | comptiaA++ |

    And User is in class with id 2
      | class 1 |
      | class 2 |
      | class 3 |

    And User is in class with id 4
      | class 4 |
      | class 5 |
      | class 6 |

    And meeting has events with id 3
      | southwell |
      | Towcester |
      | CrayFord  |

    Given I get meetings
      | id | name   | courseId | classeId | eventId |
      | 1  | arnaud | 4        | 4        | 3       |
