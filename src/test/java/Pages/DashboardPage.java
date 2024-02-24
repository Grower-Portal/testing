package Pages;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import Utilities.CommonFunctions;
import Utilities.TestBase;

public class DashboardPage extends TestBase {
	public DashboardPage() {
		super();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@id='menu-button']")
	public WebElement menuButton;

	@FindBy(xpath="//a[@href='/Application+Dashboard']")
	public WebElement dashboard;
		
	@FindBy(xpath="//span[@class='help-icon']")
	public WebElement helpIcon;

	@FindBy(xpath="//button[@class='btn btn-add']")
	public WebElement addApplicationButton;
	
	@FindBy(xpath="//input[@type='text']")
	public WebElement applicantName;
	
	@FindBy(xpath="//tbody[@id='applicationList']//td/select")
	public WebElement statusField;
	
	@FindBy(xpath="//button[@class='btn btn-start-application']")
	public WebElement startApplicationButton;
	
//	@FindBy(xpath="//div[@class='form-screen']")
//	public WebElement producerInfrmtnPage;


	
	
	
	LoginPage lp = new LoginPage();

	// private Map<String, String> dataMap;
	public void dashboardStartApplication(int count, String DropdownOpt, int size) {
		
		
		try {
			
				if (count>0)  {	
					
					CommonFunctions.clickElement(addApplicationButton);
				
				}
				CommonFunctions.selectByValue(statusField, DropdownOpt);
				test.log(Status.PASS, "Successfully selected dropdown value :" +DropdownOpt);
				CommonFunctions.clickElement(startApplicationButton);
				
//				CommonFunctions.waitForPageLoaded();
//				CommonFunctions.waitForElement(driver, producerInfrmtnPage, 5);
//				if (producerInfrmtnPage.isDisplayed()) {
//					//if (url == "https://growerPortal/landingPage") {
//						test.log(Status.PASS,
//								"Successfully entered the data in the add application fields :" + UserName + " and dropdown :" + DropdownOpt);
//
//					} else {
//						test.log(Status.FAIL, "Applicant name is empty");
//					}
//				
		
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void splitData(Map<String, String> dataMap) {
		lp.navigationMenu(dataMap.get("menuOption"));
		System.out.println(dataMap.get("applicationName").split(";"));
		String[] split = dataMap.get("applicationName").split(";");
		System.out.println(split[0]);
		int count =0;
		for (String each: split) {
			String[] seperate = each.split(":");
			
			dashboardStartApplication(count,seperate[1],split.length);
			count=count+1;
		}
		
	}
	
	
	}


