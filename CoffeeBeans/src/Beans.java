
public abstract class Beans {
	private int noOfGrowCountry;
	private int fullGrownSize;
	private String bitterness;

	public static void checkBreed(Beans beans) {
		System.out.println("----------------Check Breed for the dog----------------");
		if (beans.getClass() == Ethiopia.class) {
			System.out.println("Yes , it is a Labrador!");
			System.out.println("Max Age of Breed is " + beans.bark());
		} else {
			System.out.println("No, it's not !");
			System.out.println("Max Age of Breed is " + beans.bark());
		}
		System.out.println("------------------End of Check Breed------------------");

	}

	public String bark() {
		return "Smell so good!";
	}

}
