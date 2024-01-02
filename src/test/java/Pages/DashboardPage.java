package Pages;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utilities.CommonFunctions;

public class DashboardPage {
	
@FindBy(xpath="//div[@id='menu-button']")
public WebElement menuButton;

@FindBy(xpath="//a[@href='/Dashboard']")
public WebElement dashboard;
	
@FindBy(xpath="//div[@id='upload-container']")
public WebElement uploadContainer;

@FindBy(xpath="//input[@id='file-input']")
public WebElement chooseFile;
LoginPage lp = new LoginPage();


public void dashboardmethod(Map<String, String> dataMap) {
	
	try {
	lp.navigationMenu(dataMap.get("menuOption"));
		
	}
	catch(Exception e) {
		
	}
}
}

