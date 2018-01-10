package com.liberate.automation.pom;

import com.liberate.automation.common.CommonPanel;
import com.liberate.automation.common.LiberateCommon;
import com.liberate.automation.core.TestActions;

public class BrowseSO {
	private TestActions action = null;

	public String ServiceOrderNumber = "";

	public BrowseSO(TestActions action) {
		this.action = action;
	}

	public boolean navigate() {
		boolean passed = false;

		passed = action.waitFor(LiberateCommon.LevelOne.Orders, 4, true);
		passed = action.clickOn(LiberateCommon.LevelOne.Orders);

		return passed;
	}

	public boolean searchServiceOrder(String department, String ServiceOrderNumber) {

		action.scrollUp();

		boolean passed = false;

		passed = CommonPanel.SearchServiceOrder(action, department, ServiceOrderNumber);

		return passed;
	}
}
