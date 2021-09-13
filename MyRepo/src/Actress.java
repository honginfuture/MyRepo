public class Actress extends Person {



	public Actress(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}


	

	public void readScript(String movie) {
		System.out.println("Reading the script of " + movie);
	}

	@Override
	public void drink() {
		super.drink();
		System.out.println(this.getClass().getName() + ": I am drinking MilkTea!");
	}


	// additional methods/constructors
}