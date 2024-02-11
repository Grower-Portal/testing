package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.CommonFunctions;
import Utilities.TestBase;

public class ForgetPasswordPage extends TestBase {
	public ForgetPasswordPage() {
		super();
		PageFactory.initElements(driver, this);
	}
	
	
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
		CommonFunctions.clickElement(forgotPassword);
		CommonFunctions.enterText(email, "pravalikakatta957@gmail.com");
		CommonFunctions.clickElement(resetPassword);
		
	}
	catch(Exception e) {
		e.printStackTrace();	
		
	}
	
}
	}


