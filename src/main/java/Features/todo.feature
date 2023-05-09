@sample
Feature: Add new item to ToDO list

 @sample1
 Scenario: Lambdatest ToDO test 1
   Given I launch Session on lambdatest
   When select First Item
   Then select second item
   Then add new item
   Then verify added item
   Then Update the result
   Then Close the browser
   
  @sample2
  Scenario: Lambdatest ToDO test 2
   Given I launch Session on lambdatest
   When select First Item
   Then select second item
   Then add new item
   Then verify added item
   Then Update the result
   Then Close the browser
	
@sample3
  Scenario: Open Url from json1
   Given I launch Session on lambdatest
   Then open url from context json
   Then Close the browser

@sample3
  Scenario: Open Url from json2
   Given I launch Session on lambdatest
   Then open url from context json
   Then Close the browser

@sample3
  Scenario: Open Url from json3
   Given I launch Session on lambdatest
   Then open url from context json
   Then Close the browser

@sample3
  Scenario: Open Url from json4
   Given I launch Session on lambdatest
   Then open url from context json
   Then Close the browser

@sample3
  Scenario: Open Url from json5
   Given I launch Session on lambdatest
   Then open url from context json
   Then Close the browser


