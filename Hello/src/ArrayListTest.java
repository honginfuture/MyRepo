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
		arr.add("E");

		System.out.println(arr.size() + " elements: " + arr);
		arr.set(2, "C");
//Test set
		Collections.sort(arr);
		System.out.println(arr.size() + " elements: " + arr);
		for (String s : arr) {
			System.out.println(s);
		}
//Test remove
		arr.remove(0);
		System.out.println(arr.size() + " elements: " + arr);
		for (String s : arr) {
			System.out.println(s);
		}

		System.out.println(arr.contains("C"));
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i).equals("E")) { // arr.get(i) return the obj in index i
				System.out.println("Yes contain, breaked value at index :" + i);
				break;
			} else {
				System.out.println("searched " + (i + 1) + " Times");
			}
		}
		// String[] toArray = new String[arr.size()]; //Method 1
		// arr.toArray(toArray);
		Object[] toArray = arr.toArray(); // Method 2

		System.out.println("ToArray size: " + toArray.length);
		for (int i = 0; i < toArray.length - 1; i++) {
			System.out.print(toArray[i] + ", ");
		}
		System.out.print(toArray[toArray.length - 1]);
	}
}
