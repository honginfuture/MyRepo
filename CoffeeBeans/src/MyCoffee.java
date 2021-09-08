import javax.swing.JComponent;
import javax.swing.JFrame;

public class MyCoffee {

	// create one Frame
	public static void main(String[] args) {

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});

	}

	private static void createAndShowGUI() {
		JFrame frame = new JFrame("ComboBox Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JComponent newContentPane = new MyCoffeeGUI();
		newContentPane.setOpaque(true);
		frame.setContentPane(newContentPane);

		frame.pack();
		frame.setVisible(true);
	}

}
