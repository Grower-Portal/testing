package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utilities.CommonFunctions;

public class AboutPage {

	
@FindBy(xpath="//div[@id='menu-button']")
public WebElement menuButton;


//@FindBy(xpath="//div[@id='menu-button']")  //correction needed add xpath of about button
//public WebElement menuButton;

public void aboutmethod() {
	
	try {
		
		
		//CommonFunctions.sendkeys(password, "123456"); //edit
		CommonFunctions.clickelement(menuButton);
	}
	catch(Exception e) {
		
	}
}
}
	

