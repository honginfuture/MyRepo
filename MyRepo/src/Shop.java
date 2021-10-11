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



}
