package PT2019.assignment4.Assignment4.presentation;

import javax.swing.*;

import PT2019.assignment4.Assignment4.businessLayer.CompositeProduct;
import PT2019.assignment4.Assignment4.businessLayer.Restaurant;

import java.awt.*;
import java.awt.event.ActionListener;

public class ComputePriceView extends JFrame {
	private Font font = new Font("Trebuchet MS", Font.PLAIN, 11);
	private JLabel orderId;
	private JTextField introduceOrderId;
	private JButton go;
	private JButton goBack;
	private Restaurant restaurant;

	public ComputePriceView(Restaurant restaurant){
		
		this.restaurant = restaurant;
	
		go = new JButton("GO!");
		go.setOpaque(false);
		go.setBackground(new Color(0, 0, 0, 1));
		go.setFont(font);
		
		goBack = new JButton("Back");
		goBack.setOpaque(false);
		goBack.setBackground(new Color(0, 0, 0, 1));
		goBack.setFont(font);
		
		orderId = new JLabel("Introduce order's id: ");
		orderId.setFont(font);
		orderId.setOpaque(false);
		orderId.setForeground(Color.white);
		
		introduceOrderId = new JTextField(15);
		introduceOrderId.setOpaque(false);
		introduceOrderId.setForeground(new Color(0, 0, 0, 1));
		introduceOrderId.setForeground(Color.white);
		
		orderId.setBounds(110, 50, orderId.getPreferredSize().width, orderId.getPreferredSize().height);
		introduceOrderId.setBounds(105, 70, introduceOrderId.getPreferredSize().width, introduceOrderId.getPreferredScrollableViewportSize().height);
		
		go.setBounds(110, 95, go.getPreferredSize().width, go.getPreferredSize().height);
		goBack.setBounds(170, 95, goBack.getPreferredSize().width, goBack.getPreferredSize().height);
		go.setForeground(Color.white);
		goBack.setForeground(Color.white);
		JLabel picLabel = new JLabel(new ImageIcon("add.gif"));
		picLabel.setLayout(null);
		picLabel.add(orderId);
		picLabel.add(introduceOrderId);
		picLabel.add(go);
		picLabel.add(goBack);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(null);
		picLabel.setBounds(0, 0, picLabel.getPreferredSize().width, picLabel.getPreferredSize().height);
		mainPanel.add(picLabel);
		

		this.setContentPane(mainPanel);
		this.pack();
		this.setSize(500, 340);
		this.setLocation(700, 330);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setFont(font);
		this.setResizable(false);
		this.setVisible(false);
		this.setTitle("Restaurant");
		
	}
	public void addActionListener(ActionListener buttonListener) {
		goBack.addActionListener(buttonListener);
		go.addActionListener(buttonListener);
	}
	
	public void reset() {

	}
	public JButton getGo() {
		return go;
	}
	public void setGo(JButton go) {
		this.go = go;
	}
	public JButton getGoBack() {
		return goBack;
	}
	public void setGoBack(JButton goBack) {
		this.goBack = goBack;
	}
	public String getIntroduceOrderId() {
		return introduceOrderId.getText();
	}
	public void setIntroduceOrderId(JTextField introduceOrderId) {
		this.introduceOrderId = introduceOrderId;
	}
	
}
