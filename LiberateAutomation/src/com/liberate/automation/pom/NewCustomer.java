package com.liberate.automation.pom;

import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.By;

import com.liberate.automation.common.CommonData;
import com.liberate.automation.common.LeftLink;
import com.liberate.automation.common.LiberateCommon;
import com.liberate.automation.core.RandomData;
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
	
	By ShorCutPopupOK_Button = By.xpath("//input[@value='OK']");
	
	//Application Form - ServicePackage Details
	By CustomerType_DropDown = By.xpath("//*[text()='Customer Type:']/./following::select[1]");
	By ServiceType_DropDown = By.xpath("//*[text()='Service Type:']/./following::select[1]");
	By ProductCode_Input = By.xpath("//*[text()='Product Code:']/./following::input[1]");
	By ServiceTypeBoth_CheckBox = By.xpath("//*[text()='Both']//preceding::input[1]");
	By ServiceTypePrepaid_CheckBox = By.xpath("//*[text()='PrePaid']//preceding::input[1]"); 
	By ServiceTypePostPaid_CheckBox = By.xpath("//*[text()='PostPaid']//preceding::input[1]");
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
	//By AddressType_Input = By.xpath("(//*[text()='Billing Address']/following::input[contains(@class,'MandatoryTextBox')])"); //TODO count number of mandatory fields and fill all by adding '[<number>]'
	By StandardAddressTown_Input = By.xpath("//*[text()='town:']/following::input[1]");
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
	
	/***
	 * The method to navigate to New Customer screen
	 * 
	 * @return Returns true if able to navigate, else will return false.
	 */
	public boolean navigate()
	{
		boolean passed = false;
		
		passed = action.waitFor(LiberateCommon.LevelOne.CustomerCare,4,true);
		passed = action.clickOn(LiberateCommon.LevelOne.CustomerCare);
		
		passed = action.waitFor(LiberateCommon.CustomerCare.ServiceProvisioning,4,true);
		passed = action.clickOn(LiberateCommon.CustomerCare.ServiceProvisioning);
		
		passed = action.waitFor(LeftLink.ServiceProvisioning.NewCustomer,4,true);
		passed = action.clickOn(LeftLink.ServiceProvisioning.NewCustomer);
		
		return passed;
	}
	
	public boolean fillApplicationDetails(String ApplicationForm)
	{
		boolean passed = false;
		
		passed = action.waitFor(ApplicationDetails_ColumnHeader, 4, true);
		
		if(action.countOf(ShorCutPopupOK_Button)>0)
		{
			action.clickOn(ShorCutPopupOK_Button);
			action.waitFor(ShorCutPopupOK_Button, 2, false);
		}
		
		passed = action.waitFor(ApplicationForm_DropDown, 2, true);
		passed = action.selectBy(ApplicationForm_DropDown, ApplicationForm);
		
		passed = action.waitFor(2);
		
		passed = action.clickOn(Proceed_Button);
		
		return passed;
	}
	
	public boolean fillApplicationDetails(String ApplicationForm, String CustomerType, String ServiceType, String ServicePackage)
	{
		boolean passed = false;
		
		passed = action.waitFor(ApplicationDetails_ColumnHeader, 4, true);
		
		if(action.countOf(ShorCutPopupOK_Button)>0)
		{
			action.clickOn(ShorCutPopupOK_Button);
			action.waitFor(ShorCutPopupOK_Button, 2, false);
		}
		
		passed = action.waitFor(ApplicationForm_DropDown, 2, true);
		passed = action.selectBy(ApplicationForm_DropDown, ApplicationForm);
		
		passed = action.waitFor(2);
		
		passed = action.selectBy(CustomerType_DropDown, CustomerType);
		passed = action.waitFor(2);
		passed = action.selectBy(ServiceType_DropDown, ServiceType);
		passed = action.waitFor(2);
		passed = action.selectBy(SericePackage_DropDown, ServicePackage);
		passed = action.waitFor(2);

		passed = action.clickOn(Proceed_Button);
		
		return passed;
	}
	
	
	public boolean fillResidentialCustomerDetails()
	{
		RandomData random = new RandomData();
		
		boolean passed = false;
		
		passed = action.waitFor(Salutation_Dropdown, 4, true);
		passed = action.selectBy(Salutation_Dropdown, 2);
		
		passed = action.sendDataTo(SurName_Input, random.nextString());
		passed = action.sendDataTo(FirstName_Input, random.nextString());
		passed = action.sendDataTo(MiddleName_Input, random.nextString());
		passed = action.typeDataTo(DOB_Date, "01/01/1991");
		passed = action.waitFor(2);
		
		passed = action.clickOn(GenderMale_Radio);
		passed = action.selectBy(Nationality_DropDown, 2);
		passed = action.clickOn(EmailNotificationNo_Radio);
		
		action.sendDataTo(PrimaryEmailAddress_Input,random.nextString().substring(10)+"@cwc.com");
		action.clickOn(CreateiserviceAccountNo_Radio);
		
		return passed;
	}
	
	public boolean fillBusinessCustomerDetails()
	{
		throw new NotImplementedException("This method is not Implemented Yet");
	}
	
	public boolean fillStandardAddress()
	{
		RandomData random = new RandomData();
		
		boolean passed = false;
		
		passed = action.selectBy(AddressType_DropDown, CommonData.AddressType.StandardAddress);
		passed = action.waitFor(StandardAddressTown_Input, 3, true);
		passed = action.sendDataTo(StandardAddressTown_Input, random.nextString());
		
		return passed;
	}
	
	public boolean fillCustomerClassification()
	{
		boolean passed = false;
		
		return passed;
	}
}