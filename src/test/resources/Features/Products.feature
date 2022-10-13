Feature: This file contains all the details of product

Background:
Given open the browser

Scenario: verify search result for polo men
And launch the url
When user searches for polo shirt 
Then all results should be ralated to polo

Scenario: Verify if search by popularity yeilds proper results
And launch the url
When user hovers on men menu
And user clicks on men T-shirt
Then user selects popularity filter