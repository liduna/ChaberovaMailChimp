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
      | email         | username        | password        | message                                       |
      | "validEmail"  | "usernameTaken" | "validPassword" |"Another user with this username already exists. Maybe it's your evil twin. Spooky." |
      | "noEmail"     | "validUsername" | "validPassword" |"Please enter a value"                         |
      | "validEmail"  | "longUsername"  | "validPassword" |"Enter a value less than 100 characters long"  |
      | "validEmail"  | "validUsername" | "validPassword" |"Check your email"                             |

