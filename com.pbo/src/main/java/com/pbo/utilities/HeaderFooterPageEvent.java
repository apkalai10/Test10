package com.pbo.utilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.SystemUtils;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

public class HeaderFooterPageEvent extends PdfPageEventHelper {
	public void startpage(PdfWriter writer, Document document) throws MalformedURLException, IOException, DocumentException
	{
		
		
		String file = "D:\\TestAutomation\\com.pbo\\testfiles\\logo-abhayaa.png";
		Image img = Image.getInstance(file);
		img.scaleToFit(100, 100);
		img.setAbsolutePosition(480, 800);
		document.add(img); // acs logo
		
		String idfc = "D:\\TestAutomation\\com.pbo\\testfiles\\idfc.png";
		Image imgd = Image.getInstance(idfc);
		imgd.scaleToFit(70, 70);
		imgd.setAbsolutePosition(30, 800);
		document.add(imgd); // acs logo
		
		
		
	   // Font fontc = new Font(FontFamily.TIMES_ROMAN, 14, Font.BOLD, BaseColor.BLACK);
	   // Paragraph heading1 = new Paragraph("PBO", fontc);
       // ColumnText.showTextAligned(writer.getDirectContent(),Element.ALIGN_CENTER, new Paragraph(heading1), 30, 800, 0); // client name
        
        Font fonth = new Font(FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLACK);
        Paragraph heading = new Paragraph("Test Report", fonth);
        heading.setAlignment(Element.ALIGN_CENTER);
        document.add(heading);   //Title
        
        document.add(Chunk.NEWLINE);//space
        
        Font fontt = new Font(FontFamily.TIMES_ROMAN, 9);
        Paragraph heading2 = new Paragraph("This document is generated by "+SystemUtils.getHostName(), fontt);
        document.add(heading2); // document description
	}
	
	public void endpage(PdfWriter writer, Document document)
	{
		Font fontt = new Font(FontFamily.TIMES_ROMAN, 9, Font.BOLD);
		Calendar cal = Calendar.getInstance();
		Date time = cal.getTime();
		String timestamp = time.toString();
		Paragraph times = new Paragraph(timestamp, fontt);   
        ColumnText.showTextAligned(writer.getDirectContent(),Element.ALIGN_CENTER, new Paragraph(times), 110, 30, 0); //timestamp
        
     
        ColumnText.showTextAligned(writer.getDirectContent(),Element.ALIGN_CENTER, new Phrase(String.format(writer.getPageNumber()+ " | Page"), new Font(FontFamily.TIMES_ROMAN, 9, Font.BOLD)), 550, 30, 0); //pagenumber
	}


}
