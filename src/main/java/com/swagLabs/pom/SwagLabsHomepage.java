package com.swagLabs.pom;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.swagLabs.pojo.BaseClass;

public class SwagLabsHomepage {
	
	WebDriver driver = BaseClass.driver;
	
		@FindBy (xpath = "//select[@class='product_sort_container']") private WebElement sortDropdown;
		@FindBy (xpath = "//div[@class='inventory_item_name']") private List<WebElement> productNames;
		@FindBy (xpath = "//div[@class='inventory_item_name']") private List<WebElement> prices;

		@FindBy (xpath = "//button[text()='Open Menu']") private WebElement openMenuButton;
		@FindBy (xpath = "//a[text()='All Items']") private WebElement allItemsButton;
		@FindBy (xpath = "//a[text()='About']") private WebElement aboutButton;
		@FindBy (xpath = "//a[text()='Logout']") private WebElement logoutButton;
		@FindBy (xpath = "//a[text()='Reset App State']") private WebElement resetAppStateButton;
		@FindBy (xpath = "//button[text()='Close Menu']") private WebElement closeMenuButton;
		
		
		@FindBy (xpath = "//div[@class='shopping_cart_container']") private WebElement cartButton;
		@FindBy (xpath = "(//button[text()='Add to cart'])") private List<WebElement> totalAddToCartButton;
		@FindBy (xpath = "(//button[text()='Remove'])[1]") private WebElement removeButton;

		@FindBy (xpath = "//span[@class='shopping_cart_badge']") private WebElement cartItemCounterNotification;
		@FindBy (xpath = "(//button[text()='Add to cart'])[1]") private WebElement addToCartSingle;
		
		@FindBy (xpath = "//a[@data-test='social-twitter']") private WebElement twitterButton;
		@FindBy (xpath = "//a[@data-test='social-facebook']") private WebElement facebookButton;
		@FindBy (xpath = "//a[@data-test='social-linkedin']") private WebElement linkediInButton;

		



		
		public SwagLabsHomepage (WebDriver driver) {
			
			PageFactory.initElements(driver, this);
		}
		


		
		public ArrayList <String> clickOnOpenMenuButton() {
			
			openMenuButton.click();
			ArrayList<String> actOpAll = new ArrayList<String>();
			actOpAll.add(allItemsButton.getText());
			actOpAll.add(aboutButton.getText());
			actOpAll.add(logoutButton.getText());
			actOpAll.add(resetAppStateButton.getText());
			actOpAll.add(closeMenuButton.getText());
			return actOpAll;
		}
		
		public void clickOnopenMenuButton() {
			
			openMenuButton.click();
		}
		public void clickOnAllItemsButton() {
			
			allItemsButton.click();
		}

		public void clickOnaboutButton() {
	
			aboutButton.click();
		}
		
		
		
		public void clickOnlogoutButton() {
			clickOnAllItemsButton();
			logoutButton.click();
		}
		
		public void clickOnresetAppStateButton() {
	
			resetAppStateButton.click();
		}

		public void clickOncloseMenuButton() {
	
			closeMenuButton.click();
		}
		
		public void clickOnCartButton() {
			
			cartButton.click();
		}
		
		public String navigateToTwitterPage() throws InterruptedException {
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", twitterButton);
			
			js.executeScript("arguments[0].click();", twitterButton);
			Thread.sleep(9000);
		
			String handler = driver.getWindowHandle();
			
			Set<String> handles = driver.getWindowHandles();
		    Iterator<String> a = handles.iterator();
		    String title = "";
		    while (a.hasNext()){
		    	
		    	String handle = a.next();
		    	driver.switchTo().window(handle);
		    	Thread.sleep(3000);
		    	String expectedTitle = "Sauce Labs (@saucelabs) / X";
		    	String actualTitle = driver.getTitle();
		    	
		    	if(expectedTitle.equals(actualTitle))
		    	{
					break;
		    	}
		    }
		    Thread.sleep(3000);
			title = driver.getTitle();
			driver.close();
			driver.switchTo().window(handler);
			Thread.sleep(3000);
		    return title;
		}
		
		public String navigateToFacebookPage() throws InterruptedException {
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", facebookButton);
			String handler = driver.getWindowHandle();
			Set<String> handles = driver.getWindowHandles();
		    Iterator<String> a = handles.iterator();
		    String title = "";
		    while (a.hasNext()){
		    	
		    	String handle = a.next();
		    	driver.switchTo().window(handle);
		    	Thread.sleep(3000);
		    	String expectedTitle = "Sauce Labs | San Francisco CA | Facebook";
		    	String actualTitle = driver.getTitle();
		    	
		    	if(expectedTitle.equals(actualTitle))
		    	{
					break;
		    	}
		    
			
		    }
		    Thread.sleep(3000);
			title = driver.getTitle();
			driver.close();
			driver.switchTo().window(handler);
		    return title;
		}
		
		public String navigateToLinkedInPage() throws InterruptedException {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", linkediInButton);
			String handler = driver.getWindowHandle();
			Set<String> handles = driver.getWindowHandles();
		    Iterator<String> a = handles.iterator();
		    String title = "";
		    while (a.hasNext()){
		    	
		    	String handle = a.next();
		    	driver.switchTo().window(handle);
		    	Thread.sleep(3000);
		    	String expectedTitle = "(14) Sauce Labs: Overview | LinkedIn";
		    	String actualTitle = driver.getTitle();
		    	
		    	if(expectedTitle.equals(actualTitle))
		    	{
					break;
		    	}
		    
			
		    }
		    Thread.sleep(3000);
			title = driver.getTitle();
			driver.close();
			driver.switchTo().window(handler);
		    return title;
		}
		
	
		
		public String clickOnSingleAddToCart() {
			Select sel = new Select(sortDropdown);
			sel.selectByVisibleText("Name (A to Z)");
			addToCartSingle.click();
			String value = addToCartSingle.getText();
			return value;
		}
		
	/*	public String clickOnAllAddToCartButton() {
			
			addToCartSingle.click();
			String value = addToCartSingle.getText();
			return value;
		}
	*/
		public String clickOnRemove() {
			
			addToCartSingle.click();
			removeButton.click();
			String value = addToCartSingle.getText();
			return value;
		}
		

		
		public List <WebElement> getAllSortOptions() throws InterruptedException {
			
			Select select = new Select(sortDropdown);
			List <WebElement> op =select.getOptions();
			return op;
		}
		
		
		public boolean sortInAscendingOrder() {

			Select sel = new Select(sortDropdown);
			sel.selectByVisibleText("Name (A to Z)");
			ArrayList<String> itemNames = new ArrayList<String>();
			itemNames.add("Sauce Labs Backpack");
			itemNames.add("Sauce Labs Bike Light");
			itemNames.add("Sauce Labs Bolt T-Shirt");

			boolean check = true;
			for (int i = 0; i < productNames.size() - 3; i++) {
				if (itemNames.get(i).equals(productNames.get(i).getText())) {} 
				else 
				{
					check = false;
				}

			}
			return check;
		}

		
		public boolean sortInDescendingOrder() {

			Select sel = new Select(sortDropdown);
			sel.selectByVisibleText("Name (Z to A)");
			ArrayList<String> itemNames = new ArrayList<String>();
			itemNames.add("Test.allTheThings() T-Shirt (Red)");
			itemNames.add("Sauce Labs Onesie");
			itemNames.add("Sauce Labs Fleece Jacket");
			
			boolean check = true;
			for (int i = 0; i < productNames.size() - 3; i++)
			{
				if (itemNames.get(i).equals(productNames.get(i).getText())) {}
				else 
				{
					check = false;
				}
			}
			return check;
		}	

		
		public boolean sortByHighToLowPrice() {
			
			Select select = new Select(sortDropdown);
			select.selectByVisibleText("Price (high to low)");
			ArrayList <String> cost = new ArrayList<String>();
			cost.add("$49.99");
			cost.add("$29.99");
			cost.add("$15.99");
	
			boolean check = true;
			for (int i = 0; i < prices.size() - 3; i++)
			{
				if (cost.get(i).equals(prices.get(i).getText())) {}
				else 
				{
					check = false;
				}
			}
			return check;
		}
		
		public boolean sortByLowToHighPrice() {
			
			Select select = new Select(sortDropdown);
			select.selectByVisibleText("Price (low to high)");
			ArrayList <String> cost = new ArrayList<String>();
			cost.add("$7.99");
			cost.add("$9.99");
			cost.add("$15.99");
	
			boolean check = true;
			for (int i = 0; i < prices.size() - 3; i++)
			{
				if (cost.get(i).equals(prices.get(i).getText())) {}
				else 
				{
					check = false;
				}
			}
			return check;
		}
		
	
		
		

		
		public int countCartItem() {
			
			String Items = cartItemCounterNotification.getText();
			int itemNum = Integer.parseInt(Items);
			return itemNum;
		}
		
		public int addAllProductsToCart() {
			
			int size = totalAddToCartButton.size();
			for(int i=size-1;i>=0;i--)
			{
				WebElement addToCart = totalAddToCartButton.get(i);
				addToCart.click();
			}
			String Items = cartItemCounterNotification.getText();
			int itemNum = Integer.parseInt(Items);
			return itemNum;
	    }
	


}
