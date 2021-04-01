Feature: registration of a new user
  I want to be able to register as a new user at mailchimp.com

  Scenario Outline:
    Given I navigate to a page mailchimp.com
    When I write valid "<email address>"
    And I write also available "<username>"
    And I choose correct "<password>"
    Then I can be "<registered>" as a new user

    Examples:
      | email address | username      | password      | registered |
      | validEmail    | validUserName | validPassword | yes        |
      | noEmail       | validUserName | validPassword | no         |
      | validEmail    | longUsername  | validPassword | no         |
      | validEmail    | usernameTaken | validPassword | no         |

