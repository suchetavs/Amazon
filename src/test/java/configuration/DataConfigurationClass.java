package configuration;
import java.lang.reflect.Method;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import DataUtilities.DataUtility;


public class DataConfigurationClass extends DataUtility{
	
	protected static String SetDataSheet;
	protected static String FieldDataSheet;
	protected static String filepath;
	protected static int DatasetFieldCount;
	protected static int DatasetInstanceCount;
	
	public DataConfigurationClass() {
		super(SetDataSheet,FieldDataSheet,filepath,DatasetFieldCount,DatasetInstanceCount);
				
		}
	
	
	
	/**
	 * @param setDataSheet the setDataSheet to set
	 */
	public static void setSetDataSheet(String setDataSheet) {
		SetDataSheet = setDataSheet;
	}



	/**
	 * @param fieldDataSheet the fieldDataSheet to set
	 */
	public static void setFieldDataSheet(String fieldDataSheet) {
		FieldDataSheet = fieldDataSheet;
	}



	/**
	 * @param filepath the filepath to set
	 */
	public static void setFilepath(String filepath) {
		DataConfigurationClass.filepath = filepath;
	}



	/**
	 * @param datasetFieldCount the datasetFieldCount to set
	 */
	public static void setDatasetFieldCount(int datasetFieldCount) {
		DatasetFieldCount = datasetFieldCount;
	}



	/**
	 * @param datasetInstanceCount the datasetInstanceCount to set
	 */
	public static void setDatasetInstanceCount(int datasetInstanceCount) {
		DatasetInstanceCount = datasetInstanceCount;
	}



	@DataProvider(name="Dataset", parallel=true)
	public Object[][] Getdata(ITestContext context,Method method)
	{
		return readDataSet(context,method);
	}
	
	public Object GetFieldData(String field,Method m)
	{
		return readFieldData(field, m);
		
	}
	
	
	
}
