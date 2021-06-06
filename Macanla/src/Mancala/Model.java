package Mancala;

import java.util.ArrayList;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Model {
	private ArrayList<Integer> pits;
	private ArrayList<ChangeListener> listeners;
	
	public Model() {
		pits=new ArrayList<>();
		listeners = new ArrayList<>();
		for(int i=0;i<14;i++) {
			pits.add(1);
		}
	}
	public void click(int i) {
		Integer x=pits.get(i)+1;
		pits.set(i,x );
		
	}
	public int getStone(int i) {
		int stone = (int)pits.get(i);
				return stone;
		}
	}
	

