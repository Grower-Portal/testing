package Utilities;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.aventstack.extentreports.Status;
import com.google.common.io.Files;

public class CommonFunctions extends TestBase {

	public static void clickElement(WebElement element) {

		// implicitWait(60);
		waitForElement(driver, element, 10);
		// waitForElementsToBeclickable(element,30);
		if (element.isDisplayed()) {
			// scrollToElement(element);
			element.click();
			test.log(Status.PASS, "Clicked on Webelement : " + element.toString());

		} else {
			test.log(Status.FAIL, "Unable to click on Webelement: " + element.toString());
		}
	}

	public static void captureScreen(String fileName) {

		Reporter.log("captureScreen method called");
		File destFile = null;
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		File screFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			destFile = new File(reportDirectery + "/" + fileName + "_" + formater.format(calendar.getTime()) + ".png");
			Files.copy(screFile, destFile);

			Reporter.log("<a href='" + destFile.getAbsolutePath() + "'><img src='" + destFile.getAbsolutePath()
					+ "'height='100' width='100'/></a>");
		} catch (Exception e) {
			e.printStackTrace();
		}
		// return destFile.toString();
	}

	public static void implicitWait(int seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}

	public static void scrollToTop() {
		try {
			implicitWait(60);
			waitForPageLoaded();
			((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to scrollToTop ");
		}
	}

	public static void waitForPageLoaded() {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");

			}
		};

	}

	public static void scrollToBottom() {
		try {
			implicitWait(60);
			waitForPageLoaded();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0, document.body.scrollHeight)", "");
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to scrollToTop ");

		}
	}

	public static void enterText(WebElement element, String text) {
		try {

			// implicitWait(60);
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

	public static void selectByIndex(WebElement element, int index) {
		try {
			Select selectedvalue = new Select(element);
			selectedvalue.selectByIndex(index);
			implicitWait(60);
			test.log(Status.PASS, "Value has been select from element + element); " + element);
		} catch (Exception e) {
			test.log(Status.FAIL, "Value could not be selected for element " + element);
		}
	}

	public static void selectByText(WebElement element, String text) {
		try {
			Select selectedvalue = new Select(element);
			implicitWait(60);
			selectedvalue.selectByVisibleText(text);

			test.log(Status.PASS, "Value has been select from element " + element);
		} catch (Exception e) {

			test.log(Status.FAIL, "Value could not be selected for element " + element);

		}
	}

	public static void selectByValue(WebElement element, String value) {
		try {
			Select selectedvalue = new Select(element);
			implicitWait(60);
			selectedvalue.selectByValue(value);
			test.log(Status.PASS, "Value has been select from element " + value);
		} catch (Exception e) {
			test.log(Status.FAIL, "Value could not be selected for element " + value);
		}
	}

	public static void takeScreenshot(String fileName) {
		if (driver == null) {
			test.log(Status.FAIL, "Found driver as null :");

		}
		if (fileName == "") {
			test.log(Status.FAIL, "Found fileName as null :");

		}
		Reporter.log("Screenshort method got called");
		File destFile = null;
		Calendar calendar = Calendar.getInstance();
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			destFile = new File(System.getProperty("user.dir") + "/screenShots/" + fileName + ".png");
			// System.out.println("I am in screenshort method about to a copy a screenshort
			// :");
			// System.out.println(System.getProperty("user.dir")
			// +"/GrowerPortal/screenShots" +fileName+ ".png");
			Files.copy(srcFile, destFile);
		} catch (Exception e) {

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

			wait.until(ExpectedConditions.invisibilityOfAllElements(elements));
			// test.log(Status. PASS, "Wait for following element + element);
		} catch (Exception e) {
			// test.log(Status. FAIL, "Wait for following element could not happen
			// element);
		}
	}

	public static void waitForElementsToBeclickable(WebElement element, int timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));

			wait.until(ExpectedConditions.elementToBeClickable(element));
			// test.log(Status. PASS, "Wait for following element" + element);
		} catch (Exception e) {
			// test.log(Status.FAIL, "Wait for following element could not happen +
			// element);
		}
	}

	public static void waitForElementsToBevisible(List<WebElement> element, int timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));

			wait.until(ExpectedConditions.visibilityOfAllElements(element));
			// test.log(Status.PASS, "Wait for following element + element);
		} catch (Exception e) {
			// test.log(Status.FAIL, "Wait for following element could not happen +
			// element);
		}
	}

	public static void scrollBy(int length) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy (0, " + length + ")", "");
	}

	public static void verifyText(WebElement element, String verifytext) {
		try {
			Assert.assertEquals(element.getText(), verifytext);
			test.log(Status.PASS, "element is Displayed.." + element.getText());

		} catch (Exception e) {
			test.log(Status.FAIL, "element is not Displayed..");

		}
	}

	public static void scrollToElement(WebElement element) throws InterruptedException {
		scrollToTop();
		waitForElement(driver, element, 10);
//implicitWait(60);

	}

	public static void UploadFile(String path) {
		try {

			Thread.sleep(2000); // suspending execution for specified time // period
			Robot rb = new Robot();
			// copying File path to Clipboard
			StringSelection str = new StringSelection(path);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
			// press Control+V for pasting
			rb.keyPress(KeyEvent.VK_CONTROL);

			rb.keyPress(KeyEvent.VK_V);
			// release Control+V for pasting
			rb.keyRelease(KeyEvent.VK_CONTROL);
			rb.keyRelease(KeyEvent.VK_V);
			// for pressing and releasing Enter
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to excute method UploadCvunderProfilePage " + e.getMessage());
			e.printStackTrace();
		}
	}

}
