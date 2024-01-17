@Quote
Feature: Quote
	@Guaranteed_Maintenance_Plan
	  Scenario Outline: Quote | Basic Setup 
	    
	    Given Register TestData Index-1
	    Given Navigate To Login Page and Login to Application as <UserRole>
	    And Create Quote-Guaranteed Maintenance Plan
	    
	    
	    
	     Examples:
			|UserRole|
			|Internal|
			