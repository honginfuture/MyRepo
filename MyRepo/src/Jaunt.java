import java.io.File;
import java.io.IOException;

import com.jaunt.Element;
import com.jaunt.JNode;
import com.jaunt.JauntException;
import com.jaunt.UserAgent;

public class Jaunt {
	public static void main(String[] args) throws IOException {
		try {
			UserAgent userAgent = new UserAgent();
			userAgent.openJSON("{"
					+ "  \"fresh product\": \"vegetable\","
					+ "  \"ginger1\":  {"
					+ "    \"name\": \"giner2\","
					+ "    \"price\": \"9999\","
					+ "    \"email\": null"
					+ "  },"
					+ "  \"carrot2\": {"
					+ "    \"name\": \"carrot2\","
					+ "    \"price\": \"88888\","
					+ "    \"email\": \"kosserparamount.com"
					+ "  },"
					+ "  \"carrot2\": {"
					+ "    \"name\": \"carrot2\","
					+ "    \"price\": \"88888\","
					+ "    \"email\": \"kosser@paramount.com"
					+ "  }"
					+ "}"
					);
			// from
			// String

			
			JNode searchResults = userAgent.json.findEvery("{name: , price: }");  //quotes around String values optional
			  System.out.println("Found producers having email: " + searchResults.size() + " result(s)");
//			JNode node = userAgent.json.findEvery("price");
//			System.out.println("node name: " + node.getName());
//			System.out.println("node type: " + node.getType());
//			System.out.println("parent node name: " + node.getParent().getName());
//			System.out.println("node as string: " + node.toString());
//			System.out.println("------------");

//			node = userAgent.json.getFirst("price");
//			System.out.println("node name: " + node.getName());
//			System.out.println("node type: " + node.getType());
//			System.out.println("node as string:\n" + node.toString());
//			System.out.println("isAvailable: " + node.getFirst("isAvailable")); // or node.get("lastName")
//			System.out.println("------------");
////
//			node = userAgent.json.getFirst("id");
//			System.out.println("node name: " + node.getName());
//			System.out.println("node type: " + node.getType());
//			System.out.println("node as string:\n" + node.toString());
		} catch (JauntException e) {
			System.err.println(e);
		}
	}
}