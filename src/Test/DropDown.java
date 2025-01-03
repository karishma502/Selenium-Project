package Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		

		// click of create new account
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[contains(@id,'u_0_0')]")).click();
		
		// 1st way - without using select class
		
		Thread.sleep(2000);
		List<WebElement> birthMonth = driver.findElements(By.xpath("//select[@id='month']/option"));
		System.out.println("Total no. of months: "+ birthMonth.size());
		birthMonth.get(8).click();// sep
		
		// 2nd way - With using select class
		Thread.sleep(2000);
		WebElement bm = driver.findElement(By.xpath("//select[@id='month']"));
		
		Select month= new Select(bm);
		
		Thread.sleep(2000);
		month.selectByIndex(2);//march
		Thread.sleep(2000);
		month.selectByVisibleText("Sep");
		Thread.sleep(2000);
		month.selectByValue("2");//feb
		
		System.out.println(month.getFirstSelectedOption().getText());
		
		// 3rd Way -getOptions()
		List<WebElement> dropdown = month.getOptions();
		System.out.println(dropdown);
		for(int i=0;i<dropdown.size();i++) {
			if(dropdown.get(i).getText().equalsIgnoreCase("Sep")) {
				Thread.sleep(2000);
				dropdown.get(i).click();
			}
		}
		
		// 4th way
		
		bm.sendKeys("Jan");
		
		// 5th Way
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//select[@id='month']")).sendKeys("Nov");
		
		
		// check if dropdown supports multiselct or not
		System.out.println(month.isMultiple());
	}

}
