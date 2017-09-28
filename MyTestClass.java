package com.mytestpackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class MyTestClass {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		String url ="https://www.ups.com/one-to-one/register?sysid=myups&mcp=true&loc=en_US";
		driver.get(url);
		//when application run slower than selenium
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.MILLISECONDS);
		//Verifying the right object(page,bttn,...)
		String title= driver.getTitle();
		//check that the title name
		System.out.println(title);
		Assert.assertEquals(title,"Delivery Service from UPS ");
		
		WebElement loginLink = driver.findElement(By.xpath("//*[@id='main']/form/fieldset/div/div[2]/div[1]/fieldset/div[2]/div[1]/dl[1]/dd/input"));
		loginLink.click();
		
				
			

	}

}
