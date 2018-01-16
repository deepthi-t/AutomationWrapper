package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.common.CommonPanel;
import com.liberate.automation.common.LeftLink;
import com.liberate.automation.common.LiberateCommon;
import com.liberate.automation.core.TestActions;

public class PYSinglePayment {
	TestActions action = null;
	
	By CashDrawerNotSelectedMessage_Value = By.xpath("//*[text()='Change the department to cashiers office']");
	By CashDrawerOpenedMessage_Value = By.xpath("//*[text()='Cashdrawer already open in another office.']");

	By DepartmentDisabled_Select = By.xpath("//*[text()='Department:']/following::select[@disabled='disabled']");
	By Department_Select = By.xpath("//*[text()='Department:']/following::select");
	By Change_Button = By.xpath("//input[@value='Change']");
	
	public PYSinglePayment(TestActions action) {
		this.action = action;
	}

	public boolean navigate() {
		boolean passed = false;

		action.waitFor(LiberateCommon.LevelOne.Payments, 4, true);
		action.clickOn(LiberateCommon.LevelOne.Payments);

		action.waitFor(LeftLink.Payments.SinglePayment, 4, true);

		return passed;
	}

	public boolean verifyCashDrawer() {
		boolean passed = false;
		
		action.waitFor(2);
		
		//If no pop available on navigation, will go to if branch.
		if(!(action.countOf(CommonPanel.popUp.popUpOK_Button)>0))
		{
			//If selected Department is not Cashier, select Cashier department
			if(action.countOf(CashDrawerNotSelectedMessage_Value)>0)
			{
				if(action.countOf(DepartmentDisabled_Select)>0)
				{
					action.clickOn(Change_Button);
					action.waitFor(DepartmentDisabled_Select, 4, false);
				}
				
				action.selectByPartialText(Department_Select, "CASH");
				action.waitFor(DepartmentDisabled_Select, 4, true);
			}
		}
		
		action.waitFor(CommonPanel.popUp.popUpOK_Button, 4, true);
		String PopUpMessage = action.getTextFromPage(CashDrawerOpenedMessage_Value);
		passed = PopUpMessage.equals("Cashdrawer already open in another office.");
		
		return passed;
	}
	
	public boolean searchWithAccountNumber()
	{
		boolean passed = false;
		
		
		
		return passed;
	}
	
	public boolean searchWithServiceNumber()
	{
		boolean passed = false;
		
		
		
		return passed;
	}
}
