package Pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import Utilities.CommonFunctions;
import Utilities.TestBase;

public class AddApplicationPage extends TestBase {
	public AddApplicationPage() {
		super();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='menu-button']")
	public WebElement menuButton;

	@FindBy(xpath = "//a[@href='/AddApplication']")
	public WebElement addApplication;

	@FindBy(xpath = "//label[contains(text(),'Producer Name')]/following-sibling::input[@type='text']")
	public WebElement producerName;

	@FindBy(xpath = "//label[contains(text(),'Producer Entity Name')]/following-sibling::input[@type='text']")
	public WebElement producerEntityName;

	@FindBy(xpath = "//label[contains(text(),'County of Residence')]/following-sibling::input[@type='text']")
	public WebElement countryOfResidence;

	@FindBy(xpath = "//label[contains(text(),'Producer Address ')]/following-sibling::input[@type='text']")
	public WebElement producerAddress;

	@FindBy(xpath = "//label[contains(text(), 'small producer? This is voluntary.')]/parent::div/following-sibling::select") // xpath
	public WebElement underservedStatus;

	@FindBy(xpath = "//div[@class='info-container']//following-sibling::input[@type='number']")
	public WebElement baselineYield;

	@FindBy(xpath = "//div[@class='form-group']//label[text()='Primary Reason for Applying']//following-sibling::select")
	public WebElement primaryReason;

	@FindBy(xpath = "//label[contains(text(),'On-Farm?:')]/following-sibling::select") // xpath
	public WebElement onform;

	@FindBy(xpath = "//button[text()='Next']")
	public WebElement nextButton;

	
	//tr/td[3]/input

	@FindBy(xpath = "//button[text()='Add Farm']")
	public WebElement addFarmButton;

	@FindBy(xpath = "//button[text()='Previous']")
	public WebElement previousButton;

	@FindBy(xpath = "//table[@id='farmTable']//th")
	public List<WebElement> farmAndTrackDetails_Headers;
	
	@FindBy(xpath = "//tr/td[1]/input")
	public WebElement txt_farmIdInput;
	
	
	
	@FindBy(xpath = "//td/div[1]/input")
	public WebElement txt_farmIdInput;
	//td/div[1]/input
	
	
	
	

	@FindBy(xpath = "//option[@value='Crop land']")
	public WebElement fieldLandUse;

	@FindBy(xpath = "//option[@value='Crop land']/parent::select") // Xpath required
	public WebElement fieldIrrigation;

	@FindBy(xpath = "//option[@value='Conventional, Inversion']")
	public WebElement fieldTillage;

	@FindBy(xpath = "//input[@name='applicationAcres']")
	public WebElement applicationAcres;

	@FindBy(xpath = "//input[@name='totalLandArea']")
	public WebElement totalLandArea;

	@FindBy(xpath = "//select[@name='produceLivestock']")
	public WebElement produceLivestock;

	@FindBy(xpath = "//select[@name='livestockType1']")
	public WebElement livestockTypeOne;

	@FindBy(xpath = "//select[@name='produceLivestock']") // Xpath
	public WebElement livestockHeadOne;

	@FindBy(xpath = "//select[@name='livestockType2']")
	public WebElement livestockTypeTwo;

	@FindBy(xpath = "//select[@name='produceLivestock']") // Xpath
	public WebElement livestockHeadTwo;

	@FindBy(xpath = "//select[@name='livestockType3']")
	public WebElement livestockTypeThree;

	@FindBy(xpath = "//input[@name='totalForestArea']")
	public WebElement totalForestArea;

	@FindBy(xpath = "//input[@name='fsaPhysicalLocation']")
	public WebElement physicalLocation;

	@FindBy(xpath = "//select[@name='pastCSAFPractice']")
	public WebElement pastPracticDrpdwn;

	@FindBy(xpath = "//input[@type='file']")
	public WebElement uploadDocument;

	@FindBy(xpath = "//button[text()='Submit Application']")
	public WebElement submitBtn;

	public void addApplicationmethod(Map<String, String> dataMap) {

		try {

			CommonFunctions.clickElement(menuButton);
			CommonFunctions.clickElement(addApplication);
			CommonFunctions.enterText(producerName, dataMap.get("ProducerName"));
			CommonFunctions.enterText(producerEntityName, dataMap.get("ProducerEntityName"));
			CommonFunctions.enterText(countryOfResidence, dataMap.get("CountyofResidence"));
			CommonFunctions.enterText(producerAddress, dataMap.get("ProducerAddress"));
			CommonFunctions.selectByText(underservedStatus, dataMap.get("UnderservedStatus"));
			CommonFunctions.selectByValue(baselineYield, dataMap.get("BaselineYield"));
			CommonFunctions.selectByText(primaryReason, dataMap.get("PrimaryReasonforApplying"));
			CommonFunctions.selectByText(onform, dataMap.get("PrimaryOperatorImplementedinthelast10years"));
			CommonFunctions.clickElement(nextButton);

			test.log(Status.PASS, "Successfully entered the producer Information :");

		} catch (Exception e) {
			test.log(Status.FAIL, "Entered details are incorrect :");

		}

	}

	public void farmDetailsmethod(Map<String, String> dataMap) {

		try {
			CommonFunctions.clickElement(addFarmButton);
			
			
			int position=getPositionofTheHeader
		} catch (Exception e) {

		}

	}

	public int getPositionofTheHeader(String Value) {
		int position = 1;
		try {
			for (WebElement element : farmAndTrackDetails_Headers) {
				if (element.getText().equalsIgnoreCase(Value)) {
					break;
				}
				position++;
			}

		} catch (Exception e) {

		}
		return position;
	}

	public void fieldHistorymethod(Map<String, String> dataMap) {

		try {
			CommonFunctions.selectByValue(fieldLandUse, dataMap.get("FieldLandUseHistory"));
			CommonFunctions.selectByValue(fieldIrrigation, dataMap.get("FieldIrrigationHistory"));
			CommonFunctions.selectByValue(fieldTillage, dataMap.get("FieldTillageHistory"));
			CommonFunctions.clickElement(nextButton);
		} catch (Exception e) {

		}

	}

	public void csafPracticemethod(Map<String, String> dataMap) {

		try {
			// CommonFunctions.clickElement(addFarmButton);

		} catch (Exception e) {

		}

	}

	public void farmInformationmethod(Map<String, String> dataMap) {

		try {
			CommonFunctions.selectByValue(applicationAcres, dataMap.get("ApplicationAcres"));
			CommonFunctions.selectByValue(totalLandArea, dataMap.get("TotalLandArea"));
			CommonFunctions.selectByValue(produceLivestock, dataMap.get("livestockInformation"));
			CommonFunctions.clickElement(nextButton);

		} catch (Exception e) {

		}

	}

	public void liveStockInformationmethod(Map<String, String> dataMap) {

		try {

			CommonFunctions.selectByValue(livestockTypeOne, dataMap.get("LivestockType1"));
			CommonFunctions.enterText(livestockHeadOne, dataMap.get("LivestockHead1"));
			CommonFunctions.selectByValue(livestockTypeTwo, dataMap.get("LivestockType2"));
			CommonFunctions.enterText(livestockHeadTwo, dataMap.get("LivestockHead2"));

			// doubts for 3rd box
			CommonFunctions.selectByValue(livestockTypeThree, dataMap.get("LivestockType3"));
			// CommonFunctions.enterText(livestockHeadThree, dataMap.get("LivestockHead3"));
			CommonFunctions.clickElement(nextButton);

		} catch (Exception e) {

		}

	}

	public void forestInformationmethod(Map<String, String> dataMap) {

		try {

			CommonFunctions.enterText(totalForestArea, dataMap.get("TotalForestArea"));
			CommonFunctions.enterText(physicalLocation, dataMap.get("FSAPhysicalLocation"));
			CommonFunctions.selectByValue(pastPracticDrpdwn, dataMap.get("PastCSAFPractice"));
			CommonFunctions.clickElement(uploadDocument);
			CommonFunctions.UploadFile(dataMap.get("UploadDocument"));
			CommonFunctions.clickElement(submitBtn);

		} catch (Exception e) {

		}

	}
}
