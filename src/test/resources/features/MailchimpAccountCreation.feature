Feature: Mailchimp Account Creation
  As a new user I want to create/register
  a new account on Mailchimp signup page

  Scenario: Everything goes as expected - Successful account creation
    Given The user is on the registration page
    When User enters a valid Username "mioq23zx"
    When User enters a valid Email "msoaa993@gmail.com"
    #When User enters a random Email
    And User enters a random password
    #And User enters a valid password "Apelsin2!"
    And User clicks on sign up
    Then User sucessfully creates an account


    Scenario: Username containing more than 100 letters
      Given The user is on the registration page
      When the user enters a username containing more than hundred letters
      #When User enters a valid Email "mso23@gmail.com"
      When User enters a random Email
      And User enters a valid password "Apelsin2!"
      #And User enters a random password
      And User clicks on sign up
      Then an error occurs indicating that max number of letters for username is onehundred


      Scenario: Username already in use/taken
        Given The user is on the registration page
        When User enters a valid Username that is already in use "mktfriokzx"
        When User enters a valid Email "msoaazxc@gmail.com"
        And User enters a valid password "Apelsin2!"
        And User clicks on sign up
        Then an error occurs indicating that the username is already in use

        Scenario: Creating an account without entering an email
          Given The user is on the registration page
          When User enters a valid Username "mktfriosak"
          And User enters a valid password "Apelsin2!"
          And User clicks on sign up
          Then an error occurs due to leaving the email field empty