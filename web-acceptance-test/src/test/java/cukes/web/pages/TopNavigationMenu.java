package cukes.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TopNavigationMenu {
	
	WebDriver driver;
	
	public TopNavigationMenu(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement advert()
	{
		return driver.findElement(By.cssSelector("img[src='https://kg-static.s3-eu-west-1.amazonaws.com/assets/kurtgeiger/SS19/Menu%20Ads%20Assets/WK41/WK41-Menu_Ads-mens.jpg']"));
	}
	
	public WebElement mensBoots()
	{
		return driver.findElement(By.linkText("Boots"));
	}

}
