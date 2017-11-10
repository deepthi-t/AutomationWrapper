package com.liberate.automation.main;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

import com.liberate.automation.core.TestActions;
import com.liberate.automation.pom.Login;
import com.liberate.automation.testcases.RaiseFaultTestCases;

public class Main {

	public static void main(String[] args) {
	
		RaiseFaultTestCases rftc=new RaiseFaultTestCases();
		rftc.navigateToURL();
		rftc.raiseNewFault();
}
}