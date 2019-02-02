package PageFiles;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import configuration.DriverFactory;


public class SignInPage {
	
	@FindBy(xpath="//*[@type='email']")
	private WebElement username;
	@FindBy(xpath="//*[@type='password']")
	private WebElement password;
	@FindBy(id="signInSubmit" )
	private WebElement submit;
	@FindBy(xpath="//*[@class='nav-search-dropdown searchSelect']" )
	private WebElement dd_search;
	@FindBy(xpath="//input[@class='nav-input'][@value='Go']")
	private WebElement product_search;
	@FindBy(xpath="//img[contains(@src,'CB483')]")
	private WebElement caption_pic;
	@FindBy(xpath="//*[@id='nav-link-accountList']")
	private WebElement signin;
	
	
	
	public SignInPage(ThreadLocal<WebDriver> driver) {
		PageFactory.initElements(driver.get(), this);
		
	}
	
	
	public WebElement[] login(){
		WebElement[] loginfields=new WebElement[3];
		loginfields[0]=username;
		loginfields[1]=password;
		loginfields[2]=submit;
		return loginfields;
		
	}

	

}