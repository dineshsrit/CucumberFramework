@SecondScenario
Feature: guest place an order
  Scenario: using default payment options
    Given Iam a guest customer
    And I have a "Blue Tshirt" in the cart
    And Iam on the CheckOut Page
    When I Provide the billing details
    |firstname |lastname |country| address1 | city | state | zip | email|
    |rakesh  |sharma   | United States (US) | 6300 Spring Creek | Plano | Texas | 75024 | rakesh@gmail.com|

    And I Place the Order
    Then the order should be placed successfully with the message "Thank you. Your order has been received."

