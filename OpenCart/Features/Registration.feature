Feature: Account Registration

  @regression
  Scenario: Successful Account Registration
    Given the user navigates to register Account page
    When the user enters the details into below fields
      | firstName | John       |
      | lastName  | kenedy     |
      | telephone | 1234567890 |
      | password  | test@123   |
    And the user selects privacy policy
    And the user clicks on continue button
    Then the useer account should get createed sucessfully
