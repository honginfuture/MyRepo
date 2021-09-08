import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


//http://www.java2s.com/Code/Java/Swing-JFC/Usingdropdownlists.htm
public class MyCoffeeGUI {

	private JLabel label1 = new JLabel("Product Information:");
	// private JLabel[] jLables = new JLabel[6];

	private JLabel label2 = new JLabel();
	private JLabel label3 = new JLabel();
	private JLabel label4 = new JLabel();
	private JLabel label5 = new JLabel();
	private JLabel label6 = new JLabel();
	private JLabel label7 = new JLabel();
	private JFrame frame = new JFrame();
	JPanel panel = new JPanel();

	public MyCoffeeGUI() {

		// the clickable button1 to add
		JButton button1 = new JButton("Roast Me");

		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ethiopia eth = new Ethiopia("Arabica", 1931, 195, "Bench Maji", "Gesha 1931");
				label2.setText("Flavors: " + eth.roast());
				label3.setText("Region: " + eth.getType());
				label4.setText("Varietal: " + eth.getAltitude());
				label5.setText("Varietal: " + eth.getPrice());
				label6.setText("Varietal: " + eth.getRegion());
				label7.setText("Varietal: " + eth.getVarietal());
			}
		});

		// the panel with the button and text

		panel.setBorder(BorderFactory.createEmptyBorder(30, 10, 30, 30));
		panel.setLayout(new GridLayout(0, 3));

		String comboBoxItems[] = { "Ethiopia", "TEXTPANEL" };
		JComboBox cb = new JComboBox(comboBoxItems);
		cb.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				label1.setText((String) ((JComboBox) e.getSource()).getSelectedItem());
			}
		});

		panel.add(cb);
		panel.add(button1);
		panel.add(label1);
		panel.add(label2);
		panel.add(label3);
		panel.add(label4);
		panel.add(label5);
		panel.add(label6);
		panel.add(label7);

		// set up the frame and display it
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("GUI");
		frame.pack();
		frame.setVisible(true);
	}

}
