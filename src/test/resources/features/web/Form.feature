Feature: Registration Form

  Scenario: Fill the Registration Form

    Given I am on the Registration Page
    And Fill all the details
      | First Name | Last Name | Date        | Sex    | Years of experience | Profession        | Tool | Continents | Continents-MultiSelect | Selenium commands |
      | Nandita    | Singh     | 16 Dec 2019 | Female | 3                   | Automation Tester | QTP  | Asia       | North America          | Browser Commands  |

    Then Click on the submit button
