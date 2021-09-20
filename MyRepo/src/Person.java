
public class Person {
	final List<String> pName= new ArrayList<String>();
	final int pAge;

	public Person(String name) {
		this(name, 16);
	}

	public Person(String name, int age) {
		this.pName = "";
		this.pAge = 0;
	}
}
