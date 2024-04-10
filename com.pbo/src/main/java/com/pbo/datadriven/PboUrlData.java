package com.pbo.datadriven;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PboUrlData {
	
	public  List<String> A;
	public  List<String> B;

	public void readurlexcel() throws IOException
	{
	
		 A = new ArrayList<String>();
		 B = new ArrayList<String>();
			FileInputStream excel = new FileInputStream("D:\\TestAutomation\\com.pbo\\testfiles\\UrlData.xlsx");
			try (XSSFWorkbook workbook = new XSSFWorkbook(excel)) {
				XSSFSheet sheet = workbook.getSheetAt(0);
				Iterator<Row> rowscount = sheet.iterator();
				
				while(rowscount.hasNext())
				{
					Row rowvalue = rowscount.next();
					Iterator<Cell> columnvalue = rowvalue.iterator();
					int i =2;
					while(columnvalue.hasNext())
					{
						if(i%2==0) {
							A.add(columnvalue.next().toString());
						}else {
							B.add(columnvalue.next().toString());
						}
						i++;
					}
				}
				
			}		
		
	}	

}
