package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utilities.CommonFunctions;

public class ForgetPasswordPage {
	
@FindBy(xpath="//p[@class= 'forgot-password']")
public WebElement forgotPassword;

//@FindBy(xpath="//input[@id= 'userName']")
//public WebElement userName;

@FindBy(xpath="//input[@id= 'email']")
public WebElement email;

@FindBy(xpath="//button[@type = 'button")
public WebElement resetPassword;


public void forgetPasswordmethod() {
	
	try {
		CommonFunctions.clickelement(forgotPassword);
		CommonFunctions.sendkeys(email, "pravalikakatta957@gmail.com");
		CommonFunctions.clickelement(resetPassword);
		
	}
	catch(Exception e) {
		
		
	}
	
}
	}


