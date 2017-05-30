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
	
	public static class Orders
	{
		public static final By BrowseSO = By.xpath("//div[@class='subheadermenu_row']/descendant::*[text()='Browse SO']");
		public static final By SwitchRequests = By.xpath("//div[@class='subheadermenu_row']/descendant::*[text()='Switch Requests']");
	}
}
