Feature: registration of a new user
  I test the registration of a new user at mailchimp.com with both valid and invalid input

  Scenario Outline:
    Given I navigate to a page mailchimp.com
    When I write an email as <email>
    And I write also a username as <username>
    And I choose correct password as <password>
    And I click on signUp button
    Then I can see a correct <message> based on respective input


    Examples:
      | email         | username        | password        | message             |
      | "validEmail"  | "usernameTaken" | "validPassword" |"usernameTakenError"  |
      | "noEmail"     | "validUsername" | "validPassword" |"noEmailError"       |
      | "validEmail"  | "longUsername"  | "validPassword" |"longUsernameError"  |
      | "validEmail"  | "validUsername" | "validPassword" |"Signup successful" |

