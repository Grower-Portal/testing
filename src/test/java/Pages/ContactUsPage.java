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
public WebElement txt_contactUsTxt;

@FindBy(xpath="//span[@id='phone']")
public WebElement txt_yourPhoneNum;

@FindBy(xpath="//span[@id='email']")
public WebElement txt_yourMailAddr;

@FindBy(xpath="//p[contains(text(), 'inquiries')]")
public WebElement txt_emaildescriptionTxt;

@FindBy(xpath="//span[@class='chat-link']")
public WebElement link_startChat;


//@FindBy(xpath="//span[@class='help-icon']")
//public WebElement helpText;


LoginPage lp = new LoginPage();


public void contactmethod(Map<String, String> dataMap) {
	
	
	try {
		Thread.sleep(2000);
		lp.navigationMenu(dataMap.get("menuOption"));
		if (CommonFunctions.getValue(txt_contactUsTxt).equalsIgnoreCase(dataMap.get("contactUsText"))) {
			test.log(Status.PASS, "Content matched successfully :" + dataMap.get("contactUsText"));
			
		} else {
		   
			test.log(Status.FAIL, "Content Mismatched for :" + CommonFunctions.getValue(txt_contactUsTxt));
		}
		if (CommonFunctions.getValue(txt_yourPhoneNum).equalsIgnoreCase(dataMap.get("PhoneNumber"))) {
			test.log(Status.PASS, "Content matched successfully :" + dataMap.get("PhoneNumber"));
			
		} else {
		   
			test.log(Status.FAIL, "Content Mismatched for :" + CommonFunctions.getValue(txt_yourPhoneNum));
		}
		if (CommonFunctions.getValue(txt_yourMailAddr).equalsIgnoreCase(dataMap.get("Email"))) {
			test.log(Status.PASS, "Content matched successfully :" + dataMap.get("Email"));
			
		} else {
		   
			test.log(Status.FAIL, "Content Mismatched for :" + CommonFunctions.getValue(txt_yourMailAddr));
		}
		if (CommonFunctions.getValue(txt_emaildescriptionTxt).equalsIgnoreCase(dataMap.get("EmailText"))) {
			test.log(Status.PASS, "Content matched successfully :" + dataMap.get("EmailText"));
			
		} else {
		   
			test.log(Status.FAIL, "Content Mismatched for :" + CommonFunctions.getValue(txt_emaildescriptionTxt));
		}
		if (CommonFunctions.getValue(link_startChat).equalsIgnoreCase(dataMap.get("ChatUS"))) {
			test.log(Status.PASS, "Content matched successfully :" + dataMap.get("ChatUS"));
			
		} else {
		   
			test.log(Status.FAIL, "Content Mismatched for :" + CommonFunctions.getValue(link_startChat));
		}
		
		
	
	}
	catch(Exception e) {
		test.log(Status.FAIL, "Unable to execute contactmethod");
		e.getMessage();
		
	}
}
}


