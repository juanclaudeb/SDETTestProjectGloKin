
Feature: Browse products and add to product to cart

  Background: User is logged in
    Given I am at the login page
    And I click the username textbox
    Then I insert the standard_user username
    Then I click the password textbox
    And I insert the secret_sauce password
    Then I click the login button

  @productsmoke
  Scenario Outline: Should be able to view and add product to cart
    Given I am on the product page
    When I click the add to cart button for a product
    And I click the product basket icon
    Then I should see the <product_in_basket> product I added to the basket

    Examples:
      | product_in_basket   |
      | Sauce Labs Backpack |