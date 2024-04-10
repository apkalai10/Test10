package com.pbo.utilities;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Calendar;

import javax.imageio.ImageIO;

import com.pbo.webdriver.Webdriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class ScreenShots extends Webdriver{
	
	
	public File file;
	
	public  static long start_time;
	public  long end_time;
	
	 public void fail(String methodname) throws AWTException, IOException
	 {  
		 
		    Calendar cal = Calendar.getInstance();
			Date time = cal.getTime();
			String timestamp = time.toString().replace(":", "").replace(" ", "");
		    Robot robot = new Robot();
			Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
			Rectangle rect = new Rectangle(screen);
			BufferedImage source = robot.createScreenCapture(rect);
			File file = new File("D:\\TestAutomation\\com.pbo\\screenshots\\"+methodname+"_"+timestamp+".jpg");
			ImageIO.write(source, "jpg", file);
	 }
	 
	 public void fullsc(String methodname1) throws IOException
	 {
		    Calendar cal = Calendar.getInstance();
		    Date time = cal.getTime(); 
			String timestamp = time.toString().replace(":", "").replace(" ", "");
			Screenshot full = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver);
		    ImageIO.write(full.getImage(), "png", new File("D:\\TestAutomation\\com.pbo\\screenshots\\"+methodname1+"_"+timestamp+".png"));
		    
	 }
	 
	 public void snap(String methodname) throws AWTException, IOException
	 {
		    Calendar cal = Calendar.getInstance();
			Date time = cal.getTime(); 
			String timestamp = time.toString().replace(":", "").replace(" ", "");
		    Robot robot = new Robot();
			Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
			Rectangle rect = new Rectangle(screen);
			BufferedImage source = robot.createScreenCapture(rect);
			file = new File("D:\\TestAutomation\\com.pbo\\assertionsnaps\\"+methodname+"_"+timestamp+".jpg");
			ImageIO.write(source, "jpg", file);		
	 }
	 
	 public void Starttime()
	 {
		 start_time = System.currentTimeMillis();
		
	 }
	 public void endtime()
	 {
		 end_time = System.currentTimeMillis();
		 long total = end_time - start_time;
		 
		  long minutes = (total / 1000) / 60;
		  long seconds = (total / 1000) % 60;
		  
		 System.out.println(" Executed Time is = "
                 + minutes + " minutes & "
                 + seconds + " seconds.");
	 }

}
