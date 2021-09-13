import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Car {

	private int carID;
	private String carName = "";
	private int x;
	private int y;

	public Car(String name, int carID, int x, int y) {
		this.carName = name;
		this.carID = carID;
		this.x = x;
		this.y = y;
	}

	public void setCarName(String name) {
		this.carName = name;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarID(int carID) {
		this.carID = carID;
	}

	public int getCarID() {
		return this.carID;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	static void shuffleArray(ArrayList<Car> arr) {
		Random rnd = ThreadLocalRandom.current();
		for (int i = arr.size() - 1; i > 0; i--) {
			arr.get(i).setX(rnd.nextInt(6));
			arr.get(i).setY(rnd.nextInt(6));
			System.out.println(arr.get(i).getCarName() + " pos = " + arr.get(i).getX() + " " + arr.get(i).getY());
		}
//			System.out.println("i is: " + i + "| index now is :" + index + "| ar[index] is: " + ar.get(index).getCarID()
//					+ "| ar[i] is: " + ar.get(i).getCarID());

		// Simple swap
//			int a = ar.get(index).carID;
//			ar.get(index).setCarID(ar.get(i).getCarID());
//			ar.get(i).setCarID(a);
//
//			String b = ar.get(index).carName;
//			ar.get(index).setCarName(ar.get(i).getCarName());
//			ar.get(i).setCarName(b);

	}
}
