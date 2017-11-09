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
	//Common
	By Proceed_Button = By.xpath("//input[contains(@value,'Proceed')]");
	By Next_Button = By.xpath("(//input[@value='Next>>'])[2]");
	By ContactConfirm_Button = By.xpath("(//input[@value='Confirm'])[2]");

	//Application Form
	By ApplicationDetails_ColumnHeader = By.xpath("//div[@class='icePnlClpsblHdr singletabcollapsiblepanelHdr']/descendant::*[text()='Application Details']");
	By ServicePackageDetails_ColumnHeader = By.xpath("//div[@class='icePnlClpsblHdr singletabcollapsiblepanelHdr']/descendant::*[text()='Service Package Details (Optional)']");
	
	By ApplicationForm_DropDown = By.xpath("//*[text()='Application Form:']/following::select[1]");
	By ApplicationDate_Input = By.xpath("//*[text()='Application Date:']/following::input[1]");
	
	//Application Form - ServicePackage Details
	By CustomerType_DropDown = By.xpath("//*[text()='Customer Type:']/./following::select[1]");
	By ServiceType_DropDown = By.xpath("//*[text()='Service Type:']/./following::select[1]");
	By ProductCode_Input = By.xpath("//*[text()='Product Code:']/./following::input[1]");
	By SericePackage_DropDown = By.xpath("//*[text()='Service Package:']/./following::select[1]");
	
	By Reset_Button = By.xpath("//input[@value='Reset']");
	
	//CustomerDetails - Customer Information
	By Salutation_Dropdown = By.xpath("//*[text()='Salutation:']/following::select[1]");
	By SurName_Input = By.xpath("//*[text()='Surname:']/following::input[1]");
	By FirstName_Input = By.xpath("//*[text()='First Name:']/following::input[1]");
	By MiddleName_Input = By.xpath("//*[text()='Middle Name:']/following::input[1]");
	By Alias_Input = By.xpath("//*[text()='Alias:']/following::input[1]");
	By DOB_Date = By.xpath("//*[text()='Date Of Birth:']/following::input[1]");
	
	By GenderMale_Radio = By.xpath("//*[text()='Male']/preceding::input[1]");
	By GenderFemale_Radio = By.xpath("//*[text()='Female']/preceding::input[1]");
	By GenderUnspecified_Radio = By.xpath("//*[text()='Unspecified']/preceding::input[1]");
	
	By Nationality_DropDown = By.xpath("//*[text()='Nationality']/following::select[1]");
	
	By EmailNotificationYes_Radio = By.xpath("//*[text()='E-mail Notification:']/following::input[1]");
	By EmailNotificationNo_Radio = By.xpath("//*[text()='E-mail Notification:']/following::input[2]");
	
	By PrimaryEmailAddress_Input = By.xpath("//*[text()='Primary E-mail Address:']/following::input[1]");
	By OtherEmailAddress_Input = By.xpath("//*[text()='Other E-mail Address:']/following::input[1]");
	By AccountPassword_Input = By.xpath("//*[text()='Account Password:']/following::input[1]");
	
	By CreateiServiceAccountYes_Radio = By.xpath("//*[text()[contains(.,'iService')]]/following::input[1]");
	By CreateiserviceAccountNo_Radio = By.xpath("//*[text()[contains(.,'iService')]]/following::input[2]");
	
	By LocalAccountNumber_Input = By.xpath("//*[text()='Local Account No:']/following::input[1]");
	By LocalAccountType_Select = By.xpath("//*[text()='Local Account Type:']/following::select[1]");
	
	//CustomerDetails - Billing Address
	By AddressType_DropDown = By.xpath("//*[text()='Address Type:']/following::select[1]");//TODO only available for type 'A'
	By AddressType_Input = By.xpath("(//*[text()='Billing Address']/following::input[contains(@class,'MandatoryTextBox')])"); //TODO count number of mandatory fields and fill all by adding '[<number>]'
	//TODO Fill Address Details
	
	//Customer Classification
	By Company_DropDown = By.xpath("//*[text()='Company:']/following::select[1]");
	//**CustomerType_DropDown already declared 
	By MarketingCategory_DropDown = By.xpath("//*[text()='Marketing Category:']/following::select[1]");
	By Region_DropDown = By.xpath("//*[text()='Region:']/following::select[1]");
	By AccountType_DropDown = By.xpath("//*[text()='Account Type:']/following::select[1]");
	By BillStatusArea_DropDown = By.xpath("//*[text()='Bill Stats Area:']/following::select[1]");
	By BillStatusArea_SearchBox = By.xpath("//*[text()='Bill Stats Area:']/following::input[1]");
	By BillStatusArea_SearchButton = By.xpath("//*[text()='Bill Stats Area:']/following::input[2]");
	
	//Customer ID
	By CustomerIDReset_Button = By.xpath("//div[@class='icePnlClpsblCnt singletabcollapsiblepanelCnt']/descendant::input[@value='Reset']");
	By CustomerID_DropDown = By.xpath("//*[text()='ID:']/following::select[1]");
	By CustomerID_Input = By.xpath("(//*[text()='ID:']/following::input)[1]"); //Wait till enabled
	
	
	//Contact Information
	By ContactName_Input = By.xpath("(//*[text()='Contact Name:']/following::input)[1]");
	//Use same Address Type
	By ContactHomeNumber_input = By.xpath("(//*[text()='Home Number']/following::input)[1]");
	By ContactHomeNumber_CheckBox = By.xpath("(//*[text()='Mobile Number 2']/following::input[@class='iceSelBoolChkbx'])[1]");
	By MobileNumber1_Input = By.xpath("(//*[text()='Mobile Number 1']/following::input)[1]");
	By MobileNumber1_CheckBox = By.xpath("(//*[text()='Mobile Number 1']/following::input[@class='iceSelBoolChkbx'])[1]");
	By MobileNumber2_Input = By.xpath("(//*[text()='Mobile Number 1']/following::input)[2]");
	By MobileNumber2_CheckBox = By.xpath("(//*[text()='Mobile Number 1']/following::input[@class='iceSelBoolChkbx'])[2]");
	By ContactAccept_Button = By.xpath("//input[@value='Accept']");
	
	public void fillResidentialCustomerDetails()
	{
		
	}
	
	public void fillBusinessCustomerDetails()
	{
		
	}
	
	public void fillStandardAddress()
	{
		
	}
}