package PageFiles;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import configuration.DriverFactory;


public class Homepage {
	
	WebDriver driver;
	JavascriptExecutor js;
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
	@FindBy(id="nav-link-accountList")
	private WebElement signin;
	@FindBy(xpath="//*[@id='navFooter']//*[text()='Shop with Points']")
	private WebElement downlink;
	
	
	
	public Homepage(ThreadLocal<WebDriver> driver) {
		PageFactory.initElements(driver.get(), this);
		this.driver=driver.get();
		this.js=(JavascriptExecutor) this.driver;
		
		
	}
	public void login() {
		DriverFactory.getinstance().getDriver().get().get("https://www.amazon.com");
		signin.click();
	
	
	}
	

	public void scrolldown() {
		js.executeScript("arguments[0].scrollIntoView();", downlink);
	}

}