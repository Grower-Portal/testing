package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utilities.CommonFunctions;

public class AddApplicationPage {
	
	
@FindBy(xpath="//div[@id='menu-button']")
public WebElement menuButton;

@FindBy(xpath="//label[contains(text(),'Producer Name')]/following-sibling::input[@type='text']")
public WebElement producerName;


@FindBy(xpath="//label[contains(text(),'Producer Entity Name')]/following-sibling::input[@type='text']")
public WebElement producerEntityName;


@FindBy(xpath="(//input[@type='text'])[3]")
public WebElement countryOfResidence;

@FindBy(xpath="(//input[@type='text'])[4]")
public WebElement producerAddress;

@FindBy(xpath="//label[text()='Underserved Status:']/following-sibling::select")
public WebElement underservedStatus;

@FindBy(xpath="//input[@type='number']")
public WebElement baselineYield;

@FindBy(xpath="//label[text()='Primary Reason for Applying:']/following-sibling::select")
public WebElement primaryReason;

@FindBy(xpath="//label[contains(text(),'On-Farm?:')]/following-sibling::select")
public WebElement onform;


public void addApplicationmethod() {
	
	try {
		
		CommonFunctions.clickelement(menuButton);
		CommonFunctions.sendkeys(producerName, "Pravalika");
		CommonFunctions.sendkeys(producerEntityName, "XXXXX");
		CommonFunctions.sendkeys(countryOfResidence, "United States");
		CommonFunctions.sendkeys(producerAddress, "Louisiana");
		CommonFunctions.sendkeys(underservedStatus, "XXXXXX");
		CommonFunctions.sendkeys(baselineYield, "XXXXXXX");
		
	}
	catch(Exception e) {
		
		
	}
	
}
	}


