import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class javaScript {

	public static void jScript(WebDriver driver) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// driver.manage().window().maximize();
		// This will scroll the web page till end.
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		//Actions action = new Actions(driver);
		Thread.sleep(10000);
		//action.moveByOffset(0, 0).perform();
//action.click();
		Thread.sleep(10000);
		js.executeScript("window.scrollBy(0, 50000)");
		js.executeScript("window.scrollBy(0, -2000)");


		Thread.sleep(10000);
		js.executeScript("window.scrollBy(0, 50000)");
		js.executeScript("window.scrollBy(0, -2000)");

		Thread.sleep(10000);
		js.executeScript("window.scrollBy(0, 50000)");
		js.executeScript("window.scrollBy(0, -2000)");
		//action.moveByOffset(0, 0).perform();
		//action.click();
		Thread.sleep(10000);
		js.executeScript("window.scrollBy(0, 50000)");
		js.executeScript("window.scrollBy(0, -2000)");

		js.executeScript("window.scrollBy(0, 50000)");
		js.executeScript("window.scrollBy(0, -2000)");
		//action.moveByOffset(0, 0).perform();
		//action.click();
		Thread.sleep(10000);
	}
}
