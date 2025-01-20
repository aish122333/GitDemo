@tag
Feature: Validation of login message based on valid and invalid user
  I want to use this template for my feature file

  @LoginMessageValidation
  Scenario Outline: Validation of valid user on login page
    Given I land on website
    When I add the details username <name> and password <password> and click on login button
    Then "Login Successfully" message should be displayed

   Examples: 
      | name  					| password       | item            |
      | aish@gamil.com  | Aishwarya@123  | Adidas Original |
