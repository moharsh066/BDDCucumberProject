Feature: Registration functionality

@RegressionTest @SmokeTest
Scenario: User creates an account only with mandatory fields
Given User navigates to Register Account page
When User enters the details into below fields
|firstName	|Mohamed									|
|lastName		|Arshad													|
|telephone	|1234567890									|
|password		|12345											|
And User selects Privacy Policy
And User clicks on Continue button
Then User account should get created successfully

@RegressionTest
Scenario: User creates an account with all fields
Given User navigates to Register Account page
When User enters the details into below fields
|firstName	|Mohamed										|
|lastName		|Arshad											|
|telephone	|1234567890									|
|password		|12345											|
#This is not mandatory filed in the page
And User selects Yes for Newsletter   
And User selects Privacy Policy
And User clicks on Continue button 
Then User account should get created successfully

@RegressionTest
Scenario: User creates a duplicate account
Given User navigates to Register Account page
When User enters the details into below fields with duplicate email
|firstName	|Mohamed										|
|lastName		|Arshad											|
|email			|parkarshad@gmail.com				|
|telephone	|1234567890									|
|password		|12345											|
And User selects Yes for Newsletter
And User selects Privacy Policy
And User clicks on Continue button
Then User should get this warning "Warning: E-Mail Address is already registered!" about duplicate email

@RegressionTest
Scenario: User creates an account without filling any details
Given User navigates to Register Account page
When User dont enter any details into fields
And User clicks on Continue button
Then User should get proper warning messages for every mandatory field



