package example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Drivers {

	public static WebDriver driver;
	
	public static WebDriver choosebrowser(String name)
	{
		if(name.equalsIgnoreCase("Chrome"))
		{
			driver = new ChromeDriver();
		}
		else if (name.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
			
		}
		return driver;
	}

}
