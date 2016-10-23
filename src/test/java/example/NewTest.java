package example;		

import org.testng.annotations.*;
import org.testng.AssertJUnit;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;		
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Augmenter;
import org.testng.Assert;		
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Features;

import org.testng.annotations.BeforeTest;	
import org.testng.annotations.AfterTest;		
public class NewTest {		
	    private FirefoxDriver driver;		

	    @Features("Basic feature")
	    @Stories({"Startup"})
	    @Test 				
		public void testEasy() {
			printing();
			driver.get("http://www.guru99.com/selenium-tutorial.html");  
			String title = driver.getTitle();
			byte [] scrFile = driver.getScreenshotAs(OutputType.BYTES);
			saveScreenshot(scrFile);
			AssertJUnit.assertTrue(title.contains("Free Selenium Tutorials")); 		
		}
		@Test				
		public void testEasy2() {

			driver.get("http://www.guru99.com/selenium-tutorial.html");
			String title = driver.getTitle();				 
			AssertJUnit.assertTrue(title.contains("Free Selenium Tutorials")); 		
		}
		@Step("Open page.")
		public void printing() {
			System.out.println("Getting page!");
		}
		@Attachment(value = "Page screenshot", type = "image/png")
		public byte[] saveScreenshot(byte[] screenShot) {
		    return screenShot;
		}
		@BeforeTest
		public void beforeTest() {	
		    driver = new FirefoxDriver();  
		}		
		@AfterTest
		public void afterTest() {
			driver.quit();			
		}		
}	