package TestNgClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class AmazonSignInPage {
    WebDriver driver;
    @Test
    @Parameters({"browser","url"})
    public void test_Login(String br,String url) throws InterruptedException {

        switch (br.toLowerCase()){
            case "chrome":  driver = new ChromeDriver();
            break;
            case "firefox":  driver = new FirefoxDriver();
            break;
            case "edge": driver=new EdgeDriver();
            break;
            default:System.out.println("Invalid browser"); return;
        }
        
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get(url);
        Thread.sleep(2000);
        System.out.println("Login to Amazon...");
    }

   @Test(priority = 1,dependsOnMethods = "test_Login",groups = "Sanity")
   public void test_Search(){
        System.out.println("Search in Amazon...");
    }

    @Test(priority = 3,dependsOnMethods = "test_Search",groups = "Sanity")
    void test_AdvanceSearch(){
        System.out.println("Advance Search in Amazon...");
    }


    @Test(priority = 4,dependsOnMethods = "test_Login",groups = "Sanity")
    void test_Logout(){
        System.out.println("Logout from  Amazon...");
    }
}

