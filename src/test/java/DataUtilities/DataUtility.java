package DataUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.ITestContext;


public class DataUtility {
	
	protected String SetDataSheetname;
	protected String FieldDataSheetname;
	protected  String filepath;
	protected int DataSetInstanceCount;
	protected int DataSetFieldCount;
	
	public DataUtility(String SetDataSheet,String FieldDataSheet,String filepath,int fieldCount,int instanceCount) {
		
		this.SetDataSheetname=SetDataSheet;
		this.FieldDataSheetname=FieldDataSheet;
		this.filepath = filepath;
		this.DataSetFieldCount=fieldCount;
		this.DataSetInstanceCount=instanceCount;
	}

		
	/*Function to Open the datasheet*/
	public XSSFSheet OpenDataSheet(String filepath,String sheetname) {
		File file=new File(System.getProperty("user.dir")+filepath);
		XSSFSheet sheet = null;
		try {
			FileInputStream inputstream=new FileInputStream(file);
			Workbook wbook=new XSSFWorkbook(inputstream);
			sheet=(XSSFSheet) wbook.getSheet(sheetname);
					
	}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sheet;
		}
	
	
	/*Function to read a set of data from datasheet and return to dataprovider*/
	/*parameters - instanceCount and fieldCount should be passed from xml as parameters*/
	
	
	public Object[][] readDataSet(ITestContext context,Method method){
		XSSFSheet DataSheet=OpenDataSheet(filepath,SetDataSheetname);
		int instanceCount=DataSetInstanceCount;
		int fieldCount=DataSetFieldCount;
		Object[][] Data=new Object[instanceCount][fieldCount];
		int rowCountDataSet=DataSheet.getLastRowNum()-DataSheet.getFirstRowNum();
		int CurrentTestRowCount = 0;
				
		
		/*Find the row containing the test case*/
		for(int rownum=0;rownum<rowCountDataSet;rownum++)
		{
			
			if((DataSheet.getRow(rownum).getCell(0).getStringCellValue().trim()).equalsIgnoreCase(method.getName().trim()))
				{
				CurrentTestRowCount=rownum+1;
				System.out.println(CurrentTestRowCount);
				break;
				}
				
		}
		
		/* Make object arrays containing each field data and making a 2D array from it*/
		
		for(int fieldsArray=CurrentTestRowCount,row=0;fieldsArray<CurrentTestRowCount+instanceCount;fieldsArray++,row++)
		{
			for(int testColumn=0,column=0;testColumn<fieldCount;testColumn++,column++)
			{
				System.out.println(fieldsArray+" "+testColumn);
				Data[row][column]=DataSheet.getRow(fieldsArray).getCell(testColumn).getStringCellValue();
				
			}
			
		}
		
		
		return Data;
	}
	

/*Function to read single field values from the input file*/
	
public Object readFieldData(String field,Method m){
		
	/*Declare function parameters*/
	XSSFSheet datasheet=OpenDataSheet(filepath,FieldDataSheetname);
		Object data = null;
		XSSFRow row = null;
		XSSFRow firstRow=datasheet.getRow(0);
		int rowcount=datasheet.getLastRowNum()-datasheet.getFirstRowNum();
		
		
		
		/*Find the row containing the test case*/
		for(int rowNum=0;rowNum<rowcount;rowNum++)
		{
			if(datasheet.getRow(rowNum).getCell(0).getStringCellValue().trim().equalsIgnoreCase((m.toString().trim())))
				{
				row=datasheet.getRow(rowNum);
				break;
				}
				
		}
		
		/* Find the value of the field specified for the current test case*/
		
			for(int j=0;j<row.getLastCellNum();j++) {
				if(firstRow.getCell(j).getStringCellValue().equalsIgnoreCase(field))
					data=row.getCell(j).getStringCellValue();
			
		
			}
			return data;
			
		}
}
			
		
			
				
			
			
		
		
		
						 
				 
				 
