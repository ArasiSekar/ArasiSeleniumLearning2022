package week5.day1;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcelData {
	
	public String[][] dataProviderMethod() throws IOException
	{
		//Step1: Open the Workbook using file and path
		
		XSSFWorkbook wb = new XSSFWorkbook("data/SalesForceLoginData.xlsx");
		
		//Step2 :Go to the Specific sheet using sheetname or sheetIndex
		
		XSSFSheet sheet =wb.getSheetAt(0);
		
		//Step3: Go to Specific Row and get the Row count
		
		int rowCount = sheet.getLastRowNum();
		System.out.println("No of Rows: "+rowCount);
		
		//Step4 : Get the Column Count by using the Row and getLastCellNum
		short colCount = sheet.getRow(0).getLastCellNum();
		System.out.println("No of Cols :"+colCount);
		
		//Step5: Store the data in String Array
		String[][] data=new String[rowCount][colCount];
		
		//Step6: To get the data from all rows and cols
		for(int i=1; i<= rowCount;i++)
		{
			//Getting the Row Values
			XSSFRow row = sheet.getRow(i);
			for(int j=0; j<colCount;j++)
			{
				XSSFCell cell = row.getCell(j);
				System.out.println(cell.getStringCellValue());
				data[i-1][j]=cell.getStringCellValue();
			}
		}
		
	wb.close();
	return data;
	}
	

}
