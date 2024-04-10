package com.pbo.derived;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class AutoInput {
	
	public String pan;
	public String gstin;
	public String tan;
	public List<String> mobile;
	public List<String> telephone;
	public String fax;
	public String email;
	public String pincode;
	public String address;
	public String name;
	public String clientname;
	
    public void generatepanno()
    {
    	  pan = RandomStringUtils.randomAlphabetic(5).toUpperCase().concat(RandomStringUtils.randomNumeric(4).concat(RandomStringUtils.randomAlphabetic(1).toUpperCase()));
    }
	
	
	public void generategstin(String pann)
	{
		  gstin = RandomStringUtils.randomNumeric(2).concat(pann).concat(RandomStringUtils.randomNumeric(1)).concat("Z").concat(RandomStringUtils.randomNumeric(1));
	}
		 
	public void generatetanno()
	{
		  tan = RandomStringUtils.randomAlphabetic(4).toUpperCase().concat(RandomStringUtils.randomNumeric(5).concat(RandomStringUtils.randomAlphabetic(1).toUpperCase()));
	}
	
	public void generatemobileno()
	{
		String code = "+919";
		mobile = new ArrayList<String>();
		
		  for(int i=0;i<=1;i++)
		  {
			  mobile.add(code.concat(RandomStringUtils.randomNumeric(9)));
		  }	
		
	}
	
	public void generateofcno()
	{
		  Random rand = new Random();
		  String prefix = "0";
		  String[] stdcode = {"11","22","33","44","20","40","79","80","120","124","129","135","141","160","161","172","175","181","183",
				"233","240","241","250","251","253","257","261","265","343","422","522","532","542","551","612","712","721","724","836","870","891","452","761","641"};
		  List<String> list = new ArrayList<String>(Arrays.asList(stdcode));
		  telephone = new ArrayList<String>();
	
		  
		  for(int i=0;i<=3;i++)
		  {
			telephone.add(prefix.concat(list.get(rand.nextInt(list.size()))).concat(RandomStringUtils.randomNumeric(8)));
		  }	 
		 
	}
		 
   		
		public void generatefaxno()
		{
			 Random rand = new Random();
			  String prefix = "+91";
			  String[] dialingcode = {"562","326","121","79","5272","712","532","40","253","183","731","612","341","761","20","80","141","281","757",
					"657","261","22","512","265","33","3453","542","422","522","866","2698","161","891","11","452","7152"};
			  List<String> list = new ArrayList<String>(Arrays.asList(dialingcode));
			  
			  fax = prefix.concat(list.get(rand.nextInt(list.size()))).concat(RandomStringUtils.randomNumeric(8));
		}
		 
		public void generateemail(String name)
		{
			 Random rand = new Random();
			 String clientname = name;
			 String[] split = clientname.split(" ", 2);
			 String prefix = split[0].toLowerCase();
			 String[] emaildomain = {"gmail.com","yahoo.com","hotmail.com","outlook.com","gov.in","acs.org","acs.net"};
			 List<String> list = new ArrayList<String>(Arrays.asList(emaildomain));
			 email =  prefix.concat("@").concat(list.get(rand.nextInt(list.size())));
			 
		}
		
		public void generateaddress()
		{
			Random rand = new Random();
			String[] first = {"Complex No, ","Flat No, ","Door No, ","Street No, ","Avenue No ","Colony No, "};
			List<String> prefix = new ArrayList<String>(Arrays.asList(first));
			String backs = "/";
			String comma = ",";
			 address = prefix.get(rand.nextInt(prefix.size())) + rand.nextInt(100, 999) + backs + rand.nextInt(10, 99) + comma ;
		}
		
		
	
		  
		
		public void generatename() throws IOException
		{
			Random rand = new Random();
			FileInputStream file = new FileInputStream("D:\\TestAutomation\\com.pbo\\testfiles\\OriginatorData.xlsx");
			try (XSSFWorkbook book = new XSSFWorkbook(file)) {
				XSSFSheet sheet = book.getSheetAt(0);
				int  a  = rand.nextInt(sheet.getLastRowNum());
				XSSFRow row = sheet.getRow(a);
				name = row.getCell(0).toString();
			}
			
		}
		
		public void generateclientname() throws IOException
		{
			Random rand = new Random();
			FileInputStream file = new FileInputStream("D:\\TestAutomation\\com.pbo\\testfiles\\example.xlsx");
			try (XSSFWorkbook book = new XSSFWorkbook(file)) {
				XSSFSheet sheet = book.getSheetAt(1);
				int  a  = rand.nextInt(sheet.getLastRowNum()-1);
				//System.out.println("Inte "+a);
				XSSFRow row = sheet.getRow(a);
				clientname = row.getCell(0).toString();
			}
			
		}

		public void generatepincode() throws IOException
		{
			//Random rand = new Random();
			//pincode =  String.valueOf(rand.nextInt(11, 85))  + rand.nextInt(0, 9) + rand.nextInt(100, 999);
			
			
			Random rand = new Random();
			FileInputStream file = new FileInputStream("D:\\TestAutomation\\com.pbo\\testfiles\\OriginatorData.xlsx");
			try (XSSFWorkbook book = new XSSFWorkbook(file)) {
				XSSFSheet sheet = book.getSheetAt(2);
				int  a  = rand.nextInt(sheet.getLastRowNum());
				XSSFRow row = sheet.getRow(a);
				pincode = row.getCell(0).toString();
			}	
			
		}
}
