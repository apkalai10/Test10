package com.pbo.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class Readexcel {
	
	@Test
	public void readExcel() throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream("C:\\Users\\aravinthprasath.e\\Downloads\\FinalRating.xlsx");
		Workbook book = WorkbookFactory.create(file);
		Sheet sheet0 = book.getSheetAt(0);
		Iterator<Row> rowcount = sheet0.iterator();
		System.out.println(rowcount);
		int i=0;
		while(rowcount.hasNext())
		{
			Row row = rowcount.next();
			Iterator<Cell> cellcount = row.iterator();
			while(cellcount.hasNext())
			{
		
				System.out.println(cellcount.next().toString());
				
				i++;
				
			}
			
			
		
		}
		book.close();
		file.close();
		
	}

}
