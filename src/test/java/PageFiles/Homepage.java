package PageFiles;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import configuration.DriverFactory;


public class Homepage extends SelectObjects {
	
	WebDriver driver;
	JavascriptExecutor js;
	@FindBy(className="nav-logo-link")
	private WebElement logo;
	@FindBy(id="nav-global-location-slot")
	private WebElement location;
	@FindBy(id="twotabsearchtextbox" )
	private WebElement searchbox;
	@FindBy(xpath="//input[@class='nav-input'][@value='Go']")
	private WebElement product_search;
	@FindBy(xpath="//img[contains(@src,'CB483')]")
	private WebElement caption_pic;
	@FindBy(id="nav-link-accountList")
	private WebElement signin;
	@FindBy(xpath="//*[@id='navFooter']//*[text()='Shop with Points']")
	private WebElement downlink;
	@FindBy(css="div.navFooterLinkCol.navAccessibility")
	private WebElement table;
	
	
	public Homepage(ThreadLocal<WebDriver> driver) {
		
		PageFactory.initElements(driver.get(), this);
		this.driver=driver.get();
		this.js=(JavascriptExecutor) this.driver;
		
		
	}
	
	public String gettable() {
		String[] array;
		
		return table.getText();
	}
	
	public void picklist() {
		Select dd_search=new Select(driver.findElement(picklist));
		dd_search.selectByIndex(26);
	}
	
	
	public void login() {
		DriverFactory.getinstance().getDriver().get().get("https://www.amazon.com");
		//signin.click();
	
	
	}
	
	
	public void rightclick() throws AWTException {
		Actions builder=new Actions(driver);
		builder.contextClick(logo).build().perform();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		//robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public void scrolldown() {
		js.executeScript("arguments[0].scrollIntoView();", downlink);
	}

}