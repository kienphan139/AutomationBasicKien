package webdriver;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Css {
	
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty(projectPath);
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", "D:\\Data test auto\\geckodriver-v0.33.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
			//test demo
	}

	@Test
	public void TC_01_Registerwithemptydata() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.cssSelector("div[class='field_btn'] button[type='submit']")).click();
		assertEquals(driver.findElement(By.id("txtFirstname-error")).getText(), "Vui lòng nhập họ tên");
		assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email");
		assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Vui lòng nhập lại địa chỉ email");
		assertEquals(driver.findElement(By.id("txtPassword-error")).getText(), "Vui lòng nhập mật khẩu");
		assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Vui lòng nhập lại mật khẩu");
		assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Vui lòng nhập số điện thoại.");
	}
//test demo
	
	@Test
	public void TC_02_RegisterEmailInvalid() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.cssSelector("input#txtFirstname")).sendKeys("Nguyễn Văn A");
		driver.findElement(By.cssSelector("input#txtEmail")).sendKeys("nguyenvangamil.com");
		driver.findElement(By.cssSelector("input#txtCEmail")).sendKeys("A@ma.com");
		driver.findElement(By.cssSelector("input#txtPassword")).sendKeys("abc123");
		driver.findElement(By.cssSelector("input#txtCPassword")).sendKeys("abc123");
		driver.findElement(By.cssSelector("input#txtPhone")).sendKeys("0998639863");
		driver.findElement(By.cssSelector("div[class='field_btn'] button[type='submit']")).click();
		assertEquals(driver.findElement(By.cssSelector("div[class='form frmRegister'] label[id='txtEmail-error']"))
				.getText(), "Vui lòng nhập email hợp lệ");
		assertEquals(driver.findElement(By.cssSelector("div[class='form frmRegister'] label[id='txtCEmail-error']"))
				.getText(), "Email nhập lại không đúng");
	}

	@Test
	public void TC_03_RegisterPasswordWith6Character() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.cssSelector("input#txtFirstname")).sendKeys("Nguyễn Văn A");
		driver.findElement(By.cssSelector("input#txtEmail")).sendKeys("nguyenvana@gmail.com");
		driver.findElement(By.cssSelector("input#txtCEmail")).sendKeys("nguyenvana@gmail.com");
		driver.findElement(By.cssSelector("input#txtPassword")).sendKeys("123");
		driver.findElement(By.cssSelector("input#txtCPassword")).sendKeys("123");
		driver.findElement(By.cssSelector("input#txtPhone")).sendKeys("0998639863");
		driver.findElement(By.cssSelector("div[class='field_btn'] button[type='submit']")).click();
		assertEquals(driver.findElement(By.cssSelector("div[class='form frmRegister'] label[id='txtPassword-error']"))
				.getText(), "Mật khẩu phải có ít nhất 6 ký tự");
		assertEquals(driver.findElement(By.cssSelector("div[class='form frmRegister'] label[id='txtCPassword-error']"))
				.getText(), "Mật khẩu phải có ít nhất 6 ký tự");
	}

	@Test
	public void TC_04_RegisterIncorrectConfirmEmail() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.cssSelector("input#txtFirstname")).sendKeys("Nguyễn Văn A");
		driver.findElement(By.cssSelector("input#txtEmail")).sendKeys("nguyenvana@gmail.com");
		driver.findElement(By.cssSelector("input#txtCEmail")).sendKeys("nguyenvan@gmail.com");
		driver.findElement(By.cssSelector("input#txtPassword")).sendKeys("abc123");
		driver.findElement(By.cssSelector("input#txtCPassword")).sendKeys("abc123");
		driver.findElement(By.cssSelector("input#txtPhone")).sendKeys("0998639863");
		driver.findElement(By.cssSelector("div[class='field_btn'] button[type='submit']")).click();
		assertEquals(driver.findElement(By.cssSelector("div[class='form frmRegister'] label[id='txtCEmail-error']"))
				.getText(), "Email nhập lại không đúng");
	}

	@Test
	public void TC_05_RegisterIncorrectConfirmPassword() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.cssSelector("input#txtFirstname")).sendKeys("Nguyễn Văn A");
		driver.findElement(By.cssSelector("input#txtEmail")).sendKeys("nguyenvana@gmail.com");
		driver.findElement(By.cssSelector("input#txtCEmail")).sendKeys("nguyenvana@gmail.com");
		driver.findElement(By.cssSelector("input#txtPassword")).sendKeys("abc123");
		driver.findElement(By.cssSelector("input#txtCPassword")).sendKeys("abc126");
		driver.findElement(By.cssSelector("input#txtPhone")).sendKeys("0998639863");
		driver.findElement(By.cssSelector("div[class='field_btn'] button[type='submit']")).click();
		assertEquals(driver.findElement(By.cssSelector("div[class='form frmRegister'] label[id='txtCPassword-error']"))
				.getText(), "Mật khẩu bạn nhập không khớp");
	}

	@Test
	public void TC_06_RegisterInvalidPhone() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.cssSelector("input#txtFirstname")).sendKeys("Nguyễn Văn A");
		driver.findElement(By.cssSelector("input#txtEmail")).sendKeys("nguyenvana@gmail.com");
		driver.findElement(By.cssSelector("input#txtCEmail")).sendKeys("nguyenvana@gmail.com");
		driver.findElement(By.cssSelector("input#txtPassword")).sendKeys("abc123");
		driver.findElement(By.cssSelector("input#txtCPassword")).sendKeys("abc123");
		WebElement txtPhone = driver.findElement(By.cssSelector("input#txtPhone"));
		txtPhone.sendKeys("09986398");
		driver.findElement(By.cssSelector("div[class='field_btn'] button[type='submit']")).click();
		assertEquals(driver.findElement(By.cssSelector("div[class='form frmRegister'] label[id='txtPhone-error']"))
				.getText(), "Số điện thoại phải từ 10-11 số.");
		txtPhone.clear();
		txtPhone.sendKeys("0998639856894");
		assertEquals(driver.findElement(By.cssSelector("div[class='form frmRegister'] label[id='txtPhone-error']"))
				.getText(), "Số điện thoại phải từ 10-11 số.");
	}
	@AfterClass
	public void afterClass() {

	}


}
