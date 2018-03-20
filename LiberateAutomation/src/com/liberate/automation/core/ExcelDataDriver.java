package com.liberate.automation.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataDriver {
	static File file;
	static FileInputStream inputStream;
	static FileOutputStream outputStream;
	static XSSFWorkbook workBook;
	static XSSFSheet sheet;

	static boolean initialized = false;

	static {
		try {
			file = new File("Resources//DataSheet.xlsx");
			inputStream = new FileInputStream(file);

			workBook = new XSSFWorkbook(inputStream);
		} catch (IOException e) {
			initialized = false;
			e.printStackTrace();
		}

		initialized = true;
	}

	private ExcelDataDriver() {
		// Disabling constructor
	}

	public static Map<String, String> loadData() {
		Map<String, String> dataMap = new HashedMap<>();
		
		String key, value;
		int count = 0;
		
		sheet = workBook.getSheet("DataSheet");
		
		while(true)
		{
			try {
			key = sheet.getRow(count).getCell(0).toString().trim();
			value = sheet.getRow(count).getCell(1).toString().trim();
			count++;
			if(key.equals("")||value.equals(""))
				break;
			else
				dataMap.put(key, value);
			}
			catch (Exception e) {
				e.printStackTrace();
				break;
			}

		}
		
		return dataMap;
	}
}
