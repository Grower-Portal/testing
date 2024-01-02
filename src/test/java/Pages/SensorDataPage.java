package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utilities.CommonFunctions;

public class SensorDataPage {

	
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
		

