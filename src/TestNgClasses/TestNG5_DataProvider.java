package TestNgClasses;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
/*
 * Prioritization using Dataprovider
 */
public class TestNG5_DataProvider {

	WebDriver driver;
	@BeforeClass
	public void setEnvt() {

		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
	}

	@DataProvider
	public Object[][] dataset() throws Exception{
		//Specify the location of propery file

		File src = new File("/Users/karishmakate/Selenium Practice workspace/Selenium_Java_Project/Repository/testData.properties");

		//Create a FileinputStram class object to load the file

		FileInputStream fis = new FileInputStream(src);

		//Create a properties class object to read properties files

		Properties pro = new Properties();
		pro.load(fis);

		Object arr[][] = new Object[3][2];

		arr[0][0]= pro.getProperty("TestData1");
		arr[0][1]= pro.getProperty("TestData1");

		arr[1][0]= pro.getProperty("TestData2");
		arr[1][1]= pro.getProperty("TestData2");

		arr[2][0]= pro.getProperty("TestData3");
		arr[2][1]= pro.getProperty("TestData3");

		return arr;

	}

	@Test(dataProvider = "dataset")
	public void enterData(String username,String password) throws InterruptedException {

		Thread.sleep(2000);
		driver.findElement(By.id("email")).clear();
		Thread.sleep(2000);
		driver.findElement(By.id("pass")).clear();
		Thread.sleep(2000);
		driver.findElement(By.id("email")).sendKeys(username);
		Thread.sleep(2000);
		driver.findElement(By.id("pass")).sendKeys(password);
	}
}