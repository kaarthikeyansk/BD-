package com.Bd;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.cli.Main;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Bigbasket {
	public static 	WebDriver driver;
	public static void browserlaunch() {
		WebDriverManager.chromedriver().setup();

		driver=new ChromeDriver();
		driver.get("https://www.bigbasket.com/");
		driver.manage().window().maximize();
	}

	public static void userinput() throws InterruptedException {
		WebElement searchbox = driver.findElement(By.id("input"));
		searchbox.sendKeys("rice");
		Thread.sleep(2000);
		WebElement ddown = driver.findElement(By.xpath("(//p[@qa='brandAS'])[1]"));
		ddown.click();

	}

	public static void main(String[] args) throws InterruptedException {
		browserlaunch();
		userinput();

	}


}
