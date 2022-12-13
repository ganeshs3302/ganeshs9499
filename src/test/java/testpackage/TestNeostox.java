package testpackage;

import org.testng.annotations.Test;

import baseneo.Baseneostox;
import pompages.HomepageNeostox;
import pompages.PasswordpageNeostox;
import pompages.loginNeostocks;
import utility.Utilityclass;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TestNeostox extends Baseneostox{
	loginNeostocks login;
	HomepageNeostox home;
	PasswordpageNeostox password;
	 @BeforeClass
	  public void LaunchNeostox() 
	 {
		 LaunchBrowser();
		 login=new loginNeostocks(driver);
		 password= new PasswordpageNeostox(driver);
		 home= new HomepageNeostox(driver);
	  }
	 @BeforeMethod
	  public void LogintoNeostocks()throws EncryptedDocumentException, IOException, InterruptedException
	 {
		 login.sendmobileno(driver, Utilityclass.readdatafrompropertyfile("mobile"));
		 //login.sendmobileno(UtilityNeostox.readdatafromExcel(0, 0));
		 login.clickonSigninButton(driver);
		 Thread.sleep(1000);
		 password.sendpassword(driver, Utilityclass.readdatafrompropertyfile("password"));
		 password.clickonsubmitbutton(driver);
		 Thread.sleep(1000);
		 home.popUpHandle(driver);
	  }

  @Test 
  public void validateUserName() throws EncryptedDocumentException, IOException {
	  Assert.assertEquals(home.getUserName(), Utilityclass.readdatafrompropertyfile("un"),"TC failed, actual and expected User Names are not matching"); 
	  Utilityclass.screenshot(driver, home.getUserName());
	  }
  @AfterMethod
  public void logout()
  {
  home.logoutFormNeoStox(driver);
  }
  @AfterClass
  public void closeApplication() throws InterruptedException
  {
  closebrowser(driver);
  }
  }

