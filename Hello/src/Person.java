public class Person implements PersonInterface {
	private String name = "";
	private boolean isTired = false;

	public Person(String name) {
		this.name = name;
		System.out.println("\n-----------------------------------");
		System.out.println(name + " is born!");
	}

	public void eat() {
		System.out.println("Person: Eating Sandwitch!");
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void drink() {
		System.out.println("Person: " + name + " : I need to eat! ");
	};

	public static void checkPerson(Person person) {
		if (person.getClass().getSuperclass() == Person.class) {
			{
				System.out.println(person.getName() + " is a " + person.getClass().getName());
			}
		}
	}

	public void eat(String food) {
		System.out.println("Interface: Eating " + food + "!");
		// TODO Auto-generated method stub

	}

	@Override
	public void walk() {
		if (isTired) {
			System.out.println("Waitress: I DONT wanna walk!");
		} else
			System.out.println("Waitress: I do wanna walk!");
	}

	@Override
	public void deposit() {
		// TODO Auto-generated method stub
		System.out.println("Interface: I can deposit!");
	}

	public void setTiredness(boolean tiredness) {
		isTired = true;
	}

	public boolean getTiredness() {
		if (isTired) {
			System.out.println("I am " + isTired + "ly tired!");
		}
		return isTired;
	}

}