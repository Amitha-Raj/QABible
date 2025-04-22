package Testscripts;

import org.testng.annotations.Test;

import Pageclasses.AmazonHomePage;
import Pageclasses.AmazonProductDetailPage;
import Pageclasses.AmazonProductListingPage;

import java.awt.Window.Type;
import java.sql.Driver;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class QAbibletestcases extends Baseclass{
	WebDriver driver;
	
	AmazonHomePage homePage;
	AmazonProductListingPage productListingPage;
	AmazonProductDetailPage  productDetailPage;
	@BeforeMethod // to repeat before each test cases
	@Parameters({"browser"})
	public void initialistation(String browser) throws Exception {
		driver = browserinitialisation(browser);
		driver.manage().window().maximize();
		homePage = new AmazonHomePage(driver);
		productListingPage= new AmazonProductListingPage(driver);
		productDetailPage=new AmazonProductDetailPage(driver);
		driver.get("https://selenium.qabible.in");// to load a url 
		System.out.println("before method");
	
		
	}
	
	
	@AfterMethod
	public void close() {
		
		//driver.quit();
		System.out.println("after method");
	}
	
	@Test(priority = 1)// to a run a test case
	public void tc01() throws Exception {
		System.out.println("test case 1");
		/* driver.navigate().to("https://www.flipkart.com");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();*/
		driver.navigate().to("https://selenium.qabible.in/simple-form-demo.php");
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("single-input-field")));
		driver.findElement(By.id("single-input-field")).sendKeys("Amitha Raj");
		driver.findElement(By.id("button-one")).click();
		boolean buttonstatus = driver.findElement(By.id("button-one")).isDisplayed();
		Assert.assertEquals(buttonstatus,true);
		//driver.navigate().to("https://www.amazon.in/");
		//driver.findElement(By.name("field-keywords")).sendKeys("computer");
		//driver.findElement(By.className("nav-input nav-progressive-attribute")).click();
		//driver.findElement(By.tagName("input")).click();
		//driver.navigate().to("https://selenium.qabible.in/simple-form-demo.php");
		driver.findElement(By.linkText("Simple Form Demo")).click();
		driver.findElement(By.partialLinkText("Checkbox")).click();
		
		List<WebElement> menuoptionsElement= driver.findElements(By.xpath("//li[@class='list-group-item']//child::a"));
		System.out.println(menuoptionsElement.size());
		
		boolean buttonstatus1=driver.findElement(By.id("button-two")).isEnabled();
		System.out.println("button status "+ buttonstatus1);
		
		boolean buttonfind=driver.findElement(By.id("button-two")).isDisplayed();
		System.out.println("button find "+ buttonfind);
		
		boolean checkboxstatus=driver.findElement(By.xpath("//input[@id='gridCheck']")).isSelected();
		System.out.println("checkbox status "+ checkboxstatus);
		
		driver.findElement(By.linkText("Simple Form Demo")).click();
		String buttonlabelString= driver.findElement(By.id("button-one")).getText();
		System.out.println(buttonlabelString);
		
		String buttonattributevalue = driver.findElement(By.id("button-one")).getAttribute("type");
		System.out.println(buttonattributevalue);
		
		String buttonattributevalue1 = driver.findElement(By.id("button-one")).getDomAttribute("type");
		System.out.println(buttonattributevalue1);
		
		driver.findElement(By.xpath("//a[text()='Select Input']")).click();
		// Select Class
		// used to automate drop downs with select tag we use select class.
		//initalise an object for select class for this and using the object we can select the values of dropdown
		
		Select dropdoSelect = new Select(driver.findElement(By.id("single-input-field")));
		dropdoSelect.selectByValue("Red");
		dropdoSelect.selectByVisibleText("Yellow");
	}
	
	@Test(priority = 2)
	public void tc02() {
		System.out.println("test case 2");
		//Action class
		//used to automate mouse and keyboard events
		driver.navigate().to("https://www.globalsqa.com/demo-site/draganddrop/");
		Actions actions= new Actions(driver);
	    // Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@class='demo-frame lazyloaded']")));
		
		
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']")));//to enter into iframe to locate webelements inside iframe
		WebElement source = driver.findElement(By.xpath("(//ul[@id='gallery']//descendant::img)[1]")) ;
	    
		WebElement destination=driver.findElement(By.id("trash"));
		actions.dragAndDrop(source, destination).build().perform(); // we need to write.build().perform() for action to perform mouse events
		//and .perform() for keyboard events
		driver.switchTo().defaultContent();//to comeback from iframe 
		
		//right click
		
		//actions.contextClick().build().perform();
		
		//hover
		actions.moveToElement(driver.findElement(By.xpath("//span[text()='Sortable']")));
		
		//keyboard Actions
		
		actions.keyDown(Keys.COMMAND).sendKeys("A").keyUp(Keys.COMMAND).perform();
		actions.sendKeys(Keys.ESCAPE).perform();
		actions.doubleClick(driver.findElement(By.xpath("//span[text()='Sortable']"))).build().perform();
		 
		}
	
	@Test(dataProvider = "dataprovider")
public void tc03(String a,String b) {
		driver.navigate().to("https://selenium.qabible.in/simple-form-demo.php");
		driver.findElement(By.id("value-a")).sendKeys(a);
		driver.findElement(By.id("value-b")).sendKeys(b);
		driver.findElement(By.id("button-two")).click();
	}
	@DataProvider(name = "dataprovider")
	public Object[][] testdataProvider() {
		Object[][] testdataObjects =new Object[4][2];
		testdataObjects[0][0]= "10";
		testdataObjects[0][1]= "20";
		testdataObjects[1][0]= "30";
		testdataObjects[1][1]= "40";
		testdataObjects[2][0]= "50";
		testdataObjects[2][1]= "-30";
		testdataObjects[3][0]= "100";
		testdataObjects[3][1]= "110";
		return testdataObjects;
		
	}
	@BeforeSuite
	public void  beforesuitemethod() {
		System.out.println("before suitemethod ");
	}
	@AfterSuite
	public void  aftersuitemethod() {
		System.out.println("after suite method");
	}
	@BeforeTest
	public void beforeTestMethod() {
		System.out.println("before test method");
	}
	@AfterTest
	public void afterTestMethod() {
		System.out.println("after test method");
	}
	 @BeforeClass
	public void beforeclassmethod() {
		System.out.println("before class method");
	}
	 @AfterClass
	 public void afterclassmethod() {
			System.out.println("after class method");
		}
	 @BeforeGroups
	 public void beforegroupmethod() {
			System.out.println("before group method");
		}
	 @AfterGroups
	 public void aftergroupmethod() {
			System.out.println("after group method");
		}
	 @Test
	 public void tc04() {
		 driver.navigate().to("https://www.amazon.in/");
		 homePage.searchProduct("iphone");
		 productListingPage.clickonProduct();
		 productDetailPage.clickonAddtocartButton();
	 }

}

