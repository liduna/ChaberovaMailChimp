Feature: registration of a new user
  I want to be able to register as a new user at mailchimp.com

  Scenario Outline:
    Given I navigate to a page mailchimp.com
    When I write valid email as <email>
    And I write also available username as <username>
    And I choose correct password as <password>
    Then I can be registered as a new user and I see a <message>

    Examples:
      | email         | username        | password        | message             |
      | "validEmail"  | "validUsername" | "validPassword" |"Check your email"   |
      | "noEmail"     | "validUsername" | "validPassword" |"Check your entry"   |
      | "validEmail"  | "longUsername"  | "validPassword" |"Check your entry"   |
      | "validEmail"  | "usernameTaken" | "validPassword" |"Check your entry"   |

