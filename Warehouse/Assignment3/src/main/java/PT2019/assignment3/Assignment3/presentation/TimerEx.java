package PT2019.assignment3.Assignment3.presentation;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class TimerEx  extends JPanel implements ActionListener, KeyListener{
	
	Timer timer;
	private ImageIcon princess = new ImageIcon("princess.png");
	private ImageIcon supermarket = new ImageIcon("supermarket.png");
	private int x;
	private int y;
	private int valx;
	private View view;
	private InsideView clientView;

	public TimerEx(View view, InsideView clientView) {
		
		this.clientView = clientView;
		this.view = view;
		timer = new Timer(10, this);
		timer.start();
		
		this.setLayout(null);
		
		this.x = 0;
		this.y = 140;
		
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}
	
	public void reset() {
		
		x = 0;
		y = 140;
		
		valx = 0;
		
		repaint();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.setPaint(Color.LIGHT_GRAY);
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
		supermarket.paintIcon(this, g2, 130, 0);
		princess.paintIcon(this, g2, x, y);
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		timer.stop();
		this.requestFocus();
		if(this.isInside() == true) {
			x += valx;
			repaint();
			if(x == 450) {
				view.setVisible(false);
				clientView.setVisible(true);
			}
			else
			if(x > 700) {
				reset();
			}
		}
	}
	
	public void stop() {
		timer.stop();
	}
	public boolean isInside() {
		if(valx <= 500 && valx >= 0)
			return true;
		return false;
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub	
	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		this.requestFocus(true);
		int pressedKey = e.getKeyCode();
		timer.stop();
		if(pressedKey == KeyEvent.VK_RIGHT) {
			timer.start();
			valx = 30;
		}
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int pressedKey = e.getKeyCode();
		timer.stop();
		if(pressedKey == KeyEvent.VK_RIGHT)
			timer.stop();	
	}
}
