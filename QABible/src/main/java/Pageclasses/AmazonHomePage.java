package Pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonHomePage {
	
	WebDriver driver;
	@FindBy(id = "twotabsearchtextbox") 
	WebElement searchbox;
	@FindBy(id="nav-search-submit-button")
	WebElement searchbutton;
	
	
	
	
	
	public AmazonHomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}





	public void searchProduct(String productname) {
		
		searchbox.sendKeys(productname);
		searchbutton.click();
	}

}
