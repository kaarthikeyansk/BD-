package com.Bd;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Web {
	
	
	
	public static WebDriver driver;
	public static int indexofpopulation;
	public static int indexofcountry;

	public static void browserlaunch() {
		WebDriverManager.chromedriver().setup();

		 driver=new ChromeDriver();
		
		
		driver.get("https://www.worldometers.info/coronavirus/");
		
		driver.manage().window().maximize();

	}

	
	
	
	
	
	public static void getParticulardata(String countryName) {
		List<WebElement> allRows = driver
				.findElements(By.xpath("//table[@id='main_table_countries_today']/tbody[not(@class)]/tr"));
		for (int i = 0; i < allRows.size(); i++) {
			List<WebElement> allColoumn = allRows.get(i).findElements(By.tagName("td"));
			for (int j = 0; j < allColoumn.size(); j++) {
				if (allColoumn.get(indexofcountry).getText().equals(countryName)) {
					String population = allColoumn.get(indexofpopulation).getText();
					System.out.println(countryName + "Population is:" + population);
					break;
				}
			}
		}
	}
	public static void rowdata(String countryName) {
		List<WebElement> allRows = driver
				.findElements(By.xpath("//table[@id='main_table_countries_today']/tbody[not(@class)]/tr"));
		for (int i = 0; i < allRows.size(); i++) {
			List<WebElement> allColoumn = allRows.get(i).findElements(By.tagName("td"));
			for (int j = 0; j < allColoumn.size(); j++) {
				if (allColoumn.get(indexofcountry).getText().equals(countryName)) {
					String country = allColoumn.get(j).getText();
					System.out.println(country);
					
				}
			}
		}
	}
	
public static void main(String[] args) {
	
	browserlaunch();
	getParticulardata("india");
	rowdata("france");
	
	
}
}
