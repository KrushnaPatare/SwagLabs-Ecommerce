package testCase;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.swagLabs.pojo.BaseClass;
import com.swagLabs.pom.SwagLabCheckoutStepOnePage;
import com.swagLabs.pom.SwagLabsCartPage;
import com.swagLabs.pom.SwagLabsCheckoutComplete;
import com.swagLabs.pom.SwagLabsCheckoutStepTwoPage;
import com.swagLabs.pom.SwagLabsLoginPage;
import com.swagLabs.pom.SwagLabsProductpage;
import com.swagLabs.utilities.Parameterization;

public class SwagLabs7CheckoutCompletepageTest extends BaseClass {

	@Parameters("browser")
	@BeforeMethod
	public void openCheckoutCompletePageSetup(String browser) throws EncryptedDocumentException, IOException {

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
		SwagLabsCheckoutStepTwoPage swagLabsCheckoutStepTwoPage = new SwagLabsCheckoutStepTwoPage(driver);
		swagLabsCheckoutStepTwoPage.clickOnfinishButton();
	}

	@AfterMethod
	public void closeBrowser(ITestResult result) {

		driver.quit();
	}

	@Test(priority = 1)
	public void openCheckoutComplete_GreetInformation_Displyed() throws InterruptedException {

		SwagLabsCheckoutComplete swagLabsCheckoutComplete = new SwagLabsCheckoutComplete(driver);
		String actualGreetText = swagLabsCheckoutComplete.getGreetInformation();
		String expectedGreetText = "Thank you for your order!\n"
				+ "Your order has been dispatched, and will arrive just as fast as the pony can get there!\n"
				+ "Back Home";

		System.out.println("actualGreetText = " + actualGreetText);
		System.out.println("expectedGreetText = " + expectedGreetText);

		Assert.assertEquals(expectedGreetText, actualGreetText);
		Thread.sleep(100);
	}

	@Test(priority = 2)
	public void openCheckoutComplete_BackToHomeButton_RedirectedToProductpage() throws InterruptedException {

		SwagLabsCheckoutComplete swagLabsCheckoutComplete = new SwagLabsCheckoutComplete(driver);
		swagLabsCheckoutComplete.clickOnBackToHomeButton();

		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.saucedemo.com/inventory.html";

		System.out.println("actualUrl = " + actualUrl);
		System.out.println("expectedUrl = " + expectedUrl);

		Assert.assertEquals(expectedUrl, actualUrl);
		Thread.sleep(100);
	}

}
