package packageListeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;

import Factories.DataConfigurationClass;

public class Beforesuite extends DataConfigurationClass implements ISuiteListener  {

	final String SetDataSheet="UserLogin";
	final String FieldDataSheet="M01_S1";
	final String filepath="./src/test/resources/datasheets/m01_sprint1/m01_sprint1.xlsx";
	final int DatasetFieldCount=2;
	final int DatasetInstanceCount=2;
	@Override
	public void onStart(ISuite suite) {
			System.out.println("in beforesuite listener");
		setSetDataSheet(SetDataSheet);
		setFieldDataSheet(FieldDataSheet);
		setFilepath(filepath);
		setDatasetFieldCount(DatasetFieldCount);
		setDatasetInstanceCount(DatasetInstanceCount);
		
		
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		
	}

}
