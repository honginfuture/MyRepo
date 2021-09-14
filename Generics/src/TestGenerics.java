public class TestGenerics {
	public static void main(String[] args) {
		// instance of Integer type
		Generics<Integer, String> iObj = new Generics<Integer, String>(15, "abc");
		System.out.println(iObj.getObjectT() + " " + iObj.getObjectV());

		// instance of String type
		Generics<String, Integer> sObj = new Generics<String, Integer>("GeeksForGeeks", 999999);
		System.out.println(sObj.getObjectT() + " " + sObj.getObjectV());

		Waiter waiter = new Waiter(16);
		Generics<Waiter, String> wObj = new Generics<Waiter, String>(waiter, "ON99");
		System.out.println(wObj.getObjectT().getClass().getName() + " " + wObj.getObjectV());

	}
}
