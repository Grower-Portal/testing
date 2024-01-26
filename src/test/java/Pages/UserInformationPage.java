package Pages;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

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

@FindBy(xpath="//p[text()='Name: ']")
public WebElement name;

@FindBy(xpath="//p[text()='Email: ']")
public WebElement email;

@FindBy(xpath="//p[text()='Phone Number: ']")
public WebElement phoneNumber;

@FindBy(xpath="//p[text()='Address: ']")
public WebElement address;

@FindBy(xpath="//p[text()='Date of Birth: ']")
public WebElement dateofBirth;


LoginPage lp = new LoginPage();


public void userInformationmethod(Map<String, String>dataMap) {

	try {
		lp.navigationMenu(dataMap.get("menuOption"));

		if (CommonFunctions.getValue(userInformation).equalsIgnoreCase(dataMap.get("UserInfo"))) {
			test.log(Status.PASS, "Content matched successfully :" + dataMap.get("UserInfo"));

		} else {

			test.log(Status.FAIL, "Content Mismatched for :" + CommonFunctions.getValue(userInformation));
		}

	} catch (Exception e) {
		test.log(Status.FAIL, "Unable to execute userInformationmethod");
		e.getMessage();

	}
}

}
