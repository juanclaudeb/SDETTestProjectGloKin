Feature: Login to SwagLabs site

  @loginsmoke
  Scenario Outline: Login to SwagLabs website
    Given I am at the login page
    And I click the username textbox
    Then I insert the <std_username> username
    Then I click the password textbox
    And I insert the <std_password> password
    When I click the login button
    Then I should be navigated to the products page

    Examples:
      | std_username            | std_password |
      | standard_user           | secret_sauce |
      | performance_glitch_user | secret_sauce |
      | problem_user            | problem_user |

  @loginsmoke
  Scenario Outline: Login to SwagLabs website with locked_out_user
    Given I am at the login page
    And I click the username textbox
    Then I insert the <locked_username> username
    Then I click the password textbox
    And I insert the <locked_password> password
    When I click the login button
    Then I should see the following error returned <locked_error>

    Examples:
      | locked_username | locked_password | locked_error                                        |
      | locked_out_user | secret_sauce    | Epic sadface: Sorry, this user has been locked out. |