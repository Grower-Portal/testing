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
	public WebElement txt_empoweringGrower;

	@FindBy(xpath = "//h2[text()='Empowering Growers Through Precision Agriculture']/following-sibling::p")
	public WebElement empoweringGrowerDescptn;

	@FindBy(xpath = "//h2[text()='Innovative Water Sensing Technology']")
	public WebElement txt_innovativeWater;

	@FindBy(xpath = "//h2[text()='Innovative Water Sensing Technology']/following-sibling::p")
	public WebElement innovativeWaterDescptn;

	@FindBy(xpath = "//h2[text()='Geolocation and CLU Data Integration']")
	public WebElement txt_geolctn;

	@FindBy(xpath = "//h2[text()='Geolocation and CLU Data Integration']//following-sibling::p")
	public WebElement txt_geolctnDscptn;

	@FindBy(xpath = "//h2[text()='Our Vision']")
	public WebElement txt_ourVision;

	@FindBy(xpath = "//h2[text()='Our Vision']//following-sibling::p")
	public WebElement txt_ourVisionDscptn;

	@FindBy(xpath = "//h2[text()='Join Us']")
	public WebElement txt_joinUs;

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
			if (CommonFunctions.getValue(txt_empoweringGrower).equalsIgnoreCase(dataMap.get("empoweringGrowers"))) {
				test.log(Status.PASS, "Content matched successfully :" + dataMap.get("empoweringGrowers"));

			} else {

				test.log(Status.FAIL, "Content Mismatched for :" + CommonFunctions.getValue(txt_empoweringGrower));
			}
			if (CommonFunctions.getValue(empoweringGrowerDescptn).equalsIgnoreCase(dataMap.get("empoweringGrowersMatter"))) {
				test.log(Status.PASS, "Content matched successfully :" + dataMap.get("empoweringGrowersMatter"));

			} else {

				test.log(Status.FAIL, "Content Mismatched for :" + CommonFunctions.getValue(empoweringGrowerDescptn));
			}
			if (CommonFunctions.getValue(txt_innovativeWater).equalsIgnoreCase(dataMap.get("InnovativeWater"))) {
				test.log(Status.PASS, "Content matched successfully :" + dataMap.get("InnovativeWater"));

			} else {

				test.log(Status.FAIL, "Content Mismatched for :" + CommonFunctions.getValue(txt_innovativeWater));
			}
			if (CommonFunctions.getValue(innovativeWaterDescptn).equalsIgnoreCase(dataMap.get("InnovativeWaterDescription"))) {
				test.log(Status.PASS, "Content matched successfully :" + dataMap.get("InnovativeWaterDescription"));

			} else {

				test.log(Status.FAIL, "Content Mismatched for :" + CommonFunctions.getValue(innovativeWaterDescptn));
			}
			if (CommonFunctions.getValue(txt_geolctn).equalsIgnoreCase(dataMap.get("Geolocation"))) {
				test.log(Status.PASS, "Content matched successfully :" + dataMap.get("Geolocation"));

			} else {

				test.log(Status.FAIL, "Content Mismatched for :" + CommonFunctions.getValue(txt_geolctn));
			}
			if (CommonFunctions.getValue(txt_geolctnDscptn).equalsIgnoreCase(dataMap.get("GeolocationDescription"))) {
				test.log(Status.PASS, "Content matched successfully :" + dataMap.get("GeolocationDescription"));

			} else {

				test.log(Status.FAIL, "Content Mismatched for :" + CommonFunctions.getValue(txt_geolctnDscptn));
			}
			if (CommonFunctions.getValue(txt_ourVision).equalsIgnoreCase(dataMap.get("OurVision"))) {
				test.log(Status.PASS, "Content matched successfully :" + dataMap.get("OurVision"));

			} else {

				test.log(Status.FAIL, "Content Mismatched for :" + CommonFunctions.getValue(txt_ourVision));
			}
			if (CommonFunctions.getValue(txt_ourVisionDscptn).equalsIgnoreCase(dataMap.get("OurVisionDescription"))) {
				test.log(Status.PASS, "Content matched successfully :" + dataMap.get("OurVisionDescription"));

			} else {

				test.log(Status.FAIL, "Content Mismatched for :" + CommonFunctions.getValue(txt_ourVisionDscptn));
			}
			if (CommonFunctions.getValue(txt_joinUs).equalsIgnoreCase(dataMap.get("JoinUs"))) {
				test.log(Status.PASS, "Content matched successfully :" + dataMap.get("JoinUs"));

			} else {

				test.log(Status.FAIL, "Content Mismatched for :" + CommonFunctions.getValue(txt_joinUs));
			}
			if (CommonFunctions.getValue(joinUsDscptn).equalsIgnoreCase(dataMap.get("JoinUsDescription"))) {
				test.log(Status.PASS, "Content matched successfully :" + dataMap.get("JoinUsDescription"));

			} else {

				test.log(Status.FAIL, "Content Mismatched for :" + CommonFunctions.getValue(joinUsDscptn));
			}
			

		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to execute aboutmethod");
			e.getMessage();

		}
	}
}
