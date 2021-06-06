package com.FlipKart.TestCases;

import org.testng.annotations.Test;

import com.FlipKart.TestBase.TestBase;

public class BaseTest extends TestBase{

	
	public BaseTest() {
		
		super();
	}
	
	@Test
	public  void Test() {
		
		initilizations();
		driver.get(Config.getProperty("URL"));
	}
	
	
	
	
}
