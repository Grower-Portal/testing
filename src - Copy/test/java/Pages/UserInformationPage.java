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
public WebElement txt_name;

@FindBy(xpath="//p[text()='Email: ']")
public WebElement txt_email;

@FindBy(xpath="//p[text()='Phone Number: ']")
public WebElement txt_phoneNumber;

@FindBy(xpath="//p[text()='Address: ']")
public WebElement txt_address;

@FindBy(xpath="//p[text()='Date of Birth: ']")
public WebElement txt_dateofBirth;


LoginPage lp = new LoginPage();


public void userInformationmethod(Map<String, String>dataMap) {

	try {
		lp.navigationMenu(dataMap.get("menuOption"));

		if (CommonFunctions.getValue(userInformation).equalsIgnoreCase(dataMap.get("UserInfo"))) {
			test.log(Status.PASS, "Content matched successfully :" + dataMap.get("UserInfo"));

		} else {

			test.log(Status.FAIL, "Content Mismatched for :" + CommonFunctions.getValue(userInformation));
		}

		if (CommonFunctions.getValue(txt_name).equalsIgnoreCase(dataMap.get("Name"))) {
			test.log(Status.PASS, "Content matched successfully :" + dataMap.get("Name"));

		} else {

			test.log(Status.FAIL, "Content Mismatched for :" + CommonFunctions.getValue(txt_name));
		}
		if (CommonFunctions.getValue(txt_email).equalsIgnoreCase(dataMap.get("Mail"))) {
			test.log(Status.PASS, "Content matched successfully :" + dataMap.get("Mail"));

		} else {

			test.log(Status.FAIL, "Content Mismatched for :" + CommonFunctions.getValue(txt_email));
		}
		if (CommonFunctions.getValue(txt_phoneNumber).equalsIgnoreCase(dataMap.get("PhnNumber"))) {
			test.log(Status.PASS, "Content matched successfully :" + dataMap.get("PhnNumber"));

		} else {

			test.log(Status.FAIL, "Content Mismatched for :" + CommonFunctions.getValue(txt_phoneNumber));
		}
		if (CommonFunctions.getValue(txt_address).equalsIgnoreCase(dataMap.get("Address"))) {
			test.log(Status.PASS, "Content matched successfully :" + dataMap.get("Address"));

		} else {

			test.log(Status.FAIL, "Content Mismatched for :" + CommonFunctions.getValue(txt_address));
		}
		if (CommonFunctions.getValue(txt_dateofBirth).equalsIgnoreCase(dataMap.get("DateOfBirth"))) {
			test.log(Status.PASS, "Content matched successfully :" + dataMap.get("DateOfBirth"));

		} else {

			test.log(Status.FAIL, "Content Mismatched for :" + CommonFunctions.getValue(txt_dateofBirth));
		
		}
	} catch (Exception e) {
		test.log(Status.FAIL, "Unable to execute userInformationmethod");
		e.getMessage();

	}
}

}
