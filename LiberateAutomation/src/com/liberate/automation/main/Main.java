package com.liberate.automation.main;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;

import com.liberate.automation.core.TestActions;
import com.liberate.automation.pom.Login;

public class Main {

	public static void main(String[] args) {
		getLeftLinks();
	}
	
	public static void getLeftLinks()
	{
		By level1;
		By level2;
		By leftLink;
		
		TestActions action = new TestActions();
		Login login = new Login(action);
		action.gotoURL("http://172.21.73.80:8081/liberate-LONI01-S10/");
		login.login("libadmin", "Ic3cr34m!");
		
		//level 1 iterations
		for (int i =1; i < 100; i++)
		{
			level1 = By.xpath("//div[@class='headermenu_row']/descendant::span["+i+"]");
			if(!action.waitFor(level1, 4, true))
				break;
			action.clickOn(level1);
			System.out.println(action.getTextFromPage(level1));
			
			//level 2 iterations
			for (int j =1; j < 100; j++)
			{
				List<String> menu = new ArrayList<String>();
				level2 = By.xpath("(//div[@class='subheadermenu_row']/descendant::*[text()[contains(.,'')]])["+j+"]");
				if(!action.waitFor(level2, 4, true))
					break;
				action.clickOn(level2);
				System.out.println("\t"+action.getTextFromPage(level2));

				//left link iteration
				for (int k =1; k < 100; k++)
				{					
					leftLink = By.xpath("//td[@class='bodyleftcol']/descendant::a["+k+"]");
					if(!action.waitFor(leftLink, 2, true))
						break;
					
					menu.add(action.getTextFromPage(leftLink));
					System.out.println("\t\t"+action.getTextFromPage(leftLink));
					
					writeToFile(action.getTextFromPage(level2), action.getTextFromPage(level1)+"_",menu);
				}
			}
		}
	}

	private static void writeToFile(String className, String fileName, List<String> menu) {
		try {
			FileWriter writer = new FileWriter("D:\\data\\" + fileName + className + ".txt"); 
			
			writer.write("public static class " + className + "{ \n");
			
			for(String str: menu) {
			  writer.write("public static final By " + str.replace(" ", "") + " = getLeftLink(\"" +str+ "\"); \n");
			}
			
			writer.write("\n }");
			writer.close();

		} catch (IOException e) {

			e.printStackTrace();

		}
	}
}