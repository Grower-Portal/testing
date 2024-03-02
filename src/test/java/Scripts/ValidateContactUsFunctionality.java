package Scripts;

import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.ContactUsPage;
import Pages.LoginPage;
import Utilities.GrowerDataProvider.StaticProviderContactUsPage;
import Utilities.GrowerDataProvider.StaticProviderLoginPage;
import Utilities.TestBase;
import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;


public class ValidateContactUsFunctionality extends TestBase{ 
	ContactUsPage contactuspage;
	LoginPage loginpage;
	@BeforeClass()
	public void method() {
		
		parenttest = TestBase.extent.createTest("contact us Functionality");
		driver = TestBase.launchURL( TestBase.configMap.get("browser"),TestBase.configMap.get("ApplicationURL"));	
		contactuspage=new ContactUsPage();
		loginpage = new LoginPage();
		
	}
@Test(priority = 1)
public void validatelogin()  {
	TestBase.test=parenttest.createNode("Validating with the provided credentials");
	loginpage.loginmethod(TestBase.configMap.get("UserName"), TestBase.configMap.get("Password"));
}

@Test(dataProvider = "ContactUs", dataProviderClass = StaticProviderContactUsPage.class,priority = 2)
public void validatecontactus(Map<String, String> dataMap)  {
	TestBase.test=parenttest.createNode("Validating contact us functionality");
	contactuspage.contactmethod(dataMap);
}


@AfterClass()
public void cleanup() {
	TestBase.extent.flush();
	driver.quit();
}

}

