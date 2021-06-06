package Mancala;

import javax.swing.JFrame;

public class Controller {
	public static void main(String[] args) {
		Model model=new Model();
		View frame1=new View(model);
		frame1.setVisible(true);
		frame1.pack();
		//frame1.setSize(1000, 700);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
