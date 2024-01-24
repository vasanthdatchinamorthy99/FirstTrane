
@Contract_Master
Feature: Contract Master Functionalitys
  

		
  @TS_CMSetup_002  @Type_Guaranteed_Maintenance_Plan 
	Scenario Outline: Create CM with Multiple Contract SKUs and SKU Items,TYPE-GMP
    Given Register TestData Index-1
	  Given Navigate To Login Page and Login to Application as <UserRole>
	  And Create a ContractMaster<ContName>and<ContType> with Multiple Contract SKU and SKU items
	  Then verify the Created contract master<ContName>and<ContType>is available in inventory Add skus list
	   Examples:
			|UserRole|ContName|ContType|
			|Internal|CONT_MAST_GMP003|Guaranteed Maintenance Plan|			
			

			
	@TS_CMSetup_004  @Type_Extended_Warranty 
	Scenario Outline: Create CM with Multiple Contract SKUs and SKU Items,TYPE-Extended Warranty
    Given Register TestData Index-1
	  Given Navigate To Login Page and Login to Application as <UserRole>
	  And Create a ContractMaster<ContName>and<ContType> with Multiple Contract SKU and SKU items
	  Then verify the Created contract master<ContName>and<ContType>is available in inventory Add skus list
	   Examples:
			|UserRole|ContName|ContType|
			|Internal|CONT_MAST_EW02|Extended Warranty|
			
		
	@TS_CMSetup_003  @Type_PM_only 
	Scenario Outline: Create CM with Multiple Contract SKUs and SKU Items,TYPE-PM only
    Given Register TestData Index-1
	  Given Navigate To Login Page and Login to Application as <UserRole>
	  And Create a ContractMaster<ContName>and<ContType> with Multiple Contract SKU and SKU items
	  Then verify the Created contract master<ContName>and<ContType>is available in inventory Add skus list
	   Examples:
			|UserRole|ContName|ContType|
			|Internal|CONT_MAST_PM02|PM only|
			
			
	@TS_CMSetup_005  @Type_Telematics 
	Scenario Outline: Create CM with Multiple Contract SKUs and SKU Items,TYPE-Telematics
    Given Register TestData Index-1
	  Given Navigate To Login Page and Login to Application as <UserRole>
	  And Create a ContractMaster<ContName>and<ContType> with Multiple Contract SKU and SKU items
	  Then verify the Created contract master<ContName>and<ContType>is available in inventory Add skus list
	   Examples:
			|UserRole|ContName|ContType|
			|Internal|CONT_MAST_TELE02|Telematics|		
			
			
	@TS_CMSetup_001  @Type_Centralized_Billing		
	Scenario Outline: Create CM with Multiple Contract SKUs and SKU Items,TYPE-Centralized Billing
    Given Register TestData Index-1
	  Given Navigate To Login Page and Login to Application as <UserRole>
	  And Create a ContractMaster<ContName>and<ContType> with Multiple Contract SKU and SKU items
	  Then verify the Created contract master<ContName>and<ContType>is available in inventory Add skus list
	   Examples:
			|UserRole|ContName|ContType|
			|Internal|CONT_MAST_CB02|Centralized Billing|
			
			
			

@TS_CMSetup_006
Scenario Outline: Create ContractMaster with Single Contract SKUs and SKU Items-Type GMP
Given Register TestData Index-1
	  Given Navigate To Login Page and Login to Application as <UserRole>
	  And Create a MasterContract with Single Contract SKU and SKU items
	   Examples:
			|UserRole|
			|Internal|
#		
			
 @TS_CMSetup_008
 Scenario Outline: Create aContract master with multiple Rule configurations
 Given Register TestData Index-1
	  Given Navigate To Login Page and Login to Application as <UserRole>
	  When Create ContractMaster "CONT_MAST_AUTOSingle2","Guaranteed Maintenance Plan"
	  And Add RuleConfigurations "Record","Item Type","equals","Machine"
	  And Add RuleConfigurations "Record","Track Type","equals","Non-Serialized"
	Examples:
			|UserRole|
			|Internal|
			
			
	@TS_CMSetup_007
	  Scenario Outline: Edit an existing Contract Master and its Rule configurations.
    Given Register TestData Index-1
	  Given Navigate To Login Page and Login to Application as <UserRole>
    When Create ContractMaster "CONT_MAST_AUTOSingle005","Guaranteed Maintenance Plan"
	  And Add RuleConfigurations "Record","Item Type","equals","Machine"
	  And Add RuleConfigurations "Record","Track Type","equals","Non-Serialized"
	  And Edit ContractMaster Datas "CONT_MAST_AUTOSingle04","Status","Draft"
    And Edit RuleConfigurations ""
	  Examples:
			|UserRole|
			|Internal|
  
  @TS_CMSetup_009
  Scenario Outline: Deactivate the Contract Master
    Given Register TestData Index-1
	  Given Navigate To Login Page and Login to Application as <UserRole>
    #When Create ContractMaster "CONT_MAST_AUTOSingle006","Guaranteed Maintenance Plan"
    And Deactivate the ContractMaster "CONT_MAST_AUTOSingle005"
  
  Examples:
      |UserRole|
			|Internal|

			
			
			
			
			
			
			
			
			