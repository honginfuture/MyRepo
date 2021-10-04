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

public class Shop {
	public String sName;
	public String badge;
	public String promo;
	public int ShopCount = 0;

	public Shop(String sName, String promo, String badge) {
		this.sName = sName;
		this.promo = promo;
		this.badge = badge;
		ShopCount++;
	}

	public static void crawlShop(String url) throws IOException, InterruptedException {
		// System.setProperty("webdriver.chrome.driver",
		// "C:\\Users\\RCHCHAN\\eclipse\\chromedriver.exe");// Windows
		System.setProperty("webdriver.chrome.driver", "/Users/Hong/eclipse/chromedriver");// MacOS
		WebDriver driver = new ChromeDriver();

		// ---------------------------------------START of Wan Chai
		// Crawl Dairy Product
		driver.navigate().to(url);

		// This will scroll the web page till end.
		javaScript.jScript(driver);
		Document doc = Jsoup.parse(driver.getPageSource());
		//Element deliverTo = doc.selectFirst("span[class\"header-order-button-content\"]");
		Elements divElements = doc.select("span[class=\"name fn\"],span[class=\"box-flex fd-row ai-center\"],span[class=\"badge-info\"]");

		int nameCount = 0;
		int promoCount = 0;
		int badgeCount = 0;

		StringBuilder builder = new StringBuilder();
		Iterator<Element> iterator = divElements.iterator();
		ArrayList<Element> arr = new ArrayList<Element>();
		ArrayList<Shop> shops = new ArrayList<Shop>();
		System.out.println("Total Element: " + divElements.size());

		while (iterator.hasNext()) {
			Element divEle = iterator.next();
			arr.add(divEle);
		}
		// System.out.println(arr.toString());

		for (int i = 0; i < arr.size() - 1; i++) {
			if (arr.get(i).attr("class").equals("name fn")
					&& arr.get(i + 1).attr("class").equals("box-flex fd-row ai-center")) {
				nameCount++;
				promoCount++;
				builder.append(nameCount + "\t" + arr.get(i).text() + "\r\n");
				shops.add(new Shop(arr.get(i).text(), arr.get(i + 1).text(), arr.get(i + 2).text()));
			} else if (arr.get(i).attr("class").equals("name fn")
					&& arr.get(i + 1).attr("class").equals("badge-info")) {
				badgeCount++;
			}
		}
		System.out.print("Total namefn: " + nameCount + "\r\n" + "Total box-flex fd-row ai-center: " + promoCount
				+ "\r\n" + "Total badge-info: " + badgeCount + "\r\n");
		StringBuilder builder1 = new StringBuilder();
		for (int i = 0; i < shops.size(); i++) {

			builder1.append("Shop name: \t" + shops.get(i).sName + "\tShop Promo: \t" + shops.get(i).promo
					+ "\tShop Badge: \t" + shops.get(i).badge + "\t\r\n");
			System.out.print("Shop name: \t" + shops.get(i).sName + "\tShop Promo: \t" + shops.get(i).promo
					+ "\tShop Badge: \t" + shops.get(i).badge + "\t\r\n");
		}
		FileWriter test = new FileWriter("C:\\Users\\RCHCHAN\\1.txt");
		test.write(builder1.toString());
		test.close();
		driver.close();
		driver.quit();
	}

}
