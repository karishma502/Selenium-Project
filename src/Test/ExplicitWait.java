package Test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");

		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000000));

		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("abc@gmail.com");

		//fetch value of the attribute
		String attributeValue=driver.findElement(By.xpath("//input[@id='email']")).getText();
		System.out.println(attributeValue);


		//get height and width of input box
		System.out.println(driver.findElement(By.xpath("//input[@id='email']")).getSize().getHeight());
		System.out.println(driver.findElement(By.xpath("//input[@id='email']")).getSize().getWidth());

		//Use explicit wait to check pass field is visible
		
		WebDriverWait wt = new WebDriverWait(driver,Duration.ofSeconds(30));
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("passs"))).sendKeys("Password");
		
		driver.findElement(By.xpath("//button[@name='login']")).click();
		
		
	}

}
