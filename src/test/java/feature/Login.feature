Feature: Login functionality

@RegressionTest @SmokeTest @SmokeTest1
Scenario: Login with valid credentials
Given User navigates to login page
When User enters valid email address "parkarshad@gmail.com" into email field
And User enters valid password "12345" into password field
And User clicks on Login button
Then User should get successfully logged in

@ScenarioOutline
Scenario Outline: Login with valid credentials
Given User navigates to login page
When User enters valid email address "<username>" into email field
And User enters valid password "<password>" into password field
And User clicks on Login button
Then User should get successfully logged in
Examples:
|username								|password	|
|parkarshad@gmail.com		|12345		|
|parkarshad@gmail.com		|12345		|
|parkarshad@gmail.com	  |12345		|


@RegressionTest @SmokeTest
Scenario: Login with invalid credentials
Given User navigates to login page
When User enters invalid email address into email field
And User enters invalid password "1234567890" into password field
And User clicks on Login button
Then User should see this warning message "Warning: No match for E-Mail Address and/or Password." regarding about credentials mismatch


@RegressionTest
Scenario: Login with valid email and invalid password
Given User navigates to login page
When User enters valid email address "aldrin.sy@yahoo.com" into email field
And User enters invalid password "1234567890" into password field
And User clicks on Login button
Then User should see this warning message "Warning: No match for E-Mail Address and/or Password." regarding about credentials mismatch

@RegressionTest
Scenario: Login with invalid email and valid password
Given User navigates to login page
When User enters invalid email address into email field
And User enters valid password "12345" into password field
And User clicks on Login button
Then User should see this warning message "Warning: No match for E-Mail Address and/or Password." regarding about credentials mismatch

@RegressionTest
Scenario: Login without providing any credentails
Given User navigates to login page
When User dont enter email address into email field
And User dont enter password into password field
And User clicks on Login button
Then User should see this warning message "Warning: No match for E-Mail Address and/or Password." regarding about credentials mismatch
