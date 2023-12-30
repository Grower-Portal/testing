package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utilities.CommonFunctions;

public class ContactUsPage {
	
	
@FindBy(xpath="//div[@id='menu-button']")
public WebElement menuButton;

//@FindBy(xpath="//div[@id='menu-button']")
//public WebElement menuButton;

public void contactmethod() {
	
	try {
		
	
		CommonFunctions.clickelement(menuButton);
	}
	catch(Exception e) {
		
	}
}
}


