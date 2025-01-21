package Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseSimutions3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub


		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/draggable/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(2000);

		//switch to frame
		driver.switchTo().frame(0);

		WebElement drag= driver.findElement(By.id("draggable"));
		//WebElement drop= driver.findElement(By.id("droppable"));

		Thread.sleep(3000);
		Actions ac = new Actions(driver);

		// change the position
		ac.dragAndDropBy(drag, 100, 60).build().perform();
		ac.clickAndHold(drag).dragAndDropBy(drag, 100, 60).build().perform();



	}

}
