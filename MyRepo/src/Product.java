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

public class Product implements InterfaceGenericCrawl {
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
	
	public void genericCrawl() {
		// TODO Auto-generated method stub
	}



}