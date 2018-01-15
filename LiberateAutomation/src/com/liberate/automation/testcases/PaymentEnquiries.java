package com.liberate.automation.testcases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.liberate.automation.core.TestActions;
import com.liberate.automation.pom.PaymentEnquiriesPOM;

public class PaymentEnquiries 
{
	static TestActions action = CommonLogin.action;
	
	@Test
	public void searchWithAccountNumber()
	{
		PaymentEnquiriesPOM pe=new PaymentEnquiriesPOM(action);
		
		action.getScreenShot("PaymentEnquiries");
		assertEquals(pe.navigate(),true);
		action.getScreenShot("PaymentEnquiries");
		assertEquals(pe.paymentEnquiryWithAccountNumber("270004470000"),true);
		action.getScreenShot("PaymentEnquiries");
		String acctnum = action.getTextFromPage(By.xpath("//*[@class='icePnlGrp']/div[2]/div[2]/table/tbody/tr[2]/td[2]"));
		action.getScreenShot("PaymentEnquiries");
		System.out.println("Searched Account number is"+" "+acctnum);
		
	}
	
	@Test
	public void searchWithPaymentNumber()
	{
		PaymentEnquiriesPOM pe=new PaymentEnquiriesPOM(action);
		
		action.getScreenShot("PaymentEnquiries");
		assertEquals(pe.navigate(),true);
		action.getScreenShot("PaymentEnquiries");
		assertEquals(pe.paymentEnquiryWithPaymentNo("9320150"),true);
		action.getScreenShot("PaymentEnquiries");	
		String paymntnum = action.getTextFromPage(By.xpath("//*[@class='icePnlGrp']/div[2]/div[2]/table[1]/tbody[1]/tr[2]/td[2]/span"));
		action.getScreenShot("PaymentEnquiries");
		System.out.println("Searched Payment number is"+" "+paymntnum);
	}
	
	
	@Test
	public void SearchWithServiceOrderNumber()
	{
		PaymentEnquiriesPOM pe=new PaymentEnquiriesPOM(action);
		
		action.getScreenShot("PaymentEnquiries");
		assertEquals(pe.navigate(),true);
		action.getScreenShot("PaymentEnquiries");
		assertEquals(pe.paymentEnquiryWithServiceOrderNo(""),true);
		action.getScreenShot("PaymentEnquiries");	
	}
	
	@Test
	public void accountDetailsForSearchedPayment()
	{
		PaymentEnquiriesPOM pe=new PaymentEnquiriesPOM(action);
		
		action.getScreenShot("PaymentEnquiries");
		assertEquals(pe.navigate(),true);
		action.getScreenShot("PaymentEnquiries");
		assertEquals(pe.paymentEnquiryWithPaymentNo("9320150"),true);
		action.getScreenShot("PaymentEnquiries");	
		String acctDetailsPanelName = action.getTextFromPage(By.xpath("//*[text()='Account Payment Details']"));
		String customerdetail = action.getTextFromPage(By.xpath("//*[text()='Account Payment Details']"));
		action.getScreenShot("PaymentEnquiries");
		System.out.println(acctDetailsPanelName+" "+customerdetail);
	}
}
