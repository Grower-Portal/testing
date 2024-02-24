package Scripts;

import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Pages.AddApplicationPage;
import Utilities.GrowerDataProvider.StaticProviderLoginPage;
import Utilities.GrowerDataProvider.StaticProviderdashboardPage;
import Utilities.TestBase;

public class TestClass extends TestBase{ 
//	@BeforeClass()
//	public void method() {
//		
//		parenttest = TestBase.extent.createTest("myresult");
//		driver = TestBase.launchURL("chrome", "https://www.youtube.com");	
//				
//	}
	
//@Test(dataProvider = "loginPage", dataProviderClass = StaticProviderLoginPage.class)
//public void method1(Map<String, String> dataMap)  {
//	TestBase.test = parenttest.createNode("subheading");
//	test.log(Status.PASS, "I got my report");
//	test.log(Status.INFO, dataMap.get("UserName"));
//}
	@Test(dataProvider = "dashboard", dataProviderClass = StaticProviderdashboardPage.class)
	public void method1(Map<String, String> dataMap)  {
//		TestBase.test = parenttest.createNode("subheading");
//		test.log(Status.PASS, "I got my report");
//		test.log(Status.INFO, dataMap.get("UserName"));
		AddApplicationPage obj = new AddApplicationPage();
		//obj.splitData(dataMap);
	
	}
	
//@AfterClass()
//public void cleanup() {
//	TestBase.extent.flush();
//	driver.quit();
//}

}
