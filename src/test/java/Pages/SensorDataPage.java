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
public WebElement dataMetrics;

@FindBy(xpath="//p[text()='Location: ']")
public WebElement location;

@FindBy(xpath="//p[text()='ABC123']")
public WebElement uniqueID;

@FindBy(xpath="//p[text()='Depth: ']")
public WebElement depth;

LoginPage lp = new LoginPage();


public void sensorDatamethod(Map<String, String> dataMap) {
	
	
	try {
		lp.navigationMenu(dataMap.get("menuOption"));
		if (CommonFunctions.getValue(sensorDataDashboard).equalsIgnoreCase(dataMap.get("sensorDataHeading"))) {
			test.log(Status.PASS, "Content matched successfully :" + dataMap.get("sensorDataHeading"));
			
		} else {
		   
			test.log(Status.FAIL, "Content Mismatched for :" + CommonFunctions.getValue(sensorDataDashboard));
		}
	
	}
	catch(Exception e) {
		test.log(Status.FAIL, "Unable to execute sensorDatamethod");
		e.getMessage();
		
	}
}
	}
		

