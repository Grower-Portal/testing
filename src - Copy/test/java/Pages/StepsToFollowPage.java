package Pages;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import Utilities.CommonFunctions;
import Utilities.TestBase;

public class StepsToFollowPage extends TestBase {
	public StepsToFollowPage() {
		super();
		PageFactory.initElements(driver, this);
		
	}
	
@FindBy(xpath="//div[@id='menu-button']")
public WebElement menuButton;

@FindBy(xpath="//a[@href='/StepsToFollow']")
public WebElement stepsToFollow;

@FindBy(xpath="//h1[text()='How to Fill Out Your Application - Grower Portal']")
public WebElement stepsForApplication;

@FindBy(xpath="//ol[@id=\"steps-container\"]/li[contains(text(),'Access')]")
public WebElement txt_AccessApplicationForm;

@FindBy(xpath="//ol[@id=\"steps-container\"]/li[contains(text(),'Basic')]")
public WebElement txt_BasicInformation;

@FindBy(xpath="//ol[@id=\"steps-container\"]/li[contains(text(),'Detailed')]")
public WebElement txt_ProvideInformation;

@FindBy(xpath="//ol[@id=\"steps-container\"]/li[contains(text(),'Necessary')]")
public WebElement txt_UploadDocuments;

@FindBy(xpath="//ol[@id=\"steps-container\"]/li[contains(text(),'Review')]")
public WebElement txt_ReviewApplication;

@FindBy(xpath="//ol[@id=\"steps-container\"]/li[contains(text(),'Submit')]")
public WebElement txt_SubmitApplication;

@FindBy(xpath="//ol[@id=\"steps-container\"]/li[contains(text(),'Await')]")
public WebElement txt_AwaitConfirmation;

LoginPage lp = new LoginPage();

public void stepsToFollowmethod(Map<String, String> dataMap) {
	
	try {
		lp.navigationMenu(dataMap.get("menuOption"));
		CommonFunctions.clickElement(stepsToFollow);
		if (CommonFunctions.getValue(stepsForApplication).equalsIgnoreCase(dataMap.get("HowToFillApplication"))) {
				test.log(Status.PASS, "Content matched successfully :" + dataMap.get("HowToFillApplication"));
				
			} else {
			   
				test.log(Status.FAIL, "Content Mismatched for :" + CommonFunctions.getValue(stepsForApplication));
			}
		if (CommonFunctions.getValue(txt_AccessApplicationForm).equalsIgnoreCase(dataMap.get("AccessApplicationForm"))) {
			test.log(Status.PASS, "Content matched successfully :" + dataMap.get("txt_AccessApplicationForm"));
			
		} else {
		   
			test.log(Status.FAIL, "Content Mismatched for :" + CommonFunctions.getValue(txt_AccessApplicationForm));
		}
		if (CommonFunctions.getValue(txt_BasicInformation).equalsIgnoreCase(dataMap.get("BasicInformation"))) {
			test.log(Status.PASS, "Content matched successfully :" + dataMap.get("BasicInformation"));
			
		} else {
		   
			test.log(Status.FAIL, "Content Mismatched for :" + CommonFunctions.getValue(txt_BasicInformation));
		}
		if (CommonFunctions.getValue(txt_ProvideInformation).equalsIgnoreCase(dataMap.get("ProvideInformation"))) {
			test.log(Status.PASS, "Content matched successfully :" + dataMap.get("ProvideInformation"));
			
		} else {
		   
			test.log(Status.FAIL, "Content Mismatched for :" + CommonFunctions.getValue(txt_ProvideInformation));
		}
		if (CommonFunctions.getValue(txt_UploadDocuments).equalsIgnoreCase(dataMap.get("UploadDocuments"))) {
			test.log(Status.PASS, "Content matched successfully :" + dataMap.get("UploadDocuments"));
			
		} else {
		   
			test.log(Status.FAIL, "Content Mismatched for :" + CommonFunctions.getValue(txt_UploadDocuments));
		}
		if (CommonFunctions.getValue(txt_ReviewApplication).equalsIgnoreCase(dataMap.get("ReviewApplication"))) {
			test.log(Status.PASS, "Content matched successfully :" + dataMap.get("ReviewApplication"));
			
		} else {
		   
			test.log(Status.FAIL, "Content Mismatched for :" + CommonFunctions.getValue(txt_ReviewApplication));
		}
		if (CommonFunctions.getValue(txt_SubmitApplication).equalsIgnoreCase(dataMap.get("SubmitApplication"))) {
			test.log(Status.PASS, "Content matched successfully :" + dataMap.get("SubmitApplication"));
			
		} else {
		   
			test.log(Status.FAIL, "Content Mismatched for :" + CommonFunctions.getValue(txt_SubmitApplication));
		}
		if (CommonFunctions.getValue(txt_AwaitConfirmation).equalsIgnoreCase(dataMap.get("AwaitConfirmation"))) {
			test.log(Status.PASS, "Content matched successfully :" + dataMap.get("AwaitConfirmation"));
			
		} else {
		   
			test.log(Status.FAIL, "Content Mismatched for :" + CommonFunctions.getValue(txt_AwaitConfirmation));
		}
	
		
		}
		catch(Exception e) {
			test.log(Status.FAIL, "Unable to execute stepsToFollowmethod");
			e.getMessage();
			
		}

}
	

}
