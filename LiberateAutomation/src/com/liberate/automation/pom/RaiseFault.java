package com.liberate.automation.pom;

import org.openqa.selenium.By;

public class RaiseFault 
{
	//RaiseFault National Fault Telephone Elements
	By RaiseFault_PanelHeader = By.xpath("//td[@class='blackBold']//*[text()='Raise Fault']");
	By NationalFault_RadioButton = By.xpath("(//*[text()='National']/preceding::input)[last()]");
	By Telephone_RadioButton = By.xpath("(//*[text()='Telephone']/preceding::input)[last()]");
	By ServiceNumber_Input = By.xpath("//*[text()='Service Number:']/following::input[1]");
	By Extension_Input = By.xpath("//*[text()='Extension:']/following::input[1]");
	By LineNo_Input = By.xpath("//*[text()='Line No:']/following::input[1]");
	
	//RaiseFault National Fault Leased Circuit selected
	By LeasedCircuit_RadioButton = By.xpath("(//*[text()='Leased Circuit']/preceding::input)[last()]");
	By LeasedCircuitStartsWith_Input = By.xpath("//*[text()='Starts With']/following::input[1]");
	By LeasedCircuitStartsWithFind_Button = By.xpath("(//*[text()[contains(.,'Starts With')]]/following::input[@value='Find'])[1]");
	By LeasedCircuitStartsWith_DropDown = By.xpath("(//*[text()[contains(.,'Starts With')]]/following::select)[1]");	
	
	//RaiseFault InterNational Fault Elements
	By International_RadioButton = By.xpath("(//*[text()='International']/preceding::input)[last()]");
	By StartsWith_Input = By.xpath("//*[text()='Starts With']/following::input[1]");
	By StartsWithFind_Button = By.xpath("(//*[text()[contains(.,'Starts With')]]/following::input[@value='Find'])[1]");
	By StartsWith_DropDown = By.xpath("(//*[text()[contains(.,'Starts With')]]/following::select)[1]");
	By StartsWithFrom_Input = By.xpath("//*[text()='From']/following::input[1]");
	By StartsWithTo_Input = By.xpath("//*[text()='To']/following::input[1]");
	By StartsWithFromToFind_Button = By.xpath("(//*[text()[contains(.,'From')]]/following::input[@value='Find'])[1]");
	By CircuiDesignation_DropDown = By.xpath("(//*[text()='Circuit Designation']/following::select)[1]");
	
	//RaiseFault Common button
	By RaiseFault_Button = By.xpath("//input[@value='Raise Fault']");
	By RaiseFaultReset_Button = By.xpath("//input[@value='Reset']");
	
	//RaiseFault Service Info panel
	By ServiceInfo_PanelHeader = By.xpath("//td[@class='blackBold']//*[text()='Service Info']");
	
	//RaiseFault Service Info panel
	By FaultList_PanelHeader = By.xpath("//table[@class='panelHdr']//*[text()='Fault List']");
	
	//RaiseFault Customer Info panel
	By CustomerInfo_PanelHeader = By.xpath("//table[@class='panelHdr']//*[text()='Customer Info']");
	
	//NewFault panel elements
	By Contact_Input = By.xpath("//*[text()='Contact:']/following::input[1]");
	By Number_Input = By.xpath("//*[text()='Number:']/following::input[1]");
	By ExtensionNewFault_Input = By.xpath("//*[text()='Extension:']/following::input[1]");
	By Comments1_Input = By.xpath("//*[text()='Comments:']/following::input[1]");
	By Comments2_Input = By.xpath("(//*[text()[contains(.,'Time:')]]/following::input)[2]");
	By Priority_Dropdown = By.xpath("(//*[text()='Priority:']/following::select)[1]");
	By Time_Input = By.xpath("//*[text()='Time:']/following::input[1]");
	By Symptom_DropDown = By.xpath("(//*[text()='Symptom:']/following::select)[1]");
	By Diagnosis_DropDown = By.xpath("(//*[text()='Diagnosis:']/following::select)[1]");
	By DatePicker_Input = By.xpath("(//*[text()='Date:'])[2]/following::input[1]");
	By Site_Dropdown = By.xpath("(//*[text()='Site:']/following::select)[1]");
	By Department_Dropdown = By.xpath("(//*[text()='Department:']/following::select)[1]");
	By Reference_Input = By.xpath("(//*[text()='Reference:']/following::input)[1]");
	By ReportingAdmin_Input = By.xpath("(//*[text()='Reporting Admin:']/following::input)[1]");
	By ReportingAdminSearch_Button	 = By.xpath("//*[text()='Reporting Admin:']/following::input[@type='image']");
	By ReportingAdmin_Dropdown = By.xpath("(//*[text()='Reporting Admin:']/following::select)[1]");
	By Addnotes_Input = By.xpath("(//*[text()='Add Notes:']/following::textarea)[1]");
	By Accept_Button = By.xpath("//input[@value='Accept']");
	By Cancel_Button = By.xpath("//input[@value='Cancel']");
}
