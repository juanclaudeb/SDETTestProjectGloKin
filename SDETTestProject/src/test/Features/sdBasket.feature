Feature: Checkout functionality of basket item added

  Background: User is logged in and added a product then navigated to the basket page
    Given I am at the login page
    And I click the username textbox
    Then I insert the standard_user username
    Then I click the password textbox
    And I insert the secret_sauce password
    When I click the login button
    Then I should be navigated to the products page
    Given I am on the product page
    When I click the add to cart button for a product
    And I click the product basket icon
    Then I should see the Sauce Labs Backpack product I added to the basket

  @basketsmoke
  Scenario Outline: User should be able to perform the checkout and insert their information
    Given I am at the checkout page
    When I click the checkout button
    Then I should be navigated to the information page
    And I click the First Name text box
    And I insert the <firstname> firstname
    And I click the Last Name text box
    And I insert the <lastname> lastname
    And I click the Zip/Postal Code textbox
    And I insert the <postal_code> zip/postal code
    When I click the continue button
    Then I should be navigated to the checkout overview page


    Examples:
      | firstname     | lastname     | postal_code    |
      | testFirstName | testLastName | testPostalCode |