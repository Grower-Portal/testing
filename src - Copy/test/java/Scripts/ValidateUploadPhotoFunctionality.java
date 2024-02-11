package Scripts;

import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.UploadPhotoPage;
import Utilities.GrowerDataProvider.StaticProviderLoginPage;
import Utilities.GrowerDataProvider.StaticProviderUploadPhotoPage;
import Utilities.TestBase;

public class ValidateUploadPhotoFunctionality extends TestBase{ 
	UploadPhotoPage uploadphotoPage;
	LoginPage loginpage;
	@BeforeClass()
	public void method() {
		
		parenttest = TestBase.extent.createTest("upload photo Functionality");
		driver = TestBase.launchURL( TestBase.configMap.get("browser"),TestBase.configMap.get("ApplicationURL"));	
		uploadphotoPage=new UploadPhotoPage();
		loginpage = new LoginPage();
		
	}
@Test(dataProvider = "loginPage", dataProviderClass = StaticProviderLoginPage.class)
public void validatelogin(Map<String, String> dataMap)  {
	TestBase.test=parenttest.createNode("Validating with the provided credentials");
	loginpage.loginmethod(dataMap.get("UserName"), dataMap.get("Password"));
}

@Test(dataProvider = "UploadPhoto", dataProviderClass = StaticProviderUploadPhotoPage.class)
public void validateAbout(Map<String, String> dataMap)  {
	TestBase.test=parenttest.createNode("Validating upload photo functionality");
	uploadphotoPage.UploadPhotoMethod(dataMap);
}

@AfterClass()
public void cleanup() {
	TestBase.extent.flush();
	driver.quit();
}

}
