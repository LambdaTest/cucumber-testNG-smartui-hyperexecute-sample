@example
Feature: Check addition in Google calculator
   In order to verify that google calculator work correctly
   As a user of google
   I should be able to get correct addition result
   
   @example
   Scenario Outline: Operations
   Given I launch Session on lambdatest
   Then I open google
   When I enter "<operations>" in search textbox
   Then I should get result as "<results>"
   Then I should get internet speed and sample todo check
   Then Update the result
   Then Close the browser

   Examples:
   | operations | results |
   |  2+2       |   4     |
   |  5-2       |   3     |
   |  2*5       |   10    |
   |  5+2       |   7     |
   |  8/2       |   4     |
   |  2-2       |   0     |
   |  8-5       |   3     |
