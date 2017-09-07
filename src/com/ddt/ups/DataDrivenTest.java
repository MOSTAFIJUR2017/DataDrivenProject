package com.ddt.ups;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTest {
	WebDriver driver;

	
@Test(dataProvider="testdata")
public void login(String username, String password){
	String url ="https://www.ups.com/content/ca/en/index.jsx?flash=false";

	WebDriver driver = new FirefoxDriver();
	 driver.get(url);
     driver.findElement(By.xpath(".//*[@id='usb_login_link']")).click();
     driver.findElement(By.id("repl_id1")).sendKeys(username);
     driver.findElement(By.id("repl_id4")).sendKeys(password);
     driver.findElement(By.className("btnArw")).click();
}
	
	
@DataProvider(name="testdata")	
	public Object[][]readExcel()  throws BiffException, IOException{
		
		File f= new File("/Users/mostafijurrbhuiyan/Documents/Workbook1.xls");
		//f.exists();
		//System.out.println(f.exists());
		Workbook w =Workbook.getWorkbook(f);
		Sheet s =w.getSheet("Sheet2");
		int rows =s.getRows();
		int columns=s.getColumns();
		  //System.out.println(rows);
		  //System.out.println(columns);
		
  String inputData [][] =new  String[rows][columns];
  
  for(int i=0; i<rows; i++){
	  for(int j=0; j<columns; j++){
		  Cell c=s.getCell(j,i);
		  inputData[i][j]=c.getContents();
		  System.out.println(inputData[i][j]);
		  
		  
	  }
	  
  }
return inputData;
	  
}



}
