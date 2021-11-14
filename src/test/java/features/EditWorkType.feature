Feature: Create NewWorktype

#Background:
#Given Launch the chrome browser 
#And Load the application url

Scenario Outline: TC001_Login using positive credentials
Given Enter the username as <username>
And Enter the password as <password>
When click login button 
Then Verify the home page should be displayed
Then click click on the App Launcher
Then click on View All
Then click on Work Types
Then click on New
Then Enter Work Type Name as 'Salesforce Project'
Then Enter Description as 'Specimen'
Then Create new operating hours by Entering a name as 'UK Shift'
Then Enter Estimated Duration as '7'
When Click on Save
Then Verify the Created message 

Examples:
|username|password|WorkTypeName|Description|new operating hours|Estimated Duration|
|'fullstack@testleaf.com'|'SelBootcamp$123'|'Salesforce Project'|'Specimen'|'UK Shift'|'7'|

