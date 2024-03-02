package Utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.common.io.Files;

public class TestBase {
	
	public static WebDriver driver = null;
	
	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICIT_WAIT = 30;
	public static Map<String, String> configMap;
	
	public static ExtentHtmlReporter htmlreporter = null;
	public static ExtentReports extent = null;
	public static ExtentTest test = null;
	public static ExtentTest parenttest = null; 
	public static WebDriverWait wait;
	
	public static File reportDirectery;
	public static String downloadFilepath = null;
	public static String pillType;
	public boolean isVerified = false;
	
	public static WebDriver launchURL(String strBrowser, String strURL) { 
		downloadFilepath = configMap.get("downloadpath"); 
		// DesiredCapabilities capability=null;
		
		if (driver == null) {
			
			try {
		
		if(strBrowser.equalsIgnoreCase("CHROME")) {

			//String path = System.getProperty("user.dir") + "\\driver\\chromedriver.exe";
			//String path="C:\\CodeBase\\testing\\DriverPath\\chromedriver-win64\\chromedriver.exe";

			String path = System.getProperty("user.dir");
			 path=path+"\\DriverPath\\chromedriver-win64\\chromedriver.exe";

			System.setProperty("webdriver.chrome.driver", path); 
			//WebDriverManager.chromedriver().setup();
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>(); 
			chromePrefs.put("profile.default_content_settings.popups", 0);
			chromePrefs.put("download.default_directory", downloadFilepath); 
			chromePrefs.put("download.prompt_for_download", false); 
			chromePrefs.put("plugins.always_open_pdf_externally", true);
			
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
			options.setAcceptInsecureCerts(true);
			options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
			options.addArguments("disable-infobars");
			options.addArguments ("--start-maximized");
			options.setExperimentalOption("prefs", chromePrefs); 
			options.setPageLoadStrategy(PageLoadStrategy. NORMAL);
			//options.addArguments("headless"); //headless
			driver = new ChromeDriver(options);
			driver.manage().deleteAllCookies();
			//CommonFunctions.waitForPageLoaded();
			//CommonFunctions.scrollToBottom();
			//driver.manage().timeouts().implicitlyWait(IMPLICIT WAIT, TimeUnit.SECONDS);
		
		}
		/*
		 * else if(strBrowser.equalsIgnoreCase("SAFARI")){
		 * capability-DesiredCapabilities.safari(); }
		 */
		driver.get(strURL);
		
		driver.manage().deleteAllCookies(); 
		driver.manage().window().maximize();
		//driver.manage().timeouts().pageloadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	
	} catch (Exception e) {
		
		System.out.println(e.getMessage());
	}
		}
		return driver;
	}
	
	@BeforeSuite()
	public void init(ITestContext context) throws FileNotFoundException, IOException {
		
		reportDirectery = new File(getResourcePath("screenshots"));
		getExecutionConfig();
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("MMddyyyy");
		File destFile = null;
		
		try {
			destFile = new File(
					"result/" + "GrowerPortal_Test_Automation_Results_" + formater.format(calendar.getTime()) + ".html");
System.out.println("I am a destination file");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// htmlreporter = new ExtentHtmlReporter("result/extentreport.html");
		
		htmlreporter = new ExtentHtmlReporter(destFile);
		htmlreporter.loadXMLConfig("extent-config.xml");
		
		extent = new ExtentReports();
		extent.attachReporter(htmlreporter);
		
	}
	
	public void getExecutionConfig() throws FileNotFoundException, IOException {
		
		Properties prop = new Properties();
		FileReader reader = new FileReader("config.properties");
		
		prop.load(reader);
		configMap = new HashMap<String, String>();
		for (String key: prop.stringPropertyNames()) {
			configMap.put(key, prop.getProperty(key));
		}
	}

	
	
	/*
	 * public static String captureScreen(String fileName, WebDriver driver) {
	 * 
	 * if (driver == null) { return null; } if (fileName == "") { fileName ="blank";
	 * } Reporter.log("captureScreen method called"); File destFile = null; Calendar
	 * calendar = Calendar.getInstance(); SimpleDateFormat formater = new
	 * SimpleDateFormat("dd_MM_yyyy_hh_mm_ss"); File screFile = ((TakesScreenshot)
	 * driver).getScreenshotAs(OutputType.FILE); try { destFile = new
	 * File(reportDirectery + "/" + fileName + "_" +
	 * formater.format(calendar.getTime()) + ".png"); Files.copy(screFile,
	 * destFile);
	 * 
	 * Reporter.log("<a href='" + destFile.getAbsolutePath() + "'><img src='"
	 * +destFile.getAbsolutePath() + "'height='100' width='100'/></a>"); } catch
	 * (Exception e) { e.printStackTrace(); } return destFile.toString(); }
	 */
	 
	public static String getResourcePath(String path) {
		String basePath = System.getProperty("user.dir");
		System.out.println(basePath + "/" + path);
		return basePath + "/" + path;
	}
	
}


