package Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadingClass {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub


		//Specify the location of excel sheet

		File src = new File("/Users/karishmakate/Selenium Practice workspace/Selenium_Java_Project/TestData/Btech 7th Sem Result.xlsx");

		//Load file
		FileInputStream fis = new FileInputStream(src);

		//Load workbook
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		//Loadsheet

		XFFSSheet sheet = wb.getSheet("Sheet1");

		//print the loaded sheet name

		System.out.println(sheet.getSheetName());

		//Print PRN from sheet

		System.out.println(sheet.getRow(1).getCell(1).getStringCellValue());

		//print total num of -ROW
		System.out.println(sheet.getPhysicalNumberOfRow());

		//Print total num of row in another way
		System.out.println(sheet.getLastRowNum()+1);

		//print total num of -COL

		System.out.println(sheet.getRow(1).getPhysicalNumberOfSheet());

		//print total num of -COL other way

		System.out.println(sheet.getRow(1).getLastCellNum());


		//Real time implementation
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.facebook.com/");
		Thread.sleep(2000);

		//Enter username from excel sheet

		String username =sheet.getRow(1).getCell(1).getStringCellValue();
		driver.findElement(By.id("email")).sendKeys(username);


	}

}
