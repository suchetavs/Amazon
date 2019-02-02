package m01_2019.Sprint1;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import PageFiles.*;
import configuration.DataConfigurationClass;
import configuration.DriverFactory;

@Listeners({packageListeners.Beforesuite.class,packageListeners.MethodListener.class,packageListeners.ExtendReportListener.class})
public class Tests extends DataConfigurationClass{
	
//	private static DataConfigurationClass config;
	
	Logger log=Logger.getLogger(Tests.class);

	
	
	
	@Test(dataProvider="Dataset",dataProviderClass=configuration.DataConfigurationClass.class)
	public void TC01_Login(String username,String password) {
		pageobject.get().login();
		WebElement[] elements=signinpage.get().login();
		elements[0].sendKeys(username);
		elements[1].sendKeys(password);
		elements[2].click();
		pageobject.get().scrolldown();
	}
		
	
	@Test
	public void recaptcha() {
		System.out.println("Entered recpata");
		DriverFactory.getinstance().getDriver().get().get("https://www.chegg.com");
		
		chegg.get().forgotpassword();
	}
	
	
	
	
		
	@AfterTest
	public void teardown() {
	
		DriverFactory.getinstance().removeDriver();
		pageobject=null;
	}
	
	
}
