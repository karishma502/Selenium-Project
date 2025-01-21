package TestNgClasses;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;

import com.google.common.io.Files;

public class TakeScreenshotsOnFailure {

	WebDriver driver;

	public void captureScreenshot(ITestResult result) throws IOException {

		driver = new ChromeDriver();
		if(ITestResult.FAILURE== result.getStatus()) {

			//Create ref of takescreenshot interface and type casting
			TakesScreenshot tc = (TakesScreenshot) driver;

			//use getScreenshot() to capture the screenshot in file formate

			File src = tc.getScreenshotAs(OutputType.FILE);

			//copy the file to specific location

			File destination = new File("./screenshots/" + result.getName()+ ".png");

			Files.copy(src,destination);
			System.out.println(result.getName()+"method screenshot captured.");
		}
	}
}
