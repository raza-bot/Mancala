package Mancala;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class View extends JFrame {
	private Model model;
	private JPanel main;
	private JPanel pit;
	private JLabel west;
	private JLabel east;
	private JLabel south;
	private JLabel north;

	public View(Model model) {
		this.model=model;
		west = new JLabel(VertStr("MACANLA B"));
		east = new JLabel(VertStr("MACANLA A"));
		north = new JLabel("<- Palyer B", SwingConstants.CENTER);
		south = new JLabel("Palyer A ->", SwingConstants.CENTER);
		west.setFont(new Font("Courier", Font.BOLD, 20));
		south.setFont(new Font("Courier", Font.BOLD, 20));
		east.setFont(new Font("Courier", Font.BOLD, 20));
		north.setFont(new Font("Courier", Font.BOLD, 20));
		setLayout(new BorderLayout());
		add(new InnerPanel(model), BorderLayout.CENTER);
		add(south, BorderLayout.SOUTH);
		add(north, BorderLayout.NORTH);
		add(east, BorderLayout.EAST);
		add(west, BorderLayout.WEST);

	}

	public String VertStr(String s) {
		String[] in = s.split("");
		String out = "<html>";
		String br = "<br>";
		for (String a : in) {
			out += a + br;
		}
		out += "</html>";
		return out;
	}

}
