import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Network.UserAgent;

public class PandaCrawl {
	public static void main(String[] args) throws IOException, InterruptedException {

		 crawlProducts("https://www.foodpanda.hk/darkstore/x5xv/pandamart-wan-chai");
		// crawlShop("https://www.foodpanda.hk/restaurants/new?lat=22.274237&lng=114.1726391&vertical=shop&expedition=delivery");
		//crawlShops("https://www.foodpanda.hk/restaurants/new?lat=22.274237&lng=114.1726391&expedition=pickup&vertical=restaurants");
	}

	public static void crawlProducts(String url) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", // "/Users/Hong/eclipse/chromedriver");// MacOS
				"C:\\Users\\RCHCHAN\\eclipse\\chromedriver.exe");// Windows
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		javaScript.jScript(driver);
		Document doc = Jsoup.parse(driver.getPageSource()); // �j�U
		Elements departments = doc.select("a[href^=#category]"); // Select �U Department Link
		HashSet<String> departSet = new HashSet<String>(); // new HashSet for unique Department Link eg: �s�A���~
		for (Element ele : departments) {
			departSet.add(ele.attr("href"));
		}
		departSet.forEach(System.out::println);
		// write to txt
		String fileDate = java.time.LocalDate.now().toString();
		FileWriter file = new FileWriter("C:\\Users\\RCHCHAN\\Desktop\\Test\\" + fileDate + "-PandaMart.txt", // Windows
				// "/Users/Hong/Desktop/" + java.time.LocalDate.now().toString() + ".txt",
				true);
		file.write("Product Category\tProduct name\tProduct Price\tNormal Price\tDeal\r\n");

		for (String ele : departSet) {
			driver.navigate().to(url + ele);
			javaScript.jScript(driver);
			doc = Jsoup.parse(driver.getPageSource());
//			Elements test = doc.select("div.swimlane-as-grid > h2");
//			for (Element catName : test) {
//				if (catName.tagName().equals("h2"))
//					System.out.println(catName.text());
//			}

			Elements divElements = doc.select("div.swimlane-as-grid > h2" + ",span[class=\"product-card-name\"]"
					+ ",div[class=\"product-card-price cl-neutral-primary f-14 fw-light\"]"
					+ ",div[class=\"product-card-price-before-discount cl-neutral-secondary f-14 fw-light\"]"
					+ ",div[class=\"product-deal-tag\"]");

			int nameCount = 0;
			int promoCount = 0;
			int dealTag = 0;
			int discountTag = 0;

			StringBuilder builder = new StringBuilder();
			ArrayList<Element> arr = new ArrayList<Element>();
			ArrayList<Product> products = new ArrayList<Product>();
			System.out.println("Total Element: " + divElements.size());

			for (Element divEle : divElements) {
				arr.add(divEle);
				// System.out.println(divEle.text());
			}
			// System.out.println(arr.size());

			String categoryName = "";
			for (int i = 0; i < arr.size() - 2; i++) {
				if (arr.get(i).tagName().equals("h2")) {
					categoryName = arr.get(i).text();
					System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXxCateName: " + categoryName);
				} else if (arr.get(i).attr("class").equals("product-card-name")
						&& arr.get(i + 1).attr("class").equals("product-card-price cl-neutral-primary f-14 fw-light")
						&& arr.get(i + 2).attr("class").equals("product-card-name")) {
					nameCount++;
					dealTag++;
					products.add(new Product(categoryName, arr.get(i).text(), arr.get(i + 1).text(), "   No Discount",
							"No Promotion"));
				} else if (arr.get(i).attr("class").equals("product-card-name")
						&& arr.get(i + 1).attr("class").equals("product-card-price cl-neutral-primary f-14 fw-light")
						&& arr.get(i + 2).attr("class").equals("product-deal-tag")
						&& arr.get(i).attr("class").equals("product-card-name")) {
					nameCount++;
					dealTag++;
					products.add(new Product(categoryName, arr.get(i).text(), arr.get(i + 1).text(), "   No Discount",
							arr.get(i + 2).text()));
				} else if (arr.get(i).attr("class").equals("product-card-name")
						&& arr.get(i + 1).attr("class").equals("product-card-price cl-neutral-primary f-14 fw-light")
						&& arr.get(i + 2).attr("class")
								.equals("product-card-price-before-discount cl-neutral-secondary f-14 fw-light")
						&& arr.get(i + 3).attr("class").equals("product-deal-tag")) {
					nameCount++;
					promoCount++;
					dealTag++;
					discountTag++;
					products.add(new Product(categoryName, arr.get(i).text(), arr.get(i + 1).text(),
							arr.get(i + 2).text(), arr.get(i + 3).text()));
				}
			}

			for (int i = 0; i < products.size(); i++) {
				builder.append(products.get(i).prodCat + "\t" + products.get(i).prodName + "\t"
						+ products.get(i).prodPrice.substring(3) + "\t" + products.get(i).disPrice.substring(3) + "\t"
						+ products.get(i).deal + "\r\n");
				System.out.print(products.get(i).prodCat + "\t" + products.get(i).prodName + "\t"
						+ products.get(i).prodPrice.substring(3) + "\t" + products.get(i).disPrice.substring(3) + "\t"
						+ products.get(i).deal + "\r\n");
			}
			file.append(builder.toString());
		}
		file.close();
		driver.close();
		driver.quit();

	}

	public static void crawlShops(String url) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", // "/Users/Hong/eclipse/chromedriver");// MacOS
				"C:\\Users\\RCHCHAN\\eclipse\\chromedriver.exe");// Windows
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		javaScript.jScript(driver); // This will scroll the web page till end.
		Document doc = Jsoup.parse(driver.getPageSource()); // �j�U
		Elements shopLinks = doc.select("a[href^=/shop]"); // Select �U Department Link
		HashSet<String> shopSet = new HashSet<String>(); // new HashSet for unique Department Link eg: �s�A���~
		for (Element ele : shopLinks) {
			shopSet.add(ele.attr("href"));
		}
		shopSet.forEach(System.out::println);
		// write to txt
		String fileDate = java.time.LocalDate.now().toString();
		FileWriter file = new FileWriter("C:\\Users\\RCHCHAN\\Desktop\\Test\\" + fileDate + "-PandaMall.txt", // Windows
				// "/Users/Hong/Desktop/" + java.time.LocalDate.now().toString() + ".txt",
				true);
		file.write("Shop Name\tShop Promotion\tShop Badge\r\n");
//		for (String ele : shopSet) {
//			driver.navigate().to("https://www.foodpanda.hk" + ele);
//			javaScript.jScript(driver);
//			doc = Jsoup.parse(driver.getPageSource());

		Elements divElements = doc.select("span[class=\"name fn\"]" + ",span[class=\"box-flex fd-row ai-center\"]"
				+ ",span[class=\"badge-info\"]");

		int nameCount = 0;
		int promoCount = 0;
		int badgeCount = 0;

		StringBuilder builder = new StringBuilder();
		ArrayList<Element> arr = new ArrayList<Element>();
		ArrayList<Shop> shops = new ArrayList<Shop>();
		System.out.println("Total Element: " + divElements.size());

		for (Element divEle : divElements) {
			arr.add(divEle);
		}
		// System.out.println(arr.size());
		// write to txt

		for (int i = 0; i < arr.size() - 2; i++) {
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

		for (int i = 0; i < shops.size(); i++) {
			builder.append(shops.get(i).sName + "\t" + shops.get(i).promo + "\t" + shops.get(i).badge + "\r\n");
			System.out.print(shops.get(i).sName + "\t" + shops.get(i).promo + "\t" + shops.get(i).badge + "\r\n");
		}
		file.append(builder.toString());
//		}
		file.close();
		driver.close();
		driver.quit();

	}
}
