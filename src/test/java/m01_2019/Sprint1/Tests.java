package m01_2019.Sprint1;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import PageFiles.*;
import configuration.DataConfigurationClass;
import configuration.DriverFactory;
import junit.framework.Assert;

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
		System.out.println("check hook");
		System.out.println("check webhok again");
		Assert.assertEquals(true, false);
	}
		
	
	@Test
	public void recaptcha() throws AWTException, InterruptedException {
	//	System.out.println("Entered recpata");
		DriverFactory.getinstance().getDriver().get().get("https://www.amazon.com");
		/*//pageobject.get().login();
		pageobject.get().rightclick();
		//pageobject.get().rightclick();
		//dd_search.selectByIndex(3);
		signinpage.get().image.click();
		signinpage.get().searchbox.sendKeys("sad");
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		//robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(1000);		
		robot.mouseMove(200,600);
		robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
		Thread.sleep(1000);	
		robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
		
		for(int i=0;i<7;i++)
		{	robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
		}
		robot.keyPress(KeyEvent.VK_ENTER);*/
		System.out.println(pageobject.get().gettable());
		//DriverFactory.getinstance().getDriver().get().manage().window
		
		
	}
	
	
	
	
		
	@AfterTest
	public void teardown() {
	
		DriverFactory.getinstance().removeDriver();
		pageobject=null;
	}
	
	
}
