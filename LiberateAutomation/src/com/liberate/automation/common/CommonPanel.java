package com.liberate.automation.common;

import org.openqa.selenium.By;

public class CommonPanel 
{
	public static class ServiceOrderList
	{
		/***
		 * Append '[<i><b>count</b></i>]' to select that row.
		 * 
		 * <br>Append '/descendant::td[1]' after adding count, for Service Order
		 * <br>Append '/descendant::td[2]' after adding count, for Customer Name
		 * <br>Append '/descendant::td[1]' after adding count, for SO Priority
		 * <br>Append '/descendant::td[1]' after adding count, for Exchange
		 * <br>Append '/descendant::td[1]' after adding count, for Status
		 */
		public static By ServiceOrderList_Row = By.xpath("//*[text()[contains(.,'Service Order List')]]/following::div[1]/descendant::tbody[1]/descendant::tr");
	}
}