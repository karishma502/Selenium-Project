package Test;



import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class OpenAppilcation {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		//Setting property of chromebrowser and passing chromedriver path
		//System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");

		//if we use WebDriverManager(alternative option for system.setProperty()
		//and also we dont need to add exe file into the project ,just add dependency
		//and use below syntax
		WebDriverManager.chromedriver().setup();
		//Launching chrome
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.facebook.com/");

		//Fetch current Url
		String a = driver.getCurrentUrl();
		System.out.println(a);

		// maximize window
		Thread.sleep(2000);
		driver.manage().window().maximize();

		//delete all cookies
		Thread.sleep(2000);
		driver.manage().deleteAllCookies();

		//Open another URL using Navigate to method
		Thread.sleep(2000);
		driver.navigate().to("https://www.google.com");

		//Navigate to previous the page
		Thread.sleep(2000);
		driver.navigate().back();

		//refersh the page
		Thread.sleep(2000);
		driver.navigate().refresh();

		//Navigate next page
		Thread.sleep(2000);
		driver.navigate().forward();

		//get Title of the page
		System.out.println(driver.getTitle());

		// get current window id
		String currentWindowID= driver.getWindowHandle();
		System.out.println("Current Window id: "+ currentWindowID);


		//clean the current browser
		//driver.close()
	}



}
