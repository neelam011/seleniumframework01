package dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelReader {
static XSSFWorkbook wb;
	
	
	@DataProvider(name="newdata")
	public static Object[][] test() throws IOException
	{
		Object[][] arr=ExcelReader.excelDataRead("Sheet1");
		return arr;
	}
	
	@DataProvider(name="excelDataReaddata")
	@Test
	public static Object[][] excelDataRead(String sheetname) throws IOException
	{
	File file=new File("/Users/rahulkadam/eclipse-workspace/Framework1/excelfile/neelam.xlsx");
	FileInputStream fis=new FileInputStream(file);
	wb=new XSSFWorkbook(fis);

	int rows=wb.getSheet(sheetname).getPhysicalNumberOfRows();
	int column=wb.getSheet(sheetname).getRow(0).getPhysicalNumberOfCells();
	System.out.println(rows+"    "+column);
	
	Object[][] arr=new Object[rows-1][column];
	
	for(int i=1;i<rows;i++)
	{
		for(int j=0;j<column;j++)
		{
			//String s=wb.getSheet("Sheet1").getRow(i).getCell(j).getStringCellValue();
			//System.out.print(s+"   ");
			arr[i-1][j]=ExcelReader.getData(sheetname, i, j);
		}		
	}
	return arr;
	}
	

	public static String getData(String sheetname,int row,int col)
	{
		
		String data="";
		
		CellType s1=wb.getSheet(sheetname).getRow(row).getCell(col).getCellType();
		if(s1==CellType.STRING)
		{
			data=wb.getSheet(sheetname).getRow(row).getCell(col).getStringCellValue();
		}
		else if(s1==CellType.NUMERIC)
		{
			int value=(int) wb.getSheet(sheetname).getRow(row).getCell(col).getNumericCellValue();
		data=String.valueOf(value);
		}
		else if(s1==CellType.BOOLEAN)
		{
			boolean value=wb.getSheet(sheetname).getRow(row).getCell(col).getBooleanCellValue();
			data=String.valueOf(value);
		}
		else if(s1==CellType.BLANK)
		{
			data="";
		}
		return data;
	}
}
