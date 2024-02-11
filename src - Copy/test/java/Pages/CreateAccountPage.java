package Pages;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import Utilities.CommonFunctions;
import Utilities.TestBase;

public class CreateAccountPage extends TestBase{
	public CreateAccountPage() {
		super();
		PageFactory.initElements(driver, this);
	}
	
@FindBy(xpath="//a[text()='Sign Up']")
public WebElement signUpAccount;
	
@FindBy(xpath="//input[@id = 'first-name']")
public WebElement firstName;

@FindBy(xpath="//input[@id = 'last-name']")
public WebElement lastName;

@FindBy(xpath="//input[@id = 'dob']")
public WebElement dateOfBirth;

@FindBy(xpath="//input[@id = 'enter-email']")
public WebElement enterEmail;

@FindBy(xpath="//input[@id = 'create-password']")
public WebElement createPassword;

@FindBy(xpath="//input[@id = 'confirm-password']")
public WebElement confirmPassword;

@FindBy(xpath="//input[@id = 'us-phone']")
public WebElement phoneNumber;

@FindBy(xpath="//input[@id = 'address']")
public WebElement address;

@FindBy(xpath = "//button[text()='Verify Email']")
public WebElement verifyEmail;

@FindBy(xpath = "//button[text()='Sign Up']")
public WebElement signUp;

@FindBy(xpath="//a[@class = 'back-to-login']")
public WebElement backToLogin;

@FindBy(xpath="//input[@type='email']")
public WebElement gmailUserName;

@FindBy(xpath="//span[text()='Next']")
public WebElement btn_gmailNext;

@FindBy(xpath="//input[@type='password']")
public WebElement gmailPassword;

@FindBy(xpath="//div[@class='Cp']/div/table/tbody/tr/td[4]//span/span[1]")
public WebElement inboxMail;

public void createAccountmethod(Map<String, String> dataMap ) {
	
	try {
		CommonFunctions.waitForPageLoaded();
		//CommonFunctions.waitForElement(driver, signUpAccount, 20);
		CommonFunctions.clickElement(signUpAccount);
		CommonFunctions.enterText(firstName, dataMap.get("FirstName"));
		test.log(Status.PASS, "Successfully entered the firstName to create account :" +dataMap.get("FirstName"));
		CommonFunctions.enterText(firstName, dataMap.get("FirstName"));
		CommonFunctions.enterText(lastName, dataMap.get("LastName"));
		test.log(Status.PASS, "Successfully entered the lastName to create account :" +dataMap.get("LastName"));
		CommonFunctions.enterText(dateOfBirth, dataMap.get("DateofBirth"));
		test.log(Status.PASS, "Successfully entered the Date of birth to create account :" +dataMap.get("DateofBirth"));
		CommonFunctions.enterText(enterEmail, dataMap.get("EnterEmail"));
		test.log(Status.PASS, "Successfully entered the Email filed to create account :" +dataMap.get("EnterEmail"));
		if(validateEmailFormat(dataMap.get("EnterEmail"))) {
		CommonFunctions.enterText(createPassword, dataMap.get("CreatePassword"));
		test.log(Status.PASS, "Successfully entered the CreatePassword to create account :" +dataMap.get("CreatePassword"));
		CommonFunctions.enterText(confirmPassword, dataMap.get("ConfirmPassword"));
		test.log(Status.PASS, "Successfully entered the ConfirmPassword to create account :" +dataMap.get("ConfirmPassword"));
		CommonFunctions.enterText(phoneNumber, dataMap.get("PhoneNumber"));
		test.log(Status.PASS, "Successfully entered the PhoneNumber to create account :" +dataMap.get("PhoneNumber"));
		CommonFunctions.enterText(address, dataMap.get("Address"));
		test.log(Status.PASS, "Successfully entered the Address to create account :" +dataMap.get("Address"));
		CommonFunctions.clickElement(verifyEmail);
		test.log(Status.PASS, "Successfully created the account :");
		
		
	} else {
		test.log(Status.FAIL, "Entered email is in invalid format");
	}
	}
	catch(Exception e) {
		test.log(Status.FAIL, "Failed to create account. Error: createAccountmethod ");
		e.printStackTrace();
		
	}
	
}
public boolean validateEmailFormat(String Email) {
	String RegEx = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9.-]+$";
	Pattern pat = Pattern.compile(RegEx);
	Matcher match = pat.matcher(Email);
	test.log(Status.INFO, "Enterd email format is : "+match.matches());
	return match.matches();
	
}

public void otpValidationMethod(String email, String password, String url) {
	
	try {
		driver.switchTo().newWindow(WindowType.TAB);
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> scope=windows.iterator();
		String parentId=scope.next();
		String chaildId=scope.next();
		driver.navigate().to(url);
		
	}
	
	catch(Exception e) {
		test.log(Status.FAIL, "Failed to create account. Error: otpValidationMethod ");
		e.printStackTrace();
		
	}
	
}
	}
		

