package TestNgClasses;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(TestNgClasses.MyListener.class)
public class TakeScreenshotsOnFailure2 {

	TakeScreenshotsOnFailure t1 = new TakeScreenshotsOnFailure();

	@Test
	public void doLogin() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		t1.driver = new ChromeDriver();
		t1.driver.manage().window().maximize();
		t1.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		t1.driver.get("https://www.facebook.com/");
		Thread.sleep(2000);
		Thread.sleep(2000);
		t1.driver.findElement(By.id("email")).sendKeys("abc@123");
		Thread.sleep(2000);
		t1.driver.findElement(By.id("pass")).sendKeys("pass");

		//pass wrong id so tht test will fail
		t1.driver.findElement(By.id("email_wrong")).sendKeys("abc@123");
	}

	@AfterMethod
	public void takeScreenshot(ITestResult result) throws IOException {

		t1.captureScreenshot(result);
	}



}
