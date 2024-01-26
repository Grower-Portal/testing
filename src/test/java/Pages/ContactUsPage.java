package Pages;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import Utilities.CommonFunctions;
import Utilities.TestBase;

public class ContactUsPage extends TestBase {
	public ContactUsPage() {
		super();
		PageFactory.initElements(driver, this);
	}
	
	
@FindBy(xpath="//div[@id='menu-button']")
public WebElement menuButton;

@FindBy(xpath="//a[@href='/ContactUs']")
public WebElement contactusBtn;

//@FindBy(xpath="//div[@id='contact-container']")
//public WebElement contactusContainer;

@FindBy(xpath="//h1[text()='Contact Us']")
public WebElement contactUsTxt;

@FindBy(xpath="//span[@id='phone']")
public WebElement yourPhoneNum;

@FindBy(xpath="//span[@id='email']")
public WebElement yourMailAddr;

@FindBy(xpath="//p[contains(text(), 'inquiries')]")
public WebElement descriptionTxt;

@FindBy(xpath="//span[@class='chat-link']")
public WebElement startChat;


//@FindBy(xpath="//span[@class='help-icon']")
//public WebElement helpText;


LoginPage lp = new LoginPage();


public void contactmethod(Map<String, String> dataMap) {
	
	
	try {
		lp.navigationMenu(dataMap.get("menuOption"));
		if (CommonFunctions.getValue(contactUsTxt).equalsIgnoreCase(dataMap.get("contactUsText"))) {
			test.log(Status.PASS, "Content matched successfully :" + dataMap.get("contactUsText"));
			
		} else {
		   
			test.log(Status.FAIL, "Content Mismatched for :" + CommonFunctions.getValue(contactUsTxt));
		}
	
	}
	catch(Exception e) {
		test.log(Status.FAIL, "Unable to execute contactmethod");
		e.getMessage();
		
	}
}
}


