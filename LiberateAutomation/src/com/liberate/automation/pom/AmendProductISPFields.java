package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.core.TestActions;

public class AmendProductISPFields {

	public TestActions action = null;

	By selectproduct_record = By.xpath(
			"//tr[@id='customerServicesForm:serviceEnquiryTabs:0:productsTab:custServProductsResultTable_row_0']");
	By AmendProductISPFields = By.xpath("//span[@id='customerServicesForm:j_idt117:j_idt193:out']");
	By ISPUsername_Textfield = By.xpath("//input[@id='amendProductsForm:userNameId']");
	By ISPPassword_Textfield = By.id("amendProductsForm:pwdId");
	By GeneratePassword_Textfield = By.xpath("//*[@value='Generate Password']");
	By AmendISPFieldsAccept_Button = By.xpath("//*[@value='Generate Password']/following::input[@value='Accept']");
	By AmendISPFieldCancel_Button = By.xpath("//*[@value='Generate Password']/following::input[@value='Cancel']");

	public AmendProductISPFields(TestActions action) {
		this.action = action;
	}

	public boolean clickOnProductRecord() {
		boolean passed = false;

		passed = action.waitFor(selectproduct_record, 4, true);
		passed = action.clickOn(selectproduct_record);

		return passed;
	}

	public boolean clickOnAmendProductISPfields() {
		boolean passed = false;

		passed = action.waitFor(AmendProductISPFields, 4, true);
		passed = action.clickOn(AmendProductISPFields);

		return passed;
	}

	public boolean enterdatatoUsername() {
		boolean passed = false;

		passed = action.waitFor(ISPUsername_Textfield, 4, true);
		passed = action.sendDataTo(ISPUsername_Textfield, "Test1");

		return passed;
	}

	public boolean clickOnGeneratePassword() {
		boolean passed = false;

		passed = action.waitFor(GeneratePassword_Textfield, 4, true);
		passed = action.clickOn(GeneratePassword_Textfield);

		return passed;
	}

	public boolean clickOnAccept() {
		boolean passed = false;

		passed = action.waitFor(AmendISPFieldsAccept_Button, 4, true);
		passed = action.clickOn(AmendISPFieldsAccept_Button);

		return passed;
	}

	public boolean clickOnCance() {
		boolean passed = false;

		passed = action.waitFor(AmendISPFieldCancel_Button, 4, true);
		passed = action.clickOn(AmendISPFieldCancel_Button);

		return passed;
	}
}
