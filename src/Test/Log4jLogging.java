//package Test;
//
//import java.time.Duration;
//
////import org.apache.log4j.Logger;
////import org.apache.log4j.PropertyConfigurator;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.slf4j.Logger;
//
//public class Log4jLogging extends ObjectRepository{
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		// Create instance of logger
//		Logger log = Logger.getLogger("log4jLogging");
//
//		//configure log4j properties file
//
//		PropertyConfigurator.configure("/Users/karishmakate/Selenium Practice workspace/Selenium_Java_Project/log4j.properties");
//
//		//Open browser
//
//		log.info("set sysytem property and pass chromeDriver path");
//		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
//		WebDriver driver=new ChromeDriver();
//		log.info("Browser instance opend!");
//
//		driver.manage().window().maximize();
//		log.info("Window maximized!");
//
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.get("https://www.facebook.com/");
//		log.info("Url Launched!");
//
//		//Check of element is displayed
//		try {
//			driver.findElement(By.id("emails")).isDisplayed();
//			log.info("web element displayed");
//		}
//		catch(Exception e){
//			log.info("Failed - 'email' web Element is not found!");
//		}
//
//
//	}
//
//}
