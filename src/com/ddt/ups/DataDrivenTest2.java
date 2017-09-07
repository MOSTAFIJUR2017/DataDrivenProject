package com.ddt.ups;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class DataDrivenTest2 {

@Test(dataProvider="testdata")
public void add(String val1,String val2,String val3){
	int a=Integer.parseInt(val1);
	int b=Integer.parseInt(val2);
	int c=Integer.parseInt(val3);
	
	int result =a+b+c;
	
}
	
@DataProvider(name="testdata")

public Object[][] readExel() throws BiffException, IOException {
	
	File f =new File("/Users/mostafijurrbhuiyan/Documents/SeleniumData2.xls");
	Workbook w =Workbook.getWorkbook(f);
	Sheet s=w.getSheet(0);
	int rows =s.getRows();
	int columns=s.getColumns();
	
String inputData[][] =new String[rows][columns];
	for(int i=1;i<rows; i++){
		for(int j=0; j<columns; j++){
			Cell c=s.getCell(j,i);
			inputData[i][j]=c.getContents();	
			System.out.println(inputData[i][j]);
		}
	}
	return inputData;
		
	
		

	}

}
