package PT2019.assignment4.Assignment4.presentation;

import java.awt.*;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import PT2019.assignment4.Assignment4.businessLayer.BaseProduct;
import PT2019.assignment4.Assignment4.businessLayer.CompositeProduct;
import PT2019.assignment4.Assignment4.businessLayer.MenuItem;
import PT2019.assignment4.Assignment4.businessLayer.Order;
import PT2019.assignment4.Assignment4.businessLayer.Restaurant;

public class ViewAllOrders extends JFrame {
	JLabel menuLabel;
	private Font font = new Font("Trebuchet MS", Font.PLAIN, 30);
	private Font font2 = new Font("Trebuchet MS", Font.PLAIN, 11);
	private JTable table;
	private JScrollPane scrollPane;
	private JButton goBack;
	private Restaurant restaurant;

	public ViewAllOrders(Restaurant restaurant) {
		
		this.restaurant = restaurant;
		table = this.createTable2(restaurant.getOrders());
		table.setOpaque(false);
		table.setFont(font2);
		table.setBackground(new Color(0, 0, 0, 0));
		table.setShowGrid(false);
		table.setIntercellSpacing(new Dimension(0, 0));
		table.setPreferredScrollableViewportSize(table.getPreferredSize());
		table.setFillsViewportHeight(true);
		table.setForeground(Color.white);
		table.getTableHeader().setBackground(new Color(0, 0, 0, 0.6f));
		table.getTableHeader().setForeground(Color.white);
		table.getTableHeader().setFont(font2);
		table.getTableHeader().setOpaque(false);

		scrollPane = new JScrollPane(table);
		scrollPane.setOpaque(false);
		scrollPane.setFont(font2);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setBounds(30, 60, 250, 200);
		table.setBounds(0, 0, 200, 200);

		menuLabel = new JLabel(new ImageIcon("banana.gif"));

		goBack = new JButton("Back");
		goBack.setOpaque(false);
		goBack.setBackground(new Color(0, 0, 0, 1));
		goBack.setFont(font2);
		goBack.setForeground(Color.LIGHT_GRAY);
		goBack.setBounds(330, 240, goBack.getPreferredSize().width, goBack.getPreferredSize().height);
		JLabel menu = new JLabel("Menu");
		menu.setOpaque(false);
		menu.setFont(font);
		menu.setBounds(60, 20, menu.getPreferredSize().width, menu.getPreferredSize().height);

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(null);
		menuLabel.setBounds(0, 0, menuLabel.getPreferredSize().width, menuLabel.getPreferredSize().height);
		menuLabel.add(menu);
		menuLabel.add(scrollPane);
		menuLabel.add(goBack);
		mainPanel.add(menuLabel);

		this.setContentPane(mainPanel);
		this.pack();
		this.setSize(500, 340);
		this.setLocation(700, 330);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// this.setVisible(true);
		this.setTitle("Restaurant Menu");
	}

	public JTable createTable2(HashMap<Order, List<MenuItem>> items) {
		String[] columns = {"Date", "Table", "Quantity", "Items"};
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss", Locale.US);
		DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
		Iterator<Entry<Order, List<MenuItem>>> it = items.entrySet().iterator();
		while(it.hasNext()) {
			@SuppressWarnings("rawtypes")
				Map.Entry pair = (Map.Entry)it.next();
				Order ord = (Order) pair.getKey();
				String date = format.format(ord.getDate());
				//System.out.println(date);
				String itemuri= "";
				@SuppressWarnings("unchecked")
				List<MenuItem> menuItems = (List<MenuItem>) pair.getValue();
				for(MenuItem itemm: menuItems) {
					itemuri += itemm.getName() + " " + itemm.getComposite() + " " + itemm.getPrice() + " " + itemm.getWeight() + "\n";
				}
				System.out.println("itemuri" + itemuri);
				Object[] obj = { date, ord.getTableNumber(), ord.getQuantity(), itemuri};
				tableModel.addRow(obj);
		
			}
		JTable table = new JTable(tableModel);
		return table;
	
	}

	public void addActionListener(ActionListener buttonListener) {
		goBack.addActionListener(buttonListener);
	}

	public JButton getGoBack() {
		return goBack;
	}

	public void setGoBack(JButton goBack) {
		this.goBack = goBack;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public void reset() {
	
	}

}
