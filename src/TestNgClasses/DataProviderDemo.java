package TestNgClasses;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Optional;

public class DataProviderDemo {
    WebDriver driver;
    @BeforeClass
    @Parameters({"browser"})
   public void setEnvt(String br){
        switch (br){
            case "chrome" :
                driver= new ChromeDriver();
            case "edge" :
                driver=new EdgeDriver();
            default: System.out.println("Invalidate driver");
            return;
        }


    }

    @Test(dataProvider = "dataSet")
    public void test_Login(String email,String pass){
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("pass")).sendKeys(pass);
        driver.findElement(By.xpath("//*[@type='submit']")).submit();

    }

    public void tearDown(){
        driver.close();
    }

    @DataProvider(name ="dataSet",parallel = true)
    public Object[][] setData() {

        return new Object[][]{{"abc@123", "1234"},
                {"XYZ@123", "134"}};
    }
}
