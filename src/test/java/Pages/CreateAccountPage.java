package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utilities.CommonFunctions;

public class CreateAccountPage {
	
@FindBy(xpath="//input[@id = 'first-name']")
public WebElement firstName;

@FindBy(xpath="//input[@id = 'last-name']")
public WebElement lastName;

@FindBy(xpath="//input[@id = 'dob']")
public WebElement dateOfBirth;

@FindBy(xpath="//input[@id = 'enter-email']")
public WebElement enterEmail;

@FindBy(xpath="//input[@id = 'create-password']")
public WebElement createPassword;

@FindBy(xpath="//input[@id = 'confirm-password']")
public WebElement confirmPassword;

@FindBy(xpath="//input[@id = 'us-phone']")
public WebElement phoneNumber;

@FindBy(xpath="//input[@id = 'address']")
public WebElement address;

@FindBy(xpath = "//button[@type='button'][1]")
public WebElement verifyEmail;

@FindBy(xpath = "//button[@type='button'][2]")
public WebElement signUp;

@FindBy(xpath="//a[@class = 'back-to-login']")
public WebElement backToLogin;


public void createAccountmethod() {
	
	try {
		
		CommonFunctions.sendkeys(firstName, "Pravalika");
		CommonFunctions.sendkeys(lastName, "Reddy");
		CommonFunctions.sendkeys(dateOfBirth, "01/01/1985");
		CommonFunctions.sendkeys(enterEmail, "pravalikakatta957@gmail.com");
		CommonFunctions.sendkeys(createPassword, "Selenium@123");
		CommonFunctions.sendkeys(confirmPassword, "Selenium@123");
		CommonFunctions.sendkeys(phoneNumber, "+12254107188");
		CommonFunctions.sendkeys(address, "Baton Rouge");
		CommonFunctions.clickelement(signUp);
		CommonFunctions.clickelement(backToLogin);
	}
	catch(Exception e) {
		
		
	}
	
}
	}
		

