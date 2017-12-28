Feature: Inputting Image in the input folder to the out put folder

  Scenario: Test to verify user is able to send photo from one folder to another

    Given Event is been resulted from the editor
    And User send photo in the input folder with the correct "UK" and "Perry Barr"
    Then The output folder should have the resulted image with the correct "UK" and "Perry Barr" and "2017-12-20" and "2"

#    And the date is
#      | time     |
#      | now +61m |
#      | now +2h  |
#      | now +3h  |

