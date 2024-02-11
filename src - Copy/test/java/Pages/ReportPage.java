package Pages;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.CommonFunctions;
import Utilities.TestBase;

public class ReportPage extends TestBase {
	public ReportPage() {
		super();
		PageFactory.initElements(driver, this);
	}
	
	
@FindBy(xpath="//div[@id='menu-button']")
public WebElement menuButton;

@FindBy(xpath="//a[@href='/Report']")
public WebElement report;

@FindBy(xpath="//div[@id='report-container']//label[text()='Select Day:']//following-sibling::select[@id='day']")
public WebElement selectDay;

@FindBy(xpath="//div[@id='report-container']//label[text()='Select Month:']//following-sibling::select[@id='month']")
public WebElement selectMonth;

@FindBy(xpath="//div[@id='report-container']//label[text()='Select Year:']//following-sibling::select[@id='year']")
public WebElement selectYear;

@FindBy(xpath="//button[text()='Download Daily Report']")
public WebElement downloadDailyRptBtn;

@FindBy(xpath="//div[@id='report-container']//label[text()='Generate Yearly Report:']//following-sibling::select[@id='yearly']")
public WebElement generateYearlyRpt;

@FindBy(xpath="//button[text()='Download Yearly Report']")
public WebElement downloadYearlyRptBtn;

LoginPage lp = new LoginPage();

public void reportmethod(Map<String, String>dataMap) {
	
	try {
		lp.navigationMenu(dataMap.get("menuOption"));
		CommonFunctions.clickElement(report);
		CommonFunctions.selectByValue(selectDay, dataMap.get("Select Day:"));
		CommonFunctions.selectByValue(selectMonth, dataMap.get("Select Day:"));
		CommonFunctions.selectByValue(selectYear, dataMap.get("Select Day:"));
		CommonFunctions.clickElement(downloadDailyRptBtn);
		CommonFunctions.selectByValue(generateYearlyRpt, dataMap.get("Select Day:"));
		CommonFunctions.clickElement(downloadYearlyRptBtn);
		
	}
	catch(Exception e) {
		e.printStackTrace();
		  
		
	}
}
}


