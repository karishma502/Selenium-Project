package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class DemoBlazeCategoryCount {
    @Test
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.demoblaze.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        countCategoryItems(driver,wait, "Phones");
        countCategoryItems(driver, wait,"Laptops");
        countCategoryItems(driver,wait, "Monitors");

        // Close the browser
        driver.quit();
    }

    public static void countCategoryItems(WebDriver driver, WebDriverWait wait,String category) {
        driver.findElement(By.xpath("//a[text()='" + category + "']")).click();

        // Get initial product count before clicking the category
        List<WebElement> initialItems = driver.findElements(By.xpath("//div[@id='tbodyid']//div[@class='card h-100']"));
        int initialCount = initialItems.size();

        wait.until(driver1 -> {
            List<WebElement> updatedItems = driver1.findElements(By.xpath("//div[@id='tbodyid']//div[@class='card h-100']"));
            return updatedItems.size() != initialCount;  // Wait until the count changes
        });
        // Get the list of products displayed
        List<WebElement> items = driver.findElements(By.xpath("//div[@id='tbodyid']//div[@class='card h-100']"));
        System.out.println("There are " + items.size() + " " + category.toLowerCase() + " present on the website.");
    }
}
