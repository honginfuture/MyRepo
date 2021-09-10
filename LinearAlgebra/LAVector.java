
public class LAVector {
	private int n;
	private double[] elements;

	public LAVector(int x) {

		this.n = x;
		this.elements = new double[n];
	}

	public int GetN() {
		return this.n;
	}

	public void randomize() {
		for (int i = 0; i < n; i++) {
			elements[i] = Math.random();
		}
	}

	public void set(int i, double value) {
		elements[i] = value;
	}

	public double get(int i) {
		return elements[i];
	}

	public double dot(LAVector anotherVector) {
		if (n != anotherVector.n)
			throw new ArithmeticException("dot product of vectors in different space");
		// after the throw statement, the method will terminate with an exception;
		// the normal method execution will be interrupted

		double dotProduct = 0;
		for (int i = 0; i <= n; i++) {
			dotProduct = this.elements[i] * anotherVector.elements[i];
		}
		return dotProduct;

	}

	public double length() {
		return Math.sqrt(n * n);
	}

	public String toString() {
		String s = "[";
		s += elements[0];
		for (int i = 1; i < n; i++)
			s += ", " + elements[i];
		return s + "]";

	}

	public LAVector dotMultiply(LAMatrix mat) {
		LAVector resVec = new LAVector(n);
		if (this.n != mat.getM())
			resVec = null;
		else
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < mat.getM(); j++) {
					resVec.elements[i] = elements[i] * mat.get(i, j);
					
				}
			}
		return resVec;

	}
}
