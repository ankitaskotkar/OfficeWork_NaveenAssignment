import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Test {

	static WebDriver driver;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\akotkar\\Downloads\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://www.zoopla.co.uk/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		

		WebElement element = driver.findElement(By.cssSelector("button.ui-button-primary.ui-cookie-accept-all-medium-large"));
		Actions action = new Actions(driver);

		action.moveToElement(element).click().build().perform();

		WebElement element1 = driver.findElement(By.id("search-input-location-wrapper"));

		action.moveToElement(element1).click().sendKeys("London").build().perform();

		driver.findElement(By.id("search-submit")).click();

		// to find all the elments and to sort them in descending ordder

		List<WebElement> elements = driver.findElements(By.xpath(
				"//ul[@data-role=\"listview\"]//child::li//child::a[starts-with(@class,'listing-results-price')]"));

		System.out.println(elements.size());
	
		/*
		 * for(int i=0;i<=elements.size();i++) { if(i==0) {
		 * System.out.println(elements.get(i).getAttribute("text")); break; }
		 * 
		 * }
		 */
		  //to print all the prizes in descending order
		
		/*
		 * List<WebElement>
		 * sort=elements.stream().sorted().collect(Collectors.toList());
		 * 
		 * for(int i=sort.size();i>=0;i--) {
		 * System.out.println(sort.get(i).getAttribute("text")); }
		 */

		// To click 5th element

		
		  driver.findElement(By.xpath(
		  "//ul[@data-role=\"listview\"]//child::li[1]//img")).click();
		  
		  WebElement
		  clientName=driver.findElement(By.cssSelector("h4.ui-agent__name"));
		  
		  String name=clientName.getText();
		  
		  clientName.click();
		  
		  String expectedName=driver.findElement(By.cssSelector( "h1.bottom-half>b:nth-of-type(1)")).getText();
		  
		  Assert.assertEquals(name, expectedName);
		 

	}
}
