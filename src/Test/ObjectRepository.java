package Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ObjectRepository {
	static File src1;
	static File src2;
	static File src3;
	
	static FileInputStream fis1 ;
	static FileInputStream fis2 ;
	static FileInputStream fis3 ;
	
	static Properties pro1;
	static Properties pro2 ;
	static Properties pro3 ;

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		//specify the location of properties file

		src1 = new File("/Users/karishmakate/Selenium Practice workspace/Selenium_Java_Project/Repository/config.properties");

		src2 = new File("/Users/karishmakate/Selenium Practice workspace/Selenium_Java_Project/Repository/locators.properties");

		src3 = new File("/Users/karishmakate/Selenium Practice workspace/Selenium_Java_Project/Repository/testData.properties");

		//Create a FileinputStram class object to load the file

		fis1 = new FileInputStream(src1);

		fis2 = new FileInputStream(src2);

		fis3 = new FileInputStream(src3);

		//Create a properties class object to read properties files

		pro1 = new Properties();
		pro1.load(fis1);

		pro2 = new Properties();
		pro2.load(fis2);


		pro3 = new Properties();
		pro3.load(fis3);
		
		// setting proprty of chrome browser and passing ChromeDriver path
		
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(pro1.getProperty("URL"));
		
		//getProperty  method will accpet key and return value of that key
		
		driver.findElement(By.xpath(pro2.getProperty("EMAIL"))).sendKeys(pro3.getProperty("TestData1"));
		driver.findElement(By.xpath(pro2.getProperty("Password"))).sendKeys(pro3.getProperty("TestData2"));
		Thread.sleep(2000);
		driver.close();

	}

}
