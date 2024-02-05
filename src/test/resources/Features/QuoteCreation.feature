@Quote
Feature: Quote Functionalitys


	@TS_CMSetup_020
	  Scenario Outline: Create a quote, by selecting existing SKU items for a single inventory
	   Given Register TestData Index-2
     Given Navigate To Login Page and Login to Application as <UserRole>
	   And Create Quote "Guaranteed Maintenance Plan"
#	   And selecting existing SKU items for a single inventory
	   And Add Inventory&SKU "HTG1144113","CONT_MAST_GMP004"
     And Proceed Add-ons
	   And Click Save&Submit to Approved the Quote
	    Examples:
			|UserRole|
			|DealerUser|
	
		@TS_CMSetup_021
	Scenario Outline: Create a quote with dynamic Contract SKU creation for a single model
	    Given Register TestData Index-2
	    Given Navigate To Login Page and Login to Application as <UserRole>
      And Create a Dynamic Quote "Guaranteed Maintenance Plan","Contract_Master_Feb1","48","10000","24","8"
	    And Add Model "902246M*53101233" and Select Dynamic contract SKU "Contract_Master_Feb1","48","10000"
	    And Skip Add-ons
	    And Click Save&Submit to Approved the Quote
	    Examples:
			|UserRole|
			|DealerUser|		
			
		@TS_CMSetup_022
	Scenario Outline: Draft a quote by adding inventories to the Quote
	     Given Register TestData Index-2
	     Given Navigate To Login Page and Login to Application as <UserRole>
	     And Create Quote "Guaranteed Maintenance Plan"
#	     And selecting existing SKU items for a single inventory
	     And Add Inventory&SKU "HTG1144113","CONT_MAST_GMP004"
	     And Skip Add-ons
	     And Click Save to Draft a Quote
	    Examples:
			|UserRole|
			|DealerUser|				

	@TS_CMSetup_023
	Scenario Outline: Draft a quote by adding Model to the Quote
	     Given Register TestData Index-2
	     Given Navigate To Login Page and Login to Application as <UserRole>
	     And Create Quote "Guaranteed Maintenance Plan"
       And AddModel&SKU "902246M*53101233","CONT_MAST_GMP004"
       And Skip Add-ons 
	     And Click Save to Draft a Quote
	     Examples:
			 |UserRole|
			 |DealerUser|
	
	@TC_CMSetup_024
	Scenario Outline: Create a quote with the type - Centralized billing
	    Given Register TestData Index-2
	    Given Navigate To Login Page and Login to Application as <UserRole>
	     And Create Quote "Centralized Billing"
	     And Add Inventory&SKU "HTG1144113","CONT_MAST_GMP004"
	     And Skip Add-ons
	     And Click Save&Submit to Approved the Quote
	    Examples:
			|UserRole|
			|DealerUser|
	
	@TS_CMSetup_025
	Scenario Outline: Create a quote with the type - Guaranteed Maintenance plan
	     Given Register TestData Index-2
	     Given Navigate To Login Page and Login to Application as <UserRole>
	     And Create Quote "Guaranteed Maintenance Plan"
	     And Add Inventory&SKU "HTG1144113","CONT_MAST_GMP004"
	     And Skip Add-ons
	     And Click Save&Submit to Approved the Quote
	    Examples:
			|UserRole|
			|DealerUser|
	
	@TS_CMSetup_026
	Scenario Outline: Create a quote by selecting existing SKU items for a multiple inventories
	     Given Register TestData Index-2
	     Given Navigate To Login Page and Login to Application as <UserRole>
	      And Create Quote "Guaranteed Maintenance Plan"
	      And Add Inventory&SKU "HTG1144113","CONT_MAST_GMP004"
	      And Add Inventory&SKU "HTG1144113","CONT_MAST_GMP004"
	      And Skip Add-ons
	      And Click Save&Submit to Approved the Quote
	     Examples:
			 |UserRole|
			 |DealerUser|
	
	@TS_CMSetup_027
	Scenario Outline: Create a quote by selecting existing SKU items for a multiple Models
       Given Register TestData Index-2
	     Given Navigate To Login Page and Login to Application as <UserRole>
	     And Create Quote "Guaranteed Maintenance Plan"
	     And AddModel&SKU "902246M*53101233","CONT_MAST_GMP004"
	     And AddModel&SKU "902246M*53101233","CONT_MAST_GMP004"
	     And Skip Add-ons
	     And Click Save&Submit to Approved the Quote
	    Examples:
			|UserRole|
			|DealerUser|
	
















	@Guaranteed_Maintenance_Planint
	Scenario Outline: Quote | Basic Setup 
	    Given Register TestData Index-1
	    Given Navigate To Login Page and Login to Application as <UserRole>
	    And Create Quote-Guaranteed Maintenance Plan
	    
	    
	    
	     Examples:
			|UserRole|
			|Internal|
					