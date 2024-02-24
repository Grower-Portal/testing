package Scripts;

import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.DashboardPage;
import Pages.LoginPage;
import Utilities.GrowerDataProvider.StaticProviderLoginPage;
import Utilities.GrowerDataProvider.StaticProviderdashboardPage;
import Utilities.TestBase;

<<<<<<< HEAD
public class ValidatedashboardtFunctionality extends TestBase{ 
	DashboardPage dashboardpage;
	LoginPage loginpage;
	@BeforeClass()
	public void method() {
		
		parenttest = TestBase.extent.createTest("dashboard Functionality");
		driver = TestBase.launchURL( TestBase.configMap.get("browser"),TestBase.configMap.get("ApplicationURL"));	
		dashboardpage=new DashboardPage();
		loginpage = new LoginPage();
		
	}
@Test(dataProvider = "loginPage", dataProviderClass = StaticProviderLoginPage.class)
public void validatelogin(Map<String, String> dataMap)  {
	TestBase.test=parenttest.createNode("Validating with the provided credentials");
	loginpage.loginmethod(dataMap.get("UserName"), dataMap.get("Password"));
}

@Test(dataProvider = "dashboard", dataProviderClass = StaticProviderdashboardPage.class)
public void validatedashboard(Map<String, String> dataMap)  {
	TestBase.test=parenttest.createNode("Validating dashboard functionality");
	dashboardpage.splitData(dataMap);
}

@AfterClass()
public void cleanup() {
	TestBase.extent.flush();
	driver.quit();
}
=======
public class ValidatedashboardtFunctionality extends TestBase {
	DashboardPage dashboardpage;
	LoginPage loginpage;

	@BeforeClass()
	public void method() {

		parenttest = TestBase.extent.createTest("dashboard Functionality");
		driver = TestBase.launchURL(TestBase.configMap.get("browser"), TestBase.configMap.get("ApplicationURL"));
		dashboardpage = new DashboardPage();
		loginpage = new LoginPage();

	}

	@Test(priority = 1)
	public void validatelogin() {
		TestBase.test = parenttest.createNode("Validating with the provided credentials");
		loginpage.loginmethod(TestBase.configMap.get("UserName"), TestBase.configMap.get("Password"));
	}

	@Test(dataProvider = "dashboard", dataProviderClass = StaticProviderdashboardPage.class,priority=2)
	public void validatedashboard(Map<String, String> dataMap) {
		TestBase.test = parenttest.createNode("Validating dashboard functionality");
		dashboardpage.splitData(dataMap);
	}

	@AfterClass()
	public void cleanup() {
		TestBase.extent.flush();
		driver.quit();
	}
>>>>>>> 4cd16d686b20ace23f9c0e4db642fd5ab7d8d6f4

}
