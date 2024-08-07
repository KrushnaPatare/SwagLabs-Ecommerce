package testCase;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.swagLabs.pojo.BaseClass;
import com.swagLabs.pom.SwagLabCheckoutStepOnePage;
import com.swagLabs.pom.SwagLabsCartPage;
import com.swagLabs.pom.SwagLabsCheckoutStepTwoPage;
import com.swagLabs.pom.SwagLabsLoginPage;
import com.swagLabs.pom.SwagLabsProductpage;
import com.swagLabs.utilities.Parameterization;

@Listeners(com.swagLabs.utilities.Listeners.class)
public class SwagLabs6CheckoutOverviewPageTest extends BaseClass {

	@Parameters("browser")
	@BeforeMethod
	public void openCheckoutOverviewPageSetup(String browser) throws EncryptedDocumentException, InterruptedException, IOException {

		driver = BaseClass.openBrowser(browser);
		SwagLabsLoginPage swagLabsLoginPage = new SwagLabsLoginPage(driver);
		swagLabsLoginPage.enterUsername("standard_user");
		swagLabsLoginPage.enterPassword("secret_sauce");
		swagLabsLoginPage.clickOnLogin();
		SwagLabsProductpage swagLabsProductpage = new SwagLabsProductpage(driver);
		swagLabsProductpage.clickProductImage();
		swagLabsProductpage.clickOnAddToCartButton();
		swagLabsProductpage.clickOnCartButton();
		SwagLabsCartPage swagLabsCartPage = new SwagLabsCartPage(driver);
		swagLabsCartPage.clickOnCheckoutButton();
		SwagLabCheckoutStepOnePage swagLabCheckoutStepOnePage = new SwagLabCheckoutStepOnePage(driver);
		String fName = Parameterization.getExelData("checkout", 0, 0);
		String lName = Parameterization.getExelData("checkout", 1, 0);
		String pCode = Parameterization.getExelData("checkout", 2, 0);

		swagLabCheckoutStepOnePage.enterFirstname(fName);
		swagLabCheckoutStepOnePage.enterLastname(lName);
		swagLabCheckoutStepOnePage.enterPincode(pCode);
		swagLabCheckoutStepOnePage.clickContinueButton();
	}

	@AfterMethod
	public void closeBrowser(ITestResult result) {

		driver.quit();
	}

	@Test(priority = 1)
	public void openCheckoutOverview_PurchaseInformation_Checked() throws InterruptedException {

		SwagLabsCheckoutStepTwoPage swagLabsCheckoutStepTwoPage = new SwagLabsCheckoutStepTwoPage(driver);
		String actualSummary = swagLabsCheckoutStepTwoPage.getProductSummary();
		String expectedSummary = "QTYDescription\n" + "1\n" + "Sauce Labs Backpack\n"
				+ "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.\n"
				+ "$29.99\n" + "Payment Information\n" + "SauceCard #31337\n" + "Shipping Information\n"
				+ "Free Pony Express Delivery!\n" + "Price Total\n" + "Item total: $29.99\n" + "Tax: $2.40\n"
				+ "Total: $32.39\n" + "Cancel\n" + "Finish";

		System.out.println("actualSummary = " + actualSummary);
		System.out.println("expectedSummary = " + actualSummary);

		Assert.assertEquals(expectedSummary, actualSummary);
		Thread.sleep(100);
	}

	@Test(priority = 2)
	public void openCheckoutOverview_FinishButton_RedirectedToCheckoutComplete() throws InterruptedException {

		SwagLabsCheckoutStepTwoPage swagLabsCheckoutStepTwoPage = new SwagLabsCheckoutStepTwoPage(driver);
		swagLabsCheckoutStepTwoPage.clickOnfinishButton();

		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.saucedemo.com/checkout-complete.html";

		System.out.println("actualUrl = " + actualUrl);
		System.out.println("expectedUrl = " + expectedUrl);

		Assert.assertEquals(expectedUrl, actualUrl);
		Thread.sleep(100);
	}

	@Test(priority = 3)
	public void openCheckoutOverview_CancelButton_RedirectedToProductpage() throws InterruptedException {

		SwagLabsCheckoutStepTwoPage swagLabsCheckoutStepTwoPage = new SwagLabsCheckoutStepTwoPage(driver);
		swagLabsCheckoutStepTwoPage.clickOnCancelButton();
		
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.saucedemo.com/inventory.html";

		System.out.println("actualUrl = " + actualUrl);
		System.out.println("expectedUrl = " + expectedUrl);

		Assert.assertEquals(expectedUrl, actualUrl);
		Thread.sleep(100);
	}

}
