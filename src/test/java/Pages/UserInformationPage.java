package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.CommonFunctions;
import Utilities.TestBase;

public class UserInformationPage extends TestBase {
	public UserInformationPage() {
		super();
		PageFactory.initElements(driver, this);
	}

	
@FindBy(xpath="//div[@id='menu-button']")
public WebElement menuButton;

@FindBy(xpath="//a[@href='/UserInformation']")
public WebElement userInformation;

@FindBy(xpath="//div[@id='user-info-container']")
public WebElement userInfoContainer;


public void userInformationmethod() {
	
	try {
		
		CommonFunctions.clickelement(menuButton);
		CommonFunctions.clickelement(userInformation);
		CommonFunctions.clickelement(userInfoContainer);
		
	}
	catch(Exception e) {
		
	}
}

}
