package testCase;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.swagLabs.pojo.BaseClass;
import com.swagLabs.pom.SwagLabsHomepage;
import com.swagLabs.pom.SwagLabsLoginPage;
import com.swagLabs.utilities.AutoConstant;

@Listeners(com.swagLabs.utilities.Listeners.class)
public class SwagLabs2InventoryPageTest extends BaseClass 
{

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
	public void verifySortFunctionality() throws InterruptedException 
	{
		boolean checkAscendingOrder = BaseClass.swagLabsHomepage.sortInAscendingOrder();
		boolean checkDescendingOrder = BaseClass.swagLabsHomepage.sortInDescendingOrder();
		boolean checkLowToHigh = BaseClass.swagLabsHomepage.sortByLowToHighPrice();
		boolean checkHighToLow = BaseClass.swagLabsHomepage.sortByHighToLowPrice();
		SoftAssert sf = new SoftAssert();
		sf.assertTrue(checkAscendingOrder);
		sf.assertTrue(checkDescendingOrder);
		sf.assertTrue(checkLowToHigh);
		sf.assertTrue(checkHighToLow);
	}
	
	@Test(priority = 2)
	public void verifyUserIsAbleToNavigateToSocialMediaSites() throws InterruptedException 
	{
		String title1 = BaseClass.swagLabsHomepage.navigateToTwitterPage();
	
		String title2 = BaseClass.swagLabsHomepage.navigateToFacebookPage();
		String title3 = BaseClass.swagLabsHomepage.navigateToLinkedInPage();
		System.out.println(title1);
		System.out.println(title2);
		System.out.println(title3);
		String exptitle1 = "Sauce Labs (@saucelabs) / X";
		String exptitle2 = "Sauce Labs | San Francisco CA | Facebook";
		String exptitle3 = "Sauce Labs | LinkedIn";
		SoftAssert sf = new SoftAssert();
		sf.assertEquals(title1,exptitle1);
		sf.assertEquals(title2,exptitle2);
		sf.assertEquals(title3,exptitle3);
	}
	
	

}
