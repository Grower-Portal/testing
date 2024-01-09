package Pages;

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

//@FindBy(xpath="//div[@id='menu-button']")
//public WebElement menuButton;

public void reportmethod() {
	
	try {
		
		CommonFunctions.clickelement(menuButton);
		//CommonFunctions.clickelement(reportPage);
	}
	catch(Exception e) {
		
	}
}
}


