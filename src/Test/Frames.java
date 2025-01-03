package Test;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Frames {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub


		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://paytm.com/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[text()='Sign In']")).click();
		
		int allFrames = driver.findElements(By.tagName("iframe")).size();
		System.out.println("total frames:"+ allFrames);
		
		//driver.switchTo().frame(0);
		Thread.sleep(2000);
		String text = driver.findElement(By.xpath("//*[text()='Login with your Paytm account']")).getText();
		
		String expected ="Login with your Paytm account";
		assertEquals(text,expected);
		System.out.println(text);
//		for(int i=0;i<allFrames;i++) {
//			driver.switchTo().frame(i);
//			Thread.sleep(2000);
//			String text = driver.findElement(By.xpath("//*[text()='Login with your Paytm account']")).getText();
//			
//			String expected ="Login with your Paytm account";
//			assertEquals(text,expected);
//			System.out.println(text);
//		}
		
		

	}




}
