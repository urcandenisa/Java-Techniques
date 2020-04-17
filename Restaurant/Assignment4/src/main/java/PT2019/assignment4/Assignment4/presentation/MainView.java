package PT2019.assignment4.Assignment4.presentation;
import PT2019.assignment4.Assignment4.businessLayer.*;
import PT2019.assignment4.Assignment4.businessLayer.MenuItem;
import PT2019.assignment4.Assignment4.dataLayer.RestaurantSerialization;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.*;

public class MainView extends JFrame implements ActionListener {
	private Font font = new Font("Trebuchet MS", Font.PLAIN, 11);
	private Timer timer;
	private ImageIcon minion;
	private int x;
	private int y;
	private JLabel addItemTip;
	private JButton createOrder;
	private JButton computePriceForOrder;
	private JButton createBill;
	private JLabel minionLabel;
	private JLabel chefLabel;
	private JLabel cloudForChef;
	private JLabel picLabel;
	private JLabel waiterLabel;
	private JLabel cloudLabel;
	private JLabel menu;
	private JPanel mainPanel;
	private Restaurant restaurant;
	private JLabel cook;
	boolean once = true;
	public MainView(Restaurant restaurant) {
		this.restaurant = restaurant;
		picLabel = new JLabel(new ImageIcon("restaurant.jpg"));
		
		createOrder = new JButton("  Create order ");
		computePriceForOrder = new JButton("Compute price");
		createBill = new JButton("  Create bill    ");
		
		createOrder.setFont(font);
		computePriceForOrder.setFont(font);
		createBill.setFont(font);
		
		createOrder.setOpaque(false);
		computePriceForOrder.setOpaque(false);
		createBill.setOpaque(false);
		
		createOrder.setBackground(new Color(0, 0, 0, 1));
		computePriceForOrder.setBackground(new Color(0, 0, 0, 1));
		createBill.setBackground(new Color(0, 0, 0, 1));
		
		createOrder.setBounds(80, 45, 105, 20);
		computePriceForOrder.setBounds(80, 70, 105 , 20);
		createBill.setBounds(80, 95, 105, 20);
		
		addItemTip = new JLabel("");
		addItemTip.setToolTipText("Menu item");
		//addItemTip.setBounds(216, 216, 300, 30);
		
		mainPanel = new JPanel();
		mainPanel.setLayout(null);
		
		picLabel.setBounds(0, 0, picLabel.getPreferredSize().width, picLabel.getPreferredSize().height);
		
		timer = new Timer(100, this);
		
		minionLabel = new JLabel(new ImageIcon("minion2.png"));
		minionLabel.setBounds(0, 0, minionLabel.getPreferredSize().width, minionLabel.getPreferredSize().height);;
		
		chefLabel = new JLabel(new ImageIcon("chef.png"));
		chefLabel.setBounds(310, 235, chefLabel.getPreferredSize().width, chefLabel.getPreferredSize().height);
		picLabel.add(chefLabel);
		
		this.x = 560;
		this.y = 330;
		
		cook = new JLabel("I have to cook!");
		cook.setFont(font);
		cook.setBounds(95, 40, cook.getPreferredSize().width, cook.getPreferredSize().height);
		cook.setVisible(true);
		cook.setForeground(Color.black);

		cloudForChef = new JLabel(new ImageIcon("minicloud.png"));
		cloudForChef.setFont(font);
		cloudForChef.setBounds(270, 130, cloudForChef.getPreferredSize().width, cloudForChef.getPreferredSize().height);
		cloudForChef.setVisible(false);
		cloudForChef.add(cook);
		
		waiterLabel = new JLabel(new ImageIcon("waiter.png"));
		waiterLabel.setBounds(450, 285, waiterLabel.getPreferredSize().width, waiterLabel.getPreferredSize().height);
		
		cloudLabel = new JLabel(new ImageIcon("cloud.png"));
		cloudLabel.setBounds(390, 110, cloudLabel.getPreferredSize().width, cloudLabel.getPreferredSize().height);
		
		cloudLabel.add(createOrder);
		cloudLabel.add(computePriceForOrder);
		cloudLabel.add(createBill);
		cloudLabel.setVisible(false);
		
		menu = new JLabel("");
		menu.setToolTipText("Menu");
		//menu.setBounds(120, 350, 60, 60);
		//if(once == true) {
			timer.start();
			
	//	}
		
		picLabel.add(menu);
		picLabel.add(addItemTip);
		picLabel.add(cloudForChef);
		picLabel.add(minionLabel);
		picLabel.add(cloudLabel);
		picLabel.add(waiterLabel);
		
		mainPanel.add(picLabel);
		this.setContentPane(mainPanel);
		this.pack();
		this.setSize(800, 500);
		this.setLocation(550, 250);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		JFrame f = this;
		this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				//serializare
				
				ArrayList<MenuItem> resta = restaurant.getList();
				System.out.println(resta);
				RestaurantSerialization.serialization(restaurant.getList());
				//RestaurantSerialization.serialization(restaurant.getList());
				f.dispose();
				
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		this.setFont(font);
	//	this.setVisible(true);
		this.setTitle("Restaurant");
		
	}
	
	public void addActionListener(ActionListener buttonListener) {
		createOrder.addActionListener(buttonListener);
		computePriceForOrder.addActionListener(buttonListener);
		createBill.addActionListener(buttonListener);
	}
	
	public JButton getCreateOrder() {
		return createOrder;
	}

	public void setCreateOrder(JButton createOrder) {
		this.createOrder = createOrder;
	}

	public JButton getComputePriceForOrder() {
		return computePriceForOrder;
	}

	public void setComputePriceForOrder(JButton computePriceForOrder) {
		this.computePriceForOrder = computePriceForOrder;
	}

	public JButton getCreateBill() {
		return createBill;
	}

	public void setCreateBill(JButton createBill) {
		this.createBill = createBill;
	}

	public JLabel getCloudForChef() {
		return cloudForChef;
	}

	public void setCloudForChef(JLabel cloudForChef) {
		this.cloudForChef = cloudForChef;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public JLabel getCloudLabel() {
		return cloudLabel;
	}

	public void setCloudLabel(JLabel cloudLabel) {
		this.cloudLabel = cloudLabel;
	}

/*	public static void main(String[] args) {
		MainView mainView = new MainView();
		mainView.setVisible(true);
	}*/

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		x -= 5;
		if(x == 160) {
			once = false;
			minionLabel.setLocation(140,305);
			//cloudLabel.setVisible(true);
			timer.stop();
		}else
		minionLabel.setLocation(x, y);
	}
}
