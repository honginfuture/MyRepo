
public class TestPersonDrink {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Person peter = new Waitress("PETER");
//		Person.checkPerson(peter);
//		peter.eat();
//		peter.eat("Sausage");
//		peter.drink();
//		peter.deposit();
//		peter.walk();

		Person pete = new Actress("PETE");
		Person.checkPerson(pete);
		pete.eat();
		pete.eat("Hamburger");
		pete.drink();
		pete.walk();
		pete.getTiredness();
		pete.setTiredness(true);
		pete.walk();

	}

}
