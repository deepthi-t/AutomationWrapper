package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.common.LeftLink;
import com.liberate.automation.common.LiberateCommon;
import com.liberate.automation.core.TestActions;

public class BadCheckProcessing {
	TestActions action = null;

	// Enter payment number, search and reset button

	// Payment button

	By Payment_number = By.xpath("//*[@id = 'badChequeProcessing:bcps_inputtext_paymentNumber']");

	// search button

	By Search_button = By.xpath("//input[@value = 'Search']");

	// reset button

	By Reset_button = By.xpath("//input[@value = 'Reset']");

	// Cheque details button

	By Check_details_button = By.xpath("//*[@id = 'badChequeProcessing:badChequeProcessingResults:0']");

	// Check_card_input , Reason , Apportion, Accept , Cancel

	// Check_card_input

	By Check_card_input = By.xpath("//*[@id = 'badChequeProcessing:chequeCreditCard']");

	// Reason Drop down

	By Reason_Drop_Down = By.xpath("//*[@id ='badChequeProcessing:returnedReason']");

	// Current_Credit_Apportion

	By Current_Credit_Apportion = By.xpath("//*[@id ='badChequeProcessing:unallocChequeDetails:0:j_idt267']");

	// Current_Credit_Accept_Button

	By Current_Credit_Accept_Button = By.xpath("(//input[@value = 'Accept'])[1]");

	// Current_Credit_Cancel_Button

	By Current_Credit_Cancel_Button = By.xpath("//input[@value = 'Cancel'])[1]");
	
	
	
	// plant_item_Apportion 
	
	By Payment_Item_Apportion = By.xpath("//*[@id = 'badChequeProcessing:paymentChequeDetails:0:j_idt330']");
	
	// Payment_Item_Accept_button
	
	By Payment_Item_Accept_button = By.xpath("(//input[@value = 'Accept'])[2]");
	
	
	// Payment_Item_Cancel_Button

	By Payment_Item_Cancel_Button = By.xpath("//input[@value = 'Cancel'])[2]");
	
	
	By Check_Details_Letter_Dropdown = By.xpath("//*[@id ='badChequeProcessing:ChequeDetails3:0:letter']");
	
	By Check_Details_Accept_Button   = By.xpath("//input[@value = 'Accept'])[1]");
	
	By Check_Details_Cancel_Button   = By.xpath("//input[@value = 'Cancel'])[1]");
	
	
	

	/***
	 * Default constructor that takes TestAction object as argument.
	 * 
	 * @param action
	 *            The TestAction class object, which will be used to run test
	 *            steps
	 */
	public BadCheckProcessing(TestActions action) {
		this.action = action;
	}

	/***
	 * The method to navigate to Void Payment screen
	 * 
	 * @return Returns true if able to navigate, else will return false.
	 */
	public boolean navigate() {
		boolean passed = false;

		passed = action.waitFor(LiberateCommon.LevelOne.Orders, 4, true);
		passed = action.clickOn(LiberateCommon.LevelOne.Payments);
		passed = action.waitFor(LiberateCommon.Payments.PaymentsAdmin, 4, true);
		passed = action.clickOn(LiberateCommon.Payments.PaymentsAdmin);
		passed = action.waitFor(LeftLink.PaymentsAdmin.BadChequeProcessing, 4, true);
		passed = action.clickOn(LeftLink.PaymentsAdmin.BadChequeProcessing);

		return passed;
	}

	/***
	 * The method to Enter the payment number in Bad Check Processing screen
	 * 
	 * @return Returns true if able to Enter, else will return false.
	 */

	public boolean PaymentNumber(String PaymentNumber) {
		boolean passed = false;

		passed = action.sendDataTo(Payment_number, PaymentNumber);
		passed = action.waitFor(Payment_number, 4, true);

		return passed;

	}

	/***
	 * The method to search the Entered the payment number in Bad Check
	 * Processing screen
	 * 
	 * @return Returns true if able to Search, else will return false.
	 */
	public boolean Search() {
		boolean passed = false;

		passed = action.clickOn(Search_button);
		passed = action.waitFor(Search_button, 4, true);

		return passed;
	}

	/***
	 * The method to Reset the Entered the payment number in Bad Check
	 * Processing screen
	 * 
	 * @return Returns true if able to Reset, else will return false.
	 */
	public boolean Reset() {
		boolean passed = false;

		passed = action.clickOn(Reset_button);
		passed = action.waitFor(Reset_button, 4, true);

		return passed;
	}

	/***
	 * The method to Click on Check Details Button in Bad Check Processing
	 * screen
	 * 
	 * @return Returns true if able to Reset, else will return false.
	 */

	public boolean Checkdetailsbutton() {
		boolean passed = false;

		passed = action.waitFor(Check_details_button, 4, true);
		passed = action.clickOn(Check_details_button);
		
		return passed;
	}

	/***
	 * The method to Enter the CheckCardInput in Bad Check Processing screen
	 * 
	 * @return Returns true if able to Enter, else will return false.
	 */

	public boolean Checkcardinput(String CheckCardInput) {
		boolean passed = false;
		
		passed = action.waitFor(Check_card_input, 2, true);
		passed = action.sendDataTo(Check_card_input, CheckCardInput);
	

		return passed;
	}

	/***
	 * The method to SELECT the ReasonDropDown in Bad Check Processing screen
	 * 
	 * @return Returns true if able to Enter, else will return false.
	 */

	public boolean ReasonDropDown(String ReasonDropDown) {
		boolean passed = false;

		passed = action.selectBy(Reason_Drop_Down, Integer.parseInt(ReasonDropDown));
		

		return passed;
	}

		/***
		 * The method to Enter the Apportion of current credit in Bad Check Processing screen
		 * 
		 * @return Returns true if able to Enter, else will return false.
		 */

	public boolean CurrentCreditApportionData(String CurrentCreditApportion) {
		boolean passed = false;

		passed = action.sendDataTo(Current_Credit_Apportion, CurrentCreditApportion);
		

		return passed;

	}

	/***
	 * The method to Select the Accept button of current credit in Bad Check Processing screen
	 * 
	 * @return Returns true if able to Enter, else will return false.
	 */

	public boolean CurrentCreditAcceptButton() {
		boolean passed = false;

		passed = action.waitFor(Current_Credit_Accept_Button, 2, true);
		passed = action.clickOn(Current_Credit_Accept_Button);

		return passed;

	}

	/***
	 * The method to Select the Cancel button of current credit in Bad Check Processing screen
	 * 
	 * @return Returns true if able to Enter, else will return false.
	 */

	public boolean CurrentCreditCancelButton() {
		boolean passed = false;
		passed = action.clickOn(Current_Credit_Cancel_Button);
		passed = action.waitFor(Check_details_button, 4, true);

		return passed;

	}

	/***
	 * The method to Enter the Apportion of payment item in Bad Check Processing screen
	 * 
	 * @return Returns true if able to Enter, else will return false.
	 */

public boolean paymentitemApportion(String paymentitemApportion) {
	boolean passed = false;

	passed = action.sendDataTo(Payment_Item_Apportion, paymentitemApportion);
	

	return passed;

}
	
/***
 * The method to Select the Accept button of Payment item in Bad Check Processing screen
 * 
 * @return Returns true if able to Enter, else will return false.
 */

public boolean PaymentItemAcceptButton() {
	boolean passed = false;

	passed = action.clickOn(Payment_Item_Accept_button);
	passed = action.waitFor(Check_details_button, 4, true);

	return passed;

}

/***
 * The method to Select the Cancel button of Payment item in Bad Check Processing screen
 * 
 * @return Returns true if able to Enter, else will return false.
 */

public boolean PaymentItemCancelButton() {
	boolean passed = false;
	passed = action.clickOn(Payment_Item_Cancel_Button);
	passed = action.waitFor(Check_details_button, 4, true);

	return passed;

}

public boolean CheckDetailsDropdown(String CheckDetailsAcceptButton) {
         boolean passed = false;

         passed = action.waitFor(Check_details_button, 4, true);
         passed = action.selectBy(Check_Details_Letter_Dropdown, "04-RTD item letter (INSTRUCTION CANCELLED)");

		return passed;
}

public boolean CheckDetailsAccept(){
	boolean passed = false;
	
	passed = action.clickOn(Check_Details_Accept_Button);
	passed = action.waitFor(Check_details_button, 4, true);

	
	
	return passed;
}
public boolean CheckDetailsCancel(){
	boolean passed = false;
	
	passed = action.clickOn(Check_Details_Cancel_Button);
	passed = action.waitFor(Check_details_button, 4, true);

	
	
	return passed;
}

}
