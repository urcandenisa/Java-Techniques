package PT2019.assignment3.Assignment3.presentation;

import java.awt.GridLayout;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class InsideView extends JFrame{
	private JLabel picLabel;
	private JLabel princessLabel;
	private Font font = new Font("Trebuchet MS", Font.PLAIN, 11);
	
	public InsideView() {
		
		ImageIcon inside = new ImageIcon("inside.jpg");
		
		ImageIcon princess = new ImageIcon("miniprincess.png");
		
		JPanel left = new JPanel();
		left.setOpaque(false);
		
		JLabel picLabel = new JLabel(inside);
		picLabel.setLayout(new BoxLayout(picLabel, BoxLayout.Y_AXIS));
		picLabel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		princessLabel = new JLabel(princess);
		
		picLabel.add(Box.createRigidArea(new Dimension(10,240)));
		
		picLabel.add(princessLabel);
		
		left.add(picLabel);
			
		JPanel pane = new JPanel(new FlowLayout());
		pane.add(left);
		
		this.setContentPane(pane);
		this.pack();
		this.setSize(800, 500);
		this.setLocation(350, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setFont(font);
	//	this.setVisible(true);
		this.setTitle("Warehouse");
		
	}
	
	
	public static void main(String[] args) {
		InsideView view = new InsideView();
		view.setVisible(true);
	}
}
