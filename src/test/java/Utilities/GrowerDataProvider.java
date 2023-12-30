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
}
