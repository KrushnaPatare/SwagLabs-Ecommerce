package com.swagLabs.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="loginData")
	public static String[][] getloginData() throws IOException
	{
		String path = AutoConstant.newloginTestDataPath;
		XLUtility xlutil = new XLUtility(path);
		
		int rownum = xlutil.getRowCount("credentials"); //6
		int colcount = xlutil.getCellCount("credentials", 0); //3
		
		String loginData [][] = new String[rownum][colcount];
		for(int i=1; i<=rownum; i++) 
		{
			for(int j=0; j<colcount; j++) 
			{
				loginData[i-1][j]= xlutil.getCellData("credentials", i, j);
			}
		}
			
		return loginData;
	}
	

	

}
