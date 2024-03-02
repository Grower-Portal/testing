package Scripts;

import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.StepsToFollowPage;
import Utilities.GrowerDataProvider.StaticProviderLoginPage;
import Utilities.GrowerDataProvider.StaticProviderstepsToFollowPage;
import Utilities.TestBase;

public class ValidateStepstoFollowFunctionality extends TestBase {
	StepsToFollowPage stepstofollow;
	LoginPage loginpage;

	@BeforeClass()
	public void method() {

		parenttest = TestBase.extent.createTest("steps to follow Functionality");
		driver = TestBase.launchURL(TestBase.configMap.get("browser"), TestBase.configMap.get("ApplicationURL"));
		stepstofollow = new StepsToFollowPage();
		loginpage = new LoginPage();

	}

	@Test(priority = 1)
	public void validatelogin() {
		TestBase.test = parenttest.createNode("Validating with the provided credentials");
		loginpage.loginmethod(TestBase.configMap.get("UserName"), TestBase.configMap.get("Password"));
	}

	@Test(dataProvider = "stepsToFollow", dataProviderClass = StaticProviderstepsToFollowPage.class, priority = 2)
	public void validateSteptoFollow(Map<String, String> dataMap) {
		TestBase.test = parenttest.createNode("Validating steps to follow functionality");
		stepstofollow.stepsToFollowmethod(dataMap);
	}

	@AfterClass()
	public void cleanup() {
		TestBase.extent.flush();
		driver.quit();
	}

}
