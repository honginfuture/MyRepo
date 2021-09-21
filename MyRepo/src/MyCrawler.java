import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.xml.crypto.Data;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MyCrawler {
	public static void main(String[] args) throws Exception {
		// String freshProduce = "https://jsoup.org/cookbook/input/parse-body-fragment";

		try {
			// Document freshProduceRaw = Jsoup.connect(freshProduce).get();
			File file = new File("C:\\Users\\RCHCHAN\\how2.html");
//			Document freshProduceRaw = Jsoup.parse(input, "UTF-8", "http://example.com/");
//			String para = freshProduceRaw.toString();

			Document doc = Jsoup.parse(file, "UTF-8", "http://example.com/");

			Elements els = doc.getElementsByTag("div");
			for (Element e : els) {
				System.out.println("Product$: " + e.text());
			}
			// parsing HTML after examining DOM
//			Elements els = doc.select("div");
//			for (Element el : els) {
//				// Print title, site and abstract
//				System.out.println("XXXXXXXXXX" + el.text());
//				System.out.println("Title : " + el.getElementsByTag("parentId").text());
//				System.out.println("Site : " + el.getElementsByTag("cite").text());
//				System.out.println("Abstract : " + el.getElementsByTag("span").text() + "\n");
//			}
			// System.out.println(freshProduceRaw);

			// Get content by tag
//			Elements paragraphs = freshProduceRaw.getElementsByTag("script");
//			for (Element e : paragraphs) {
//				System.out.println("link: " + e.select("id"));
//				System.out.println("element: " + e.select("{\"id\":\""));
//			}

			// Get content by ID
//			Elements e = freshProduceRaw.select("name");
//			for (Element element : e) {
//				System.out.println(e.text());
//			}

		} catch (

		IOException ex) {
			System.out.println(ex);
		}

	}
}