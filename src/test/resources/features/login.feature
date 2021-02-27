Feature: Login functionality via Getir password

  Background:
    Given the user is on the login page


  @login @positive-login
  Scenario: the user should able to login with valid phone number and password
    When the user logs in using "532XXXXXXX" and "UserUser123"
    Then the the user should be able to see "Çıkış yap" button

  @login @negative-login
  Scenario: the user should NOT able to login with invalid phone number and password
    When the user logs in using "532XXXXXXX" and "UserUser1234"
    Then the user should see "Hatalı telefon numarası veya şifre" message

  @login @negative-login
  Scenario: the user should NOT able to login with invalid phone number and valid password
    When the user logs in using "532XXXXXXX" and "UserUser123"
    Then the user should see "Hatalı telefon numarası veya şifre" message

  @login @negative-login
  Scenario: the user should NOT able to login with valid phone number and invalid password
    When the user logs in using "532XXXXXXX" and "UserUser1234"
    Then the user should see "Hatalı telefon numarası veya şifre" message
