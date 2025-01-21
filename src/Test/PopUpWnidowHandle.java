package Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PopUpWnidowHandle {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://demoqa.com/browser-windows");
		Thread.sleep(2000);

		// Tab handling
		driver.findElement(By.id("tabButton")).click();

		// get total num of windows/tabs
		Set<String> allWindowId = driver.getWindowHandles();
		System.out.println("Total num of window opend: "+ allWindowId);

		Iterator<String> abc = allWindowId.iterator();
		String win1=abc.next();
		String win2=abc.next();

		//print title of parent window
		driver.switchTo().window(win1); // Alphanumeric id of parent tab
		System.out.println("Parent window:" + win1);
		System.out.println(driver.getTitle());

		//print title of child window
		driver.switchTo().window(win2); // Alphanumeric id of child tab
		System.out.println("child window:" + win2);
		System.out.println(driver.getCurrentUrl());
		driver.close();

		// Steps-2 Popup and Window handles

		Thread.sleep(2000);
		driver.switchTo().window(win1);
		//driver.navigate().refresh();
		Thread.sleep(2000);
		driver.findElement(By.id("windowButton")).click();

		//print titile of child window
		Set<String> allWindowId2 = driver.getWindowHandles();
		System.out.println("Total num of window opend: "+ allWindowId2);

		Iterator<String> abc1 = allWindowId2.iterator();
		String win3=abc1.next();
		String win4=abc1.next();
		Thread.sleep(2000);
		driver.switchTo().window(win4);
		System.out.println("child window:" + win4);
		System.out.println(driver.getCurrentUrl());

	}

}
