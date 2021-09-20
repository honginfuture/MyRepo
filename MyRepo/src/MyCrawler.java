import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class MyCrawler {
	public static void main(String[] args) throws Exception {
		String freshProduce = "https://www.foodpanda.hk/darkstore/x2hz/pandamart-hung-hom#category/6ad1794a-f6ae-43d3-9f70-78371e3297f9";

		try {
			Document doc = Jsoup.connect(freshProduce).get();
			String title = doc.title();

			System.out.println(doc);
			
			FileWriter writer = new FileWriter("C:\\Users\\RCHCHAN\\MyFile.txt");
			writer.write(fileContent);
			writer.close();

		} catch (

		IOException ex) {
			System.out.println(ex);
		}

	}
}