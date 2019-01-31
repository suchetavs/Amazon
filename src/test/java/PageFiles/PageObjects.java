package PageFiles;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import configuration.DriverFactory;


public class PageObjects {
	WebDriver driver;
	@FindBy(className="nav-logo-link")
	private WebElement logo;
	@FindBy(id="nav-global-location-slot")
	private WebElement location;
	@FindBy(id="twotabsearchtextbox" )
	private WebElement searchbox;
	@FindBy(xpath="//*[@class='nav-search-dropdown searchSelect']" )
	private WebElement dd_search;
	@FindBy(xpath="//input[@class='nav-input'][@value='Go']")
	private WebElement product_search;
	@FindBy(xpath="//img[contains(@src,'CB483')]")
	private WebElement caption_pic;
	@FindBy(xpath="//*[@id='nav-link-accountList']")
	private WebElement signin;
	
	
	
	public PageObjects(ThreadLocal<WebDriver> driver) {
		PageFactory.initElements(driver.get(), this);
		
	}
	
	public void login(){
		signin.click();
	}

	

}