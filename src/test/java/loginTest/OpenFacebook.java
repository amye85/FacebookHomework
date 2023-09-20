package loginTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenFacebook {
WebDriver driver;
@BeforeTest
public void OpenApplication() {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.get("https://www.facebook.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	
}
@Test
public void loginTest() {
	driver.findElement(By.xpath("//input[@name='email']")).sendKeys("nurulvhai");
	WebElement password=driver.findElement(By.xpath("//input[@name='pass']"));
	password.clear();
	password.sendKeys("abc");
	driver.findElement(By.xpath("//button[@name='login']")).click();
	
	
}
@Test
public void assertionTest() {
	String actualtitle = "Facebook - log in or sign up";
	String expectedTitle=driver.getTitle();
	System.out.println("Facebook expected title :" + expectedTitle);
	Assert.assertEquals(actualtitle, expectedTitle);
	
	String actualUrl = "https://www.facebook.com/";
	String expectedUrl=driver.getCurrentUrl();
	System.out.println("Facebook expected Url :" + expectedUrl);
	Assert.assertEquals(actualUrl, expectedUrl);
}
}