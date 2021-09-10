public class Waitress extends Person {

	public Waitress(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void serveStarter(String starter) {
		System.out.println("Serving a " + starter);
	}

	@Override
	public void drink() {
		super.drink();
		System.out.println("Waitress: I am drinking coffee!");
	}

	@Override
	public void walk() {
		System.out.println("Waitress: I dont wanna walk!");
	}
	// additional methods/constructors
}