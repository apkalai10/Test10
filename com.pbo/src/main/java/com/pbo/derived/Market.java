package com.pbo.derived;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.testng.annotations.Test;

public class Market {
	static int a = 3;
	static int b = 4;
	
	
	@Test
	public void publicfree()
	{

		System.out.println("Public Class");
	}
	
	@Test
	private void privatefree()
	{
		System.out.println("Private Class");
	}
	
	@Test
	protected void protectedfree()
	{
		System.out.println("Protected Class");
	}
}
