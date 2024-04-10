package example;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class Pagefactory {
	
	@CacheLookup
	@FindBy(xpath = "//textarea[@name='q']")  //It is used to locate web elements using different locators strategies,  it helps in quickly locating the web elements using one search criteria.
	public static WebElement name;
	
	
	
	@FindBys(
			
	            {
	               @FindBy(name  = "//textarea[@name='q']"),
                   @FindBy(id  = "//textarea[@id='APjFqb']")
	            }
			
	)
	public static WebElement name2;
	
	
	
	@FindAll(
			
			   {
				 @FindBy(name  = "//textarea[@name='q']"),
				 @FindBy(id  = "//textarea[@id='APjFqb']"),
				 @FindBy(className = "//textarea[@classname='fake']")
			   }
			   
	)
	public static WebElement name3;

}
