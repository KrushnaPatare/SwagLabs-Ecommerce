package testCase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.swagLabs.pojo.BaseClass;
import com.swagLabs.pom.SwagLabsCartPage;
import com.swagLabs.pom.SwagLabsLoginPage;
import com.swagLabs.pom.SwagLabsProductpage;
import com.swagLabs.utilities.AutoConstant;

@Listeners(com.swagLabs.utilities.Listeners.class)
public class SwagLabs4CartPageTest extends BaseClass {

	@Parameters("browser")
	@BeforeMethod()
	public void Setup(@Optional("chrome")String browser) throws InterruptedException 
	{
		BaseClass.login(browser, AutoConstant.username,AutoConstant.password);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@AfterMethod
	public void closeBrowser(ITestResult result) 
	{
		driver.quit();
	}

	@Test(priority = 1)
	public void verifyProductIsAddedToCart() throws InterruptedException {

		String actualProductName = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).getText();
		String expectedProductName = "Sauce Labs Backpack\n"
				+ "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.\n"
				+ "$29.99\n" + "Remove";

		Assert.assertEquals(actualProductName, expectedProductName);
		Thread.sleep(100);
	}

	@Test(priority = 2)
	public void verifyNavigationToCheckoutPage() throws InterruptedException {

		BaseClass.swagLabsCartPage.clickOncontinueShopping();
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.saucedemo.com/checkout-step-one.html";
		Assert.assertEquals(expectedUrl, actualUrl);
		Thread.sleep(100);
	}
/*
	@Test(priority = 3)
	public void clickCart_ContinueShoppingButton_RedirectedToHomepage() throws InterruptedException {

		SwagLabsCartPage swagLabsCartPage = new SwagLabsCartPage(driver);
		swagLabsCartPage.clickOncontinueShopping();
		String expectedUrl = driver.getCurrentUrl();
		String actualUrl = "https://www.saucedemo.com/inventory.html";
		System.out.println("expectedUrl = " + expectedUrl);
		System.out.println("actualUrl = " + actualUrl);
		Assert.assertEquals(expectedUrl, actualUrl);
		Thread.sleep(100);
	}

	@Test(priority = 4)
	public void clickCart_CheckoutButton_OpenedCheckoutpage() throws InterruptedException {

		SwagLabsCartPage swagLabsCartPage = new SwagLabsCartPage(driver);
		swagLabsCartPage.clickOnCheckoutButton();
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.saucedemo.com/checkout-step-one.html";
		System.out.println("expectedUrl = " + expectedUrl);
		System.out.println("actualUrl = " + actualUrl);
		Thread.sleep(100);
	}
*/
	
}
