package configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;
import static io.github.bonigarcia.wdm.DriverManagerType.IEXPLORER;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	private DriverFactory() {
		
	}
	private static DriverFactory instance=new DriverFactory();
	
	public static DriverFactory getinstance() {
		
		return instance;
	}
	
	
	//public String check="I am checker";
	private  ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>(); // thread local driver object for webdriver
			/*   {
			      @Override
			      protected WebDriver initialValue()
			      {
			    	 WebDriverManager.getInstance(CHROME).setup();
			         return new ChromeDriver(); // can be replaced with other browser drivers
			      }
			   };*/
	
	
	public void setchromeDriver() // call this method to get the driver object and launch the browser
	   {
		WebDriverManager.getInstance(CHROME).setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("headless");
	      driver.set(new ChromeDriver(options));
	      
	      }
	public void setieDriver() // call this method to get the driver object and launch the browser
	   {
		WebDriverManager.getInstance(IEXPLORER).setup(); 
	     driver.set(new InternetExplorerDriver());
	   }

			   public ThreadLocal<WebDriver> getDriver() // call this method to get the driver object and launch the browser
			   {
				//  System.out.println("IN driver factory get"+driver.get()+" Thread "+Thread.currentThread());
			      return driver;
			   }

			   public void removeDriver() // Quits the driver and closes the browser
			   {
				 //  System.out.println("in driver factory quit"+ driver.get());
			      
			      driver.remove();
			   }
			   
		/*	   ThreadLocal<WebDriver> iedriver = new ThreadLocal<WebDriver>() // thread local driver object for webdriver
					   {
					      @Override
					      protected WebDriver initialValue()
					      {
					    	  WebDriverManager.getInstance(IEXPLORER).setup(); 
					         return new InternetExplorerDriver(); // can be replaced with other browser drivers
					      }
					   };
					   public WebDriver getIEDriver() // call this method to get the driver object and launch the browser
					   {
					      return iedriver.get();
					   }

					   public void removeIEDriver() // Quits the driver and closes the browser
					   {
					      iedriver.get().quit();
					      iedriver.remove();
					   }*/

			   
}
