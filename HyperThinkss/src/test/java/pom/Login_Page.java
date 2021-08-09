package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import generic.Base_Page;

public class Login_Page extends Base_Page {

	@FindBy(xpath="//input[@id='email']")
	private WebElement unameTxtField;
	
	@FindBy(xpath="//input[@id='Password']")
	private WebElement pwordTextField;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement submit;
	
//	@FindBy(xpath="//span[contains(.,'Check Your')]")
//	private WebElement errorMessage;
//	
	
	public Login_Page(WebDriver driver) {
		super(driver);
	}
	
	public void setUsername(String uname)
	{
		unameTxtField.sendKeys(uname);
	}
	
	public void setPassword(String pword)
	{
		pwordTextField.sendKeys(pword);
	}
	
	public void clickSubmit()
	{
		submit.click();
	}
		
}
