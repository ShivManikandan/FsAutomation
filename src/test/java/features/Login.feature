Feature: Salesforce login functionality

#Background:
#Given Launch the chrome browser 
#And Load the application url

Scenario Outline: TC001_Login using positive credentials
Given Enter the username as <username>
And Enter the password as <password>
When click login button 
Then Verify the home page should be displayed

Examples:
|username|password|
|'fullstack@testleaf.com'|'SelBootcamp$123'|
|'fullstack@testleaf.com'|'SelBootcamp$123'|



Scenario: TC001_Login using positive credentials
Given Enter the username as 'fullstack@testleaf.com'
And Enter the password as 'SelBootcamp$123'
When click login button 
But Verify the home page should be displayed