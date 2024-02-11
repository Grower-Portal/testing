package delete;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.FindBy;

public class Random {

	public static void main(String[] args) throws InterruptedException {
		String path="C:\\Users\\Pavan\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe";
		System.setProperty("webdriver.msedge.driver", path);
//		op.setBinary("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe");
//		op.setExperimentalOption("debuggerAddress", "localhost:9898");
		ChromeDriver cd = new ChromeDriver();
		System.out.println(cd.getCurrentUrl());
		cd.get("https://youtube.com");
		cd.switchTo().newWindow(WindowType.TAB);
		Set<String> windows=cd.getWindowHandles();
		Iterator<String> scope=windows.iterator();
		String parentId=scope.next();
		String chaildId=scope.next();
		cd.navigate().to("https://accounts.google.com/v3/signin/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&emr=1&flowEntry=ServiceLogin&flowName=GlifWebSignIn&followup=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&ifkv=ASKXGp1LKNZWXmp0n-vl7gdZjK-1gbOS1NCnFV3-DhqT8oNvIE-1dI17qgYcj3yWuuOtLRPvLnZ5kQ&osid=1&passive=1209600&service=mail&theme=glif");
		cd.findElement(By.xpath("//input[@type='email']")).sendKeys("pravalikareddykatta1@gmail.com");
		cd.close();
		Thread.sleep(5000);
		cd.switchTo().window(parentId);
		//cd.findElement(By.xpath("//yt-formatted-string[text()='Music']")).click();
		System.out.println(cd.getCurrentUrl());
		
	}

}
