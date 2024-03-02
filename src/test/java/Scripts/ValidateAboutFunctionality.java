package Scripts;

import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.AboutPage;
import Pages.LoginPage;
import Utilities.GrowerDataProvider.StaticProviderLoginPage;
import Utilities.GrowerDataProvider.StaticProvideraboutPage;
import Utilities.TestBase;


public class ValidateAboutFunctionality extends TestBase{ 
	AboutPage aboutPage;
	LoginPage loginpage;
	@BeforeClass()
	public void method() {
		
		parenttest = TestBase.extent.createTest("about Functionality");
		driver = TestBase.launchURL( TestBase.configMap.get("browser"),TestBase.configMap.get("ApplicationURL"));	
		aboutPage=new AboutPage();
		loginpage = new LoginPage();
		
	}
@Test(priority =1)
public void validatelogin()  {
	TestBase.test=parenttest.createNode("Validating with the provided credentials");
	loginpage.loginmethod(TestBase.configMap.get("UserName"), TestBase.configMap.get("Password"));
}

@Test(dataProvider = "about", dataProviderClass = StaticProvideraboutPage.class, priority =2 )
public void validateAbout(Map<String, String> dataMap)  {
	TestBase.test=parenttest.createNode("Validating about functionality");
	aboutPage.aboutmethod(dataMap);
}

@AfterClass()
public void cleanup() {
	TestBase.extent.flush();
	driver.quit();
}


}
