package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utilities.CommonFunctions;

public class StepsToFollowPage {
	
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
