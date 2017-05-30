package com.liberate.automation.common;

import org.openqa.selenium.By;

public class LeftLink
{
	public static class SwitchRequests
	{
		public static final By ManageSwitchRequest = By.xpath("//td[@class='bodyleftcol']/descendant::*[text()='Manage Switch Request']");
		public static final By RequeueFailedSwitchRequest = By.xpath("//td[@class='bodyleftcol']/descendant::*[text()='Requeue Failed Switch Request']");
		public static final By ManageStalledSwitchRequest = By.xpath("//td[@class='bodyleftcol']/descendant::*[text()='Manage Stalled Switch Request']");
		public static final By BulkReSubmitFailedRequests = By.xpath("//td[@class='bodyleftcol']/descendant::*[text()='Bulk Re-Submit Failed Requests']");
		public static final By MaintainSwitchInterfaceParameters = By.xpath("//td[@class='bodyleftcol']/descendant::*[text()='Maintain Switch Interface Parameters']");
		public static final By ManageSTPUpdates = By.xpath("//td[@class='bodyleftcol']/descendant::*[text()='Manage STP Updates']");
	}
}
