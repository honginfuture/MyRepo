import javax.swing.JOptionPane;

/*
* CSC1130 Assignment 2 Exercise A: BMI Dialogue
* Aim: use of class JOptionPane to create dialogues
*
* Student Name: xxx <fill in yourself>
* Student ID : xxx <fill in yourself>
*
* Declaration: This assignment submission is my own work,
* done without referencing others' assignment.
* My work has NOT been revealed to ANYBODY in ANY form.
* I have read and I understand the University Policy and
* Guideline on Academic Honesty posted on:
* http://www.cuhk.edu.hk/policy/academichonesty/
*/
public class MyVector {
	double x;
	double y;
	double z;

	public static void main(String[] args) {
		MyVector v1;
		MyVector v2;
		MyVector v3;
		double lengthOfv1;
		double lengthOfv2;
		double v1v2DotProduct;

		v1 = new MyVector();
		v2 = new MyVector();
		v3 = new MyVector();

		v1.x = 1.5;
		v1.y = 2.5;
		v1.z = -0.8;

		v2.x = -1;
		v2.y = 2;
		v2.z = 0;

		v3.x = v1.x + v2.x;
		v3.y = v1.y + v2.y;
		v3.z = v1.z + v2.z;

		lengthOfv1 = Math.sqrt(Math.pow(v1.x, 2) + Math.pow(v1.y, 2) + Math.pow(v1.z, 2));
		lengthOfv2 = Math.sqrt(Math.pow(v2.x, 2) + Math.pow(v2.y, 2) + Math.pow(v2.z, 2));
		v1v2DotProduct = v1.x * v2.x + v1.y * v2.y + v1.z * v2.z;

		JOptionPane.showMessageDialog(null,
				"v1 = (1.5, 2.5, -0.8)\n" + "v2 = (-1.0, 2.0, 0.0)\n" + "Length of v1 = " + lengthOfv1
						+ "\nLength of v2 = " + lengthOfv2 + "\nv1v2DotProduct  = v1 . v2 = " + v1v2DotProduct
						+ "\nv3 = v1 + v2 = (" + v3.x + ", " + v3.y + ", " + v3.z + ")");
		// JOptionPane.showMessageDialog(null, Math.sqrt(v1,v2));
	}

}
