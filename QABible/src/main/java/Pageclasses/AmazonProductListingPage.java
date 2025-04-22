package Pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonProductListingPage {
	WebDriver driver;
	@FindBy(xpath = "(//h2[@class='a-size-medium a-spacing-none a-color-base a-text-normal']//child::span)[3]")
	WebElement product;
	
	
	public AmazonProductListingPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}


	public void clickonProduct() {
		product.click();
	}

}
