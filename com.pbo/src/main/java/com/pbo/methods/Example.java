package com.pbo.methods;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.itextpdf.text.DocumentException;
import org.testng.annotations.Test;

import com.pbo.derived.AutoInput;

public class Example {
	
	public static String user="daniel";
	public static String pass="acs123";
	
	@Test
	public void Sample() throws IOException, DocumentException
	{
		AutoInput binput = new AutoInput();
		List<String> exist = new ArrayList<>();
		exist.add("ARBOBANDRY FARMING LIMITED");
		exist.add("SAPLICULTURE FARMING LIMITED");
		exist.add("SUMRADA AGRI PRODUCTS LIMITED");
		exist.add("REHAN TRADING INDIA LIMITED");
		exist.add("SAVARIA RETAIL LIMITED");
		exist.add("SAVARIA INDIA LIMITED");
		exist.add("J R TRADELINKS PRIVATE LIMITED");
		exist.add("HIMORGO PRIVATE LIMITED");
		
		while(true)
		{
			
			binput.generateclientname();
			String data = binput.clientname;
			if(!exist.contains(data))
			{
				System.out.println("pass " +data);
				break;
			}
			System.out.println("Fail "+data);
		
		}
		
	
		
	}

}
