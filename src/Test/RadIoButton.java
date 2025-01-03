package Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadIoButton {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		//Setting property of chromebrowser and passing chromedriver path
		System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");
		
		//Launching chrome
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		
		// click of create new account

		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[contains(@id,'u_0_0')]")).click();
		
		// 1st way
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='1']")).click(); //Female
		driver.findElement(By.xpath("//input[@value='2']")).click(); //Male		
		driver.findElement(By.xpath("//input[@value='-1']")).click(); //Custome		

		// 2nd way
		List<WebElement> radios= driver.findElements(By.xpath("//input[@type='radio']"));
		System.out.println("Total radio button : "+ radios.size());
		
		System.out.println(radios.get(0).isSelected()); //false
		System.out.println(radios.get(2).isEnabled()); //True
		System.out.println(radios.get(2).isDisplayed()); //True
		Thread.sleep(2000);
		radios.get(1).click();
		System.out.println(radios.get(2).isSelected()); //false
		
		// 3rd way
		
		List<WebElement> radios1= driver.findElements(By.xpath("//label[@class='_58mt']"));
		System.out.println("Total Radio buttons: " +radios1.size());
		
		String female = "Female";
		String male = "Male";
		String custom = "Custome";

		for(int i=0;i<radios1.size();i++) {
			
			if(radios1.get(i).getText().equalsIgnoreCase(female)) {
				Thread.sleep(2000);
				radios1.get(i).click();
				System.out.println(radios.get(0).isSelected()); //true

			}
			if(radios1.get(i).getText().equalsIgnoreCase(male)) {
				//System.out.println(radios1.get(i).getText().equalsIgnoreCase(male));
				Thread.sleep(2000);
				radios1.get(i).click();
				System.out.println(radios.get(1).isSelected()); //true

			}
			if(radios1.get(i).getText().equalsIgnoreCase(custom)) {
				//System.out.println(radios1.get(i).getText().equalsIgnoreCase(male));
				Thread.sleep(2000);
				radios1.get(i).click();
				System.out.println(radios.get(2).isSelected()); //true
				

			}
		}



		
		
		Thread.sleep(2000);
		driver.close();

	}

}
