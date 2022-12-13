package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import utility.Utilityclass;

public class loginNeostocks
{
@FindBy(id="MainContent_signinsignup_txt_mobilenumber")private WebElement mobileno;
@FindBy(id="lnk_signup1")private WebElement signinbutton;

public loginNeostocks(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
	
public void sendmobileno(WebDriver driver,String mobile) throws InterruptedException
{
	
	mobileno.sendKeys(mobile);
	Reporter.log("Entering mobileno", true);
}
public void clickonSigninButton(WebDriver driver)
{
	Utilityclass.wait(driver, 1000);
	signinbutton.click();
	Reporter.log("clicking on the SignIn Button", true);
}
}
