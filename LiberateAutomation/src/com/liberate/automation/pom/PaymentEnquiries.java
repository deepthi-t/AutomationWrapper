package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.core.TestActions;

public class PaymentEnquiries {

	public static void main(String[] args) 
		{
			TestActions action = null;
			
			//Payment Enquiries Panel Header
			By PaymentEnquiry_PanelHeader = By.xpath("//*[text()='Payment Enquiry']");
			
			// Payemnt enquiries search options - Input fileds
			By SearchAccountNumber_InputField = By.xpath("//*[text()='Account No :']/following::input[1]");
			By SearchServiceOrderNumber_InputField = By.xpath("//*[text()='Service Order Number:']/following::input[1]");
			By SearchPaymentNo_InputField = By.xpath("//*[text()='Payment No  :']/following::input[1]");
			By SearchChequeOrCardNo_InputField = By.xpath("//*[text()='Cheque/Card No:']/following::input[1]");
			By SearchPaymentPeriodFrom_InputField = By.xpath("//*[text()='Payment Period From:']/following::input[1]");
			By SearchPaymentPeriodTo_InputField = By.xpath("//*[text()='Payment Period To:']/following::input[1]");
			
			// Payemnt enquiries search options - Dropdown 
			By SearchStatus_Dropdown = By.xpath("//*[text()='Status:']/following::select[1]");
			
			// Payemnt enquiries - Command buttons
			By SearchButton = By.xpath("//*[@value='Search']");
			
	}

}
