import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/******************************************************************************
 * Compilation: javac GUI.java Execution: java GUI
 *
 * A minimal Java program with a graphical user interface. The GUI prints out
 * the number of times the user clicks a button.
 *
 * % java GUI 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
 ******************************************************************************/

public class GUI {
	private double clicks = 0;
	private JLabel label = new JLabel("Number of clicks:  0     ");
	private JFrame frame = new JFrame();
	JPanel panel = new JPanel();

	public GUI() {

		// the clickable button1 to add
		JButton button1 = new JButton("Add");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clicks++;
				label.setText("Number of clicks:  " + clicks);
			}
		});

		// the clickable button2 to substract
		JButton button2 = new JButton("Substract");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clicks--;
				label.setText("Number of clicks:  " + clicks);
			}
		});

		// the clickable button3 to ShowText
		JButton button3 = new JButton("ClickMe");
		button3.addActionListener(new ActionListener() {
			String s = "<html>";

			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i <= 10; i++) {
					s += (i + "\t" + i + "\t" + 2 * Math.PI * i / 2 + "<br>");
				}
				s += "</html>";

				panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
				panel.setLayout(new GridLayout(7, 1));
				panel.add(button1);
				panel.add(button2);
				panel.add(button3);
				panel.add(label);

				// set up the frame and display it
				frame.add(panel, BorderLayout.CENTER);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setTitle("GUI");
				frame.pack();
				frame.setVisible(true);

				label.setText(s);
			}
		});

		// the panel with the button and text

		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		panel.setLayout(new GridLayout(0, 1));
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(label);

		// set up the frame and display it
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("GUI");
		frame.pack();
		frame.setVisible(true);
	}

	// process the button clicks
	public void actionPerformed(ActionEvent e) {
		clicks++;
		label.setText("Number of clicks:  " + clicks);
	}

	// create one Frame
	public static void main(String[] args) {
		new GUI();
	}
}
