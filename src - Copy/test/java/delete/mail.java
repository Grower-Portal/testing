package delete;

import java.sql.Driver;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class mail {

	public static void main(String[] args) throws InterruptedException {
		String path="C:\\Users\\Pavan\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe";
		System.setProperty("webdriver.msedge.driver", path);
		ChromeDriver cd = new ChromeDriver();
		cd.navigate().to("https://accounts.google.com/v3/signin/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&emr=1&flowEntry=ServiceLogin&flowName=GlifWebSignIn&followup=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&ifkv=ASKXGp1LKNZWXmp0n-vl7gdZjK-1gbOS1NCnFV3-DhqT8oNvIE-1dI17qgYcj3yWuuOtLRPvLnZ5kQ&osid=1&passive=1209600&service=mail&theme=glif");
		cd.findElement(By.xpath("//input[@type='email']")).sendKeys("agriportal8@gmail.com");
		cd.findElement(By.xpath("//span[text()='Next']")).click();
		Thread.sleep(5000);
		cd.findElement(By.xpath("//input[@type='password']")).sendKeys("Agri@123");
		cd.findElement(By.xpath("//span[text()='Next']")).click();
		Thread.sleep(5000);
		List<WebElement> lis=cd.findElements(By.xpath("//div[@class='Cp']/div/table/tbody/tr/td[4]//span/span[1]"));
		for(WebElement l:lis) {
			if(l.getText().contains("Google Community Te.")) {
				Thread.sleep(5000);
				l.click();
			}
		

	}
	}
}


