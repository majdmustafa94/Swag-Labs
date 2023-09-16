import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Home_Page {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Majd Mustafa\\\\OneDrive\\\\Desktop\\\\chromedriver\\\\chromedriver\\\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://saucedemo.com");
		driver.manage().window().maximize();
		
		String user_name= "standard_user";
		String Password= "secret_sauce";
		
		driver.findElement(By.id("user-name")).sendKeys(user_name);
		Thread.sleep(2000);
		driver.findElement(By.id("password")).sendKeys(Password);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
		
		String actualTitle= driver.getTitle();
		String expectTiyle= "Swag Labs";
		
		Assert.assertEquals(actualTitle, expectTiyle);
		
		
//		if(actualTitle==expectTiyle) {
//			System.out.println("QA test Passed");
//		}
//		else {System.out.println("QA test Failed");}
		
		int expectItems= 11;
		
		List<WebElement> Buttons = driver.findElements(By.className("btn"));
		for(int i=0; i<Buttons.size(); i++) {
			Buttons.get(i).click();			
		}
		
		String actualItems= driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")).getText();
		
		int theActualnum= Integer.parseInt(actualItems);
		
		Assert.assertEquals(theActualnum, expectItems);

        

		
		
	}

}
