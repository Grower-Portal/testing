package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.CommonFunctions;
import Utilities.TestBase;

public class ContactUsPage extends TestBase {
	public ContactUsPage() {
		super();
		PageFactory.initElements(driver, this);
	}
	
	
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


