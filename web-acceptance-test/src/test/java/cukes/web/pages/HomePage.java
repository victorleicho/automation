package cukes.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement brands()
	{
		return driver.findElement(By.cssSelector("a[href*='/shop-by-brand']"));
	}
	
	public WebElement men()
	{
		return driver.findElement(By.cssSelector("a[href*='/men/shoes']"));
	}
	
	public WebElement cookieAcceptButton()
	{
		return driver.findElement(By.xpath("//span[text()='I Accept']"));
	}
	
	public WebElement closeButton()
	{
		return driver.findElement(By.cssSelector("button[class='close']"));
	}
	
}
