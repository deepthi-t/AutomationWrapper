package com.liberate.automation.pom;

import org.openqa.selenium.By;

public class MaintainDepositReason 


{
	//Maintain Deposit Reason Panel Header, first record selection in existing records
	
	By MaintainDepositReason_PanelHeader = By.xpath("//div[@class='icePnlClpsbl icePnlClpsblDM']/div[1]/div[1]/span");
	By FirstRecord_MaintainDepositReasons = By.xpath("//table[@class='iceDatTbl']/tbody[1]/tr[1]/td[1]/span");
	
	//New_Deposit Reason Creation
	
	// New button in Maintain Deposit Reason screen	
	By NewButton = By.xpath("//div[@class='icePnlGrp iceNormalPnlGrd']/div[1]/input[1]");

	// New record creation _ Maintain Deposit Reason - All input fields
	By DepositReasonCode_inputField = By.xpath("//div[@class='icePnlClpsbl icePnlClpsblDM']//*[text()='Deposit reason Code:']/following::input[1]");
	By Description_inputField = By.xpath("//*[text()='Description:']/following::input[1]");
	By InteresttobeCreditedtoCustomersBill = By.xpath("//*[text()[contains(.,'Interest to be credited to customer')]]/following::input[1]");
	By NoofMonthstoHoldDepositBeforeAutomaticRefund = By.xpath("//*[text()[contains(.,'deposit before automatic refund:')]]/following::input[1]");
	By MonthsOverWhichDepositisRefunded = By.xpath("//*[text()[contains(.,'deposit is refunded:')]]/following::input[1]");
	By UsageAdvanceDefaultAmount = By.xpath("//*[text()[contains(.,'Default Amount:')]]/following::input[1]");
	By MonthsthePayBill_onTimeBeforeDepositisAutomaticallyRefunded = By.xpath("//*[text()[contains(.,'before deposit is automatically refunded:')]]/following::input[1]"); 
	By MonthsAfterProdorAcctCeasedBeforeRecommendforRefund = By.xpath("//*[text()[contains(.,'before recommend for refund:')]]/following::input[1]");
	
	// New record creation _ Maintain Deposit Reason - All radio buttons
	By RefundDeposit_radioButtonYes = By.xpath("(//*[text()='Refund deposit:']/following::input[@value='Y'])[1]");
	By RefundDeposit_radioButtonNo = By.xpath("(//*[text()='Refund deposit:']/following::input[@value='N'])[1]");
	By AccrueInterestOnDeposit_radioButtonYes = By.xpath("(//*[text()='Accrue interest on deposit :']/following::input[@value='Y'])[1]");
	By AccrueInterestOnDeposit_radioButtonNo = By.xpath("(//*[text()='Accrue interest on deposit :']/following::input[@value='N'])[1]");
	By AutomaticallyRefundtoWorkingAccounts_Yes = By.xpath("(//*[text()='Automatically Refund to Working Accounts:']/following::input[@value='Y'])[1]");
	By AutomaticallyRefundtoWorkingAccounts_No = By.xpath("(//*[text()='Automatically Refund to Working Accounts:']/following::input[@value='N'])[1]");
	By InterestisCompound_Yes = By.xpath("(//*[text()='Interest is compound:']/following::input[@value='Y'])[1]");
	By InterestisCompound_No = By.xpath("(//*[text()='Interest is compound:']/following::input[@value='N'])[1]");
	By PayInitialPartPeriodInterest_Yes = By.xpath("(//*[text()='Pay Initial Part Period Interest:']/following::input[@value='Y'])[1]");
	By PayInitialPartPeriodInterest_No = By.xpath("(//*[text()='Pay Initial Part Period Interest:']/following::input[@value='N'])[1]");
	By UsageAdvance_Yes = By.xpath("(//*[text()='Usage Advance:']/following::input[@value='Y'])[1]");
	By UsageAdvance_No = By.xpath("(//*[text()='Usage Advance:']/following::input[@value='N'])[1]");
	By AutomaticallyRefundtoCeasedAccounts_Yes = By.xpath("(//*[text()='Automatically Refund to Ceased Accounts:']/following::input[@value='Y'])[1]");
	By AutomaticallyRefundtoCeasedAccounts_No = By.xpath("(//*[text()='Automatically Refund to Ceased Accounts:']/following::input[@value='N'])[1]");
	By RefundMethod_Adjustment = By.xpath("//*[text()='Refund Method:']/following::input[@value='A']");
	By RefundMethod_ServiceCharge = By.xpath("//*[text()='Refund Method:']/following::input[@value='S']");
	
	// New record creation_Maintain Deposit Reason - Command button
	By Acceptbutton = By.xpath("//div[@class='icePnlGrp iceNormalPnlGrd']//input[@value='Accept']");
	By CancelButton = By.xpath("//div[@class='icePnlGrp iceNormalPnlGrd']//input[@value='Cancel']");
}
