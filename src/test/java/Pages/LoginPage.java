package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import Utilities.CommonFunctions;
import Utilities.TestBase;

public class LoginPage extends TestBase {
	public LoginPage() {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id = 'username']")
	public WebElement userName;

	@FindBy(xpath = "//input[@id = 'password']")
	public WebElement password;

	@FindBy(xpath = "//button[@type = 'button']")
	public WebElement logIn;

	@FindBy(xpath = "//div[@id='menu-button']")
	public WebElement landingPageMenu;
	
	@FindBy(xpath = "//div[@id='menu-button']")
	public List<WebElement> lst_landingPageMenu;

	public void loginmethod(String userId, String passwrd) {

		try {

			CommonFunctions.enterText(userName, userId);
			CommonFunctions.enterText(password, passwrd);
			CommonFunctions.clickElement(logIn);
			CommonFunctions.waitForPageLoaded();
			String url = driver.getCurrentUrl();
			Thread.sleep(2000);
		if (lst_landingPageMenu.size()>0) {
			//if (url == "https://growerPortal/landingPage") {
				test.log(Status.PASS,
						"Able to Login with the credentials provided :" + userId + " and Password :" + passwrd);

			} else {
				test.log(Status.FAIL, "Unable to login with the credentials provided");
			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to execute method : loginmethod");
			e.printStackTrace();

		}
	}
	public void navigationMenu(String menuOption) {
		try {
			CommonFunctions.clickElement(landingPageMenu);
			CommonFunctions.implicitWait(10);
			driver.findElement(By.xpath("//a[text()='"+menuOption+"']")).click();
			
		 } catch (Exception e) {
			test.log(Status.FAIL, "Unable to execute method : navigationMenu");
			e.printStackTrace();
		 }
	}
}
