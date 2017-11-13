package com.liberate.automation.testcases;

import static org.testng.Assert.assertEquals;

import com.liberate.automation.core.TestActions;
import com.liberate.automation.pom.Login;
import com.liberate.automation.pom.PaymentEnquiriesPOM;

public class PaymentEnquiries 
{
	TestActions action = new TestActions();
	
	public void navigateToURL()
	{
		action.gotoURL("http://172.21.73.80:8081/liberate-LONI01-S10/");
	}
	
	public void paymentEnquiry_SearchWithAccountNumber()
	{
		PaymentEnquiriesPOM pe=new PaymentEnquiriesPOM(action);
		Login login = new Login(action);
		
		assertEquals(login.login("libadmin", "Ic3cr34m!"),true);
		action.getScreenShot("PaymentEnquiries");
		assertEquals(pe.navigate(),true);
		action.getScreenShot("PaymentEnquiries");
		assertEquals(pe.paymentEnquiryWithAccountNumber("940003940100"),true);
		action.getScreenShot("PaymentEnquiries");	
	}
	
	
	public void paymentEnquiry_SearchWithPaymentNumber()
	{
		PaymentEnquiriesPOM pe=new PaymentEnquiriesPOM(action);
		Login login = new Login(action);
		
		assertEquals(login.login("libadmin", "Ic3cr34m!"),true);
		action.getScreenShot("PaymentEnquiries");
		assertEquals(pe.navigate(),true);
		action.getScreenShot("PaymentEnquiries");
		assertEquals(pe.paymentEnquiryWithPaymentNo("9319463"),true);
		action.getScreenShot("PaymentEnquiries");	
	}
	
	
	
	public void paymentEnquiry_SearchWithServiceOrderNumber()
	{
		PaymentEnquiriesPOM pe=new PaymentEnquiriesPOM(action);
		Login login = new Login(action);
		
		assertEquals(login.login("libadmin", "Ic3cr34m!"),true);
		action.getScreenShot("PaymentEnquiries");
		assertEquals(pe.navigate(),true);
		action.getScreenShot("PaymentEnquiries");
		assertEquals(pe.paymentEnquiryWithServiceOrderNo(""),true);
		action.getScreenShot("PaymentEnquiries");	
	}

	public void accountDetailsForSearchedPayment()
	{
		PaymentEnquiriesPOM pe=new PaymentEnquiriesPOM(action);
		Login login = new Login(action);
		
		assertEquals(login.login("libadmin", "Ic3cr34m!"),true);
		action.getScreenShot("PaymentEnquiries");
		assertEquals(pe.navigate(),true);
		action.getScreenShot("PaymentEnquiries");
		assertEquals(pe.paymentEnquiryWithAccountNumber("940003940100"),true);
		action.getScreenShot("PaymentEnquiries");	
		assertEquals(pe.clickOnAccountDetails_CommandButton(),true);
		action.getScreenShot("AccountDetails_payment");
	}
	
}
