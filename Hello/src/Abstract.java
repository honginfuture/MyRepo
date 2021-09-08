abstract class Dog {
	String breed;

	public void bark() {
		System.out.println("Bark!");

	}

	public static void checkBreed(Dog d) {
		System.out.println("----------------Check Breed for the dog----------------");
		if (d.getClass() == Labrador.class) {
			System.out.println("Yes , it is a Labrador!");
		} else {
			System.out.println("No, it's not !");
		}
		System.out.println("------------------End of Check Breed------------------");
	}

	public abstract void poop();
}

class Chihuahua extends Dog {
	private final int maxAge = 12;

	public Chihuahua() {
		super.breed = "Chihuahua";
		System.out.println("A Chihuahua is born!");
	}

	@Override
	public void poop() {
		System.out.println("Chihuahua poop!");

	}

	public void getMaxAge() {
		System.out.println(maxAge + "\n");
	}
}

class Labrador extends Dog {
	private final int maxAge = 100;

	public Labrador() {
		breed = "Labrador";
		System.out.println("A Labrador is born!");
	}

	@Override
	public void poop() {
		System.out.println("Labrador poop!\n");

	}

	public void getMaxAge() {
		System.out.println(maxAge + "\n");
	}
}

public class Abstract {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Chihuahua dogA = new Chihuahua();
		dogA.bark();
		System.out.println(dogA.breed + " is " + dogA.getClass().getSuperclass());
		Dog.checkBreed(dogA);
		dogA.poop();
		dogA.getMaxAge();

		Labrador dogB = new Labrador();
		dogB.bark();
		System.out.println(dogB.breed + " is " + dogB.getClass().getSuperclass());
		Dog.checkBreed(dogB);
		dogB.poop();
		dogB.getMaxAge();
	}

}
