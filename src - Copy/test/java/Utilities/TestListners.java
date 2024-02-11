package Utilities;

import java.util.Collection;
import java.util.List;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

public class TestListners implements ITestListener {

	@Override
	public void onTestSuccess(ITestResult tr) {
		// TODO Auto-generated method stub
		System.out.println("TestCase got passed successfully :" +tr.getName());
		//CommonFunctions.takeScreenshot("/pass/" +tr.getName());
	CommonFunctions.captureScreen(tr.getName());
		 // Reporter.log("<a href='" + destFile.getAbsolutePath() + "'><img src='" +destFile.getAbsolutePath() + "'height='100' width='100'/></a>"); 

	}
	

	@Override
	public void onTestFailure(ITestResult tr) {
		CommonFunctions.takeScreenshot("/fail/" +tr.getName());

		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult tr) {
		// TODO Auto-generated method stub
		
	}

}