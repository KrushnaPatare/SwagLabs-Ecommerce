package testCase;

import java.io.IOException;
import java.time.Duration;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.swagLabs.pojo.BaseClass;
import com.swagLabs.utilities.AutoConstant;
import com.swagLabs.utilities.DataProviders;
import com.swagLabs.utilities.XLUtility;

@Listeners(com.swagLabs.utilities.Listeners.class)
public class SwagLabs1LoginPageTest extends BaseClass {
	
	@Parameters({"browser"})
	@BeforeMethod()
	public void setUp(@Optional("chrome") String browser) 
	{
		BaseClass.openBrowser(browser);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}


	
	
	
	@Test(dataProvider = "loginData", dataProviderClass=DataProviders.class)
	public void checkLoginFunctionality(String testCaseName, String user, String pass) throws InterruptedException, IOException {

		System.out.println(testCaseName);

		swagLabsLoginPage.enterUsername(user);
		swagLabsLoginPage.enterPassword(pass);
	/*	
		String screenshotDestinationPath = BaseClass.screenshot.takeScreenshot(driver, "swagLabsLoginPage");
		 BaseClass.listners.test.info("Username entered./nPassword entered.",
				MediaEntityBuilder.createScreenCaptureFromPath(screenshotDestinationPath).build());
	*/	
		Thread.sleep(1000);
		swagLabsLoginPage.clickOnLogin();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.saucedemo.com/inventory.html";
		Assert.assertEquals(actualUrl, expectedUrl);
	}
	
	@AfterMethod
	public void closeBrowser(ITestResult result)
	{
		try 
		{
		BaseClass.logout();
		driver.quit();
		}
		
		catch(Exception e) 
		{
			driver.quit();
		}
	}
	
	
}
