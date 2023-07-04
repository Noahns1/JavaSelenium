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
  Scenario: Amazon - Incorrectly attempt to create an account
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

  @positive
  Scenario: Amazon - Validate text on item
    When User clicks on search bar
    And User searches for Python Selenium book
    And User selects a Python Selenium book
    And Clicks on Read more
    Then User validates Title and Author on item page
      | productTitle  | Test-Driven Development with Python: Obey the Testing Goat: Using Django, Selenium, and JavaScript |
      | bylineInfo    | by Harry Percival (Author)                                                                         |
    Then User validates book description
      | //*[@id="bookDescription_feature_div"]/div/div[1]/p[1]/span[1]      | By taking you through the development of a real web application from beginning to end, the second edition of this hands-on guide demonstrates the practical advantages of test-driven development (TDD) with Python. You’ll learn how to write and run tests |
      | //*[@id="bookDescription_feature_div"]/div/div[1]/p[2]/span          | In the process, you’ll learn the basics of Django, Selenium, Git, jQuery, and Mock, along with current web development techniques. If you’re ready to take your Python skills to the next level, this book―updated for Python 3.6―clearly demonstrates how TDD encourages simple designs and inspires confidence.|
    Then User validates preface
    Then close browser