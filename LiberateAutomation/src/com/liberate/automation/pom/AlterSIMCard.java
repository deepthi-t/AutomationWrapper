package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.core.TestActions;

public class AlterSIMCard {
	TestActions action = null;
	
	// By Department Site Panel
	By Department_Select = By.xpath("//*[text()='Department:']//following::select[1]");
	By SiteDisabled_Select = By.xpath("//*[text()='Site:']//following::select[@disabled='disabled'][1]");
	By Site_Select = By.xpath("//*[text()='Site:']//following::select[1]");
	
	By retiredReason_Select = By.xpath("//*[text()='Retired Reason:']//following::select[1]");
	
	public AlterSIMCard(TestActions action) {
		this.action = action;
	}
	
	public boolean selectDepartmentSite(String department, String site) {
		boolean passed = false;

		passed = action.waitFor(Department_Select, 4, true);
		passed = action.selectByPartialText(Department_Select, department);

		passed = action.waitFor(SiteDisabled_Select, 4, false);
		passed = action.selectByPartialText(Site_Select, site);

		return passed;
	}
	
	public void updateSIMCard() {
		
	}
}
