package com.swagLabs.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabCheckoutStepOnePage {
	
	@FindBy (xpath = "//input[@name='firstName']") 
	private WebElement firstName;
	@FindBy (xpath = "//input[@name='lastName']")
	private WebElement lastName;
	@FindBy (xpath = "//input[@name='postalCode']")
	private WebElement pincode;
	@FindBy (xpath = "//button[@name='cancel']")
	private WebElement cancelButton;
	@FindBy (xpath = "//input[@name='continue']")
	private WebElement cotinueButton;
	@FindBy (xpath = "//h3[@data-test='error']")
	private WebElement errorMSG;
	
	public SwagLabCheckoutStepOnePage(WebDriver driver)
	{PageFactory.initElements(driver, this);}
	
	public String getFirstnamePlaceholderText() {
		String actualPlaceHolderText = firstName.getAttribute("placeholder");
		return actualPlaceHolderText;
	}
	
	public String getLastnamePlaceholderText() {
		String actualPlaceHolderText = lastName.getAttribute("placeholder");
		return actualPlaceHolderText;
	}
	
	public String getPincodePlaceholderText() {
		String actualPlaceHolderText = pincode.getAttribute("placeholder");
		return actualPlaceHolderText;
	}
	
	public void clickCancelButton() {
		cancelButton.click();
	}
	
	public void clickContinueButton() {
		cotinueButton.click();
	}
	
	public void enterFirstname(String fName) {
		firstName.sendKeys(fName);
	}
	
	public void enterLastname(String lName) {
		lastName.sendKeys(lName);
	}
	
	public void enterPincode(String pCode) {
		pincode.sendKeys(pCode);
	}

	public String getErrorMSG() {
		String text = errorMSG.getText();
		return text;
	}

}
