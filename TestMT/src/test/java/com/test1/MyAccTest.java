package com.test1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class MyAccTest {
	
	WebDriver driver;
	
	@BeforeMethod()
	public void open(){
		System.setProperty("webdriver.chrome.driver","C:\\selenium drivers\\chromedriver.exe");
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void test() throws Exception{
		
		driver.get("https://wordpress.com/wp-login.php");
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='user_login']")).sendKeys("mahendrakblog");
		driver.findElement(By.xpath(".//*[@id='user_pass']")).sendKeys("wordpress");
		driver.findElement(By.xpath(".//*[@id='wp-submit']")).click();
		Thread.sleep(5000);
		Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='header']/a[1]/span")).getText().contains("Site"),"WordPress test pass");
		
	}
	

	@AfterMethod()
	public void close(){
  driver.close();
	}

}
