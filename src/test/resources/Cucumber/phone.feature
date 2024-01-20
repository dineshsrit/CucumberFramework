@Features
Feature: Add to Cart
  Scenario: Add one quantity from the store
    Given Iam on the Store Page
    When I add a "Blue Shoes" to the Cart
    Then I should see 1 "Blue Shoes" in the Cart

    @cart
    Scenario Outline: Add to Cart -- Mulitple
      Given Iam on the Store Page
      When I add a "<productname>" to the Cart
      Then I should see 1 "<productname>" in the Cart
      Examples:
        |productname  |
        |Blue Tshirt  |

