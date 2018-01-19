package com.liberate.automation.common;

import org.openqa.selenium.By;

import com.liberate.automation.core.TestActions;

public class CommonPanel {
	public static By Accept_Button = By.xpath("//*[@value = 'Accept']");
	public static By AcceptDisable_Button = By.xpath("//input[@value='Accept' and @disabled='disabled']");
	public static By Apply_Button = By.xpath("//*[@value = 'Apply']");
	public static By Search_Button = By.xpath("//*[@value = 'Search']");
	
	/***
	 * Class which holds information about Liberate Header
	 * @author Nikhil Das
	 *
	 */
	public static class LiberateHeader{
		
		/***
		 * To get Liberate System Date in 'DD/MM/YYYY, HH:mm' 
		 */
		public static By LiberateDate = By.xpath("//span[text()='Date:']/following::span[1]");
		public static By EnvironmentDetails = By.xpath("//span[text()='CIS System:']/following::span[1]"); 
	}
	
	public static class popUp {
		/***
		 * XPath of pop up window
		 */
		public static By popUpWindow = By.xpath("//td[@class='icePnlPopBody popupPanelBody']");
		public static By popUpMessage_Value = By.xpath("//td[@class='icePnlPopBody popupPanelBody']/descendant::span[1]");
		
		public static By popUpYes_Button = By.xpath("//input[@value='Yes']");
		public static By popUpNo_Button = By.xpath("//input[@value='No']");
		public static By popUpOK_Button = By.xpath("//input[@value='OK']");
		
		public static boolean validateMessage(TestActions action, String message)
		{
			boolean passed = false;

			passed = action.waitFor(CommonPanel.popUp.popUpWindow, 4, true);
			passed = (action.getTextFromPage(CommonPanel.popUp.popUpMessage_Value).trim().equals(message.trim()))?true:false;
			
			return passed;
		}
		
		/***
		 * Click on OK button in the pop up.
		 * 
		 * @param action
		 *            The action class to be passed.
		 * @return True is able to click on OK button. Else will return false.
		 */
		public static boolean clickOK(TestActions action) {
			By OK_Button = By.xpath("//input[@value='OK']");

			boolean passed = false;

			passed = action.waitFor(OK_Button, 4, true);
			passed = action.clickOn(OK_Button);

			return passed;
		}
	}

	public static class ServiceOrder {
		
		static By department_Select = By.xpath("//*[text()='Department:']/following::select[1]");
		static By departmentDisabled_Select = By
				.xpath("//*[text()='Department:']/following::select[@disabled='disabled'][1]");
		static By changeDepartment_Button = By.xpath("//input[@value='Change']");
		static By serviceOrder_Input = By.xpath("//*[text()='Service Order:']/following::input[1]");
		static By search_Button = By.xpath("//input[@value='Search']");
		
		/***
		 * XPath for Service Order List Header.
		 */
		public static By serviceOrderList_Header = By.xpath("//*[text()='Service Order List']");

		/***
		 * Method to select particular Service Order from List
		 * 
		 * @param element
		 *            Append '[<i><b>count</b></i>]' to select that row.
		 * 
		 *            <br>
		 *            Append '/descendant::td[1]' after adding count, for Service Order
		 *            <br>
		 *            Append '/descendant::td[2]' after adding count, for Customer Name
		 *            <br>
		 *            Append '/descendant::td[3]' after adding count, for SO Priority
		 *            <br>
		 *            Append '/descendant::td[4]' after adding count, for Exchange <br>
		 *            Append '/descendant::td[5]' after adding count, for Status
		 * @return XPath of the row or particular cell depends on the passed
		 *         <i>element</i> parameter
		 */
		public static By ServiceOrderList_Row(String element) {
			return By.xpath(
					"//*[text()[contains(.,'Service Order List')]]/following::div[1]/descendant::tbody[1]/descendant::tr"
							+ element);
		}
	
		/***
		 * Method to search with Service Order Number
		 * 
		 * @param action
		 *            The action class that needs to be passed.
		 * @param department
		 *            The department to be selected while searching.
		 * @param ServiceOrderNumber
		 *            The Service Order Number to be searched for.
		 * @return True is able to search. Else will return false.
		 */
		public static boolean Search(TestActions action, String department, String ServiceOrderNumber) {
			boolean passed = false;
			
			passed = selectDepartment(action, department);
			
			passed = action.sendDataTo(serviceOrder_Input, ServiceOrderNumber);
			passed = action.waitFor(1);
			passed = action.clickOn(search_Button);

			return passed;
		}
		
		public static boolean selectDepartment(TestActions action, String department)
		{
			boolean passed = false;

			passed = action.waitFor(department_Select, 4, true);

			if (!action.getSelectedOption(department_Select).contains(department)) {
				passed = action.clickOn(changeDepartment_Button);
				passed = action.waitFor(departmentDisabled_Select, 4, false);

				passed = action.selectByPartialText(department_Select, department);
				passed = action.waitFor(departmentDisabled_Select, 4, true);

				passed = action.waitFor(1);
			}
			
			return passed;
		}
	}
}