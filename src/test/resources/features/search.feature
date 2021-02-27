Feature: Search functionality

  Scenario Outline: Searching <item>
    Given the user logs in using "5426219772" and "UserUser123"
    When the user search for "<item>"
    Then user should see



    Examples:
      | item     |
      | lahmacun |
      | burger   |
      | dondurma |
