package com.Bd;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Webtable {
	
	public static WebDriver driver;
	public static int indexofpopulation;
	public static int indexofcountry;

	public static void browserlaunch() {
		WebDriverManager.chromedriver().setup();

		driver=new ChromeDriver();

		driver.get("https://www.worldometers.info/coronavirus/");

		driver.manage().window().maximize();

	}


	public static  void getallheader() {

		Map<Integer, String> headermap =new LinkedHashMap<Integer, String>();

		List<WebElement> allheader = driver.findElements(By.xpath("//table[@id='main_table_countries_today']//thead/tr/th"));

		for (int i = 0; i < allheader.size(); i++) {
			String header=	allheader.get(i).getText();
			headermap.put(i, header);


			if (header.equals("population")) {
				indexofpopulation=i;
			}else if (header.contains("country")) {
				indexofcountry=i;
			}

		}
	}

	//	public static void alldata() {
	//		List<WebElement> alldata = driver.findElements(By.xpath("//table[@id='main_table_countries_today']//tbody[1]/tr/td"));
	//		for (WebElement a : alldata) {
	//			System.out.println(a.getText());
	//		}
	//
	//	}
	//
	//	public static void allcolumn() {
	//		List<WebElement> countryname = driver.findElements(By.xpath("//table[@id='main_table_countries_today']//tbody/tr/td[2]"));
	//
	//		for (WebElement country : countryname) {
	//
	//			System.out.println(country.getText());
	//
	//		}
	//
	//
	//	}
	//
	//	public static  void rowwise() {
	//
	//		List<WebElement> rowdata	=driver.findElements(By.xpath("//table[@id='main_table_countries_today']//tbody/tr/td[2]"));
	//		for (WebElement webElement : rowdata) {
	//			System.out.println(webElement.getText());
	//		}
	//
	//	}
	//
	//	public static void particularrows() {
	//
	//		WebElement row = driver.findElement(By.xpath("//table[@id='main_table_countries_today']//tbody//tr[5]//td"));
	//
	//		System.out.println(row.getText());
	//
	//	}
	//	


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
		//		getallheader();
		//		allcolumn();
		//		particularrows();
		//		rowwise();
		getParticulardata("india");
		rowdata("france");

	}



}
