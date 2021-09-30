import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Product {
	public String prodName;
	public String prodPrice;
	public String disPrice;
	public String deal;
	public int productCount = 0;

	public Product(String prodName, String prodPrice, String disPrice, String deal) {
		this.prodName = prodName;
		this.prodPrice = prodPrice;
		this.disPrice = disPrice;
		this.deal = deal;
	}

	public static void crawlProd(String url) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\RCHCHAN\\eclipse\\chromedriver.exe");// Windows
		// System.setProperty("webdriver.chrome.driver",
		// "/Users/Hong/eclipse/chromedriver");//MacOS
		WebDriver driver = new ChromeDriver();

		// ---------------------------------------START of Wan Chai
		// Crawl Dairy Product
		driver.navigate().to(url);
		javaScript.jScript(driver);

		Document doc = Jsoup.parse(driver.getPageSource()); // 大廳
		Elements departments = doc.select("a[href" + "^=#category" + "]"); // Select 各 Department Link
		HashSet<String> departSet = new HashSet<String>(); // new HashSet for unique Department Link eg: 新鮮食品
		for (Element ele : departments) {
			departSet.add(ele.attr("href"));
		}
		departSet.forEach(System.out::println);

//		for (String departLink : departSet) {
//			driver.navigate().to(url + departLink);
//			javaScript.jScript(driver);
//			doc = Jsoup.parse(driver.getPageSource());
//			Elements catNames = doc.select("ul[class=\"categories-navigation\"]"); // Select 各Category Name
//			HashSet<String> catSet = new HashSet<String>(); // new HashSet for unique Category eg: 新鮮食品->生果
//			for (Element catName : catNames) {
//				 catSet.add(catName.text());
//				
//			}
//			catSet.forEach(System.out::println);
//		}

		for (String ele : departSet) {
			driver.navigate().to(url + ele);
			javaScript.jScript(driver);
			doc = Jsoup.parse(driver.getPageSource());
			//Elements catNames = doc.select("h1[class=\"category name\"]");
		//	for(Element catName:catNames) {System.out.println(catName.text());}
			Elements departmentName = doc.select("div[class=\"category-header\"]");
			Elements divElements = doc.select("span[class=\"product-card-name\"]"
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
			System.out.println(departmentName.text() + ", Total Element: " + divElements.size());

			for (Element divEle : divElements) {
				arr.add(divEle);
			}
			// System.out.println(arr.toString());

			for (int i = 0; i < arr.size() - 2; i++) {
				if (arr.get(i).attr("class").equals("product-card-name")
						&& arr.get(i + 1).attr("class").equals("product-card-price cl-neutral-primary f-14 fw-light")
						&& arr.get(i + 2).attr("class").equals("product-card-name")) {
					nameCount++;
					dealTag++;
					products.add(
							new Product(arr.get(i).text(), arr.get(i + 1).text(), "   No Discount", "No Promotion"));
				} else if (arr.get(i).attr("class").equals("product-card-name")
						&& arr.get(i + 1).attr("class").equals("product-card-price cl-neutral-primary f-14 fw-light")
						&& arr.get(i + 2).attr("class").equals("product-deal-tag")
						&& arr.get(i).attr("class").equals("product-card-name")) {
					nameCount++;
					dealTag++;
					products.add(new Product(arr.get(i).text(), arr.get(i + 1).text(), "   No Discount",
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
					products.add(new Product(arr.get(i).text(), arr.get(i + 1).text(), arr.get(i + 2).text(),
							arr.get(i + 3).text()));
				}
			}
			System.out.print("Total product-card-name: " + nameCount + "\r\n"
					+ "product-card-price cl-neutral-primary f-14 fw-light: " + promoCount + "\r\n" + "Total deal Tag: "
					+ dealTag + "\r\n" + "Total discount Tag: " + discountTag + "\r\n");

			// StringBuilder builder = new StringBuilder();
			for (int i = 0; i < products.size(); i++) {
				builder.append("Product name:\t" + products.get(i).prodName + "\tProduct Price: \t"
						+ products.get(i).prodPrice.substring(3) + "\tNormal Price: \t"
						+ products.get(i).disPrice.substring(3) + "\tDeal: \t" + products.get(i).deal + "\r\n");
				System.out.print("Product name:\t" + products.get(i).prodName + "\tProduct Price: \t"
						+ products.get(i).prodPrice.substring(3) + "\tNormal Price: \t"
						+ products.get(i).disPrice.substring(3) + "\tDeal: \t" + products.get(i).deal + "\r\n");
			}
			FileWriter test = new FileWriter("C:\\Users\\RCHCHAN\\" + fileDate + ".txt", true);
			test.append(builder.toString());
			test.close();
		}

//		Elements divElements = doc.select("span[class=\"product-card-name\"]"
//				+ ",div[class=\"product-card-price cl-neutral-primary f-14 fw-light\"]"
//				+ ",div[class=\"product-card-price-before-discount cl-neutral-secondary f-14 fw-light\"]"
//				+ ",div[class=\"product-deal-tag\"]");
//		
////		System.out.println(TotaldivElements.size());
//		int nameCount = 0;
//		int promoCount = 0;
//		int dealTag = 0;
//		int discountTag = 0;
//
//		StringBuilder builder = new StringBuilder();
//		Iterator<Element> iterator = divElements.iterator();
//		ArrayList<Element> arr = new ArrayList<Element>();
//		ArrayList<Product> products = new ArrayList<Product>();
//		System.out.println(", Total Element: " + divElements.size());
//
//		while (iterator.hasNext()) {
//			Element divEle = iterator.next();
//			arr.add(divEle);
//		}
//		// System.out.println(arr.toString());
//
//		for (int i = 0; i < arr.size() - 2; i++) {
//			if (arr.get(i).attr("class").equals("product-card-name")
//					&& arr.get(i + 1).attr("class").equals("product-card-price cl-neutral-primary f-14 fw-light")
//					&& arr.get(i + 2).attr("class").equals("product-card-name")) {
//				nameCount++;
//				dealTag++;
//				products.add(new Product(arr.get(i).text(), arr.get(i + 1).text(), "   No Discount", "No Promotion"));
//			} else if (arr.get(i).attr("class").equals("product-card-name")
//					&& arr.get(i + 1).attr("class").equals("product-card-price cl-neutral-primary f-14 fw-light")
//					&& arr.get(i + 2).attr("class").equals("product-deal-tag")
//					&& arr.get(i).attr("class").equals("product-card-name")) {
//				nameCount++;
//				dealTag++;
//				products.add(
//						new Product(arr.get(i).text(), arr.get(i + 1).text(), "   No Discount", arr.get(i + 2).text()));
//			} else if (arr.get(i).attr("class").equals("product-card-name")
//					&& arr.get(i + 1).attr("class").equals("product-card-price cl-neutral-primary f-14 fw-light")
//					&& arr.get(i + 2).attr("class")
//							.equals("product-card-price-before-discount cl-neutral-secondary f-14 fw-light")
//					&& arr.get(i + 3).attr("class").equals("product-deal-tag")) {
//				nameCount++;
//				promoCount++;
//				dealTag++;
//				discountTag++;
//				products.add(new Product(arr.get(i).text(), arr.get(i + 1).text(), arr.get(i + 2).text(),
//						arr.get(i + 3).text()));
//			}
//		}
//		System.out.print("Total product-card-name: " + nameCount + "\r\n"
//				+ "product-card-price cl-neutral-primary f-14 fw-light: " + promoCount + "\r\n" + "Total deal Tag: "
//				+ dealTag + "\r\n" + "Total discount Tag: " + discountTag + "\r\n");
//
//		// StringBuilder builder = new StringBuilder();
//		for (int i = 0; i < products.size(); i++) {
//			builder.append("Product name:\t" + products.get(i).prodName + "\tProduct Price: \t"
//					+ products.get(i).prodPrice.substring(3) + "\tNormal Price: \t"
//					+ products.get(i).disPrice.substring(3) + "\tDeal: \t" + products.get(i).deal + "\r\n");
//			System.out.print("Product name:\t" + products.get(i).prodName + "\tProduct Price: \t"
//					+ products.get(i).prodPrice.substring(3) + "\tNormal Price: \t"
//					+ products.get(i).disPrice.substring(3) + "\tDeal: \t" + products.get(i).deal + "\r\n");
//		}
//		FileWriter test = new FileWriter("C:\\Users\\RCHCHAN\\"+ java.time.LocalDate.now().toString()+".txt",true);
//		test.append(builder.toString());
//		test.close();
		driver.close();
		driver.quit();
	}
}
