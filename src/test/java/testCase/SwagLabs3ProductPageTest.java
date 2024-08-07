package testCase;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.swagLabs.pojo.BaseClass;
import com.swagLabs.pom.SwagLabsHomepage;
import com.swagLabs.pom.SwagLabsLoginPage;
import com.swagLabs.pom.SwagLabsProductpage;

@Listeners(com.swagLabs.utilities.Listeners.class)
public class SwagLabs3ProductPageTest extends BaseClass {

	@Parameters("browser")
	@BeforeMethod()
	public void openProductPageSetup(String browser) throws InterruptedException {

		driver = BaseClass.openBrowser(browser);
		SwagLabsLoginPage swagLabsLoginPage = new SwagLabsLoginPage(driver);
		swagLabsLoginPage.enterUsername("standard_user");
		swagLabsLoginPage.enterPassword("secret_sauce");
		swagLabsLoginPage.clickOnLogin();
	}

	@AfterMethod
	public void closeBrowser(ITestResult result) {

		driver.quit();
	}

	@Test(priority = 1)
	public void clickProduct_ProductImg_OpenedProductpage() throws InterruptedException {

		SwagLabsProductpage swagLabsProductpage = new SwagLabsProductpage(driver);
		swagLabsProductpage.clickProductImage();
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.saucedemo.com/inventory-item.html?id=4";
		System.out.println("expectedUrl = " + expectedUrl);
		System.out.println("actualUrl = " + actualUrl);
		Assert.assertEquals(expectedUrl, actualUrl);
		Thread.sleep(100);
	}

	@Test(priority = 2)
	public void clickProduct_ProductBanner_OpenedProductpage() throws InterruptedException {

		SwagLabsProductpage swagLabsProductpage = new SwagLabsProductpage(driver);
		swagLabsProductpage.clickProductBanner();
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.saucedemo.com/inventory-item.html?id=4";
		System.out.println("expectedUrl = " + expectedUrl);
		System.out.println("actualUrl = " + actualUrl);
		Assert.assertEquals(expectedUrl, actualUrl);
		Thread.sleep(100);
	}

	@Test(priority = 3)
	public void clickProduct_ProductBanner$Description$Price_Checked() throws InterruptedException {

		SwagLabsProductpage swagLabsProductpage = new SwagLabsProductpage(driver);
		swagLabsProductpage.clickProductBanner();
		String actualDescription = swagLabsProductpage.getProductDescription();
		String expectedDescription = "Sauce Labs Backpack\n"
				+ "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.\n"
				+ "$29.99\n" + "Add to cart";

		System.out.println("expectedDescription = " + expectedDescription);
		System.out.println("actualDescription = " + actualDescription);
		Assert.assertEquals(expectedDescription, actualDescription);
		Thread.sleep(100);
	}

	@Test(priority = 4)
	public void clickProduct_AddProductButton_AddedToCart() throws InterruptedException {

		SwagLabsProductpage swagLabsProductpage = new SwagLabsProductpage(driver);
		swagLabsProductpage.clickProductImage();
		swagLabsProductpage.clickOnAddToCartButton();
		String actualText = swagLabsProductpage.getCartNotification();
		String expectedText = "1";
		System.out.println("expectedText = " + expectedText);
		System.out.println("actualText = " + actualText);
		Assert.assertEquals(expectedText, actualText);
		Thread.sleep(100);
	}

	@Test(priority = 5)
	public void clickProduct_RemoveProductButton_RemovedFromCart() throws InterruptedException {

		SwagLabsProductpage swagLabsProductpage = new SwagLabsProductpage(driver);
		swagLabsProductpage.clickProductImage();
		swagLabsProductpage.clickOnAddToCartButton();
		Thread.sleep(1000);
		swagLabsProductpage.clickOnRemoveButton();
		boolean expectedCheck = true;
		boolean actualCheck = false;
		try {
			driver.findElement(By.xpath("span"));
		} catch (NoSuchElementException e) {
			actualCheck = true;
			System.out.println("NoSuchElementException");
		}

		System.out.println("expectedCheck = " + expectedCheck);
		System.out.println("actualCheck = " + actualCheck);
		Assert.assertEquals(expectedCheck, actualCheck);
		Thread.sleep(100);
	}

	@Test(priority = 6)
	public void clickProduct_ProductAddOrRemoveButton_Clickable() throws InterruptedException {

		SwagLabsProductpage swagLabsProductpage = new SwagLabsProductpage(driver);
		swagLabsProductpage.clickProductImage();
		String actualText = swagLabsProductpage.clickOnAddToCartButton();
		String expectedText = "Remove";
		System.out.println("expectedText = " + expectedText);
		System.out.println("actualText = " + actualText);
		Assert.assertEquals(expectedText, actualText);
		Thread.sleep(100);
	}

	@Test(priority = 7)
	public void clickProduct_BackToProductsButton_GoneToHomepage() throws InterruptedException {

		SwagLabsProductpage swagLabsProductpage = new SwagLabsProductpage(driver);
		swagLabsProductpage.clickProductImage();
		swagLabsProductpage.clickOnBackToProducts();
		String expextedUrl = "https://www.saucedemo.com/inventory.html";
		String actualUrl = driver.getCurrentUrl();
		System.out.println("expextedUrl = " + expextedUrl);
		System.out.println("actualUrl = " + actualUrl);
		Assert.assertEquals(expextedUrl, actualUrl);
		Thread.sleep(100);
	}

	@Test(priority = 8)
	public void clickCart_Clickable_OpenedCart() {

		SwagLabsHomepage SwagLabsHomepage = new SwagLabsHomepage(driver);
		SwagLabsHomepage.clickOnCartButton();
		String expectedTitle = "https://www.saucedemo.com/cart.html";
		String actualTitle = driver.getCurrentUrl();
		System.out.println(actualTitle);
		System.out.println(expectedTitle);
		Assert.assertEquals(actualTitle, expectedTitle);
	}

}
