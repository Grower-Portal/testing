package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.CommonFunctions;
import Utilities.TestBase;

public class AboutPage extends TestBase  {
	public AboutPage() {
			super();
			PageFactory.initElements(driver, this);
		}

	
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
	

