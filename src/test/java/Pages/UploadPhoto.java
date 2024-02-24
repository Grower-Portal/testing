package Pages;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

import Utilities.CommonFunctions;
import Utilities.TestBase;

public class UploadPhoto extends TestBase {
	
@FindBy(xpath="//div[@id='menu-button']")
public WebElement menuButton;

@FindBy(xpath="//a[@href='/Dashboard']")
public WebElement dashboard;
	
@FindBy(xpath="//div[@id='upload-container']")
public WebElement uploadContainer;

@FindBy(xpath="//input[@id='file-input']")
public WebElement chooseFile;
LoginPage lp = new LoginPage();


public void uploadPhotoMethod(Map<String, String> dataMap) {
	
	try {
		
		
	lp.navigationMenu(dataMap.get("menuOption"));
	CommonFunctions.clickElement(chooseFile);
	CommonFunctions.UploadFile(dataMap.get("Path"));
		
	}
	catch(Exception e) {
		e.getMessage();
		test.log(Status.FAIL, "Unable to execute method dashboardStartApplication");
		
	}
}
}

