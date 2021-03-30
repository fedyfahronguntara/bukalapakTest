Feature: Login

Scenario Outline: Login
Given user has access Home page
When user fill username <email> and password <password>
And click Login button
Then dashboard page

Examples:
|email|password|
|"fedyfahron98@gmail.com"|"fedy24091998"|