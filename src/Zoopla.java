import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Zoopla {
	  WebDriver driver;
	  @Test
	  public void f() {
		  System.setProperty("webdriver.chrome.driver","C:\\Users\\akotkar\\Downloads\\chromedriver_win32\\chromedriver.exe");	
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			//driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.get("https://www.zoopla.co.uk/");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			WebElement element =driver.findElement(By.cssSelector("button.ui-button-primary.ui-cookie-accept-all-medium-large"));
			Actions action= new Actions(driver);
			
			
			action.moveToElement(element).click().build().perform();
			
			WebElement element1=driver.findElement(By.id("search-input-location-wrapper"));
			
		
			action.moveToElement(element1).click().sendKeys("London").build().perform();
			
			driver.findElement(By.id("search-submit")).click();
			
			driver.findElement(By.xpath("//ul[@data-role=\"listview\"]//child::li[1]//img")).click();
			
			WebElement clientName=driver.findElement(By.cssSelector("h4.ui-agent__name"));
			
			String name=clientName.getText();
			
			clientName.click();
			
			String expectedName=driver.findElement(By.cssSelector("h1.bottom-half>b:nth-of-type(1)")).getText();
			
			Assert.assertEquals(name, expectedName);
			
			System.out.println("Client Name:"+name);
			
			System.out.println("Expected:" +expectedName);
	  }
}
