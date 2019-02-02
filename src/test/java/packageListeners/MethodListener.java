package packageListeners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import PageFiles.*;
import configuration.DriverFactory;
import m01_2019.Sprint1.Tests;

public class MethodListener implements IInvokedMethodListener{
	int i=0;
		
	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		System.out.println("IN before listner "+method.getTestMethod().toString());
		if(method.isTestMethod()) {
		if(method.getTestMethod().getXmlTest().getParameter("browser").equalsIgnoreCase("chrome"))
			DriverFactory.getinstance().setchromeDriver();
		else
			DriverFactory.getinstance().setieDriver();
		//Tests.driver=DriverFactory.getinstance().getDriver();
		setPageObjects();
		DriverFactory.getinstance().getDriver().get().manage().window().maximize();
		
		
		
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
		i++;
		File scrFile,destFile;
		String filename=method.toString().substring(0, 11);
		String path="./test-output/Screenshots/"+filename+i;
		System.out.println(path);
		
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
	
	
	public void setPageObjects() {
		Tests.pageobject.set(new Homepage(DriverFactory.getinstance().getDriver()));
		Tests.signinpage.set(new SignInPage(DriverFactory.getinstance().getDriver()));
		Tests.chegg.set(new Chegg(DriverFactory.getinstance().getDriver()));

	}
		
	}

//}
