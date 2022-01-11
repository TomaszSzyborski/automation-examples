@regression @accounting
Feature: Account balance manipulation
  In order to safely manage my account balance
  As account owner I want to be able to:
  - deposit money on my account
  - withdraw money off my account
  - be sure that I can't withdraw more than I have

  Background:
    Given I have account with initial balance 200.00


  @positive
  Scenario: Deposit money
    When I deposit amount 4000.00
    Then last deposited amount should be: 4000.00
    And current account balance should be: 4200.00


  @positive
  Scenario Outline: Withdraw desired amount <withdrawnAmount> from account
    When I try to withdraw amount <withdrawnAmount>
    Then last withdrawn amount should be: <withdrawnAmount>
    And current account balance should be: <accountBalance>

    Examples:
      | withdrawnAmount | accountBalance |
      | 0.00            | 200.00         |
      | 50.00           | 150.00         |
      | 100.00          | 100.00         |
      | 150.00          | 50.00          |
      | 200.00          | 0.00           |


  @negative
  Scenario: Can't withdraw too much
    When I try to withdraw amount 500.00
    Then user should see error message You don't have enough money to withdraw
    Then last withdrawn amount should be: 0.00
    And  current account balance should be: 200.00


  @wip #failing
  Scenario: Can't withdraw negative
    When I try to withdraw amount -1.00
    Then user should see error message You don't have enough money to withdraw
    Then last withdrawn amount should be: 0.00
    And  current account balance should be: 200.00

  @wip #failing
  Scenario: Can't withdraw negative without displaying error
    When I try to withdraw amount -1.00
    Then last withdrawn amount should be: 0.00
    And  current account balance should be: 200.00

  @wip #failing
  Scenario: Checking for wrong deposit
    When I deposit amount 100.00
    Then last deposited amount should be: 0.00
    And  current account balance should be: 200.00
