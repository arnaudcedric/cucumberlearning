Feature: tester's Life

  Scenario Outline: I am a tester

    Given I am a "<Tester_Type>" tester
      | industry   | country  |
      | IT         | India    |
      | Automation | Cameroon |
    When I go to work
    Then I "<Work_output>" it
    And My boss "<Boss_action>" me
    But Then developer "<Developer_reaction>" me

    Examples:
      | Tester_Type | Work_output | Boss_action | Developer_reaction |
      | Good        | bad         | complete    | hates              |
      | bad         | mess        | Fires       | Likes              |