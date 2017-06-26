package com.test1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Google {

	WebDriver driver;
	
	@BeforeMethod()
	public void open(){
		System.setProperty("webdriver.chrome.driver","C:\\selenium drivers\\chromedriver.exe");
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void test() throws Exception{
		
		driver.get("https://www.google.co.in/");
		Thread.sleep(5000);
		Assert.assertTrue(driver.getTitle().contains("Google"),"Google test pass");
		
	}
	

	@AfterMethod()
	public void close(){
  driver.close();
	}
}
