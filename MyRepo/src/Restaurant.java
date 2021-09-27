import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Restaurant {

	public String rName;
	public String badge;
	public String promo;
	public String distance;
	public int ShopCount = 0;

	public Restaurant(String rName, String promo, String badge, String distance) {
		this.rName = rName;
		this.promo = promo;
		this.badge = badge;
		this.distance = distance;
		ShopCount++;
	}

	public static void crawlRest(String url) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\RCHCHAN\\eclipse\\chromedriver.exe");// Windows
		// System.setProperty("webdriver.chrome.driver",
		// "/Users/Hong/eclipse/chromedriver");//MacOS
		WebDriver driver = new ChromeDriver();

		// ---------------------------------------START of Wan Chai
		// Crawl Dairy Product
		driver.navigate().to(url
		// "https://www.foodpanda.hk/restaurants/new?lat=22.27987718737818&lng=114.18376973387&vertical=restaurants&expedition=pickup"
		// "https://www.foodpanda.hk/restaurants/new?lat=22.2742239&lng=114.1728051&vertical=shop&expedition=delivery/"
		);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		// This will scroll the web page till end.
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		js.executeScript("window.scrollBy(0, 50000)");
		js.executeScript("window.scrollBy(0, -1000)");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0, 50000)");
		js.executeScript("window.scrollBy(0, -1000)");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0, 50000)");
		js.executeScript("window.scrollBy(0, -1000)");
		Thread.sleep(2000);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		js.executeScript("window.scrollBy(0, 50000)");
		js.executeScript("window.scrollBy(0, -1000)");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0, 50000)");
		js.executeScript("window.scrollBy(0, -1000)");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0, 50000)");
		js.executeScript("window.scrollBy(0, -1000)");
		Thread.sleep(2000);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		js.executeScript("window.scrollBy(0, 50000)");
		js.executeScript("window.scrollBy(0, -1000)");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0, 50000)");
		js.executeScript("window.scrollBy(0, -1000)");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0, 50000)");
		js.executeScript("window.scrollBy(0, -1000)");
		Thread.sleep(2000);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		js.executeScript("window.scrollBy(0, 50000)");
		js.executeScript("window.scrollBy(0, -1000)");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0, 50000)");
		js.executeScript("window.scrollBy(0, -1000)");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0, 50000)");
		js.executeScript("window.scrollBy(0, -1000)");
		Thread.sleep(2000);
		Document doc = Jsoup.parse(driver.getPageSource());
		Element deliverTo = doc.selectFirst("span[class\"header-order-button-content\"]");
		Elements divElements = doc.select(
				"span[class=\"name fn\"],ul[class=\"extra-info mov-df-extra-info\"],span[class=\"box-flex fd-row ai-center\"],span[class=\"badge-info pickup-info\"]");

		int nameCount = 0;
		int promoCount = 0;
		int badgeCount = 0;

		StringBuilder builder = new StringBuilder();
		Iterator<Element> iterator = divElements.iterator();
		ArrayList<Element> arr = new ArrayList<Element>();
		ArrayList<Restaurant> rests = new ArrayList<Restaurant>();
		System.out.println("Deliver To: " + deliverTo + ", Total Element: " + divElements.size());

		while (iterator.hasNext()) {
			Element divEle = iterator.next();
			arr.add(divEle);
		}
		// System.out.println(arr.toString());

		for (int i = 0; i < arr.size() - 1; i++) {
			if (arr.get(i).attr("class").equals("name fn")
					&& arr.get(i + 2).attr("class").equals("box-flex fd-row ai-center")) {
				nameCount++;
				promoCount++;
				builder.append(nameCount + "\t" + arr.get(i).text() + "\r\n");
				rests.add(new Restaurant(arr.get(i).text(), arr.get(i + 1).text(), arr.get(i + 2).text(),
						arr.get(i + 3).text()));
			} else if (arr.get(i).attr("class").equals("name fn")
					&& arr.get(i + 1).attr("class").equals("badge-info pickup-info")) {
				badgeCount++;
			}
		}
		System.out.print("Total namefn: " + nameCount + "\r\n" + "Total box-flex fd-row ai-center: " + promoCount
				+ "\r\n" + "Total badge-info: " + badgeCount + "\r\n");
		StringBuilder builder1 = new StringBuilder();
		for (int i = 0; i < rests.size(); i++) {

			builder1.append("Restarant name: " + rests.get(i).distance + rests.get(i).rName + "\tRestarant Promo: \t"
					+ rests.get(i).promo + "\tRestarant Badge: \t" + rests.get(i).badge + "\t\r\n");
			System.out.print("Restarant name: \t" + rests.get(i).distance + rests.get(i).rName + "\tRestarant Promo: \t"
					+ rests.get(i).promo + "\tRestarant Badge: \t" + rests.get(i).badge + "\t\r\n");
		}
		FileWriter test = new FileWriter("C:\\Users\\RCHCHAN\\2.txt");
		test.write(builder1.toString());
		test.close();
	}
}
