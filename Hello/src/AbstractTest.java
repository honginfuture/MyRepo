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

class ChiWaWa extends Dog {
	public ChiWaWa() {
		super.breed = "ChiWaWa";
		System.out.println("A ChiWaWa is born!");
	}

	@Override
	public void poop() {
		System.out.println("ChiWaWa poop!\n");

	}
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
}

public class AbstractTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog dogA = new ChiWaWa();
		dogA.bark();
		System.out.println(dogA.breed + " is " + dogA.getClass().getSuperclass());
		Dog.checkBreed(dogA);
		dogA.poop();

		Dog dogB = new Labrador();
		dogB.bark();
		System.out.println(dogB.breed + " is " + dogB.getClass().getSuperclass());
		Dog.checkBreed(dogB);
		dogB.poop();
	}

}
