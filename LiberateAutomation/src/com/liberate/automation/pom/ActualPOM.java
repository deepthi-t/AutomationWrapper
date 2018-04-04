package com.liberate.automation.pom;

import com.liberate.automation.core.TestActions;

public abstract class ActualPOM {
	/***
	 * All Test Page Object Repository class must have an object assigned to the
	 * local action variable. The value should be assigned via the Constructor of the
	 * class.
	 */
	TestActions action = null;

	/***
	 * All Page Object Repository class must have a constructor to accept a
	 * TestAction Class
	 */
	public ActualPOM(TestActions action) {
		/***
		 * The passed TestAction class object should be assigned to the local variable
		 */
		this.action = action;
	}
	
	/***
	 * Page Object Repository class must have a navigate method if it is possible to navigate to the screen using left link. 
	 */
	public abstract void navigate();
}
