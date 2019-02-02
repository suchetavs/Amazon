package PageFiles;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import configuration.DriverFactory;


public class Chegg {
	
	@FindBy(css="span.forgot-password active-link")
	private WebElement forgot;
	@FindBy(css="a.signin-item nav-item track-signin")
	private WebElement signin;
	
	public Chegg(ThreadLocal<WebDriver> driver) {
		PageFactory.initElements(driver.get(), this);
		
	}
	
	public void forgotpassword() {
		Wait<WebDriver> wait=new WebDriverWait(DriverFactory.getinstance().getDriver().get(),60000);
		wait.until(ExpectedConditions.elementToBeClickable(signin));
		signin.click();
		forgot.click();
		
	}
	}