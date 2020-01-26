@test
Feature: Kurt Geiger online scenarios

Scenario Outline: Verify that the products displayed is for the same brand name
Given I am on the homepage
When I select brand category from the header
Then I should see the list of brands
And I select "<brand>" brand from the list
Then I should see the list of products from "<brand>"

Examples:
|brand|
|Ash|
|Barkers|
|Aldo|
|Champion|

Scenario: Checking list of Products in Men's category
Given I am on the homepage
And I select men category from the header
Then I should see the list of products
When I hover over a main navigation item
Then I should see an advert from Fred Hopper
And I select a sub navigation link from the drop down
Then I should see another list of products