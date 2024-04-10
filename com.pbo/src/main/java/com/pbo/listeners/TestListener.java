package com.pbo.listeners;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.pbo.utilities.ScreenShots;

public class TestListener extends ScreenShots implements ITestListener {
	
	
	@Override
	public void onTestStart(ITestResult result)
	{
		
	}
	
	@Override
	public void onTestSuccess(ITestResult result)
	{
	
	}
	
	@Override
	public void onTestFailure(ITestResult result)
	{
		
	
			try {
				fail(result.getMethod().getMethodName());
			} catch (AWTException | IOException e) {
			     System.out.println("SC not captured "+result.getName());
				//e.printStackTrace();
			}
		         System.out.println("SC captured for "+result.getName());
	}
	
	
	
	@Override
	public void onTestSkipped(ITestResult result)
	{
		System.out.println("onTestSkipped Method is " +result.getName());
	}
	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
	
	}
	
	@Override
	public void onStart(ITestContext context)
	{
		
		Starttime();
	}
	
	@Override
	public void onFinish(ITestContext context)
	{
		endtime();
	}

}
