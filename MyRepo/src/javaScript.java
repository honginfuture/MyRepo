import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class javaScript {

	public static void jScript(WebDriver driver) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// driver.manage().window().maximize();
		// This will scroll the web page till end.
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		js.executeScript("window.scrollBy(0, 50000)");
		js.executeScript("window.scrollBy(0, -1000)");
		Thread.sleep(500);
		js.executeScript("window.scrollBy(0, 50000)");
		js.executeScript("window.scrollBy(0, -1000)");
		Thread.sleep(500);
		js.executeScript("window.scrollBy(0, 50000)");
		Thread.sleep(500);
		js.executeScript("window.scrollBy(0, 50000)");
		js.executeScript("window.scrollBy(0, -1000)");
		Thread.sleep(500);
		js.executeScript("window.scrollBy(0, 50000)");
		js.executeScript("window.scrollBy(0, -1000)");
	}
}
