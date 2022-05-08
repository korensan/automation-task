package automation;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class zengo_task {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/Users/korensalav/Downloads/chromedriver");

		// initialize the two requested links in the task
		String expectedUrl1 = "https://zengo.com/";
		String expectedUrl2 = "https://zengowallet.banxa.com/";

		// Opening the browser on the home page
		WebDriver driver = new ChromeDriver();
		driver.get(expectedUrl1);

		// Print the requested address and the address we actually reached
		System.out.println("Desired address: " + expectedUrl1);
		System.out.println("Current address: " + driver.getCurrentUrl());

		// Check if we have reached the requested address
		if (driver.getCurrentUrl().equals(expectedUrl1)) {
			System.out.println("Navigated to correct webpage!" + "\n");
		} else
			System.out.println("Didn't navigate to correct webpage" + "\n");

		// Delay for elements to load
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		driver.findElement(By.cssSelector("#menu-item-13191 > button")).click();
		driver.findElement(By.cssSelector("#menu-item-10474 > a")).click();

		// Print the requested address and the address we actually reached
		System.out.println("Desired address: " + expectedUrl2);
		System.out.println("Current address: " + driver.getCurrentUrl());

		// Check if we have reached the requested address
		if (driver.getCurrentUrl().startsWith("https://zengowallet.banxa.com")) {
			System.out.println("Navigated to correct webpage!" + "\n");
		} else
			System.out.println("Didn't navigate to correct webpage" + "\n");

		// Delay for elements to load
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		// Check if the logo is displayed
		WebElement imageWebElement = driver.findElement(By.xpath(
				"//img[@src='https://btc-storage-syd-p1-ap-southeast-2-branding-files.s3.ap-southeast-2.amazonaws.com/ZENGOWEB/logo/M8BBuMvyNP1RKDZAFfadxXzV0Rui1JCPC0zoi0v9.png']"));
		Boolean isImageLoaded = (Boolean) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
				imageWebElement);
		if (isImageLoaded)
			System.out.println("Logo displayed successfully!");
		else
			System.out.println("Logo not displayed successfully");

		driver.navigate().back();
		driver.navigate().back();
		// Delay for elements to load
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.close();

	}

}
