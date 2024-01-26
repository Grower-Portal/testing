package Pages;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import Utilities.CommonFunctions;
import Utilities.TestBase;

public class AboutPage extends TestBase {
	public AboutPage() {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='menu-button']")
	public WebElement menuButton;

	@FindBy(xpath = "//a[@href='/About']")
	public WebElement aboutBtn;

	@FindBy(xpath = "//h1[contains(text(),'About Grower')]")
	public WebElement abtGrower;

	@FindBy(xpath = "//h2[contains(text(),'Empowering Grower')]")
	public WebElement empoweringGrower;

	@FindBy(xpath = "//h2[text()='Empowering Growers Through Precision Agriculture']/following-sibling::p")
	public WebElement empoweringGrowerDescptn;

	@FindBy(xpath = "//h2[text()='Innovative Water Sensing Technology']")
	public WebElement innovativeWater;

	@FindBy(xpath = "//h2[text()='Innovative Water Sensing Technology']/following-sibling::p")
	public WebElement innovativeWaterDescptn;

	@FindBy(xpath = "//h2[text()='Geolocation and CLU Data Integration']")
	public WebElement geolctn;

	@FindBy(xpath = "//h2[text()='Geolocation and CLU Data Integration']//following-sibling::p")
	public WebElement geolctnDscptn;

	@FindBy(xpath = "//h2[text()='Our Vision']")
	public WebElement ourVision;

	@FindBy(xpath = "//h2[text()='Our Vision']//following-sibling::p")
	public WebElement ourVisionDscptn;

	@FindBy(xpath = "//h2[text()='Join Us']")
	public WebElement joinUs;

	@FindBy(xpath = "//h2[text()='Join Us']/following-sibling::p")
	public WebElement joinUsDscptn;

	LoginPage lp = new LoginPage();

	public void aboutmethod(Map<String, String> dataMap) {

		try {
			lp.navigationMenu(dataMap.get("menuOption"));

			if (CommonFunctions.getValue(abtGrower).equalsIgnoreCase(dataMap.get("AboutPage"))) {
				test.log(Status.PASS, "Content matched successfully :" + dataMap.get("AboutPage"));

			} else {

				test.log(Status.FAIL, "Content Mismatched for :" + CommonFunctions.getValue(abtGrower));
			}

		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to execute aboutmethod");
			e.getMessage();

		}
	}
}
