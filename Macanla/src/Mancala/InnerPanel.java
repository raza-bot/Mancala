package Mancala;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;

import javax.swing.JPanel;

public class InnerPanel extends JPanel {
	private Model model;
	private ArrayList<Shape> pits = new ArrayList<Shape>();
	private Shape border=new RoundRectangle2D.Double(0, 0, 980, 299, 50, 50);
	
	public InnerPanel(Model model) {
		this.model = model;

		setPreferredSize(new Dimension(1000, 300));
		setLayout(new GridLayout(0, 6));
		
		pits.add(new RoundRectangle2D.Double(20, 20, 100, 260, 50, 50));
		
		for (int i = 0; i < 12; i++) {
			if (i < 6)
				pits.add(new Ellipse2D.Double((20 + (20 * i) + (100 * i))+125, 20, 100, 120));

			else
				pits.add(new Ellipse2D.Double((20 + (20 * (i - 6)) + (100 * (i - 6)))+125, 160, 100, 120));
		}
		
		pits.add(new RoundRectangle2D.Double(860, 20, 100, 260, 50, 50));
		
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				for (int i=1;i<13;i++) {

					if (pits.get(i).contains(e.getPoint())) {
						model.click(i);

					}

				}

				repaint();

			}
		});

	}

	@Override
	protected void paintComponent(Graphics grphcs) {
		super.paintComponent(grphcs);

		Graphics2D g2 = (Graphics2D) grphcs;
		g2.draw(border);

		for (int i = 0; i < 14; i++) {

			g2.draw(pits.get(i));
			
			for (int x = 0; x < model.getStone(i); x++) // where check pit array in model to draw no. of stone
			{
				if (i < 7)
					g2.fillOval(30 + 20 * i + (100 * i) + 20 * x, 40 + 20 * x, 20, 20);
				else
					g2.fillOval((30 + (20 * (i - 7)) + (100 * (i - 7)) + 20 * x+125), 175 + 20 * x, 20, 20);
			}
		}

	}

}
