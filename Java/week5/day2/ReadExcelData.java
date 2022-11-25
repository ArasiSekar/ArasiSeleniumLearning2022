package week5.day2;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcelData {
	@Test
	public void readData() throws IOException
	{
		//Open the workbook using Filename and Path
		XSSFWorkbook wb = new XSSFWorkbook("data/CreateLead.xlsx");
		
		//Go to the Specific Sheet
		XSSFSheet sheet = wb.getSheetAt(0);
		
		//Go to the Specific Row and Row count
		int rowCount = sheet.getLastRowNum();
		System.out.println("The number of Rows :"+rowCount);
		
		//Get the Col Count
		short colCount = sheet.getRow(0).getLastCellNum();
		System.out.println("The number of Cols: "+colCount);
		
		//To get the Row1 and Col1 data
		XSSFCell cellFirstValue = sheet.getRow(1).getCell(1);
		System.out.println("The First row and col value :"+cellFirstValue);
		System.out.println("---------------------");
		
		//To get the Row2 and Col1 data
				XSSFCell cellSecValue = sheet.getRow(2).getCell(1);
				System.out.println("The First row and col value :"+cellSecValue);
				System.out.println("----------------------------");
				
				//To get the row1 and all col values
				System.out.println("First Row and all Col Values");
				XSSFRow rowFirst = sheet.getRow(1);
				for(int k=0;k<colCount;k++)
				{
					XSSFCell cellAllData = rowFirst.getCell(k);
					System.out.println(cellAllData);
				}
				System.out.println("------------------------------");
				System.out.println("All Values from Xcel");
	   //To get all Values from all row and col
				for(int i=1;i<=rowCount;i++)
				{
					//Getting all the Row count data
					XSSFRow rowData= sheet.getRow(i);
					for(int j=0;j<colCount;j++)
					{
						XSSFCell cellData= rowData.getCell(j);
						System.out.println(cellData);
					}
				}
				//closing workbook
				wb.close();
	}

}
