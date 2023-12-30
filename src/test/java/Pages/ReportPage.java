package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utilities.CommonFunctions;

public class ReportPage {
	
	
@FindBy(xpath="//div[@id='menu-button']")
public WebElement menuButton;

//@FindBy(xpath="//div[@id='menu-button']")
//public WebElement menuButton;

public void reportmethod() {
	
	try {
		
		CommonFunctions.clickelement(menuButton);
		//CommonFunctions.clickelement(reportPage);
	}
	catch(Exception e) {
		
	}
}
}


