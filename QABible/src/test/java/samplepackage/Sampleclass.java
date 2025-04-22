package samplepackage;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.Test;

import java.awt.Desktop.Action;
import java.nio.channels.SelectableChannel;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Testscripts.Baseclass;

public class Sampleclass extends Baseclass{
	WebDriver driver;
	SoftAssert softAssert;
	
	@BeforeMethod
	
	public void startbrowser() throws Exception {
		
		driver =browserinitialisation("chrome");
		driver.get("https://selenium.qabible.in/");
		//soft assertion
	    softAssert = new SoftAssert();
	}
	
	@Test(dataProvider = "dataprovider")
   public void testCase1(String msg) {
		
		System.out.println("Test Case 1");
		driver.findElement(By.xpath("(//ul[@class='navbar-nav']//descendant::a)[2]")).click();
		driver.findElement(By.id("single-input-field")).sendKeys(msg);
		driver.findElement(By.id("button-one")).click();
		
		String message = driver.findElement(By.id("message-one")).getText();
		System.out.println(message);
		softAssert.assertEquals(message, "Your Message : Going to find the total");
		driver.findElement(By.xpath("//input[@id='value-a']")).sendKeys("23");
		driver.findElement(By.id("value-b")).sendKeys("10");
		driver.findElement(By.id("button-two")).click();
		softAssert.assertAll();
	}
	@DataProvider(name = "dataprovider")
	public Object[] testmessage() {
		Object[] msgString = new Object[1];
		msgString[0]="Going to find the total";
		return msgString;
	}
	@Test
	public void testCase2() {
		System.out.println("Test Case 2");
		driver.findElement(By.xpath("(//ul[@class='navbar-nav']//descendant::a)[2]")).click();
		driver.findElement(By.linkText("Checkbox Demo")).click();
		boolean checkboxselected= driver.findElement(By.id("gridCheck")).isSelected();
		if(checkboxselected == false) {
			driver.findElement(By.id("gridCheck")).click();
		}
		boolean successmessage=driver.findElement(By.id("message-one")).isDisplayed();
		System.out.println(successmessage);
		List<WebElement> checkboxesList=driver.findElements(By.xpath("//input[contains(@id,'check-box')]"));
	    System.out.println(checkboxesList.size());
	    driver.findElement(By.id("button-two")).click();
	    driver.findElement(By.linkText("Select Input")).click();
	    driver.findElement(By.id("single-input-field")).click();
	    Select dropdown = new Select(driver.findElement(By.id("single-input-field")));
	    dropdown.selectByValue("Yellow");
	    Actions action =new Actions(driver);
	    action.keyDown(Keys.COMMAND).sendKeys("A").keyUp(Keys.COMMAND).perform();
	    action.sendKeys(Keys.ESCAPE).perform();
	    action.doubleClick(driver.findElement(By.linkText("Form Submit"))).build().perform();
	    action.contextClick(driver.findElement(By.id("validationCustom01"))).build().perform();
			
		
	}
 @AfterMethod
 public void closeBrowser() {
	//driver.quit();
 }
}
