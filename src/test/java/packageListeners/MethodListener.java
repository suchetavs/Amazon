package packageListeners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import com.beust.jcommander.converters.PathConverter;

import Factories.DriverFactory;
import PageFiles.PageObjects;
import m01_2019.Sprint1.Tests;

public class MethodListener implements IInvokedMethodListener{
	
		
	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		System.out.println("IN before listner");
		if(method.isTestMethod()) {
		if(method.getTestMethod().getXmlTest().getParameter("browser").equalsIgnoreCase("chrome"))
			DriverFactory.getinstance().setchromeDriver();
		else
			DriverFactory.getinstance().setieDriver();
		//Tests.driver=DriverFactory.getinstance().getDriver();
		Tests.pageobject.set(new PageObjects(DriverFactory.getinstance().getDriver()));
		
	}
	}

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) throws NullPointerException {
		//WebDriver driver=DriverFactory.getinstance().getDriver().get();
		if(method.isTestMethod())
		{
			if(testResult.isSuccess())
				{
				takeScreenshot(method);
	        
	        }
			DriverFactory.getinstance().getDriver().get().close();// TODO Auto-generated method stub
		}
	}
	
	public void takeScreenshot(IInvokedMethod method) {
		File scrFile,destFile;
		String filename=method.toString().substring(0, 11);
		String path="./test-output/Screenshots/"+filename;
		System.out.println(path);
		
		System.out.println("PArameter invocation count "+method.getTestMethod().getXmlTest().getParameter("username"));
		System.out.println("current invoc count "+method.getTestMethod().getCurrentInvocationCount());
		System.out.println("current instance "+method.getTestMethod().getInstance());
		
		scrFile = ((TakesScreenshot)DriverFactory.getinstance().getDriver().get()).getScreenshotAs(OutputType.FILE);
		new File(path).mkdir();
		destFile=new File(path+"/"+filename+".jpg");
		try {
			FileUtils.copyFile(scrFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
	}

//}
