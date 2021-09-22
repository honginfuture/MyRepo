import java.io.IOException;

import com.jaunt.JauntException;
import com.jaunt.UserAgent;

public class Jaunt {
	public static void main(String[] args) throws IOException {
		try {
			UserAgent userAgent = new UserAgent(); // create new userAgent (headless browser).
			userAgent.sendGET("http://jsonplaceholder.typicode.com/posts/1"); // send request
			System.out.println(userAgent.json); // print the retrieved JSON object
			System.out.println("Other response data: " + userAgent.response); // response metadata, including headers.
		} catch (JauntException e) { // if an HTTP/connection error occurs, handle JauntException.
			System.err.println(e);
		}
	}
}