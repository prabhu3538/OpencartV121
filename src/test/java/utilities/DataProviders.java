package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	//DataProvider 1
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		String path = ".\\testdata\\Opencart_LoginData.xlsx";        //taking excel file from testdata
		
		ExcelUtility xlutil=new ExcelUtility(path);                  //creating an object for XLUtility
		
		int totalrows = xlutil.getRowCount("Sheet1");
		int totalcols = xlutil.getCellCount("Sheet1",1);
		
		String logindata[][]=new String[totalrows][totalcols];       //created for 2D array which can store the value
		
		for(int i=1;i<totalrows;i++) {							     //read data from xl and storing in 2D array
			for(int j=0;j<totalcols;j++) {						     //i is rows and j iscols
				logindata[i-1][j]=xlutil.getCellData("Sheet1", i, j);  //1,0
			}
		}
		return logindata;  											 //returning 2D array
	}
	
	//DataProvider 2
	
	//DataProvider 2
	
	//DataProvider 2
	
}
