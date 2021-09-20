import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Car {

	private int carID = 1;
	private String carName = "";
	private int x;
	private int y;
	private double speed;
	private String model;
	

	public Car(String name, int carID, int x, int y) {
		this.carName = name;
		this.carID = carID;
		this.x = x;
		this.y = y;
		this.speed = Math.random() * 100;
	}

	public static Car makeCar(String carName, int x, int y) {
		Car carObj = new Car(carName, 1, 7, 0);
		return carObj;
	}

	public void setCarName(String name) {
		this.carName = name;
	}

	public String getCarName() {
		return carName;
	}

// To prohibit Car ID change
//	public void setCarID(int carID) {
//		this.carID = carID;
//	}

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

	public void increaseSpeed() {
		this.speed++;
	}

	public String toString() {
		return String.format("%d-%s-%.2f", this.carID, this.carName.toString(), this.speed);
	}

	static void shuffleArray(ArrayList<Car> arr) {
		Random rnd = ThreadLocalRandom.current();
		int rndX = 0;
		int rndY = 0;
		for (int i = 0; i < arr.size(); i++) {
			rndX = rnd.nextInt(arr.size());
			rndY = rnd.nextInt(arr.size());
			if (arr.get(i).getX() == arr.get(rndX).getX() && arr.get(i).getY() == arr.get(rndY).getY()) {
				System.out.println(arr.get(i).getCarName() + " is Crashed and DEAD!! x: " + arr.get(i).getX() + " y: "
						+ arr.get(i).getY());
				arr.get(i).setCarName("DEAD");

				continue;
			} else {
				System.out.println("OK!");
				arr.get(i).setX(rndX);
				arr.get(i).setY(rndY);
			}
		}

		// for (int i = 0; i < arr.size() - 1; i++) {
//			for(int j=0;j<arr.size()-1;j++) {		
//				if(arr.get(i).getCarID() != arr.get())
//						{;
//			}
//				
//			}

//		arr.get(arr.size() - 1).setX(rnd.nextInt(arr.size()));
//		arr.get(arr.size() - 1).setY(rnd.nextInt(arr.size()));
//		arr.get(0).setX(rnd.nextInt(6));
//		arr.get(0).setY(rnd.nextInt(6));
//		arr.get(1).setX(rnd.nextInt(6));
//		arr.get(1).setY(rnd.nextInt(6));
//		arr.get(1).setX(rnd.nextInt(6));
//		arr.get(1).setY(rnd.nextInt(6));
//		arr.get(2).setX(rnd.nextInt(6));
//		arr.get(2).setY(rnd.nextInt(6));
//		arr.get(2).setX(rnd.nextInt(6));
//		arr.get(2).setY(rnd.nextInt(6));
//		arr.get(3).setX(rnd.nextInt(6));
//		arr.get(3).setY(rnd.nextInt(6));
//		arr.get(3).setX(rnd.nextInt(6));
//		arr.get(3).setY(rnd.nextInt(6));
//		arr.get(4).setX(rnd.nextInt(6));
//		arr.get(4).setY(rnd.nextInt(6));
//		arr.get(4).setX(rnd.nextInt(6));
//		arr.get(4).setY(rnd.nextInt(6));
//		arr.get(5).setX(rnd.nextInt(6));
//		arr.get(5).setY(rnd.nextInt(6));
//		arr.get(5).setX(rnd.nextInt(6));
//		arr.get(5).setY(rnd.nextInt(6));
//		arr.get(0).setX(rnd.nextInt(6));
//		arr.get(0).setY(rnd.nextInt(6));
//		System.out.println(arr.get(0).getCarName() + " " + arr.get(0).getX() + " " + arr.get(0).getY());
//		System.out.println(arr.get(1).getCarName() + " " + arr.get(1).getX() + " " + arr.get(1).getY());
//		System.out.println(arr.get(2).getCarName() + " " + arr.get(2).getX() + " " + arr.get(2).getY());
//		System.out.println(arr.get(3).getCarName() + " " + arr.get(3).getX() + " " + arr.get(3).getY());
//		System.out.println(arr.get(4).getCarName() + " " + arr.get(4).getX() + " " + arr.get(4).getY());
//		System.out.println(arr.get(5).getCarName() + " " + arr.get(5).getX() + " " + arr.get(5).getY());
	}
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

//	}
//
//	static boolean checkEmpty(ArrayList<Car> arr) {
//		boolean isEmpty = false;
//		for (int i = 0; i < grid.length; i++) {
//			for (int j = 0; j < grid[i].length; j++) {
//				if (grid[x][y].isEmpty()) {
//					isEmpty = true;
//				} else
//					isEmpty = false;
//			}
//		}
//		return isEmpty;
//	}
//}
