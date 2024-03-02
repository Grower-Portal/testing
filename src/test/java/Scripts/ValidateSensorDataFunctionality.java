package Scripts;

import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.SensorDataPage;
import Utilities.GrowerDataProvider.StaticProviderLoginPage;
import Utilities.GrowerDataProvider.StaticProvidersensorDataPage;
import Utilities.TestBase;

public class ValidateSensorDataFunctionality extends TestBase {
	SensorDataPage sensordatapage;
	LoginPage loginpage;

	@BeforeClass()
	public void method() {

		parenttest = TestBase.extent.createTest("sensor data Functionality");
		driver = TestBase.launchURL(TestBase.configMap.get("browser"), TestBase.configMap.get("ApplicationURL"));
		sensordatapage = new SensorDataPage();
		loginpage = new LoginPage();

	}

	@Test(priority=1)
	public void validatelogin() {
		TestBase.test = parenttest.createNode("Validating with the provided credentials");
		loginpage.loginmethod(TestBase.configMap.get("UserName"), TestBase.configMap.get("Password"));
	}

	@Test(dataProvider = "sensorData", dataProviderClass = StaticProvidersensorDataPage.class,priority =2)
	public void validatesensordata(Map<String, String> dataMap) {
		try {
		TestBase.test = parenttest.createNode("Validating sensordata functionality");
		sensordatapage.sensorDatamethod(dataMap);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@AfterClass()
	public void cleanup() {
		TestBase.extent.flush();
		driver.quit();
	}

}
