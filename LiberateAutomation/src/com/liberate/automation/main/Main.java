package com.liberate.automation.main;

import com.liberate.automation.core.RandomData;

public class Main {

	public static void main(String[] args) {
		RandomData random = new RandomData();
		while(true)
		{
			System.out.println(random.nextString());
		}
	}
}