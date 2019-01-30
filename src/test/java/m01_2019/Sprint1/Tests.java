package m01_2019.Sprint1;


import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Factories.DataConfigurationClass;
import Factories.DriverFactory;
import PageFiles.PageObjects;

@Listeners({packageListeners.Beforesuite.class,packageListeners.MethodListener.class,packageListeners.ExtendReportListener.class})
public class Tests extends DataConfigurationClass{
	
//	private static DataConfigurationClass config;
	public static ThreadLocal<PageObjects> pageobject=new ThreadLocal<>();

	
			
	/*Configure DataSheet Access*/
	@BeforeSuite
	public void Setup(ITestContext context) {
		System.out.println("in beforesuite");
	//	config=new DataConfigurationClass();
		
							
	}
	
	
	
	@Test(dataProvider="Dataset",dataProviderClass=Factories.DataConfigurationClass.class)
	public void TC01_Login(String username,String password) {
		//System.out.println("In test");
		//System.out.println("");
		System.out.println(username);
		System.out.println(password);
		DriverFactory.getinstance().getDriver().get().get("https://www.google.com");
		System.out.println("In TC01 method from factory "+Thread.currentThread()+DriverFactory.getinstance().getDriver().get());
		//System.out.println("In TC01 method from driver "+Thread.currentThread()+driver.get());
		
		System.out.println("\n");
	}
		
	
	@Test
	public void TC02_Login2() {
		DriverFactory.getinstance().getDriver().get().get("https://www.amazon.com");
		pageobject.get().login();
		
		System.out.println("In TC02 method from factory"+Thread.currentThread()+DriverFactory.getinstance().getDriver().get());
		//System.out.println("In TC02 method from driver"+Thread.currentThread()+driver.get());
		System.out.println("\n");
	
	
	}
	
		
	@AfterTest
	public void teardown() {
	
		DriverFactory.getinstance().removeDriver();
		pageobject=null;
	}
	
	
}
