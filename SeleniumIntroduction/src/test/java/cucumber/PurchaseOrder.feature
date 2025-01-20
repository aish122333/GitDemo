@tag
Feature: Purchase an Item in Ecommerce website

Background: 
Given I landed on website


@PurchaseOrder
  Scenario Outline: Postive Case for purchase order
    Given Logged in to website with username <name> and password <password>
    When I want to add product <item> to cart
    And Click on submit button
    Then Message "THANKYOU FOR THE ORDER." is displayed on confirmation page

    Examples: 
      | name  					| password       | item            |
      | aish@gamil.com  | Aishwarya@123  | Adidas Original |