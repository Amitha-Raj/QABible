package Pageclasses;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonProductDetailPage {
	WebDriver driver;
	By addtocartbuttonBy= By.xpath("(//input[@id='add-to-cart-button'])[2]");
	
	
	
	public AmazonProductDetailPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}



	public void clickonAddtocartButton() {
		String parenttab =driver.getWindowHandle();
		Set<String> tabs=driver.getWindowHandles();
		Iterator<String> i1=tabs.iterator();
		while(i1.hasNext()) {
			String childtab = i1.next();
			driver.switchTo().window(childtab);
		}
		driver.findElement(addtocartbuttonBy).click();
		driver.switchTo().window(parenttab);
		//driver.findElement(By.xpath())
	}

}
