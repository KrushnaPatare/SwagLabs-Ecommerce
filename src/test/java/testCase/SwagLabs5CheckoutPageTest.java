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
import com.swagLabs.pom.SwagLabsLoginPage;
import com.swagLabs.pom.SwagLabsProductpage;
import com.swagLabs.utilities.Parameterization;

@Listeners(com.swagLabs.utilities.Listeners.class)
public class SwagLabs5CheckoutPageTest extends BaseClass {

	@Parameters("browser")
	@BeforeMethod
	public void openCheckoutPageSetup(String browser) {

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
	}

	@AfterMethod
	public void closeBrowser(ITestResult result) {

		driver.quit();
	}

	@Test(priority = 1)
	public void clickCheckout_FirstnamePlaceholderText_Displayed() throws InterruptedException {

		SwagLabCheckoutStepOnePage swagLabCheckoutStepOnePage = new SwagLabCheckoutStepOnePage(driver);
		String actualPlaceHolderText = swagLabCheckoutStepOnePage.getFirstnamePlaceholderText();
		String expectedPlaceHolderText = "First Name";
		System.out.println("actualPlaceHolderText = " + actualPlaceHolderText);
		System.out.println("expectedPlaceHolderText = " + expectedPlaceHolderText);
		Assert.assertEquals(actualPlaceHolderText, expectedPlaceHolderText);
		Thread.sleep(100);
	}

	@Test(priority = 2)
	public void clickCheckout_LastnamePlaceholderText_Displayed() throws InterruptedException {

		SwagLabCheckoutStepOnePage swagLabCheckoutStepOnePage = new SwagLabCheckoutStepOnePage(driver);
		String actualPlaceHolderText = swagLabCheckoutStepOnePage.getLastnamePlaceholderText();
		String expectedPlaceHolderText = "Last Name";
		System.out.println("actualPlaceHolderText = " + actualPlaceHolderText);
		System.out.println("expectedPlaceHolderText = " + expectedPlaceHolderText);
		Assert.assertEquals(actualPlaceHolderText, expectedPlaceHolderText);
		Thread.sleep(100);
	}

	@Test(priority = 3)
	public void clickCheckout_PincodePlaceholderText_Displayed() throws InterruptedException {

		SwagLabCheckoutStepOnePage swagLabCheckoutStepOnePage = new SwagLabCheckoutStepOnePage(driver);
		String actualPlaceHolderText = swagLabCheckoutStepOnePage.getPincodePlaceholderText();
		String expectedPlaceHolderText = "Zip/Postal Code";
		System.out.println("actualPlaceHolderText = " + actualPlaceHolderText);
		System.out.println("expectedPlaceHolderText = " + expectedPlaceHolderText);
		Assert.assertEquals(actualPlaceHolderText, expectedPlaceHolderText);
		Thread.sleep(100);
	}

	@Test(priority = 4)
	public void clickCheckout_InvalidFirstname_DisplayedErrorMSG()
			throws EncryptedDocumentException, IOException, InterruptedException {

		SwagLabCheckoutStepOnePage swagLabCheckoutStepOnePage = new SwagLabCheckoutStepOnePage(driver);
		String fName = Parameterization.getExelData("checkout", 0, 0);
		String lName = Parameterization.getExelData("checkout", 1, 0);
		String pCode = Parameterization.getExelData("checkout", 2, 0);
		swagLabCheckoutStepOnePage.enterFirstname(fName);
		swagLabCheckoutStepOnePage.enterLastname(lName);
		swagLabCheckoutStepOnePage.enterPincode(pCode);
		swagLabCheckoutStepOnePage.clickContinueButton();
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.saucedemo.com/checkout-step-one.html";
		System.out.println("expectedUrl = " + expectedUrl);
		System.out.println("actualUrl = " + actualUrl);
		Assert.assertEquals(expectedUrl, actualUrl);
		Thread.sleep(100);
	}

	@Test(priority = 5)
	public void clickCheckout_InvalidLastname_DisplayedErrorMSG()
			throws InterruptedException, EncryptedDocumentException, IOException {

		SwagLabCheckoutStepOnePage swagLabCheckoutStepOnePage = new SwagLabCheckoutStepOnePage(driver);
		String fName = Parameterization.getExelData("checkout", 0, 1);
		String lName = Parameterization.getExelData("checkout", 1, 1);
		String pCode = Parameterization.getExelData("checkout", 2, 1);
		swagLabCheckoutStepOnePage.enterFirstname(fName);
		swagLabCheckoutStepOnePage.enterLastname(lName);
		swagLabCheckoutStepOnePage.enterPincode(pCode);
		swagLabCheckoutStepOnePage.clickContinueButton();
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.saucedemo.com/checkout-step-one.html";
		System.out.println("expectedUrl = " + expectedUrl);
		System.out.println("actualUrl = " + actualUrl);
		Assert.assertEquals(expectedUrl, actualUrl);
		Thread.sleep(100);
	}

	@Test(priority = 6)
	public void clickCheckout_InvalidZipcode_DisplayedErrorMSG()
			throws EncryptedDocumentException, IOException, InterruptedException {

		SwagLabCheckoutStepOnePage swagLabCheckoutStepOnePage = new SwagLabCheckoutStepOnePage(driver);
		String fName = Parameterization.getExelData("checkout", 0, 2);
		String lName = Parameterization.getExelData("checkout", 1, 2);
		String pCode = Parameterization.getExelData("checkout", 2, 2);

		swagLabCheckoutStepOnePage.enterFirstname(fName);
		swagLabCheckoutStepOnePage.enterLastname(lName);
		swagLabCheckoutStepOnePage.enterPincode(pCode);
		swagLabCheckoutStepOnePage.clickContinueButton();

		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.saucedemo.com/checkout-step-one.html";
		System.out.println("expectedUrl = " + expectedUrl);
		System.out.println("actualUrl = " + actualUrl);
		Assert.assertEquals(expectedUrl, actualUrl);
		Thread.sleep(100);
	}

	@Test(priority = 7)
	public void clickCheckout_1EmptyFirstN2EmptyLastN3EmptyZipcode_DisplayedWarningMSG() throws InterruptedException {

		SwagLabCheckoutStepOnePage swagLabCheckoutStepOnePage = new SwagLabCheckoutStepOnePage(driver);
		swagLabCheckoutStepOnePage.clickContinueButton();
		String actualMessage = swagLabCheckoutStepOnePage.getErrorMSG();
		String expectedMessage = "Error: First Name is required";
		System.out.println("expectedMessage = " + expectedMessage);
		System.out.println("actualMessage = " + actualMessage);
		Assert.assertEquals(expectedMessage, actualMessage);
		Thread.sleep(100);
	}

	@Test(priority = 8)
	public void clickCheckout_1FillFirstN2EmptyLastN3EmptyZipcode_DisplayedWarningMSG()
			throws InterruptedException, EncryptedDocumentException, IOException {

		SwagLabCheckoutStepOnePage swagLabCheckoutStepOnePage = new SwagLabCheckoutStepOnePage(driver);
		String fName = Parameterization.getExelData("checkout", 0, 0);
		swagLabCheckoutStepOnePage.enterFirstname(fName);
		swagLabCheckoutStepOnePage.clickContinueButton();
		String actualMessage = swagLabCheckoutStepOnePage.getErrorMSG();
		String expectedMessage = "Error: Last Name is required";
		System.out.println("expectedMessage = " + expectedMessage);
		System.out.println("actualMessage = " + actualMessage);
		Assert.assertEquals(expectedMessage, actualMessage);
		Thread.sleep(100);
	}

	@Test(priority = 9)
	public void clickCheckout_1FillFirstN2FillLastN3EmptyZipcode_DisplayedWarningMSG()
			throws EncryptedDocumentException, IOException, InterruptedException {

		SwagLabCheckoutStepOnePage swagLabCheckoutStepOnePage = new SwagLabCheckoutStepOnePage(driver);
		String fName = Parameterization.getExelData("checkout", 0, 0);
		String lName = Parameterization.getExelData("checkout", 1, 0);
		swagLabCheckoutStepOnePage.enterFirstname(fName);
		swagLabCheckoutStepOnePage.enterLastname(lName);
		swagLabCheckoutStepOnePage.clickContinueButton();
		String actualMessage = swagLabCheckoutStepOnePage.getErrorMSG();
		String expectedMessage = "Error: Postal Code is required";
		System.out.println("expectedMessage = " + expectedMessage);
		System.out.println("actualMessage = " + actualMessage);
		Assert.assertEquals(expectedMessage, actualMessage);
		Thread.sleep(100);
	}

	@Test(priority = 10)
	public void clickCheckout_ValData1FillFirstN2FillLastN3FillZipcode_OpenedCheckoutPage2()
			throws InterruptedException, EncryptedDocumentException, IOException {

		SwagLabCheckoutStepOnePage swagLabCheckoutStepOnePage = new SwagLabCheckoutStepOnePage(driver);
		String fName = Parameterization.getExelData("checkout", 0, 0);
		String lName = Parameterization.getExelData("checkout", 1, 0);
		String pCode = Parameterization.getExelData("checkout", 2, 0);
		swagLabCheckoutStepOnePage.enterFirstname(fName);
		swagLabCheckoutStepOnePage.enterLastname(lName);
		swagLabCheckoutStepOnePage.enterPincode(pCode);
		swagLabCheckoutStepOnePage.clickContinueButton();
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.saucedemo.com/checkout-step-two.html";
		System.out.println("expectedUrl = " + expectedUrl);
		System.out.println("actualUrl = " + actualUrl);
		Assert.assertEquals(expectedUrl, actualUrl);
		Thread.sleep(100);
	}

	@Test(priority = 11)
	public void clickCheckout_1EmptyFirstN2FillLastN3EmptyZipcode_DisplayedWarningMSG()
			throws EncryptedDocumentException, IOException, InterruptedException {

		SwagLabCheckoutStepOnePage swagLabCheckoutStepOnePage = new SwagLabCheckoutStepOnePage(driver);
		String lName = Parameterization.getExelData("checkout", 1, 0);
		swagLabCheckoutStepOnePage.enterLastname(lName);
		swagLabCheckoutStepOnePage.clickContinueButton();
		String actualMessage = swagLabCheckoutStepOnePage.getErrorMSG();
		String expectedMessage = "Error: First Name is required";
		System.out.println("expectedMessage = " + expectedMessage);
		System.out.println("actualMessage = " + actualMessage);
		Assert.assertEquals(expectedMessage, actualMessage);
		Thread.sleep(100);
	}

	@Test(priority = 12)
	public void clickCheckout_1EmptyFirstN2FillLastN3FillZipcode_DisplayedWarningMSG()
			throws EncryptedDocumentException, IOException, InterruptedException {

		SwagLabCheckoutStepOnePage swagLabCheckoutStepOnePage = new SwagLabCheckoutStepOnePage(driver);
		String lName = Parameterization.getExelData("checkout", 1, 0);
		String pCode = Parameterization.getExelData("checkout", 2, 0);

		swagLabCheckoutStepOnePage.enterLastname(lName);
		swagLabCheckoutStepOnePage.enterPincode(pCode);
		swagLabCheckoutStepOnePage.clickContinueButton();
		String actualMessage = swagLabCheckoutStepOnePage.getErrorMSG();
		String expectedMessage = "Error: First Name is required";
		System.out.println("expectedMessage = " + expectedMessage);
		System.out.println("actualMessage = " + actualMessage);
		Assert.assertEquals(expectedMessage, actualMessage);
		Thread.sleep(100);
	}

	@Test(priority = 13)
	public void clickCheckout_1EmptyFirstN2EmptyLastN3FillZipcode_DisplayedWarningMSG()
			throws InterruptedException, EncryptedDocumentException, IOException {

		SwagLabCheckoutStepOnePage swagLabCheckoutStepOnePage = new SwagLabCheckoutStepOnePage(driver);
		String pCode = Parameterization.getExelData("checkout", 2, 0);
		swagLabCheckoutStepOnePage.enterPincode(pCode);
		swagLabCheckoutStepOnePage.clickContinueButton();
		String actualMessage = swagLabCheckoutStepOnePage.getErrorMSG();
		String expectedMessage = "Error: First Name is required";
		System.out.println("expectedMessage = " + expectedMessage);
		System.out.println("actualMessage = " + actualMessage);
		Assert.assertEquals(expectedMessage, actualMessage);
		Thread.sleep(100);
	}

	@Test(priority = 14)
	public void clickCheckout_1FillFirstN2EmptyLastN3FillZipcode_DisplayedWarningMSG()
			throws EncryptedDocumentException, IOException, InterruptedException {

		kjtrxcb';iuytfvb'iuyg 
		'poiuygb/';lkjhbessage);
		Assert.assertEquals(expectedMessage, actualMessage);
		Thread.sleep(100);
	}

	@Test(priority = 15)
	public void clickCheckout_CancelButton_RedirectedToCartpage() throws InterruptedException {

		SwagLabCheckoutStepOnePage swagLabCheckoutStepOnePage = new SwagLabCheckoutStepOnePage(driver);
		swagLabCheckoutStepOnePage.clickCancelButton();
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.saucedemo.com/cart.html";
		System.out.println("expectedUrl = " + expectedUrl);
		System.out.println("actualUrl = " + actualUrl);
		Assert.assertEquals(expectedUrl, actualUrl);
		Thread.sleep(100);
	}

}
