package org.sample;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Workout {
	public static void main(String[] args) throws AWTException, IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.flipkart.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
			driver.findElement(By.xpath("//input[@class='_3704LK']")).sendKeys("iPhone");
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(5000);
			WebElement move = driver.findElement(By.xpath("(//div[@class='_4rR01T'])[23]"));
			Actions a = new Actions (driver);
			a.moveToElement(move).perform();
			Thread.sleep(10000);
			TakesScreenshot sc = (TakesScreenshot)driver;
			File sc1 = sc.getScreenshotAs(OutputType.FILE);
			File Ds1 = new File(".//screenshot/screen2.png");
			FileUtils.copyFile(sc1, Ds1);
			driver.findElement(By.xpath("(//div[@class='_4rR01T'])[24]")).click();
			Set<String> allwins = driver.getWindowHandles();
			System.out.println(allwins);
			List<String> allID = new ArrayList<String>(allwins);
			driver.switchTo().window(allID.get(1));
			Thread.sleep(10000);
			driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")).click();
			
			
	}

}
