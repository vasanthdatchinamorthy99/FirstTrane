
@Contract_Master
Feature: Contract Master Functionalitys
  
  @Create_Contract_Master
  Scenario Outline: Create Contract Master
    Given Register TestData Index-1
	  Given Navigate To Login Page and Login to Application as <UserRole>
	  And Create a MasterContract <Mostercontract>
	  
	  
	   Examples:
			|UserRole|
			|Internal|
	  
    #And some other precondition
    #When I complete action
    #And some other action
    #And yet another action
    #Then I validate the outcomes
    #And check more outcomes

  #@tag2
  #Scenario Outline: Title of your scenario outline
    #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step
#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
