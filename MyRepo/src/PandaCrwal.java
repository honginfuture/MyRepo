import java.util.LinkedList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.page.Page.GetAppManifestResponse;

public class PandaCrwal {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\RCHCHAN\\eclipse\\chromedriver.exe");// Windows
		// System.setProperty("webdriver.chrome.driver",
		// "/Users/Hong/eclipse/chromedriver");//MacOS
		WebDriver driver = new ChromeDriver();

		// ---------------------------------------START of Wan Chai
		// Crawl Dairy Product
		driver.navigate().to("\n"
				+ "		https://www.foodpanda.hk/restaurants/new?lat=22.2742239&lng=114.1728051&vertical=shop&expedition=delivery/");
		Document doc = Jsoup.parse(driver.getPageSource());
		// https://www.twilio.com/blog/working-with-html-on-the-web-java-jsoup
		// Get content by Class

		// System.out.println(doc.select("div>class.info-badges-without-variant-layout>span>span").html());

		String[] shopNames = new String[doc.getElementsByClass("name fn").size()];
		String[] shopPromos = new String[shopNames.length];
		System.out.println(shopNames.length + " " + shopPromos.length);
		for (int i = 0; i < doc.getElementsByClass("name fn").size(); i++) {
			shopNames[i] = doc.getElementsByClass("name fn").get(i).text();

			if (i < (doc.getElementsByClass("box-flex fd-row ai-center").size())) {
				shopPromos[i] = doc.getElementsByClass("box-flex fd-row ai-center").get(i).text();
				System.out.println("Space\t:" + i + "/" + shopNames.length + ",  \t" + shopNames[i] + "\t\tPromo\t\t:"
						+ i + "/" + shopPromos.length + "\t\tPromo\t\t:" + shopPromos[i]);
			} else {
				System.out.println("Space\t:" + i + "/" + shopNames.length + ",  \t" + shopNames[i]);
			}
		}
	}

//		Elements prices = doc.select("box-flex fd-row ai-center");
//		System.out.println(names.size() + "\tshops in Wanchai");
//		Product[] mainPage = new Product[names.size()];
//		for (int i = 0; i < mainPage.length; i++) {
//
//			mainPage[i] = new Product(names.get(i).text().toString(), prices.get(i).text().toString());
//		}
//		System.out.println();
//		// Sort array by price:
//		for (int i = 0; i < mainPage.length; i++) {
//			for (int j = i + 1; j < mainPage.length; j++) {
//				double tmp = 0;
//				String tname = "";
//				if (mainPage[i].price > mainPage[j].price) {
//					tmp = mainPage[i].price;
//					mainPage[i].price = mainPage[j].price;
//					mainPage[j].price = tmp;
//
//					tname = mainPage[i].name;
//					mainPage[i].name = mainPage[j].name;
//					mainPage[j].name = tname;
//				}
//			}
//			System.out.println(i + "\tname:\t" + mainPage[i].name);
//			driver.quit();
//		} // ---------------------------------------End of Wai Chai
//
//		driver = new ChromeDriver();
//		driver.navigate().to(
//				"https://www.foodpanda.hk/darkstore/x5xv/pandamart-wan-chai#category/6ad1794a-f6ae-43d3-9f70-78371e3297f9/");
//		doc = Jsoup.parse(driver.getPageSource());
//		// Get content by Class
//		names = doc.getElementsByClass("product-card-name");
//		prices = doc.getElementsByClass("product-card-price cl-neutral-primary f-14 fw-light");
//		System.out.println(names.size() + "\titems in Fresh produce");
//		Product[] prodFresh = new Product[names.size()];
//		for (int i = 0; i < prodFresh.length; i++) {
//			prodFresh[i] = new Product(names.get(i).text().toString(),
//					Double.parseDouble(prices.get(i).text().substring(3)));
//		}
//		System.out.println();
//		// Sort array by price:
//		for (int i = 0; i < prodFresh.length; i++) {
//			for (int j = i + 1; j < prodFresh.length; j++) {
//				double tmp = 0;
//				String tname = "";
//				if (prodFresh[i].price > prodFresh[j].price) {
//					tmp = prodFresh[i].price;
//					prodFresh[i].price = prodFresh[j].price;
//					prodFresh[j].price = tmp;
//
//					tname = prodFresh[i].name;
//					prodFresh[i].name = prodFresh[j].name;
//					prodFresh[j].name = tname;
//				}
//			}
//			System.out.println(i + "\tname:\t" + prodFresh[i].price + "\tprice:\t" + prodFresh[i].name);
//		}
//		driver.quit();
//
//		// ---------------------------------------START of Dairy Product
//		driver = new ChromeDriver();
//		// Crawl Dairy Product
//		driver.navigate().to(
//				"https://www.foodpanda.hk/darkstore/x5xv/pandamart-wan-chai#category/7f9532a2-93c8-49f9-a7da-5c060dcc3537/");
//		doc = Jsoup.parse(driver.getPageSource());
//
//		// Get content by Class
//		names = doc.getElementsByClass("product-card-name");
//		prices = doc.getElementsByClass("product-card-price cl-neutral-primary f-14 fw-light");
//		System.out.println(names.size() + "\titems in Dairy");
//		Product[] prodDairy = new Product[names.size()];
//		for (int i = 0; i < prodDairy.length; i++) {
//			prodDairy[i] = new Product(names.get(i).text().toString(),
//					Double.parseDouble(prices.get(i).text().substring(3)));
//		}
//		System.out.println();
//		// Sort array by price:
//		for (int i = 0; i < prodDairy.length; i++) {
//			for (int j = i + 1; j < prodDairy.length; j++) {
//				double tmp = 0;
//				String tname = "";
//				if (prodDairy[i].price > prodDairy[j].price) {
//					tmp = prodDairy[i].price;
//					prodDairy[i].price = prodDairy[j].price;
//					prodDairy[j].price = tmp;
//
//					tname = prodDairy[i].name;
//					prodDairy[i].name = prodDairy[j].name;
//					prodDairy[j].name = tname;
//				}
//			}
//			System.out.println(i + "\tname:\t" + prodDairy[i].price + "\tprice:\t" + prodDairy[i].name);
//			driver.quit();
//		} // ---------------------------------------End of Dairy Product
//
//		// ---------------------------------------START of Ice Cream Product
//		driver = new ChromeDriver();
//		// Crawl Dairy Product
//		driver.navigate().to(
//				"https://www.foodpanda.hk/darkstore/x5xv/pandamart-wan-chai#category/0cb4a4fc-df25-4dcb-b10d-95464815e38f/");
//		doc = Jsoup.parse(driver.getPageSource());
//
//		// Get content by Class
//		names = doc.getElementsByClass("product-card-name");
//		prices = doc.getElementsByClass("product-card-price cl-neutral-primary f-14 fw-light");
//		System.out.println(names.size() + "\titems in Dairy");
//		Product[] prodIce = new Product[names.size()];
//		for (int i = 0; i < prodIce.length; i++) {
//			prodIce[i] = new Product(names.get(i).text().toString(),
//					Double.parseDouble(prices.get(i).text().substring(3)));
//		}
//		System.out.println();
//		// Sort array by price:
//		for (int i = 0; i < prodIce.length; i++) {
//			for (int j = i + 1; j < prodIce.length; j++) {
//				double tmp = 0;
//				String tname = "";
//				if (prodIce[i].price > prodIce[j].price) {
//					tmp = prodIce[i].price;
//					prodIce[i].price = prodIce[j].price;
//					prodIce[j].price = tmp;
//
//					tname = prodIce[i].name;
//					prodIce[i].name = prodIce[j].name;
//					prodIce[j].name = tname;
//				}
//			}
//			System.out.println(i + "\tname:\t" + prodIce[i].price + "\tprice:\t" + prodIce[i].name);
//			driver.quit();
//		} // ---------------------------------------End of Dairy Product

}
