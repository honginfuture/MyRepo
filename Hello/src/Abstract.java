import java.util.Arrays;

abstract class Dog {
	String breed;
	private final static int maxAgeLabrador = 120;
	private final static int maxAgeChihauhau = 100;
	public final static String[] ALLBREED = { "Labrador", "ChiHauHau", "GoldenRetriver" };

	public void bark() {
		System.out.println("Bark!");

	}

	public static void checkBreed(Dog d) {
		System.out.println("----------------Check Breed for the dog----------------");
		if (d.getClass() == Labrador.class) {
			System.out.println("Yes , it is a Labrador!");
			System.out.println("Max Age of Breed is " + maxAgeLabrador);
		} else {
			System.out.println("No, it's not !");
			System.out.println("Max Age of Breed is " + maxAgeChihauhau);
		}
		System.out.println("------------------End of Check Breed------------------");

	}

	public abstract void poop();
}

class Chihuahua extends Dog {

	public Chihuahua() {
		super.breed = "Chihuahua";
		System.out.println("A Chihuahua is born!");
	}

	@Override
	public void poop() {
		System.out.println("Chihuahua poop!\n");

	}

//	public void getMaxAge() {
//		System.out.println(maxAge + "\n");
//	}
}

class Labrador extends Dog {

	public Labrador() {
		breed = "Labrador";
		System.out.println("A Labrador is born!");
	}

	@Override
	public void poop() {
		System.out.println("Labrador poop!\n");

	}

//	public void getMaxAge() {
//		System.out.println(maxAge + "\n");
//	}
}

public class Abstract {

	public static void main(String[] args) {
		String s = String.join(" ", Dog.ALLBREED);
		System.out.println(s);// List all dog breed

		Chihuahua dogA = new Chihuahua();
		dogA.bark();
		System.out.println(dogA.breed + " is " + dogA.getClass().getSuperclass());
		Dog.checkBreed(dogA);
		dogA.poop();
		// dogA.getMaxAge();

		Labrador dogB = new Labrador();
		dogB.bark();
		System.out.println(dogB.breed + " is " + dogB.getClass().getSuperclass());
		Dog.checkBreed(dogB);
		dogB.poop();
		// dogB.getMaxAge();
	}

}
