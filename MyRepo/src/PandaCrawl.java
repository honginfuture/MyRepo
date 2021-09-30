import java.io.IOException;

public class PandaCrawl {
	public static void main(String[] args) throws IOException, InterruptedException {

		// Product.crawlProd("https://www.foodpanda.hk/darkstore/x5xv/pandamart-wan-chai");
		Product.crawlProd("https://www.foodpanda.hk/darkstore/x5xv/pandamart-wan-chai");
//		Product.crawlProd("https://www.foodpanda.hk/darkstore/x5xv/pandamart-wan-chai#category/1d9b2558-4e8d-44d1-b511-e9196a27e4a7");
//		Product.crawlProd("https://www.foodpanda.hk/darkstore/x5xv/pandamart-wan-chai#category/02721ad0-a9d9-479c-9c6c-c901930a7cc4");
//		Product.crawlProd("https://www.foodpanda.hk/darkstore/x5xv/pandamart-wan-chai#category/1e483064-af24-4d59-af5b-bba147ed83f7");
//		Product.crawlProd("https://www.foodpanda.hk/darkstore/x5xv/pandamart-wan-chai#category/994e57f5-bfcc-46bd-b387-c1f606337f61");
//		Product.crawlProd("https://www.foodpanda.hk/darkstore/x5xv/pandamart-wan-chai#category/617964aa-afda-4558-b00e-4107c4a913a3");
//		Product.crawlProd("https://www.foodpanda.hk/darkstore/x5xv/pandamart-wan-chai#category/21286eb3-b114-4024-9a86-a9bcffc35a2c");
//		Product.crawlProd("https://www.foodpanda.hk/darkstore/x5xv/pandamart-wan-chai#category/ca59ccd4-fc42-475e-bf89-e01db04f4e54");
//		
//		Product.crawlProd("https://www.foodpanda.hk/darkstore/x5xv/pandamart-wan-chai#category/709f7f7a-c26f-49a2-8b5b-83be5bbdc113");
//		Product.crawlProd("https://www.foodpanda.hk/darkstore/x5xv/pandamart-wan-chai#category/9163e783-96a0-4342-9c09-73b8756a99af");
//		Product.crawlProd("https://www.foodpanda.hk/darkstore/x5xv/pandamart-wan-chai#category/9a4b82ee-d19d-4cdb-a7e0-47f3dfc46df2");
//		Product.crawlProd("https://www.foodpanda.hk/darkstore/x5xv/pandamart-wan-chai#category/b1212777-de70-45ab-8217-9be671b86576");
//		Product.crawlProd("https://www.foodpanda.hk/darkstore/x5xv/pandamart-wan-chai#category/7a17be3d-48b2-495a-9339-16f01df6f689");
//		Product.crawlProd("https://www.foodpanda.hk/darkstore/x5xv/pandamart-wan-chai#category/ccde6c48-6090-43fb-8ba8-782bd7efb72c");
//		Product.crawlProd("https://www.foodpanda.hk/darkstore/x5xv/pandamart-wan-chai#category/711fd8c9-9964-46ed-b24d-3c07b1e56e28");
//		Product.crawlProd("https://www.foodpanda.hk/darkstore/x5xv/pandamart-wan-chai#category/7c3b0ee3-53f3-4856-a733-1510e93f92c4");
//		
//		Product.crawlProd("https://www.foodpanda.hk/darkstore/x5xv/pandamart-wan-chai#category/4abec6af-b1af-4fab-8f2f-5c1b58bacb1d");
//		Product.crawlProd("https://www.foodpanda.hk/darkstore/x5xv/pandamart-wan-chai#category/76ecd3b4-e3f1-481a-ace7-4b77344943d7");
		
		// Shop.crawlShop("https://www.foodpanda.hk/restaurants/new?lat=22.2742239&lng=114.1728051&vertical=shop&expedition=delivery");
		// Restaurant.crawlRest(
		// "https://www.foodpanda.hk/restaurants/new?lat=22.27987718737818&lng=114.18376973387&vertical=restaurants&expedition=pickup");

	}
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\RCHCHAN\\eclipse\\chromedriver.exe");// Windows
//		// System.setProperty("webdriver.chrome.driver", "/Users/Hong/eclipse/chromedriver");//MacOS
//		WebDriver driver = new ChromeDriver();
//
//		// ---------------------------------------START of Wan Chai
//		// Crawl Dairy Product
//		driver.navigate().to(
//				"https://www.foodpanda.hk/restaurants/new?lat=22.27987718737818&lng=114.18376973387&vertical=restaurants&expedition=pickup"
//		// "https://www.foodpanda.hk/restaurants/new?lat=22.2742239&lng=114.1728051&vertical=shop&expedition=delivery/"
//		);
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		driver.manage().window().maximize();
//		// This will scroll the web page till end.
//		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//		js.executeScript("window.scrollBy(0, 50000)");
//		js.executeScript("window.scrollBy(0, -1000)");
//		Thread.sleep(2000);
//		js.executeScript("window.scrollBy(0, 50000)");
//		js.executeScript("window.scrollBy(0, -1000)");
//		Thread.sleep(2000);
//		js.executeScript("window.scrollBy(0, 50000)");
//		js.executeScript("window.scrollBy(0, -1000)");
//		Thread.sleep(2000);
//		Document doc = Jsoup.parse(driver.getPageSource());
//		Element deliverTo = doc.selectFirst("span[class\"header-order-button-content\"]");
//		Elements divElements = doc
//				.select("span[class=\"name fn\"],span[class=\"box-flex fd-row ai-center\"],span[class=\"badge-info\"]");
//
//		int nameCount = 0;
//		int promoCount = 0;
//		int badgeCount = 0;
//
//		StringBuilder builder = new StringBuilder();
//		Iterator<Element> iterator = divElements.iterator();
//		ArrayList<Element> arr = new ArrayList<Element>();
//		ArrayList<Shop> shops = new ArrayList<Shop>();
//		System.out.println("Deliver To: " + deliverTo + "Total Element: " + divElements.size());
//
//		while (iterator.hasNext()) {
//			Element divEle = iterator.next();
//			arr.add(divEle);
//		}
//		System.out.println(arr.toString());
//
//		for (int i = 0; i < arr.size() - 1; i++) {
//			if (arr.get(i).attr("class").equals("name fn")
//					&& arr.get(i + 1).attr("class").equals("box-flex fd-row ai-center")) {
//				nameCount++;
//				promoCount++;
//				builder.append(nameCount + "\t" + arr.get(i).text() + "\r\n");
//				shops.add(new Shop(arr.get(i).text(), arr.get(i + 1).text(), arr.get(i + 2).text()));
//			} else if (arr.get(i).attr("class").equals("name fn")
//					&& arr.get(i + 1).attr("class").equals("badge-info")) {
//				badgeCount++;
//			}
//		}
//		System.out.print("Total namefn: " + nameCount + "\r\n" + "Total box-flex fd-row ai-center: " + promoCount
//				+ "\r\n" + "Total badge-info: " + badgeCount + "\r\n");
//		StringBuilder builder1 = new StringBuilder();
//		for (int i = 0; i < shops.size(); i++) {
//
//			builder1.append("Shop name: \t" + shops.get(i).sName + "\tShop Promo: \t" + shops.get(i).promo
//					+ "\tShop Badge: \t" + shops.get(i).badge + "\t\r\n");
//			System.out.print("Shop name: \t" + shops.get(i).sName + "\tShop Promo: \t" + shops.get(i).promo
//					+ "\tShop Badge: \t" + shops.get(i).badge + "\t\r\n");
//		}
//		FileWriter test = new FileWriter("C:\\Users\\RCHCHAN\\1.txt");
//		test.write(builder1.toString());
//		test.close();
//	}
}
//		ArrayList<Element> nameElementsArr = new ArrayList<Element>();
//		ArrayList<Element> divElementsArr = new ArrayList<Element>();
//		int i = 0;
//		while (iterator.hasNext()) {
//			divElementsArr.add(iterator.next());
//			// System.out.println(divElementsArr.get(i).text());
//			i++;
//		}

//		int j = 0;
//		while (nameIterator.hasNext()) {
//			nameElementsArr.add(nameIterator.next());
//			// System.out.println(divElementsArr.get(i).text());
//			j++;
//		}
//
//		for (int t = 0; t < divElements.size()-nameElements.size(); t++) {
//			if (
//
//			(divElementsArr.get(t).attr("class").equals("box-flex fd-row ai-center")
//					&& divElementsArr.get(t + 1).attr("class").equals("badge-info")) ||
//
//					(divElementsArr.get(t).attr("class").equals("box-flex fd-row ai-center")
//							&& divElementsArr.get(t + 1).attr("class").equals("box-flex fd-row ai-center"))
//
//			) {
//				promoCount++;
//				System.out.print(promoCount + " Promotion:\t\t");
//				System.out.print(divElementsArr.get(t).text() + "\t");
//				System.out.print(nameElementsArr.get(t).text());
//				System.out.println();
//
//			} else if (
//					
//					(divElementsArr.get(t).attr("class").equals("badge-info")
//					&& divElementsArr.get(t + 1).attr("class").equals("box-flex fd-row ai-center"))  	|| 
//					(divElementsArr.get(t).attr("class").equals("badge-info")
//							&& divElementsArr.get(t + 1).attr("class").equals("badge-info"))
//					) {
//				dryCount++;
//				System.out.print(dryCount + " No Promotion\t\t");
//				System.out.print(divElementsArr.get(t).text() + "\t\t");
//				System.out.print(nameElementsArr.get(t).text());
//				System.out.println();
//			}
//		}

//		while (iterator.hasNext()) {
//			Element divElement = divElements.get(totalCount);
//			builder.append(divElement.attr("class").toString() + "\r\n");
//			divElement = iterator.next();
//			totalCount++;
//		}
//		System.out.println(totalCount + "\r\n" + builder.toString());

//		while (iterator.hasNext()) {
//			Element nEl = iterator.next();
//
//			// Element nameElement = nameIterator.next();
//			if (nEl.attr("class").equals("box-flex fd-row ai-center") && nnEl.attr("class").equals("badge-info")) {
//				promoCount++;
//				System.out.print(nEl.attr("class").toString() + "\t");
//				System.out.println(promoCount + ":\t\tPromotion");
//				totalCount++;
//
//			} else if (nnEl.attr("class").equals("box-flex fd-row ai-center")
//					&& nEl.attr("class").equals("badge-info")) {
//				dryCount++;
//				System.out.print(nEl.attr("class").toString());
//				System.out.println(dryCount + ":\t\t\t\tNo Promotion");
//				totalCount++;
//			}
//		}
//		System.out.print(promoCount + " promotion!");
//		System.out.print(dryCount + "NO PROMOTION");

// System.out.println(count + builder.toString());

// https://www.twilio.com/blog/working-with-html-on-the-web-java-jsoup
// Get content by Class

// System.out.println(doc.select("div>class.info-badges-without-variant-layout>span>span").html());

//		String[] shopNames = new String[doc.getElementsByClass("name fn").size()];
//		String[] shopPromos = new String[shopNames.length];
//		System.out.println(shopNames.length + " " + shopPromos.length);
//		for (int i = 0; i < doc.getElementsByClass("name fn").size(); i++) {
//			shopNames[i] = doc.getElementsByClass("name fn").get(i).text();
//
//			if (i < (doc.getElementsByClass("box-flex fd-row ai-center").size())) {
//				shopPromos[i] = doc.getElementsByClass("box-flex fd-row ai-center").get(i).text();
//				System.out.println("Space\t:" + i + "/" + shopNames.length + ",  \t" + shopNames[i] + "\t\tPromo\t\t:"
//						+ i + "/" + shopPromos.length + "\t\tPromo\t\t:" + shopPromos[i]);
//			} else {
//				System.out.println("Space\t:" + i + "/" + shopNames.length + ",  \t" + shopNames[i]);
//			}
//		}

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
