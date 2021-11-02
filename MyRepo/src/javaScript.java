import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class javaScript {

	public static void jScript(WebDriver driver) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// driver.manage().window().maximize();
		// This will scroll the web page till end.
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		// Actions action = new Actions(driver);
		// action.moveByOffset(0, 0).perform();
//action.click();
		Thread.sleep(3100);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		js.executeScript("window.scrollBy(0, -1000)");

		Thread.sleep(3200);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		js.executeScript("window.scrollBy(0, -1000)");

		Thread.sleep(3300);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		js.executeScript("window.scrollBy(0, -1000)");
		// action.moveByOffset(0, 0).perform();
		// action.click();
		Thread.sleep(3400);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		js.executeScript("window.scrollBy(0, -1000)");

		Thread.sleep(3400);
	}
}
