package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
public WebElement sensorData;

@FindBy(xpath="//div[@id=\"sensor-data-container\"]")
public WebElement sensorDataDashboard;

public void sensorDatamethod() {
	
	try {
		CommonFunctions.clickelement(menuButton);
		CommonFunctions.sendkeys(sensorData, "Data");
		CommonFunctions.sendkeys(sensorDataDashboard, "details");	
	}
	catch(Exception e) {
		
		
	}
	
}
	}
		

