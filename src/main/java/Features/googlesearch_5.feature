@feature6
Feature: Check addition in Google calculator
   In order to verify that google calculator work correctly
   As a user of google
   I should be able to get correct addition result
   
   @Addition
   Scenario: Addition
   Given I launch Session on lambdatest
   Then I open google
   When I enter "2+2" in search textbox
   Then I should get result as "4"
   Then I should get internet speed and sample todo check
   Then Close the browser

   @Subtraction
   Scenario: Subtraction
   Given I launch Session on lambdatest
   Then I open google
   When I enter "5-2" in search textbox
   Then I should get result as "3"
   Then I should get internet speed and sample todo check
   Then Close the browser

   @Multiplication
   Scenario: Multiplication
   Given I launch Session on lambdatest
   Then I open google
   When I enter "2*2" in search textbox
   Then I should get result as "4"
   Then I should get internet speed and sample todo check
   Then Close the browser

   @Division
   Scenario: Division
   Given I launch Session on lambdatest
   Then I open google
   When I enter "8/2" in search textbox
   Then I should get result as "4"
   Then I should get internet speed and sample todo check
   Then Close the browser

   @Modulus
   Scenario: Modulus
   Given I launch Session on lambdatest
   Then I open google
   When I enter "9%2" in search textbox
   Then I should get result as "1"
   Then I should get internet speed and sample todo check
   Then Close the browser
