package Utilities;

import java.util.Iterator;

import org.testng.annotations.DataProvider;

public class GrowerDataProvider {
public static class StaticProviderLoginPage{
	@DataProvider(name = "loginPage", parallel = false)
	public static Iterator<Object[]> getdata(){
		Iterator<Object[]> testData = DPExcelUtil.getTestData("input/GrowerPortal.xlsx", "loginPage");
		return testData;
		
	}

}
public static class StaticProviderSignUpPage{
	@DataProvider(name = "createAccount", parallel = false)
	public static Iterator<Object[]> getdata(){
		Iterator<Object[]> testData = DPExcelUtil.getTestData("input/GrowerPortal.xlsx", "createAccount");
		return testData;
		
	}

}
public static class StaticProviderdashboardPage{
	@DataProvider(name = "dashboard", parallel = false)
	public static Iterator<Object[]> getdata(){
		Iterator<Object[]> testData = DPExcelUtil.getTestData("input/GrowerPortal.xlsx", "dashboard");
		return testData;
		
	}


}
public static class StaticProviderforgetPasswordPage{
	@DataProvider(name = "forgetPassword", parallel = false)
	public static Iterator<Object[]> getdata(){
		Iterator<Object[]> testData = DPExcelUtil.getTestData("input/GrowerPortal.xlsx", "forgetPassword");
		return testData;
	}
}
public static class StaticProviderAddApplicationPage{
	@DataProvider(name = "AddApplication", parallel = false)
	public static Iterator<Object[]> getdata(){
		Iterator<Object[]> testData = DPExcelUtil.getTestData("input/GrowerPortal.xlsx", "AddApplication");
		return testData;
	}
}
public static class StaticProviderUploadPhotoPage{
	@DataProvider(name = "UploadPhoto", parallel = false)
	public static Iterator<Object[]> getdata(){
		Iterator<Object[]> testData = DPExcelUtil.getTestData("input/GrowerPortal.xlsx", "UploadPhoto");
		return testData;
	}
}
public static class StaticProvideraboutPage{
	@DataProvider(name = "about", parallel = false)
	public static Iterator<Object[]> getdata(){
		Iterator<Object[]> testData = DPExcelUtil.getTestData("input/GrowerPortal.xlsx", "about");
		return testData;
	}
}
public static class StaticProviderContactUsPage{
	@DataProvider(name = "ContactUs", parallel = false)
	public static Iterator<Object[]> getdata(){
		Iterator<Object[]> testData = DPExcelUtil.getTestData("input/GrowerPortal.xlsx", "ContactUs");
		return testData;
	}
}
public static class StaticProviderreportPage{
	@DataProvider(name = "report", parallel = false)
	public static Iterator<Object[]> getdata(){
		Iterator<Object[]> testData = DPExcelUtil.getTestData("input/GrowerPortal.xlsx", "report");
		return testData;
	}
}


public static class StaticProvidersensorDataPage{
	@DataProvider(name = "sensorData", parallel = false)
	public static Iterator<Object[]> getdata(){
		Iterator<Object[]> testData = DPExcelUtil.getTestData("input/GrowerPortal.xlsx", "sensorData");
		return testData;
	}
}
public static class StaticProviderstepsToFollowPage{
	@DataProvider(name = "stepsToFollow", parallel = false)
	public static Iterator<Object[]> getdata(){
		Iterator<Object[]> testData = DPExcelUtil.getTestData("input/GrowerPortal.xlsx", "stepsToFollow");
		return testData;
	}
}
public static class StaticProviderUserInformationPage{
	@DataProvider(name = "UserInformation", parallel = false)
	public static Iterator<Object[]> getdata(){
		Iterator<Object[]> testData = DPExcelUtil.getTestData("input/GrowerPortal.xlsx", "UserInformation");
		return testData;
	}

}
}

