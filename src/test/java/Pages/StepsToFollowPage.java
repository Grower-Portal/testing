package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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


public void stepsToFollowmethod() {
	
	try {
		
		CommonFunctions.clickelement(menuButton);
		CommonFunctions.clickelement(stepsToFollow);
	}
	catch(Exception e) {
		
	}
}
	

}
