Feature: Student Registration
  Scenario: New Student Registration
    Given student fills up registration form
    When student submits registration form
    Then new student record is created successfully
    When update class-name
    Then student class-name is updated successfully
    When delete student by id
    Then student record is deleted successfully
    When student details are retrieved
    Then No records are found