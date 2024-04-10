package com.pbo.webdriver;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.pbo.datadriven.PboUrlData;

public class Webdriver {
	
	public static WebDriver driver;
	public static WebDriver StartBrowser(String browsername) throws IOException
    {
 	  
		PboUrlData pud = new PboUrlData();
		pud.readurlexcel();
		

               if(browsername.equalsIgnoreCase("Firefox"))
               {       
                             
                   driver = new FirefoxDriver();
                   driver.manage().window().maximize();
                   driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));
                   driver.get(pud.B.get(0));
                   driver.manage().window().fullscreen();
                }


                else if(browsername.equalsIgnoreCase("Chrome"))
                {
         	   
         	       ChromeOptions opt = new ChromeOptions();
        		   opt.addArguments("use-fake-ui-for-media-stream");
        		   Map<String, Object> prefs = new HashMap<String, Object>();
        		   prefs.put("download.default_directory", "D:\\TestAutomation\\com.pbo\\downloads\\");  //download file path
        		   opt.setExperimentalOption("prefs", prefs);
        		   opt.addArguments("use-fake-ui-for-media-stream");
        		   
   
                   driver = new ChromeDriver(opt);
                   driver.manage().window().maximize();
                   driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));
                   driver.get(pud.B.get(0));  // url type 
                   driver.manage().window().fullscreen();
            
                }
          
               else if(browsername.equalsIgnoreCase("IE"))
               {
                   driver = new InternetExplorerDriver();
                   driver.manage().window().maximize();
                   driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(120));
                   driver.get(pud.B.get(0));
                   driver.manage().window().fullscreen();
               }

                  
                return driver;
               }


}
