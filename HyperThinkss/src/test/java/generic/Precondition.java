package generic;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Precondition implements AutoConstant  {

	public WebDriver driver;
	
	@BeforeMethod
    public void setUp(@Optional("chrome")String browser) 
    { 
		System.out.println(browser);
		if(browser.contentEquals("chrome")) {
		
			 WebDriverManager.chromedriver().setup();		
			 driver = new ChromeDriver();	 
	         driver.get("https://hyperthings.om");		
	         driver.manage().window().maximize();
	         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	         			
		}else if(browser.contentEquals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			driver.get("https://hyperthings.om");	
			driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        
		}else if(browser.contentEquals("opera")){
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
	        driver.get("https://hyperthings.om");
		}
		   
    }
	   
	@AfterMethod
	public void closeApplication() {
	
		//driver.quit();
	}
	

}
