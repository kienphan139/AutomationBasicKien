package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_01_Check_Environment {
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	private FirefoxDriver driver;

	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.gecko.driver", "D:\\Data test auto\\geckodriver-v0.33.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
	}

	@Test
	public void TC_01_Url() {
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/");
	}

	@Test
	public void TC_02_Logo() {
		Assert.assertTrue(driver.findElement(By.cssSelector("img.fb_logo")).isDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
}
