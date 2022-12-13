package baseneo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;


public class Baseneostox {
	protected static WebDriver driver;
	public  void LaunchBrowser()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\GN-PC\\Downloads\\velocity\\CHROME\\chromedriver.exe");
		
		 driver=new ChromeDriver();
		driver.get("https://neostox.com/sign-in");
		Reporter.log("Launching the Browser", true);
	}
		public static void closebrowser(WebDriver driver) throws InterruptedException
		{
			Reporter.log("closing the Browser", true);
			Thread.sleep(500);
			driver.close();
		}
	}


