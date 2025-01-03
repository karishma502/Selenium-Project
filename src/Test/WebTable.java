package Test;

import java.time.Duration;
import java.util.List;

import javax.swing.text.Document;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://money.rediff.com/mutual-funds");

		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// 1st way - just click operation To print particular data only
		driver.findElement(By.xpath("//table[@class='dataTable']//tbody//tr[3]/td[3]/a")).click();
		 driver.switchTo().defaultContent();

		//2 nd way
		List<WebElement> tableRows= driver.findElements(By.xpath("//table[@class='dataTable']//tbody//tr/td[1]/a"));
		System.out.println("Total rows: "+ tableRows.size());

		tableRows.get(1).click();
		System.out.println("click opration performed");

		//To print all data’s in the table:
		for(WebElement row : tableRows) {
			List<WebElement>  tableData =  driver.findElements(By.xpath("//table[@class='dataTable']//tbody//tr//td"));
			System.out.println("Total data value: "+ tableData);

			for(WebElement data : tableData) {
				System.out.println(data.getText());
			}
		}
		
		//To print particular data only:
		for(WebElement row: tableRows) {
			if(row.getText().equalsIgnoreCase("HDFC Defence Fund - Direct Plan - Growth")) {
				System.out.println(row.getText().equalsIgnoreCase("HDFC Defence Fund - Direct Plan - Growth"));
				row.click();
				break;
			
			}
		}
		
		//using normal for loop
		
		for(int i=0;i<tableRows.size();i++) {
			if(tableRows.get(i).getText().equalsIgnoreCase("HDFC Defence Fund - Direct Plan - Growth")) {
				String value= tableRows.get(i).getText();
				System.out.println("Value is" + value);
				tableRows.get(i).click();
				break;
			}
		}
		//driver.close();
	}

}
