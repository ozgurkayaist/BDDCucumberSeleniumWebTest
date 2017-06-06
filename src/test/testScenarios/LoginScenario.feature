Feature: Login section

@QuickTest
  Scenario: Successfully Login to Website
    Given I am on the www.garanti.com.tr Home Page
    When I click Login Link on Home Page
    And Fill UserID field with "68131538" and Fill Password field with "P@ssw0rd" and click Login on LoginPage
    And I click SMS Code and write "190700" on Login Page
    Then I should see url contains "dashboard"
 #   And I should see my wallet Dashboard page

  Scenario Outline: UnSuccessfully Login with Invalid SmsCode to Website
    Given I am on the www.garanti.com.tr Home Page
    When I click Login Link on Home Page
    And Fill UserID field with "68131538" and Fill Password field with "P@ssw0rd" and click Login on LoginPage
    And I click SMS Code and write "<smscode>" on Login Page
    Then I should not see url contains "dashboard"
    Examples: Valid user Invalid SMS Code
      | smscode |
      | 123456 |
      | 111111 |

  Scenario Outline: UnSuccessfully Login with Credentials to Website
    Given I am on the www.garanti.com.tr Home Page
    When I click Login Link on Home Page
    And Fill UserID field with "<userid>" and Fill Password field with "<password>" from list and click Login on LoginPage
    Then I should not see url contains "dashboard"
    Examples:Invalid User
      | userid    | password |
      | 768678660  | P@ssw0rd     |
      | 234127890  | P@ssw0rd     |


