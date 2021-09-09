import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

//http://www.java2s.com/Code/Java/Swing-JFC/Usingdropdownlists.htm
public class MyCoffeeGUI extends JPanel implements ActionListener {
	private String[] description = { "Ethiopia", "Bazil", "Polio", "Brilliant", "Somnescent", "Timorous", "Florid",
			"Putrescent" };

	private JLabel label1 = new JLabel("HIHIHIHI");
	private JComboBox dropList;

	public MyCoffeeGUI() {
		super(new BorderLayout());
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
		dropList = new JComboBox(description);
		// dropList.setSelectedIndex(2);

		dropList.addActionListener(this);
		label1.setHorizontalAlignment(JLabel.CENTER);

		add(dropList, BorderLayout.PAGE_START);
		add(label1);

		setBorder(BorderFactory.createEmptyBorder(0, 30, 20, 20));

		// dropList.addActionListener(dropList);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		String coffeeName = (String) cb.getSelectedItem();
		updateLabel(coffeeName);

	}

	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == dropList) {
			label1.setText((String) dropList.getSelectedItem());
		}
	}

	protected void updateLabel(String name) {
		label1.setText(name);
	}

}
