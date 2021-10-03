import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Product {
	public String prodCat;
	public String prodName;
	public String prodPrice;
	public String disPrice;
	public String deal;
	public int productCount = 0;

	public Product(String prodCat, String prodName, String prodPrice, String disPrice, String deal) {
		this.prodName = prodName;
		this.prodCat = prodCat;
		this.prodPrice = prodPrice;
		this.disPrice = disPrice;
		this.deal = deal;
	}

	// public static void crawlProd(String url) {

	public static void crawlProduct(String url) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/Hong/eclipse/chromedriver");// MacOS
		// "C:\\Users\\RCHCHAN\\eclipse\\chromedriver.exe");// Windows
		WebDriver driver = new ChromeDriver();

		// Crawl Dairy Product
		driver.get(url);
		javaScript.jScript(driver);
		driver.findElement(By.cssSelector("div.language-wrapper > div > a:nth-child(2)")).click();
		Document doc = Jsoup.parse(driver.getPageSource()); // �j�U

		Elements departments = doc.select("a[href^=#category]"); // Select �U Department Link
		HashSet<String> departSet = new HashSet<String>(); // new HashSet for unique Department Link eg: �s�A���~
		for (Element ele : departments) {
			departSet.add(ele.attr("href"));
		}
		departSet.forEach(System.out::println);

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

			String fileDate = java.time.LocalDate.now().toString();

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
				//System.out.println(divEle.text());
			}
			//System.out.println(arr.size());

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

//		System.out.print("Total product-card-name: " + nameCount + "\r\n"
//				+ "product-card-price cl-neutral-primary f-14 fw-light: " + promoCount + "\r\n" + "Total deal Tag: "
//				+ dealTag + "\r\n" + "Total discount Tag: " + discountTag + "\r\n");

			// StringBuilder builder = new StringBuilder();
			for (int i = 0; i < products.size(); i++) {
				builder.append(
						"Product Category:\t" + products.get(i).prodCat + "\tProduct name:\t" + products.get(i).prodName
								+ "\tProduct Price: \t" + products.get(i).prodPrice.substring(3) + "\tNormal Price: \t"
								+ products.get(i).disPrice.substring(3) + "\tDeal: \t" + products.get(i).deal + "\r\n");
				System.out.print(
						"Product Category:\t" + products.get(i).prodCat + "\tProduct name:\t" + products.get(i).prodName
								+ "\tProduct Price: \t" + products.get(i).prodPrice.substring(3) + "\tNormal Price: \t"
								+ products.get(i).disPrice.substring(3) + "\tDeal: \t" + products.get(i).deal + "\r\n");
			}
			// FileWriter test = new FileWriter("C:\\Users\\RCHCHAN\\" + fileDate + ".txt",
			// true); // Windows
			FileWriter test = new FileWriter("/Users/Hong/Desktop/" + java.time.LocalDate.now().toString() + ".txt",
					true);test.flush();
			test.append(builder.toString());
			test.close();
		}
		driver.close();
		driver.quit();

	}
}