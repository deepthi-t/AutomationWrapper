package com.liberate.automation.testcases;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;

import com.liberate.automation.core.TestActions;
import com.liberate.automation.pom.Login;
import com.liberate.automation.pom.MaintainDepositReason;



public class DepositReason {
	
	static TestActions action = new TestActions();
	
	public void navigateToURL()
	{
		action.gotoURL("http://172.21.73.80:8081/liberate-LONI01-S10/");
	}
	
	public void newDepositReasonAccept()
	{
		MaintainDepositReason mdr = new MaintainDepositReason(action);
		Login login = new Login(action);

		assertEquals(login.login("libadmin", "Ic3cr34m!"),true);
		action.getScreenShot("DepositReason");
		assertEquals(mdr.navigate(),true);
		action.getScreenShot("DepositReason");
		assertEquals(mdr.clickNewButton(),true);
		action.getScreenShot("DepositReason");
		action.scroll(1340);
		assertEquals(mdr.provideDepositReasonDetailsNewCreation("Mti7", "TestingAutomation", "Y", "4"),true);
		action.getScreenShot("DepositReason");
		assertEquals(mdr.clickAcceptButton(),true);
		action.getScreenShot("DepositReason");
		String x=action.getTextFromPage(By.xpath("//span[@class='iceMsgInfo']"));
		System.out.println(x);

	}

	public void newDepositReasonCancel() 
	{
		MaintainDepositReason mdr = new MaintainDepositReason(action);
		Login login = new Login(action);

		assertEquals(login.login("libadmin", "Ic3cr34m!"),true);
		action.getScreenShot("DepositReason");
		assertEquals(mdr.navigate(),true);
		action.getScreenShot("DepositReason");
		assertEquals(mdr.clickNewButton(),true);
		action.getScreenShot("DepositReason");
		assertEquals(mdr.provideDepositReasonDetailsNewCreation("Mte7", "TestingAutomation", "Y", "4"),true);
		action.getScreenShot("DepositReason");
		assertEquals(mdr.clickCancelButton(),true);
		action.getScreenShot("DepositReason");

	}
	
	
	public void amendDepositReasonAccept() {
		MaintainDepositReason mdr = new MaintainDepositReason(action);
		Login login = new Login(action);

		assertEquals(login.login("libadmin", "Ic3cr34m!"),true);
		action.getScreenShot("DepositReason");
		assertEquals(mdr.navigate(),true);
		action.getScreenShot("DepositReason");
		assertEquals(mdr.selectRecordToAmend(),true);
		action.getScreenShot("DepositReason");
		assertEquals(mdr.clickAmendButton(),true);
		action.getScreenShot("DepositReason");
		assertEquals(mdr.provideDetailsAmendDepositReason("TestingAutomationAmend", "Y", "4"),true);
		action.getScreenShot("DepositReason");
		assertEquals(mdr.clickAcceptButton(),true);
		action.getScreenShot("DepositReason");

	}

	public void amendDepositReasonCancel() {
		MaintainDepositReason mdr = new MaintainDepositReason(action);
		Login login = new Login(action);

		assertEquals(login.login("libadmin", "Ic3cr34m!"),true);
		action.getScreenShot("DepositReason");
		assertEquals(mdr.navigate(),true);
		action.getScreenShot("DepositReason");
		assertEquals(mdr.selectRecordToAmend(),true);
		action.getScreenShot("DepositReason");
		assertEquals(mdr.clickAmendButton(),true);
		action.getScreenShot("DepositReason");
		assertEquals(mdr.provideDetailsAmendDepositReason("TestingAutomationAmend", "Y", "4"),true);
		action.getScreenShot("DepositReason");
		assertEquals(mdr.clickCancelButton(),true);
		action.getScreenShot("DepositReason");

	}

}
