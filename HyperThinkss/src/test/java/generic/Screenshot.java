package generic;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.logging.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Screenshot { 

	public String capture(WebDriver driver,String testName) {
		
		String Date = new Date().toString().replace(":", "-");
		String photo_path = System.getProperty("user.dir")+"/TestCaseExecutionReports/"+testName+Date+".png";
		TakesScreenshot TS=(TakesScreenshot) driver;
		File src = TS.getScreenshotAs(OutputType.FILE);
		File dst = new File(photo_path);
		try {
			org.openqa.selenium.io.FileHandler.copy(src, dst);
		} catch (IOException e) {
			System.out.println("Failed to take screenshot");
		}
		return photo_path;
		}
}
