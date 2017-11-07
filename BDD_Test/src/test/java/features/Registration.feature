Feature: Registring new accounts to www.mendely.com

  @Runthistest
  Scenario: To register new account with one account
    Given I am on "https://www.mendeley.com" to register new account
    And I enter email as "test@xmail.com"
    And I enter "test" as given name,"tester" as first name,"tester1" as password
    When I click Register
    Then I should see "You are registered" message

    @Runthistest
    Scenario Outline:To register new account with multiple account
      Given I am on "https://www.mendeley.com/" to register new account
      And I enter "<Email ID>"
      And I enter "<given name>","<first name>","<password>"
      When I click Register
      Then I should see "You are registered" message

      Examples:
      |Email ID|given name|first name|password|
      |grm@test.com|given name|first name|testr1|