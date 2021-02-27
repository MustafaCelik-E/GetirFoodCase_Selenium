Feature: Address functionality

  @address @wip
  Scenario: Adding a new address
    Given the user is on the login page
    And the user logs in using "532XXXXXXX" and "UserUser123"
    And the user navigates to "Adreslerim"
    When the user clicks the "Ev adresi ekle"
    And the user writes "Etiler" to search box and clicks first option
    And the user logs in using following credentials
      | addressTitle | office                  |
      | address      | Tanburi Ali Efendi Sok. |
      | building     | Maya Residences         |
      | floor        | 16                      |
      | aptNo        | 330                     |
      | direction    | Merkez                  |
    Then the user should be able to see the address under "Adreslerim"

