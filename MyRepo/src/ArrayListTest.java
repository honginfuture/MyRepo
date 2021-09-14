import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ArrayListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Car car1 = new Car("Chan", 1, 0, 0);
		Car car2 = new Car("Chun", 2, 1, 0);
		Car car3 = new Car("Hong", 3, 2, 0);
		Car car4 = new Car("Leung", 4, 3, 0);
		Car car5 = new Car("Shuk", 5, 4, 0);
		Car car6 = new Car("Man", 6, 5, 0);
		Car car7 = new Car("BMW", 7, 6, 0);
		Car car8 = new Car("Lexus", 8, 7, 0);

		ArrayList<Car> arr = new ArrayList<Car>();
		arr.add(car1);
		arr.add(car2);
		arr.add(car3);
		arr.add(car4);
		arr.add(car5);
		arr.add(car6);
		arr.add(car7);
		arr.add(car8);

		String[][] grid = new String[arr.size()][arr.size()];

		System.out.println("==========Start==========\n" + arr.size() + " elements: ");
//		for (int i = 0; i < arr.size(); i++) {
//			System.out.println(arr.get(i).getCarName() + ", " + arr.get(i).getCarID() + "| ");
//		}		
		Draw.setPos(grid, arr);
		Draw.draw(grid);
		System.out.println("==========Shuffle==========\n" + arr.size() + " elements: ");
//		int count = 0;
//		for (Car car : arr) {
//			System.out.println(arr.get(count).getCarName()+" "+arr.get(count).getX()+" "+arr.get(count).getY());
//			count++;
//		}

		Car.shuffleArray(arr);
		Draw.setPos(grid, arr);
		Draw.draw(grid);
		Draw.checkWin(grid, arr);
//		for (int i = 0; i < arr.size(); i++) {
//			System.out.println(arr.get(i).getCarName() + ", " + arr.get(i).getCarID() + "| ");
//		}

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