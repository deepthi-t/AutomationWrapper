package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.common.LeftLink;
import com.liberate.automation.common.LiberateCommon;
import com.liberate.automation.core.TestActions;

public class BadCheckProcessing {

	private static final String Search = null;

	TestActions action = null;
	

	// Enter payment number, search and reset button

	
	
	// Payment button
	
	By Payment_number =  By.xpath("//*[@id = 'badChequeProcessing:bcps_inputtext_paymentNumber']"); 
	
	
	// search button

		By Search_button = By.xpath("//*[@id = 'badChequeProcessing:j_idt142']");
		
		// reset button

		By Reset_button = By.xpath("//*[@id = 'badChequeProcessing:j_idt143']");
		
		
		
		
	
		// Cheque details button
		
	By Check_details_button = By.xpath("//*[@id = 'badChequeProcessing:badChequeProcessingResults:0']");
	
	
	
	// Check_card_input , Reason , Apportion, Accept , Cancel
	
	
	// Check_card_input
	
	By Check_card_input = By.xpath("//*[@id = 'badChequeProcessing:chequeCreditCard']");
	
	//Reason Drop down
	
	By Reason_Drop_Down = By.xpath("//*[@id ='badChequeProcessing:returnedReason']");
	
	// Apportion
	
	By Apportion = By.xpath("//*[@id ='badChequeProcessing:unallocChequeDetails:0:j_idt267']");
	
	// Accept_Button
	
	By Accept_Button = By.xpath("//*[@id = 'badChequeProcessing:j_idt311']");
	
	// Cancel_Button
	
	By Cancel_Button = By.xpath("//*[@id = 'badChequeProcessing:j_idt312']");
	
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
	 * The method to search the Entered the payment number in Bad Check Processing screen
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
	 * The method to Reset the Entered the payment number in Bad Check Processing screen
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
	 * The method to Click on Check Details Button in Bad Check Processing screen
	* 
	 * @return Returns true if able to Reset, else will return false.
	*/
	
	public boolean Checkdetailsbutton() {
		boolean passed = false;
	
	
	passed = action.clickOn(Check_details_button);
	passed = action.waitFor(Check_details_button, 4, true);
	
	return passed;
}


	/***
	 * The method to Enter the CheckCardInput in Bad Check Processing screen
	 * 
	 * @return Returns true if able to Enter, else will return false.
	*/
	
	
	public boolean Checkcardinput(String CheckCardInput) {
		boolean passed = false;
	
		passed = action.sendDataTo(Check_card_input, CheckCardInput);
		passed = action.waitFor(Check_details_button, 4, true);
		
		return passed;
	}
	

	/***
	 * The method to SELECT the ReasonDropDown in Bad Check Processing screen
	 * 
	 * @return Returns true if able to Enter, else will return false.
	*/
	
	public boolean ReasonDropDown(String ReasonDropDown) {
	     boolean passed = false;
	     
	     
	     passed = action.selectBy(Reason_Drop_Down, ReasonDropDown);
	     passed = action.waitFor(Check_details_button, 4, true);
	     
	     return passed;
	}
	
	
	/***
	 * The method to Enter the Apportion in Bad Check Processing screen
	 * 
	 * @return Returns true if able to Enter, else will return false.
	*/
	
	  public boolean ApportionData(String ApportionData) {
		  boolean passed = false;
		
		  passed = action.sendDataTo(Apportion, ApportionData);
		  passed = action.waitFor(Check_details_button, 4, true);
		  
		  
		  return passed;
		 	
	
	}
	
	  /***
		 * The method to Select the Accept button in Bad Check Processing screen
		 * 
		 * @return Returns true if able to Enter, else will return false.
		*/
		
	
	public boolean AcceptButton(){
		boolean passed = false;
		
		passed = action.clickOn( Accept_Button);
        passed = action.waitFor(Check_details_button, 4, true);
	     
	     return passed;
		
		
	}
	
	 /***
	 * The method to Select the Cancel button in Bad Check Processing screen
	 * 
	 * @return Returns true if able to Enter, else will return false.
	*/
	
	public boolean CancelButton(){
		boolean passed = false;
		passed = action.clickOn( Cancel_Button);
        passed = action.waitFor(Check_details_button, 4, true);
	     
	     return passed;
		
	}
	
	
	
	
}
