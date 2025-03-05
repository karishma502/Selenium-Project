package Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseSimutions {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub


		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//span[@role='button']")).click();
		//System.out.println("click opetation performed");

		// Ref of Electonic

		WebElement electro= driver.findElement(By.xpath("//*[text()='Electronics']"));

		//mouse simulation using Action class

		Actions ac =new Actions(driver);

		//Mouse hover to elcetronic
		Thread.sleep(2000);
		ac.moveToElement(electro).build().perform();


		//Keyboard oprations
		driver.navigate().refresh();
		Thread.sleep(2000);
		WebElement fashion= driver.findElement(By.xpath("//*[text()='Fashion']"));
		ac.sendKeys(fashion, Keys.ENTER);
		System.out.println("Clicked on Fashions");
		driver.findElement(By.xpath("//span[@role='button']")).click();
		System.out.println("click opetation performed");

		// right click on web page

		Thread.sleep(2000);
		ac.contextClick().build().perform();

	}

}
