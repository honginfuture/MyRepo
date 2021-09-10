
public class LAMatrix {
	private int m, n;
	private double[][] elements;

	public LAMatrix(int x, int y) {
		this.m = x;
		this.n = y;
		this.elements = new double[m][n];
	}

	public int getM() {
		return this.m;
	}

	public int getN() {
		return this.n;
	}

	public void randomize() {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				elements[i][j] = Math.random();
			}
		}
	}

	public void set(int i, int j, double value) {
		elements[i][j] = value;
	}

	public double get(int i, int j) {
		return elements[i][j];
	}

	public LAMatrix dotMultiply(LAMatrix anotherMatrix) {
		LAMatrix resMat = new LAMatrix(m, n);
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				resMat.elements[i][j] = elements[i][j] * anotherMatrix.get(i, j);
			}
		}
		return resMat;

	}

	public LAVector dotMultiply(LAVector vec) {
		LAVector resVec = new LAVector(n);
		if (this.n != vec.GetN())
			resVec = null;
		else
			for (int i = 0; i < vec.length(); i++) {
				for (int j = 0; j < this.n; j++) {
				//resVec.
				
				}
			}
		return resVec;
	}

	public LAMatrix transpose() {
		LAMatrix trasMat = new LAMatrix(n, m);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				trasMat.elements[i][j] = elements[j][i];
			}
		}
		return trasMat;

	}

	public String toString() {
		String s = "[\n";
		for (int i = 0; i < m; i++) {
			s += elements[i][0];
			for (int j = 0; j < n - 1; j++) {
				s += ", " + elements[i][j];
			}
			s += ", " + elements[i][n - 1] + ";\n";
		}
		return s + "]";
	}
}
