import java.util.ArrayList;
import java.util.Collections;

public class ArrayListTest<T> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("D");
		arr.add("A");
		arr.add(null);
		arr.add("B");

		System.out.println(arr.size() + " elements: " + arr);
		arr.set(2, "C");

		Collections.sort(arr);
		System.out.println(arr.size() + " elements: " + arr);
		for (String s : arr) {
			System.out.println(s);
		}

		arr.remove(0);
		System.out.println(arr.size() + " elements: " + arr);
		for (String s : arr) {
			System.out.println(s);
		}

		System.out.println(arr.contains("C"));
	}
}
