
Feature: Login Feature
  Checking Login feature of salesforce

  Background:
  	Given user on "loginpage"

  Scenario: Login with valid credentials
       
    When I enter valid login
    When I enter valid password
    And I click login button
    When user on "homepage"
    Then I should get page title as "Home Page ~ Salesforce - Developer Edition"
 
  Scenario: Login with invalid credentials
    
    When I enter invalid login
    When I enter invalid password
    And I click login button
    Then I should get error as "Please check your username and password. If you still can't log in, contact your Salesforce administrator."

	Scenario: Login with clear password
    #Given user on "loginpage"
    When I enter valid login
    When I enter clear password
    And I click login button
    Then I should get error as "Please enter your password."
 
 Scenario: Testing remember me chkbox
 	#Given user on "loginpage"
  When I enter valid login
  When I enter valid password
  When I click rememberme chkbox
  And I click login button
  When user on "homepage" 
  Then I should get page title as "Home Page ~ Salesforce - Developer Edition"
  And click on usermenu drop down's logout link
  And username field should display username  
    
 Scenario: Testing forgot password link  
  #Given user on "loginpage"
  When I click forgot password link
  When user on "forgot password page1"
  When I enter valid login in forgot password page1
  When I click continue button
  When user on "forgot password page2"
  Then I should see a message "Check Your Email"
  
  
 # @tag2
 # Scenario Outline: Title of your scenario outline
 #   Given I want to write a step with <name>
 #   When I check for the <value> in step
 #   Then I verify the <status> in step

 #   Examples: 
 #     | name  | value | status  |
 #     | name1 |     5 | success |
 #     | name2 |     7 | Fail    |
