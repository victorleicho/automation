package cukes.web.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BrandSpecificPage {
	
	WebDriver driver;
	
	public BrandSpecificPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public List<WebElement> productBrandName(String productBrandName)
	{
		return driver.findElements(By.cssSelector("a[href*='https://www.kurtgeiger.es/brands/"+productBrandName.toLowerCase()+"']"));
	}

}
