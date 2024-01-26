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
public WebElement stepOne;

@FindBy(xpath="//ol[@id=\"steps-container\"]/li[contains(text(),'Basic')]")
public WebElement stepTwo;

@FindBy(xpath="//ol[@id=\"steps-container\"]/li[contains(text(),'Detailed')]")
public WebElement stepThree;

@FindBy(xpath="//ol[@id=\"steps-container\"]/li[contains(text(),'Necessary')]")
public WebElement stepFour;

@FindBy(xpath="//ol[@id=\"steps-container\"]/li[contains(text(),'Review')]")
public WebElement stepFive;

@FindBy(xpath="//ol[@id=\"steps-container\"]/li[contains(text(),'Submit')]")
public WebElement stepSix;

@FindBy(xpath="//ol[@id=\"steps-container\"]/li[contains(text(),'Await')]")
public WebElement stepSeven;

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
		
		}
		catch(Exception e) {
			test.log(Status.FAIL, "Unable to execute stepsToFollowmethod");
			e.getMessage();
			
		}

}
	

}
