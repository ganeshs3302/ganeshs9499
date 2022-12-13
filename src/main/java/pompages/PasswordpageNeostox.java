package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import utility.Utilityclass;
public class PasswordpageNeostox {
@FindBy(id="txt_accesspin") private WebElement pass;
@FindBy(id="lnk_submitaccesspin")private WebElement submitbutton;
public PasswordpageNeostox(WebDriver driver)
{
	PageFactory.initElements( driver,this);

	}
public void sendpassword(WebDriver driver,String pass1)
{
	Utilityclass.wait(driver, 1000);
	pass.sendKeys(pass1);
	Reporter.log("sending password", true);
}
public void clickonsubmitbutton(WebDriver driver) throws InterruptedException
  {
	Thread.sleep(1000);
	submitbutton.click();
	Reporter.log("cliking on submit button", true);
  }
 }

