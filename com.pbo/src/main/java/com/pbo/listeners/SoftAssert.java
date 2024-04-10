package com.pbo.listeners;


import java.awt.AWTException;
import java.io.IOException;

import org.testng.asserts.IAssert;
import com.pbo.utilities.ScreenShots;

public class SoftAssert extends org.testng.asserts.SoftAssert {
	
	@Override
	 public void onAssertFailure(IAssert<?> var1, AssertionError var2)
	 {
			
				  try {
					new ScreenShots().snap(var1.getMessage());
				} catch (AWTException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			
					
				}
				  
			  
				  
				
	 }

}
