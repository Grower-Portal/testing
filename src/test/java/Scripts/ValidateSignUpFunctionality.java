package Scripts;

import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Pages.CreateAccountPage;
import Pages.LoginPage;
import Utilities.GrowerDataProvider.StaticProviderLoginPage;
import Utilities.GrowerDataProvider.StaticProviderSignUpPage;
import Utilities.TestBase;

public class ValidateSignUpFunctionality extends TestBase{ 
	
	CreateAccountPage signuppage;
	@BeforeClass()
	public void method() {
		
		parenttest = TestBase.extent.createTest("SignUp Functionality");
		driver = TestBase.launchURL( TestBase.configMap.get("browser"),TestBase.configMap.get("ApplicationURL"));	
				
	}
@Test(dataProvider = "createAccount", dataProviderClass = StaticProviderSignUpPage.class)
public void validatelogin(Map<String, String> dataMap)  {
	TestBase.test=parenttest.createNode("Validate createaccount functionality");
	signuppage.createAccountmethod(dataMap);
}
@AfterClass()
public void cleanup() {
	TestBase.extent.flush();
	driver.quit();
}

}
