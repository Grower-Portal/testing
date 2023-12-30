package Utilities;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

public class CommonFunctions extends TestBase {
public static void clickElement(WebElement element) {
	try {
		implicitWait(60);
		waitForElement(driver, element,30);
		waitForElementsToBeclickable(element,30);
		if (element.isDisplayed()) {
			scrollToElement(element);
			element.click();
			test.log(Status.PASS, "Clicked on Webelement : " + element.toString());
			
		} else {
			test.log(Status.FAIL, "Unable to click on Webelement: " + element.toString());
		}
	} catch (Exception e) {
		test.log(Status.FAIL, "Unable to click on Webelement: " + element.toString());
	}
}

public static void implicitWait(int seconds) {
	driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}

	public static void scrollToTop() {
		try {
			Thread.sleep(2000);
			waitForPageLoaded();
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
		} catch (Exception e) {
			test.log(Status.FAIL,"Unable to scrollToTop ");
		}
	}
public static void waitForPageLoaded() {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() { 
			public Boolean apply (WebDriver driver)
			{
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
				
			}
		};
		
		
}
public static void scrollToBottom() {
	try {
		Thread.sleep(2000);
		waitForPageLoaded();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, document.body.scrollHeight)", ""); 
	}catch(Exception e){
		test.log(Status.FAIL,"Unable to scrollToTop ");
	}
}

public static void enterText(WebElement element, String text) {
	try {

		Thread.sleep(1000);
		if (element.isDisplayed()) {
			element.clear();
			Thread.sleep(1000);
			element.sendKeys(text);
			test.log(Status.PASS, "Text entered is " + text);
		}
	} catch (Exception e) {
		test.log(Status.FAIL, "Unable to enter text" + text);
	}
}
	/* 
	 * This function is for pressing tab on the web page 
	 */
	
	public static String getValue(WebElement element) {
		
		return element.getText();
	}
	public static void selectByIndex (WebElement element, int index) {
		try {
			Select selectedvalue = new Select (element); 
			selectedvalue.selectByIndex(index);
			Thread.sleep(1000);
			test.log(Status.PASS, "Value has been select from element + element); " +element);
		} catch (Exception e) {
			test.log(Status.FAIL, "Value could not be selected for element " + element);
		}
	}
		

public static void selectByText(WebElement element, String text) {
    try {
    	Select selectedvalue = new Select(element); 
    	Thread.sleep(1000);
    	selectedvalue.selectByVisibleText(text);
    	
    	test.log(Status.PASS, "Value has been select from element " + element);
    } catch (Exception e) {
    	
    	test.log(Status.FAIL, "Value could not be selected for element " + element);
    	
    }
}

public static void selectByValue (WebElement element, String value) { 
	try {
		Select selectedvalue = new Select(element); 
		Thread.sleep(1000);
		selectedvalue.selectByValue(value);
		test.log(Status.PASS, "Value has been select from element "+ value);
	} catch (Exception e) {
		test.log(Status.FAIL, "Value could not be selected for element " + value);
	}
}


public static void waitForElement(WebDriver driver, WebElement element, int timeout) { 
	try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		
		wait.until(ExpectedConditions.invisibilityOf(element));
		// test.log(Status.PASS, "Wait for following element" + element);
		} catch (Exception e) {
			// test.log(Status.FAIL, "Wait for following element could not happen 
			// element);
		}
}
public static void waitForInvisibilityElement(WebElement element, int timeout) { 
	try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		
		wait.until(ExpectedConditions.invisibilityOf(element));
		// test.log(Status.PASS, "Wait for following element + element); 
		} catch (Exception e) {
		// test.log(Status.FAIL, "Wait for following element could not happen 
			// element);
			
		}
}
public static void waitForInvisibilityElements(List<WebElement> elements, int timeout) { 
	try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		
		wait.until(ExpectedConditions. invisibilityOfAllElements(elements));
		// test.log(Status. PASS, "Wait for following element + element);
		} catch (Exception e) {
			// test.log(Status. FAIL, "Wait for following element could not happen 
			// element);
		}
}
public static void waitForElementsToBeclickable(WebElement element, int timeout) {
	try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds (timeout));
		
		wait.until(ExpectedConditions.elementToBeClickable(element));
		// test.log(Status. PASS, "Wait for following element" + element);
	} catch (Exception e) {
		// test.log(Status.FAIL, "Wait for following element could not happen + 
		// element);
	}
}

public static void waitForElementsToBevisible(List<WebElement> element, int timeout) { 
	try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds (timeout));
		
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
		// test.log(Status.PASS, "Wait for following element + element);
		} catch (Exception e) {
			// test.log(Status.FAIL, "Wait for following element could not happen + 
			// element);
		}
}

public static void scrollBy(int length) {
	JavascriptExecutor js = (JavascriptExecutor) driver; 
	js.executeScript("window.scrollBy (0, "+length+")", "");
}
public static void verifyText(WebElement element, String verifytext) { 
	try {
		Assert.assertEquals(element.getText(), verifytext);
		test.log(Status.PASS, "element is Displayed.." + element.getText());
		
	} catch (Exception e) {
		test.log(Status.FAIL, "element is not Displayed..");
		
	}
}
public static void scrollToElement (WebElement element) throws InterruptedException{ 
	scrollToTop();
	waitForElement(driver, element, 20);
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
Thread.sleep(500);

}
}
