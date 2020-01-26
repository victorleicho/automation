package cukes.steps;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cukes.web.Utils;
import cukes.web.pages.BrandSpecificPage;
import cukes.web.pages.BrandsPage;
import cukes.web.pages.HomePage;
import cukes.web.pages.MensBootsPage;
import cukes.web.pages.MensPage;
import cukes.web.pages.TopNavigationMenu;

public class TestSteps {
	
	WebDriver driver;
	
	List<String> allBrandsAtoD = Arrays.asList("Aldo","Anne Klein","Ash","Barbour", "Barkers","Birkenstock"
			,"Boss","Carvela","Carvela Comfort","Champion","Chie Mihara","Church","Cole Haan","DKNY");
	
	public TestSteps() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@After
	public void cleanUp()
	{
		driver.close();
	}

	
	@Given("^I am on the homepage$")
	public void i_am_on_the_homepage() throws Throwable {

		driver.get("https://www.kurtgeiger.es/");
		driver.manage().window().maximize();
	}

	@When("^I select brand category from the header$")
	public void i_select_brand_category_from_the_header() throws Throwable {
		HomePage home = new HomePage(driver);
		home.cookieAcceptButton().click();
		home.brands().click();
	}

	@Then("^I should see the list of brands$")
	public void i_should_see_the_list_of_brands() throws Throwable {
	   BrandsPage brandPage = new BrandsPage(driver);
	   WebElement aToDBrands = brandPage.aToDBrands();
	   
	   String[] split = aToDBrands.getText().split("\n");
	   
	   ArrayList<String> actualListOfBrandsAtoD = new ArrayList<String>();
	   
	   for (String brand : split) {
		   
		   actualListOfBrandsAtoD.add(brand);
	}
	   assertEquals(allBrandsAtoD,actualListOfBrandsAtoD);
	   
	}

	@Then("^I select \"([^\"]*)\" brand from the list$")
	public void i_select_brand_from_the_list(String brand) throws Throwable {
	    BrandsPage brandPage = new BrandsPage(driver);
	    
	    brandPage.aBrandInAllBrands(brand).click();
	}

	@Then("^I should see the list of products from \"([^\"]*)\"$")
	public void i_should_see_the_list_of_products_from(String productBrandName) throws Throwable {
		BrandSpecificPage brand = new BrandSpecificPage(driver);
		
		List<WebElement> productBrandDisplayed = brand.productBrandName(productBrandName);
		
		for (int i = 1; i < productBrandDisplayed.size(); i++) {
			productBrandDisplayed.get(i).getText().equalsIgnoreCase(productBrandName);
		}
	}
	
	@Given("^I select men category from the header$")
	public void i_select_men_category_from_the_header() throws Throwable {
	    HomePage home = new HomePage(driver);
	    home.men().click();
	}

	@Then("^I should see the list of products$")
	public void i_should_see_the_list_of_products() throws Throwable {
	    MensPage mensPage = new MensPage(driver);
	    List<WebElement> products = mensPage.products();
	    products.size();
	    Utils productVerificationUtil = new Utils();
	    
	    productVerificationUtil.verifyProducts(products);
	    
	    assertTrue(mensPage.categoryTitle().isDisplayed());
	    assertTrue(mensPage.categoryTitle().getText().equalsIgnoreCase("Men's Shoes"));
	}


	@When("^I hover over a main navigation item$")
	public void i_hover_over_a_main_navigation_item() throws Throwable {
		HomePage home = new HomePage(driver);
		
		if (home.closeButton().isDisplayed()) {
			home.closeButton().click();
		}
	    
		Actions action = new Actions(driver);
		action.moveToElement(home.men()).perform();
		
	}

	@Then("^I should see an advert from Fred Hopper$")
	public void i_should_see_an_advert_from_Fred_Hopper() throws Throwable {
		
		HomePage home = new HomePage(driver);
		Actions action = new Actions(driver);
		action.moveToElement(home.men()).perform();
		
		TopNavigationMenu menu = new TopNavigationMenu(driver);
	    assertTrue(menu.advert().isDisplayed());
	}

	@Then("^I select a sub navigation link from the drop down$")
	public void i_select_a_sub_navigation_link_from_the_drop_down() throws Throwable {
		TopNavigationMenu menu = new TopNavigationMenu(driver);
		menu.mensBoots().click();
	}

	@Then("^I should see another list of products$")
	public void i_should_see_another_list_of_products() throws Throwable {
		MensBootsPage mensBootsPage = new MensBootsPage(driver);
	    List<WebElement> products = mensBootsPage.products();
	    products.size();
	    Utils productVerificationUtil = new Utils();
	    
	    productVerificationUtil.verifyProducts(products);
	    
	    assertTrue(mensBootsPage.categoryTitle().isDisplayed());
	    assertTrue(mensBootsPage.categoryTitle().getText().equalsIgnoreCase("Men's Boots"));
	}

}
