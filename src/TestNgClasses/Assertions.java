package TestNgClasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertions {
	WebDriver driver;
	//Hard assertion
	@Test(enabled = true)
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
		String expected1 ="abc";

		try {
			Assert.assertEquals(actual1, expected1);
		} catch (Error e) {
			System.out.println("assertion failed!!!");
		}


	}

// Even if assertion fail  next step will execute if use soft assertion
@Test
	void test_softAssert(){
		System.out.println("testing");
		System.out.println("testing");

      	SoftAssert  as = new SoftAssert(); //soft assertion

		  as.assertEquals(1,2);

		System.out.println("testing");
		System.out.println("testing");

		as.assertAll(); //mandatory


	}
}
