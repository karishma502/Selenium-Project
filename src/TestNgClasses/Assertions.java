package TestNgClasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Assertions {
	WebDriver driver;
	@Test
	public void testCase1() {
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		String actual = driver.findElement(By.xpath("//*[contains(text(),'life.')]")).getText();
		String expectedText = "Facebook helps you connect and share with the people in your life.";

		//Equal assertion
		Assert.assertEquals(actual, expectedText);
		System.out.println("equal assert pass");

		//Assert false
		Assert.assertFalse(driver.findElement(By.xpath("//*[contains(text(),'life.')]")).isSelected());
		System.out.println("False assertion varified");

		//Assert True
		Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'life.')]")).isDisplayed());
		System.out.println("True assertion varified");

		String actual1 = "ab";
		String expt ="abc";
		
		try {
			Assert.assertEquals(actual1, expt);
		} catch (Error e) {
		}
		System.out.println("equal assert pass");


	}
}
