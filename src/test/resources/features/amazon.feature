Feature: Amazon Basics

  Background: start up Amazon steps
    Given User opens up Chrome
    Then User goes to Amazon

  Scenario: Amazon - Find Selenium book and add to cart
    When User clicks on search bar
    And User searches for selenium book
    Then Selects selenium book
    And User is on the item page
    When User clicks on Add to Cart
    And User navigates to cart
    And User Verifies selenium book is in cart
    Then close browser