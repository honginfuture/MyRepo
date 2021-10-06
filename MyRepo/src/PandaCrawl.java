import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PandaCrawl {
	public static void main(String[] args) throws IOException, InterruptedException {

		// crawlProducts("https://www.foodpanda.hk/darkstore/y5f3/pandamart-sai-ying-pun");
		crawlShops(
				"https://www.foodpanda.hk/restaurants/new?lat=22.274237&lng=114.1726391&expedition=pickup&vertical=restaurants");
	}

	public static void crawlShops(String url) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", // "/Users/Hong/eclipse/chromedriver");// MacOS
				"C:\\Users\\RCHCHAN\\eclipse\\chromedriver.exe");// Windows
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		javaScript.jScript(driver);
		// driver.findElement(By.cssSelector("div.language-wrapper > div > //
		// a:nth-child(2)")).click();
		Document doc = Jsoup.parse(driver.getPageSource()); // �j�U

		Elements departments = doc.select("a[href^=/restaurant]"); // Select �U Department Link
		HashSet<String> departSet = new HashSet<String>(); // new HashSet for unique Department Link eg: �s�A���~
		for (Element ele : departments) {
			departSet.add(ele.attr("href"));
		}
		departSet.forEach(System.out::println);

		for (String ele : departSet) {
			driver.navigate().to(url + ele);
			javaScript.jScript(driver);
			doc = Jsoup.parse(driver.getPageSource());
			Elements test = doc.select("section.vendor-lane-section > h3");
			for (Element catName : test) {
				if (catName.tagName().equals("h3"))
					System.out.println(catName.text());
			}
//
//			Elements divElements = doc.select("div.swimlane-as-grid > h2" + ",span[class=\"product-card-name\"]"
//					+ ",div[class=\"product-card-price cl-neutral-primary f-14 fw-light\"]"
//					+ ",div[class=\"product-card-price-before-discount cl-neutral-secondary f-14 fw-light\"]"
//					+ ",div[class=\"product-deal-tag\"]");
//
//			int nameCount = 0;
//			int promoCount = 0;
//			int dealTag = 0;
//			int discountTag = 0;
//
//			StringBuilder builder = new StringBuilder();
//			ArrayList<Element> arr = new ArrayList<Element>();
//			ArrayList<Product> products = new ArrayList<Product>();
//			System.out.println("Total Element: " + divElements.size());
//
//			for (Element divEle : divElements) {
//				arr.add(divEle);
//				// System.out.println(divEle.text());
//			}
//			// System.out.println(arr.size());
//
//			String categoryName = "";
//			for (int i = 0; i < arr.size() - 2; i++) {
//				if (arr.get(i).tagName().equals("h2")) {
//					categoryName = arr.get(i).text();
//					System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXxCateName: " + categoryName);
//				} else if (arr.get(i).attr("class").equals("product-card-name")
//						&& arr.get(i + 1).attr("class").equals("product-card-price cl-neutral-primary f-14 fw-light")
//						&& arr.get(i + 2).attr("class").equals("product-card-name")) {
//					nameCount++;
//					dealTag++;
//					products.add(new Product(categoryName, arr.get(i).text(), arr.get(i + 1).text(), "   No Discount",
//							"No Promotion"));
//				} else if (arr.get(i).attr("class").equals("product-card-name")
//						&& arr.get(i + 1).attr("class").equals("product-card-price cl-neutral-primary f-14 fw-light")
//						&& arr.get(i + 2).attr("class").equals("product-deal-tag")
//						&& arr.get(i).attr("class").equals("product-card-name")) {
//					nameCount++;
//					dealTag++;
//					products.add(new Product(categoryName, arr.get(i).text(), arr.get(i + 1).text(), "   No Discount",
//							arr.get(i + 2).text()));
//				} else if (arr.get(i).attr("class").equals("product-card-name")
//						&& arr.get(i + 1).attr("class").equals("product-card-price cl-neutral-primary f-14 fw-light")
//						&& arr.get(i + 2).attr("class")
//								.equals("product-card-price-before-discount cl-neutral-secondary f-14 fw-light")
//						&& arr.get(i + 3).attr("class").equals("product-deal-tag")) {
//					nameCount++;
//					promoCount++;
//					dealTag++;
//					discountTag++;
//					products.add(new Product(categoryName, arr.get(i).text(), arr.get(i + 1).text(),
//							arr.get(i + 2).text(), arr.get(i + 3).text()));
//				}
//			}

//				// write to txt
//		String fileDate = java.time.LocalDate.now().toString();
//		FileWriter file = new FileWriter("C:\\Users\\RCHCHAN\\Desktop\\Test\\" + fileDate + ".txt", // Windows
//				// "/Users/Hong/Desktop/" + java.time.LocalDate.now().toString() + ".txt",
//				true);
//		file.write("");
//		file.write("Product Category\tProduct name\tProduct Price\tNormal Price\tDeal\r\n");
//
//
//			for (int i = 0; i < products.size(); i++) {
//				builder.append(products.get(i).prodCat + "\t" + products.get(i).prodName + "\t"
//						+ products.get(i).prodPrice.substring(3) + "\t" + products.get(i).disPrice.substring(3) + "\t"
//						+ products.get(i).deal + "\r\n");
//				System.out.print(products.get(i).prodCat + "\t" + products.get(i).prodName + "\t"
//						+ products.get(i).prodPrice.substring(3) + "\t" + products.get(i).disPrice.substring(3) + "\t"
//						+ products.get(i).deal + "\r\n");
//			}
//			file.append(builder.toString());
		}
//		file.close();
		driver.close();
		driver.quit();

	}

	public static void crawlProducts(String url) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", // "/Users/Hong/eclipse/chromedriver");// MacOS
				"C:\\Users\\RCHCHAN\\eclipse\\chromedriver.exe");// Windows
		WebDriver driver = new ChromeDriver();

		driver.get(url);

//		driver.findElement(By.cssSelector("#delivery-information-postal-index")).sendKeys("213 Queen's Road East");
//		driver.findElement(By.cssSelector("#delivery-information-postal-index")).sendKeys(Keys.ENTER);
//		driver.findElement(By.cssSelector(
//				"#delivery-information-postal-index-form > div.button-container.two-buttons > button.button.restaurants-search-form__button.js-restaurants-search-submit.restaurants-search-form__button--full.js-restaurants-search-button.gtm-homepage-delivery-button.restaurants-search-form__button--flexible.js-ripple"))
//				.click();

		javaScript.jScript(driver);
		// driver.findElement(By.cssSelector("div.language-wrapper > div > //
		// a:nth-child(2)")).click();
		Document doc = Jsoup.parse(driver.getPageSource()); // �j�U

		Elements departments = doc.select("a[href^=#category]"); // Select �U Department Link
		HashSet<String> departSet = new HashSet<String>(); // new HashSet for unique Department Link eg: �s�A���~
		for (Element ele : departments) {
			departSet.add(ele.attr("href"));
		}
		departSet.forEach(System.out::println);

		// write to txt
		String fileDate = java.time.LocalDate.now().toString();
		FileWriter file = new FileWriter("C:\\Users\\RCHCHAN\\Desktop\\Test\\" + fileDate + ".txt", // Windows
				// "/Users/Hong/Desktop/" + java.time.LocalDate.now().toString() + ".txt",
				true);
		file.write("");
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

}
