package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.core.TestActions;

public class CUG_POM 
{
	TestActions action = null;
	
	By New_ActionButton = By.xpath("//*[text()='New']");
	By CUGID_InputBox = By.xpath("//*[text()='CUG ID']/following::input[1]");
	By CUGDescription_InputBox = By.xpath("//*[text()='Description:']/following::input[1]");
	By CUGType_SelectServiceType = By.xpath("(//*[text()='CUG Type:']/following::input[@type='radio'])[2]");
	By ChargeGroup_dropdown = By.xpath("//*[text()='Charge Group']/following::select[1]");
	By InternationalChargeGroup_dropdown = By.xpath("//*[text()='International Charge Group']/following::select[1]");
	By MaxServices_testBox = By.xpath("//*[text()='Max No of Services']/following::input[1]");
	By ServCallType_Dropdown = By.xpath("//*[text()='Call Type']/following::select[1]");
	
	
	By Accept_Button = By.xpath("//*[@value='Accept']");
	By Cancel_Button = By.xpath("//*[@value='Cancel']");
	
	By SuccessMsg_test = By.xpath("//*[@class='icePnlGrp']/div[1]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/div[2]/span[1]");
	By CUG_Search = By.xpath("//*[text()='CUG Search']");
	By CUGStartingWith_radio = By.xpath("(//*[text()='CUG Search']/following::input[@type='radio'])[2]");
	By CUGStartingWith_inputBox = By.xpath("(//*[text()='CUGs Starting with']/following::input[1]");
	
	By Search_Button = By.xpath("//*[@value='Search']");
	By Service_tab = By.xpath("(//*[text()='Service'])[1]");
	
	By ServiceNumber_Input =By.xpath("(//*[text()='Service No:'])[2]/following::input[1]");
	By ValidateCUGNum_Button = By.xpath("//*[@value='Validate CUG No.']");
	
	By Ok_Button = By.xpath("//*[@value='OK']");
	
	
	
	
	
	
	public CUG_POM(TestActions action) {
		/***
		 * The passed TestAction class object should be assigned to the local variable
		 */
		this.action = action;
	}
	
	public boolean navigation_CUG()
	{
		boolean passed = false;
		
		return passed;
	}

}
