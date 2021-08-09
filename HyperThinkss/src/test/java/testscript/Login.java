package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import generic.ExcelSheet;
import generic.Precondition;

import pom.Login_Page;


public class Login extends Precondition {
	
	@Test(invocationCount =1)
	public void hyperThinkLoginVerification() throws InterruptedException, IOException {
				
		String username = ExcelSheet.readDataFromexcel("Sheet1", 1, 0);
		String password = ExcelSheet.readDataFromexcel("Sheet1", 1, 1);
		System.out.println("username is "+username);
		System.out.println("password is "+password);
		
		Login_Page lp = new Login_Page(driver);
		lp.setUsername(username);
		lp.setPassword(password);
		lp.clickSubmit();
		String actuaURL = driver.getCurrentUrl();
		//SoftAssert softAssert = new SoftAssert();
		//softAssert.assertEquals(actuaURL, "https://hyperthings.om/login/home");
		//test.pass("URL verified");	
		ExcelSheet.writeDataToExcel("Sheet1", 1, 2, "Failed");
		//softAssert.assertAll();
				
	}
}
