@addToCart
Feature: Validate add to cart functionality
  As a buyer, I need to add an item in order to make a purchase

  Scenario: Add an item to cart
    When I add an item to cart
    Then I will see the cart badge number
    And I will see the item added is available in cart page