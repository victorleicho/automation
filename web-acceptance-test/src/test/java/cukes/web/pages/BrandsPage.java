package cukes.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BrandsPage {
	
	WebDriver driver;
	
	public BrandsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement allBrandsTab()
	{
		return driver.findElement(By.id("tab1"));
	}
	
	public WebElement aToDBrands()
	{
		return allBrandsTab().findElement(By.xpath("//div/h3[text()='a-d']/../ul"));
	}
	
	public WebElement aBrandInAllBrands(String brand)
	{
		return allBrandsTab().findElement(By.cssSelector("a[href*='https://www.kurtgeiger.es/brands/"+brand.toLowerCase()+"']"));
	}
}
