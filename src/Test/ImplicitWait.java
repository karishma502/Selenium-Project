package Test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitWait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000000));
		
		// handle auto search auto suggestion
		
		driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("How stuff works");
		List<WebElement> AllSuggestions= driver.findElements(By.xpath("//ul[@role='listbox']//li"));
		
		for(int i=0;i<AllSuggestions.size();i++) {
			String expResult ="How stuff works quiz";
			if(AllSuggestions.get(i).getText().equalsIgnoreCase(expResult)) {
				AllSuggestions.get(i).click();
				break;
			}
		}

	}

}
