package Pages;

import java.util.Map;
import java.util.UUID;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Test;

import Utilities.CommonFunctions;
import Utilities.TestBase;

public class UploadPhotoPage extends TestBase{
	public UploadPhotoPage() {
		super();
		PageFactory.initElements(driver, this);
		
	}
	
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


public void UploadPhotoMethod(Map<String, String> dataMap) {
	
	try {
	lp.navigationMenu(dataMap.get("menuOption"));
		//CommonFunctions.clickElement(chooseFile);
		CommonFunctions.waitForPageLoaded();
		CommonFunctions.enterText(chooseFile,dataMap.get("Path"));
		test.log(Status.INFO, "File was uploaded from the path :"+dataMap.get("Path"));
		CommonFunctions.waitForPageLoaded();
		uploadPhoto.click();
		CommonFunctions.captureScreen("upload"+UUID.randomUUID().toString());
	}
	catch(Exception e) {
		e.printStackTrace();
		
	}
}
}

