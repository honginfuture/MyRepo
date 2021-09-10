/*
 * CSC1130 Assignment 5
 * Given class LinearAlgebra
 * You should uncomment the statement line one-by-one to test run your classes LAVector and LAMatrix
 */

/**
 *
 * @author pffung
 */
public class LinearAlgebra {
	public static void main(String[] args) {
		LAVector v1 = new LAVector(5);
		LAVector v2 = new LAVector(1);
		LAMatrix m1 = new LAMatrix(5, 5);
		LAMatrix m2 = new LAMatrix(3, 4);

		v1.set(2, -5.8);
		m1.set(2, 4, 3.57);

		System.out.println("v1 = " + v1);
		System.out.println("v2 = " + v2);
		System.out.println("m1 = " + m1);
		// System.out.println("m2 = " + m2);

		try {
			v1.dot(v2);
		} catch (Exception e) {
			System.out.println("*** " + e);
		}

		System.out.println("||v1|| = " + v1.length());

		v1.randomize();
		v2.randomize();
		m1.randomize();
		m2.randomize();

		System.out.println("m1 = " + m1);
		System.out.println("m1 * m1 = " + m1.dotMultiply(m1));

		System.out.println("v1 = " + v1);
		System.out.println("v1 * m1 = " + v1.dotMultiply(m1));

		System.out.println("m1 * v1' = " + m1.dotMultiply(v1));

		System.out.println("m2 = " + m2);
		System.out.println("m2' = " + m2.transpose());

		//System.out.println("m2 * m2' = " + m2.dotMultiply(m2.transpose())); 
		//System.out.println("m2' * m2 = " + m2.transpose().dotMultiply(m2));
	}
}
