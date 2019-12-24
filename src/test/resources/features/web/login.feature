Feature: Login

  Scenario Outline: verify the Login Functionality with invalid inputs
    Given I hit the Url
    When I enter "<User Name>" and "<password>"

    And Press Login button

    Examples:
      | User Name       | password |
      | ABC             | XYZABC   |
      | FSAdministrator | XYZZZABB |
