Feature: Add to Cart
  Scenario: Add one quantity from the store
    Given Iam on the Store Page
    When I add a "Blue Shoes" to the Cart
    Then I should see 1 "Blue Shoes" in the Cart
