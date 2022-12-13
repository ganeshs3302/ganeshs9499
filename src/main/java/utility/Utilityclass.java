package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Utilityclass {
	public static String readdatafrompropertyfile(String key) throws IOException
	{
		//create object of Properties class
		Properties prop=new Properties();
		//create object of FileInputStream
		FileInputStream myFile = new FileInputStream("C:\\Users\\GN-PC\\eclipse-workspace\\ABC\\input.properties");
		prop.load(myFile);
		String value = prop.getProperty(key);
		Reporter.log("reading value of "+key+" from property file",true);
		return value;
	}
	public static void screenshot(WebDriver driver,String f1) throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\Users\\GN-PC\\Downloads\\velocity\\pic2"+f1+".jpeg");
		FileHandler.copy(src, dest);
		Reporter.log("taking screenshot ",true);
	}
	
	public static void wait(WebDriver driver ,int waittime)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(waittime));
		Reporter.log("waiting for "+waittime+"milis",true);
	}
}
