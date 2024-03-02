package Scripts;

import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.UserInformationPage;
import Utilities.GrowerDataProvider.StaticProviderLoginPage;
import Utilities.GrowerDataProvider.StaticProviderUserInformationPage;
import Utilities.TestBase;

public class ValidateUserInformationFunctionality extends TestBase {
	UserInformationPage userinformationpage;
	LoginPage loginpage;

	@BeforeClass()
	public void method() {

		parenttest = TestBase.extent.createTest("User Information Functionality");
		driver = TestBase.launchURL(TestBase.configMap.get("browser"), TestBase.configMap.get("ApplicationURL"));
		userinformationpage = new UserInformationPage();
		loginpage = new LoginPage();

	}

	@Test(priority = 1)
	public void validatelogin() {
		TestBase.test = parenttest.createNode("Validating with the provided credentials");
		loginpage.loginmethod(TestBase.configMap.get("UserName"), TestBase.configMap.get("Password"));
	}

	@Test(dataProvider = "UserInformation", dataProviderClass = StaticProviderUserInformationPage.class, priority = 2)
	public void validateuserinformationt(Map<String, String> dataMap) {
		TestBase.test = parenttest.createNode("Validating user information functionality");
		userinformationpage.userInformationmethod(dataMap);
	}

	@AfterClass()
	public void cleanup() {
		TestBase.extent.flush();
		driver.quit();
	}
}
