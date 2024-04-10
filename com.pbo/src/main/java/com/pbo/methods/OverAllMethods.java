package com.pbo.methods;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.WebElement;
import com.pbo.derived.AutoInput;
import com.pbo.listeners.HardAssert;
import com.pbo.listeners.SoftAssert;
import com.pbo.utilities.Marker;
import com.pbo.webdriver.Webdriver;

public class OverAllMethods extends Webdriver{
	
	
	AutoInput ainput = new AutoInput();
	public static SoftAssert softassert = new SoftAssert();
	public static HardAssert hardassert = new HardAssert();
	
	
	
	
	
	
	//*********************************************************ORIGINATOR_SEED***************************************************************//
	
	public void Originator_Seed(List<String> existentry, WebElement textbox) throws IOException
	{
		
		while(true)
		{
			ainput.generateclientname();
			String newentry = ainput.clientname;
			if(!existentry.contains(newentry))
			{
				textbox.sendKeys(newentry);
				break;
			}
		}
	}
	
	//*********************************************************TEXTBOXVALUE_SEED***************************************************************//
	
	public void textboxwrite(WebElement textlabel, WebElement textbox, String textvalue, WebElement gettextvalue) throws InterruptedException
	{
		if(textbox.isEnabled())
		{
			if(textbox.isSelected())
			{
				System.out.println(textlabel.getText()+"_TextValue_AlreadyBound"+gettextvalue.getAttribute("value"));
				Marker.shadeyellow(gettextvalue);
				softassert.assertEquals(textbox.isSelected(), false, "TextValue_AlreadyBound");
				Thread.sleep(2000);
				Marker.unshadeyellow(gettextvalue);
			}else
			{
				textbox.sendKeys(textvalue);
			}
		}else {
			Marker.shadeyellow(textlabel);
			softassert.assertEquals(textbox.isEnabled(), true, textlabel.getText()+"_TextBoxDisabled");
			Thread.sleep(2000);
			Marker.unshadeyellow(textlabel);
		}	
		
	}
	
	
	//*********************************************************DROPVALUE_SELECT&FIND_SORT***************************************************************//
	
	public void selectvalue(WebElement dropbox, List<WebElement> droplistvale ,WebElement droplabel, WebElement dropgetvalue) throws InterruptedException
	{
		List<String> unsorted = new ArrayList<String>();
		List<String> sorted = new ArrayList<String>();
		if(dropbox.isEnabled()) 
		{
			if(dropbox.isSelected()&dropbox.isDisplayed())
			{
				System.out.println(droplabel.getText()+"_DropdownValue_AlreadyBound"+dropgetvalue.getText());
				Marker.shadeyellow(dropgetvalue);
				softassert.assertEquals(dropbox.isSelected()&dropbox.isDisplayed(), false, "DropdownValue_AlreadyBound");
				Thread.sleep(2000);
				Marker.unshadeyellow(dropgetvalue);
			}
			else
			{
	
				dropbox.sendKeys(" ");
				Thread.sleep(4000);
				System.out.println(droplabel.getText()+"_Dropdown_Size_"+droplistvale.size());
				System.out.println("---------------------------------");
			    for (WebElement value : droplistvale) {
		             System.out.println(value.getText());
		             unsorted.add(value.getText());
		             sorted.add(value.getText());
			    }
			    System.out.println("---------------------------------");
				Collections.sort(sorted); //drop down sorted
				Thread.sleep(2000);
			
				if(unsorted.equals(sorted)) {
					System.out.println(droplabel.getText()+"Dropdown_Sorted");
				}else {
					
					Marker.shadeyellow(droplabel);
				
					softassert.assertEquals(unsorted.equals(sorted),true, droplabel.getText().replace("*", "_")+"Dropdown_UnSorted");
					Thread.sleep(2000);
					Marker.unshadeyellow(droplabel);
				}
				 
				droplistvale.get(0).click();
				
			}
				
		}else
		{
			Marker.shadeyellow(droplabel);
			softassert.assertEquals(dropbox.isEnabled(), true, droplabel.getText()+"_DropdownDisabled");
			Thread.sleep(2000);
			Marker.unshadeyellow(droplabel);
		}
	
	
	
	
	
	
	
	}
	
	
	

}
