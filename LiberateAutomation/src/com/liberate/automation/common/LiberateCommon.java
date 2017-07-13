package com.liberate.automation.common;

import org.openqa.selenium.By;

public class LiberateCommon
{
	public static class LevelOne
	{
		public static final By Home = By.xpath("//div[@class='headermenu_row']/descendant::*[text()='Home']");
		public static final By CustomerCare = By.xpath("//div[@class='headermenu_row']/descendant::*[text()='Customer Care']");
		public static final By Orders = By.xpath("//div[@class='headermenu_row']/descendant::*[text()='Orders']");
		public static final By Inventory = By.xpath("//div[@class='headermenu_row']/descendant::*[text()='Inventory']");
		public static final By Faults = By.xpath("//div[@class='headermenu_row']/descendant::*[text()='Faults']");
		public static final By Networks = By.xpath("//div[@class='headermenu_row']/descendant::*[text()='Networks']");
		public static final By BillingEventProcessing = By.xpath("//div[@class='headermenu_row']/descendant::*[text()='Billing & Event Processing']");
		public static final By Payments = By.xpath("//div[@class='headermenu_row']/descendant::*[text()='Payments']");
		public static final By CreditControl = By.xpath("//div[@class='headermenu_row']/descendant::*[text()='Credit Control']");
		public static final By DirectoryEnquiries = By.xpath("//div[@class='headermenu_row']/descendant::*[text()='Directory Enquiries']");
		public static final By ProductsPricing = By.xpath("//div[@class='headermenu_row']/descendant::*[text()='Products & Pricing']");
		public static final By Admin = By.xpath("//div[@class='headermenu_row']/descendant::*[text()='Admin']");
	}
	
	public static class Home
	{
		public static final By News = By.xpath("//div[@class='subheadermenu_row']/descendant::*[text()='News']");
		public static final By Reports = By.xpath("//div[@class='subheadermenu_row']/descendant::*[text()='Reports']");
	}
	
	public static class CustomerCare
	{
		public static final By Search = By.xpath("//div[@class='subheadermenu_row']/descendant::*[text()[contains(.,'Search')]]");
		public static final By ServiceProvisioning = By.xpath("//div[@class='subheadermenu_row']/descendant::*[text()[contains(.,'Service Provisioning')]]");
		public static final By MaintainQuery = By.xpath("//div[@class='subheadermenu_row']/descendant::*[text()='Maintain Query']");
		public static final By AdditionalCustomerInformation = By.xpath("//div[@class='subheadermenu_row']/descendant::*[text()='Additional Customer Information']");
		public static final By CustomerCareAdmin = By.xpath("//div[@class='subheadermenu_row']/descendant::*[text()='Customer Care Admin']");
		public static final By CustomerCareReports = By.xpath("//div[@class='subheadermenu_row']/descendant::*[text()='Customer Care Reports']");
		public static final By LIMELITE = By.xpath("//div[@class='subheadermenu_row']/descendant::*[text()='LIME LITE']");
	}
	
	public static class Orders
	{
		public static final By BrowseSO = By.xpath("//div[@class='subheadermenu_row']/descendant::*[text()='Browse SO']");
		public static final By ManageServiceOrder = By.xpath("//div[@class='subheadermenu_row']/descendant::*[text()='Manage Service Order']");
		public static final By WaitlistEnquiry = By.xpath("//div[@class='subheadermenu_row']/descendant::*[text()[contains(.,'Waitlist Enquiry')]]");
		public static final By WorkAssignmentManagement = By.xpath("//div[@class='subheadermenu_row']/descendant::*[text()[contains(.,'Work Assignment Management')]]");
		public static final By ServiceOrderApproval = By.xpath("//div[@class='subheadermenu_row']/descendant::*[text()[contains(.,'Service Order Approval')]]");
		public static final By SwitchRequests = By.xpath("//div[@class='subheadermenu_row']/descendant::*[text()='Switch Requests']");
		public static final By RouteMaintenance = By.xpath("//div[@class='subheadermenu_row']/descendant::*[text()[contains(.,'Route Maintenance')]]");
		public static final By OrderReferenceData = By.xpath("//div[@class='subheadermenu_row']/descendant::*[text()[contains(.,'Orders Reference Data')]]");
		public static final By OrderReports = By.xpath("//div[@class='subheadermenu_row']/descendant::*[text()[contains(.,'Orders Reports')]]");
	}

	public static class Inventory
	{
		public static final By SimManagement = By.xpath("//div[@class='subheadermenu_row']/descendant::*[text()='SIM Management']");
		public static final By ManageMACInventory = By.xpath("//div[@class='subheadermenu_row']/descendant::*[text()='Manage MAC Inventory']");
		public static final By ManageSmartCardInventory = By.xpath("//div[@class='subheadermenu_row']/descendant::*[text()='Manage Smart Card Inventory']");
		public static final By SIMReferenceData = By.xpath("//div[@class='subheadermenu_row']/descendant::*[text()='SIM Ref Data']");
		public static final By InventoryReports = By.xpath("//div[@class='subheadermenu_row']/descendant::*[text()='Inventory Reports']");
	}
}
