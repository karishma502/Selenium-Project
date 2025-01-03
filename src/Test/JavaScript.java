package Test;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScript {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//JavaScriptExecutor
		
		// locate web element using javascript
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("document.getElementById('email').setAttribute('value', 'abc@gmail.com')");
		Thread.sleep(2000);
		//js.executeAsyncScript("document.getElementById('pass').setAttribute('value', 'abcom')");
		//js.executeScript("document.getElemenetById('email').value='avle@gmail.com'");
		
		
		//scroll down  using javascript
		
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(2000);

		js.executeScript("window.scrollBy(0,-400)");
	}

}
