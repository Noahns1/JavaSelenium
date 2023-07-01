Feature: test driving selenium

  Scenario: opening and closing Chrome
    Given User is on Chrome
    When User goes to google
    Then Window closes