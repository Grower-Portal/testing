package Pages;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import Utilities.CommonFunctions;
import Utilities.TestBase;

public class SensorDataPage extends TestBase {
	public SensorDataPage() {
		super();
		PageFactory.initElements(driver, this);
		
	}

	
@FindBy(xpath="//div[@id='menu-button']")
public WebElement menuButton;

@FindBy(xpath="//a[@href=\"/SensorData\"]")
public WebElement sensorDataButton;

@FindBy(xpath="//div[@id=\"sensor-data-container\"]")
public WebElement sensorDataDashboard;

@FindBy(xpath="//h2[text()='Sensor Data']")
public WebElement sensorDataTxt;

@FindBy(xpath="//p[text()='Sensor Data Metrics:']")
public WebElement txt_dataMetrics;

@FindBy(xpath="//p[text()='Location: ']")
public WebElement txt_location;

@FindBy(xpath="//p[text()='ABC123']")
public WebElement txt_uniqueID;

@FindBy(xpath="//p[text()='Depth: ']")
public WebElement txt_depth;

LoginPage lp = new LoginPage();


public void sensorDatamethod(Map<String, String> dataMap) {
	
	
	try {
		lp.navigationMenu(dataMap.get("menuOption"));
		CommonFunctions.clickElement(sensorDataButton);
		if (CommonFunctions.getValue(sensorDataDashboard).equalsIgnoreCase(dataMap.get("sensorDataHeading"))) {
			test.log(Status.PASS, "Content matched successfully :" + dataMap.get("sensorDataHeading"));
			
		} else {
		   
			test.log(Status.FAIL, "Content Mismatched for :" + CommonFunctions.getValue(sensorDataDashboard));
		}
		if (CommonFunctions.getValue(sensorDataTxt).equalsIgnoreCase(dataMap.get("SensorData"))) {
			test.log(Status.PASS, "Content matched successfully :" + dataMap.get("SensorData"));
			
		} else {
		   
			test.log(Status.FAIL, "Content Mismatched for :" + CommonFunctions.getValue(sensorDataTxt));
		}
		if (CommonFunctions.getValue(txt_dataMetrics).equalsIgnoreCase(dataMap.get("DataMetrics"))) {
			test.log(Status.PASS, "Content matched successfully :" + dataMap.get("DataMetrics"));
			
		} else {
		   
			test.log(Status.FAIL, "Content Mismatched for :" + CommonFunctions.getValue(txt_dataMetrics));
		}
		if (CommonFunctions.getValue(txt_location).equalsIgnoreCase(dataMap.get("Location"))) {
			test.log(Status.PASS, "Content matched successfully :" + dataMap.get("Location"));
			
		} else {
		   
			test.log(Status.FAIL, "Content Mismatched for :" + CommonFunctions.getValue(txt_location));
		}
		if (CommonFunctions.getValue(txt_uniqueID).equalsIgnoreCase(dataMap.get("UniqueId"))) {
			test.log(Status.PASS, "Content matched successfully :" + dataMap.get("UniqueId"));
			
		} else {
		   
			test.log(Status.FAIL, "Content Mismatched for :" + CommonFunctions.getValue(txt_uniqueID));
		}
		if (CommonFunctions.getValue(txt_depth).equalsIgnoreCase(dataMap.get("Depth"))) {
			test.log(Status.PASS, "Content matched successfully :" + dataMap.get("Depth"));
			
		} else {
		   
			test.log(Status.FAIL, "Content Mismatched for :" + CommonFunctions.getValue(txt_depth));
		}
		
	
	}
	catch(Exception e) {
		test.log(Status.FAIL, "Unable to execute sensorDatamethod");
		e.getMessage();
		
	}
}
	}
		

