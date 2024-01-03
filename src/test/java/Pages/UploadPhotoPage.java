package Pages;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Test;

import Utilities.CommonFunctions;
import Utilities.TestBase;

public class UploadPhotoPage extends TestBase{
	
@FindBy(xpath="//div[@id='menu-button']")
public WebElement menuButton;

@FindBy(xpath="//a[@href='/Dashboard']")
public WebElement dashboard;
	
@FindBy(xpath="//div[@id='upload-container']")
public WebElement uploadContainer;

@FindBy(xpath="//input[@id='file-input']")
public WebElement chooseFile;

@FindBy(xpath="//button[@id='upload-button']")
public WebElement uploadPhoto;

LoginPage lp = new LoginPage();


public void dashboardmethod(Map<String, String> dataMap) {
	
	try {
	lp.navigationMenu(dataMap.get("menuOption"));
		CommonFunctions.clickElement(chooseFile);
		CommonFunctions.waitForPageLoaded();
		CommonFunctions.UploadFile(dataMap.get("Path"));
		test.log(Status.INFO, "File was uploaded from the path :"+dataMap.get("Path"));
		CommonFunctions.waitForPageLoaded();
		CommonFunctions.clickElement(uploadPhoto);
	}
	catch(Exception e) {
		
	}
}
}

