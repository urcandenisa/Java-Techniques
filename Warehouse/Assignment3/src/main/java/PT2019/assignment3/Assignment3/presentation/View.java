package PT2019.assignment3.Assignment3.presentation;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class View extends JFrame {

	private TimerEx timerEx;
	private Font font = new Font("Trebuchet MS", Font.PLAIN, 11);
	
	public View(InsideView clientView) {
		
		timerEx = new TimerEx(this, clientView);

		timerEx.setLayout(null);
		timerEx.setFocusable(true);

		this.setContentPane(timerEx);
		this.setSize(800, 500);
		this.setLocation(350, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setFont(font);
		this.setVisible(true);
		this.setTitle("Warehouse");
	}

}
