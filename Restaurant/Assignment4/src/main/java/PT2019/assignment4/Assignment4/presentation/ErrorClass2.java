package PT2019.assignment4.Assignment4.presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import PT2019.assignment4.Assignment4.businessLayer.CompositeProduct;
import PT2019.assignment4.Assignment4.businessLayer.Restaurant;

public class ErrorClass2 extends JFrame {
	private JLabel errorLabel;
	private Font font = new Font("Trebuchet MS", Font.PLAIN, 30);
	private Font font2 = new Font("Trebuchet MS", Font.PLAIN, 11);
	private Font font3 = new Font("Trebuchet MS", Font.PLAIN, 15);
	private JButton viewAll;
	private JButton goBack;
	private Restaurant restaurant; 
	public ErrorClass2(String errors, Restaurant restaurant) {

		this.restaurant = restaurant;
		JLabel picLabel = new JLabel(new ImageIcon("error.gif"));
		picLabel.setOpaque(false);
		picLabel.setLayout(null);

		viewAll = new JButton("View all");
		viewAll.setOpaque(false);
		viewAll.setBackground(new Color(0, 1, 0, 1));
		viewAll.setFont(font2);
		viewAll.setSize(new Dimension(10, 20));

		goBack = new JButton("  Back  ");
		goBack.setOpaque(false);
		goBack.setBackground(new Color(0, 1, 0, 1));
		goBack.setFont(font2);

		errorLabel = new JLabel(errors);
		errorLabel.setFont(font3);
		errorLabel.setOpaque(false);
		errorLabel.setForeground(Color.white);

		JPanel error = new JPanel();
		error.setOpaque(false);
		error.setLayout(new FlowLayout());
		error.setSize(new Dimension(30, 40));
		error.add(errorLabel);

		picLabel.add(error);
		picLabel.add(viewAll);
		picLabel.add(goBack);
		error.setBounds(30, 20, error.getPreferredSize().width, error.getPreferredSize().height);
		viewAll.setBounds(335, 210, viewAll.getPreferredSize().width, viewAll.getPreferredSize().height);
		goBack.setBounds(70, 210, goBack.getPreferredSize().width, goBack.getPreferredSize().height);
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.add(picLabel);

		this.setContentPane(mainPanel);
		this.pack();
		// this.setResizable(false);
		this.setSize(500, 340);
		this.setLocation(700, 330);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setFont(font);
		// this.setVisible(true);
		this.setTitle("Warehouse");
	}

	public void addActionListener(ActionListener buttonListener) {
		goBack.addActionListener(buttonListener);
		viewAll.addActionListener(buttonListener);
	}

	public JButton getViewAll() {
		return viewAll;
	}

	public void setViewAll(JButton viewAll) {
		this.viewAll = viewAll;
	}

	public JButton getGoBack() {
		return goBack;
	}

	public void setGoBack(JButton goBack) {
		this.goBack = goBack;
	}

	public void reset(int var) {
		
	}
}
