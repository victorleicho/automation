package cukes.web;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;

public class Utils {

	public void verifyProducts(List<WebElement> products) {
		for (WebElement product : products) {
	    	Assert.assertFalse(product.findElement(By.className("product-name")).getText().isEmpty());
	    	Assert.assertFalse(product.findElement(By.className("product-brand")).getText().isEmpty());
	    	//More assertions can be added 
		}
	}

}
