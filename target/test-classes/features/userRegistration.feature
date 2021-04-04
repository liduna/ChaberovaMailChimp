Feature: registration of a new user
  I test the registration of a new user at mailchimp.com with both valid and invalid input

  Scenario Outline:
    Given I navigate to a page mailchimp.com
    When I write an email as <email>
    And I write also a username as <username>
    And I choose correct password as <password>
    And I click on signUp button
    Then I can see respective <message>


    Examples:
      | email         | username        | password        | message                 |
      | "validEmail"  | "validUsername" | "validPassword" |"Signup successful"      |
      | "noEmail"     | "validUsername" | "validPassword" |"No Email failure"       |
      | "validEmail"  | "longUsername"  | "validPassword" |"Long username failure"  |
      | "validEmail"  | "usernameTaken" | "validPassword" |"Username taken failure" |

