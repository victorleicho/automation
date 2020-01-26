package cukes.web.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage {
	
	WebDriver driver;
	
	public ProductsPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement productList()
	{
		return driver.findElement(By.id("product-list"));
	}
	
	public List<WebElement> products()
	{
		return productList().findElements(By.tagName("li"));
	}

	public WebElement categoryTitle()
	{
		return driver.findElement(By.cssSelector("div[class='category-title']"));
	}
}
