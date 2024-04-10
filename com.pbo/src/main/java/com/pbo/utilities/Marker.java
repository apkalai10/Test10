package com.pbo.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.pbo.webdriver.Webdriver;

public class Marker extends Webdriver {
	
	
public static JavascriptExecutor jsExecutor = (JavascriptExecutor) driver; 
	
	public static  void shadegreen(WebElement element)
	{
		
		jsExecutor.executeScript("arguments[0].style.background='green'", element); 
		//jsExecutor.executeScript("arguments[0].style.border='2px solid red'", search); 
		//jsExecutor.executeScript("arguments[0].setAttribute('style', 'border:2px solid red; background:yellow')", search);
	}
	public static  void shadeyellow(WebElement element)
	{
		
		jsExecutor.executeScript("arguments[0].style.background='yellow'", element); 
		//jsExecutor.executeScript("arguments[0].style.border='2px solid red'", search); 
		//jsExecutor.executeScript("arguments[0].setAttribute('style', 'border:2px solid red; background:yellow')", search);
	}
	public static  void unshadeyellow(WebElement element)
	{
		
		jsExecutor.executeScript("arguments[0].style.background=''", element); 
	}
	public static void shadeRed(WebElement element)
	{
	
		jsExecutor.executeScript("arguments[0].style.border='2px solid red'", element); 
	}
	public static void UnshadeRed(WebElement element)
	{
	
		jsExecutor.executeScript("arguments[0].style.border=''", element); 
	}
	public static void shadeYellowRed(WebElement element)
	{
		
		jsExecutor.executeScript("arguments[0].setAttribute('style', 'border:2px solid red; background:yellow')", element);
	}
	public static void UnshadeYellowRed(WebElement element)
	{
		
		jsExecutor.executeScript("arguments[0].setAttribute('style', '')", element);
	}

}
