Feature: Amazon Basics

  Background: start up Amazon steps
    Given User opens up Chrome
    Then User goes to Amazon

  @positive
  Scenario: Amazon - Find Selenium book and add to cart
    When User clicks on search bar
    And User searches for selenium book
    Then Selects selenium book
    And User is on the item page
    When User clicks on Add to Cart
    And User navigates to cart
    And User Verifies selenium book is in cart
    Then close browser

  @negative
  Scenario: incorrectly attempt to create an account
    When User clicks Account & Lists
    Then User is on Sign in page
    When User clicks Create your Amazon account
    Then User is on Create account page
    And User clicks continue
    Then Verifies error messages from incorrect entries
      | auth-customerName-missing-alert | Enter your name                         |
      | auth-email-missing-alert        | Enter your email or mobile phone number |
      | auth-password-missing-alert     | Minimum 6 characters required           |
    When User enters invalid email
    Then Verifies error message for email
    When User enter mismatching passwords
    Then Verifies error message for mismatching password
    When User enters an improper password
    Then Verifies error message for improper password
    Then close browser