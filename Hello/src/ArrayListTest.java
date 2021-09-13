import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ArrayListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car3 = new Car("Chan", 1, 1, 1);
		Car car1 = new Car("Chun", 2, 2, 2);
		Car car2 = new Car("Hong", 3, 3, 3);
		Car car4 = new Car("Leung", 4, 4, 4);
		Car car5 = new Car("Shuk", 5, 5, 5);
		Car car6 = new Car("Man", 6, 6, 6);

		ArrayList<Car> arr = new ArrayList<Car>();
		arr.add(car1);
		arr.add(car2);
		arr.add(car3);
		arr.add(car4);
		arr.add(car5);
		arr.add(car6);
//		arr.add(2, new Car("BMW", 7));
//		arr.add(2, new Car("benz", 1));

		String[][] grid = new String[arr.size()][arr.size()];

		Draw.draw(grid);
		Draw.setPos(grid, arr);
		System.out.println("==========Start==========\n" + arr.size() + " elements: ");
//		for (int i = 0; i < arr.size(); i++) {
//			System.out.println(arr.get(i).getCarName() + ", " + arr.get(i).getCarID() + "| ");
//		}

//		System.out.println("==========Shuffle==========\n" + arr.size() + " elements: ");
		Car.shuffleArray(arr);
		Draw.draw(grid);
//		for (int i = 0; i < arr.size(); i++) {
//			System.out.println(arr.get(i).getCarName() + ", " + arr.get(i).getCarID() + "| ");
//		}

//		arr.add(2, new Car("Mazda", 2));

//Test sort by carName Ascending
//		Collections.sort(arr, new Comparator<Car>() {
//
//			public int compare(Car o1, Car o2) {
//				// compare two instance of `Score` and return `int` as result.
//				return o2.getName().compareTo(o1.getName());
//			}
//		});

		// Test sort by carID Ascending
		Collections.sort(arr, new Comparator<Car>() {

			public int compare(Car o1, Car o2) {
				// compare two instance of `Score` and return `int` as result.
				return String.valueOf(o1.getCarID()).compareTo(String.valueOf(o2.getCarID()));
			}
		});

//Test remove
		arr.remove(0);
		System.out.print("\nSorted " + (arr.size()) + ", ");
		for (int i = 0; i < arr.size(); i++) {
			System.out.print(arr.get(i).getCarName() + ", " + arr.get(i).getCarID() + "| ");
		}

		Collections.sort(arr, new Comparator<Car>() {

			public int compare(Car o1, Car o2) {
				// compare two instance of `Score` and return `int` as result.
				return o2.getCarName().compareTo(o1.getCarName());
			}
		});
		System.out.print("\nRandom " + (arr.size()) + ": ");
		for (int i = 0; i < arr.size(); i++) {
			System.out.print(arr.get(i).getCarName() + ", " + arr.get(i).getCarID() + "| ");
		}
//		System.out.println(arr.contains("C"));
//		String checkContain = "D";
//		String abc = "";
//		for (int i = 0; i < arr.size(); i++) {
//			if (arr.get(i).equals(checkContain)) { // arr.get(i) return the obj in index i
//				System.out.println("Yes contains \"" + checkContain + "\", breaked value at index :" + i);
//				// continue;// test continue.
//				break;// test break.
//			} else {
//				System.out.println("searched " + (i + 1) + " Times. checked index :" + i);
//
//			}
//
//		}
//		// String[] toArray = new String[arr.size()]; //Method 1
//		// arr.toArray(toArray);
//		Object[] toArray = arr.toArray(); // Method 2
//
//		System.out.println("ToArray size: " + toArray.length);
//		for (int i = 0; i < toArray.length - 1; i++) {
//			System.out.print(toArray[i] + ", ");
//		}
//		System.out.print(toArray[toArray.length - 1]);
	}
}
