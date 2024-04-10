package com.pbo.utilities;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Excelreport {
	
	
	
	@Test
	public void createexcel() throws IOException
	{
		Workbook book = new XSSFWorkbook();
		Sheet sheet = book.createSheet("Report");
		Font font = book.createFont();
		font.setFontName("Calibri");
		font.setFontHeightInPoints((short)12);
		font.setBold(true);
		HorizontalAlignment align = HorizontalAlignment.CENTER;
		
		CellStyle style = book.createCellStyle();
		style.setAlignment(align);
		style.setFont(font);
		
		Row row0 = sheet.createRow(0);
	
		Cell c00 = row0.createCell(0);
		c00.setCellValue("S.No");
		c00.setCellStyle(style);
		
		
		Cell c01 = row0.createCell(1);
		c01.setCellValue("PathName");
		c01.setCellStyle(style);
		
		Cell c02 = row0.createCell(2);
		c02.setCellValue("Expected Output");
		c02.setCellStyle(style);
		
		Cell c03 = row0.createCell(3);
		c03.setCellValue("Actual Output");
		c03.setCellStyle(style);
		
		
		Cell c04 = row0.createCell(4);
		c04.setCellValue("Test Status");
		c04.setCellStyle(style);
		
		Cell c05 = row0.createCell(5);
		c05.setCellValue("Priority");
		c05.setCellStyle(style);
		
		Cell c06 = row0.createCell(6);
		c06.setCellValue("Attachments");
		c06.setCellStyle(style);
		
		Row row1 = sheet.createRow(1);
		Cell c10 = row1.createCell(0);
		c10.setCellValue("1");
		
		Cell c11 = row1.createCell(1);
		c11.setCellValue("PBOpoolconfig");
		
		Cell c12 = row1.createCell(2);
		c12.setCellValue("System should allow to seed given  pan number");
		
		Cell c13 = row1.createCell(3);
		c13.setCellValue("System did not allow to seed a pan number");
		
		Cell c14 = row1.createCell(4);
		c14.setCellValue("PASS");
		
		Cell c15 = row1.createCell(5);
		c15.setCellValue("High");
		
		Cell c16 = row1.createCell(6);
		c16.setCellValue("NA");
		
		

	
        for(int i=0;i<row0.getLastCellNum();i++)
        {
		sheet.autoSizeColumn(i);
		System.out.println(sheet.getRow(0).getCell(i).toString());
	
		
        }
		
		FileOutputStream fos = new FileOutputStream("ReportExe.xlsx");
		book.write(fos);
		book.close();
	}

}
