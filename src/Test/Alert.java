package Test;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alert {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://demoqa.com/alerts");
		Thread.sleep(2000);

		// Alert handling
		Thread.sleep(2000);
		driver.findElement(By.id("confirmButton")).click();
		Thread.sleep(2000);

		// verify alert text
		String alertText=driver.switchTo().alert().getText();
		String expectedText="Do you confirm action?";
		assertEquals(alertText, expectedText);
		System.out.println("Alert varified!");

		//Accpet alert

		driver.switchTo().alert().accept();
		System.out.println("Alert accpeted!");

		//Dismiss alert
		Thread.sleep(2000);
		driver.findElement(By.id("confirmButton")).click();
		driver.switchTo().alert().dismiss();
		System.out.println("Alert dismissed!");


	}

}
