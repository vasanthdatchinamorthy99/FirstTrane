#Author: vikram.nadella@tavant.com

@LoginPage
Feature: Login Functionality

	@Test @SystemAdminLogin
  Scenario: Login
  	Given Register TestData Index-1
    Given Navigate To Login Page and Login to Application as SystemAdmin
			 
	@Test @LoginAll
  Scenario: Login
    Given Navigate To Login Page and Login to Application as <UserRole>
    
     Examples:
		 	 |	    UserRole     |
		 	 | SystemAdmin       |
			 | WarrantyAdmin     |
			 | ClaimProcessor    |
			 | FieldMeasureAdmin |
			 

#	@Test @WarrantyAdminLogin
  Scenario: Login
  	Given Register TestData Index-<TestDataIndex>
    Given Navigate To Login Page and Login to Application as <UserRole>
    
     Examples:
		 	 |	  UserRole   | TestDataIndex |
			 | WarrantyAdmin | 25            |
			 
	