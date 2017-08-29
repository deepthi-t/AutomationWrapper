package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.core.TestActions;

public class NewCustomer 
{
	TestActions action = null;
	
	public NewCustomer(TestActions action)
	{
		this.action = action;
	}
	
	By ApplicationDetails_ColumnHeader = By.xpath("//div[@class='icePnlClpsblHdr singletabcollapsiblepanelHdr']/descendant::*[text()='Application Details']");
	By ServicePackageDetails_ColumnHeader = By.xpath("//div[@class='icePnlClpsblHdr singletabcollapsiblepanelHdr']/descendant::*[text()='Service Package Details (Optional)']");
	
	//Application Form
	By ApplicationForm_DropDown = By.xpath("//*[text()='Application Form:']/following::select[1]");
	By ApplicationDate_Input = By.xpath("//*[text()='Application Date:']/following::input[1]");
	
	//ServicePackage Details
	
}