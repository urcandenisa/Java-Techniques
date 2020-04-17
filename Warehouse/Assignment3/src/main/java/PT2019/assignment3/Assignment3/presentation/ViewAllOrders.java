package PT2019.assignment3.Assignment3.presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import PT2019.assignment3.Assignment3.businessLogic.ClientBusiness;
import PT2019.assignment3.Assignment3.businessLogic.OrderDetailBusiness;
import PT2019.assignment3.Assignment3.businessLogic.OrdersBusiness;
import PT2019.assignment3.Assignment3.businessLogic.ProductBusiness;

public class ViewAllOrders extends JFrame{
	private JTable table;
	List<? extends Object> list;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane1;
	private Font font = new Font("Trebuchet MS", Font.PLAIN, 11);
	private JButton goBack;
	private JTable table1;
	List<? extends Object> list1;

	public ViewAllOrders(OrdersBusiness ordersBusiness, OrderDetailBusiness orderDetailBusiness) {
		
		table = new JTable();
		
		goBack = new JButton("  Back  ");
		goBack.setOpaque(false);
		goBack.setBackground(new Color(0, 1, 0, 1));
		goBack.setFont(font);
	

		list1 = orderDetailBusiness.selectAll();
		System.out.println(list1);
		table1 = orderDetailBusiness.createTable(list1);
		table1.setOpaque(false);
		table1.setFont(font);
		table1.setBackground(new Color(0,0, 0, 0));
		table1.setShowGrid(false);
		table1.setIntercellSpacing(new Dimension(0, 0));
		table1.setPreferredScrollableViewportSize(table1.getPreferredSize());
		table1.setFillsViewportHeight(true);
		table1.setForeground(Color.white);
		table1.getTableHeader().setBackground(new Color(0, 0, 0, 0.6f));
		table1.getTableHeader().setForeground(Color.white);
		table1.getTableHeader().setFont(font);
		table1.getTableHeader().setOpaque(false);
		System.out.println(list1);
		System.out.println(table1);
		list = ordersBusiness.selectAll();
		table = ordersBusiness.createTable(list);
		table.setOpaque(false);
		table.setFont(font);
		table.setBackground(new Color(0,0, 0, 0));
		table.setShowGrid(false);
		table.setIntercellSpacing(new Dimension(0, 0));
		table.setPreferredScrollableViewportSize(table.getPreferredSize());
		table.setFillsViewportHeight(true);
		table.setForeground(Color.white);
		table.getTableHeader().setBackground(new Color(0, 0, 0, 0.6f));
		table.getTableHeader().setForeground(Color.white);
		table.getTableHeader().setFont(font);
		table.getTableHeader().setOpaque(false);
		System.out.println(list);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setOpaque(false);
		scrollPane.setForeground(Color.LIGHT_GRAY);
		scrollPane.getViewport().setOpaque(false);
		
		scrollPane1 = new JScrollPane(table1);
		scrollPane1.setOpaque(false);
		scrollPane1.setForeground(Color.LIGHT_GRAY);
		scrollPane1.getViewport().setOpaque(false);
		
		JPanel pane = new JPanel();
		pane.setOpaque(false);
		pane.setLayout(null);
		
		scrollPane.setBounds(10, 10, scrollPane.getPreferredSize().width + 80, scrollPane.getPreferredSize().height);
		pane.add(scrollPane);
		
		scrollPane1.setBounds(250, 10, scrollPane1.getPreferredSize().width, scrollPane1.getPreferredSize().height);
		pane.add(scrollPane1);
		
		JLabel picLabel = new JLabel(new ImageIcon("crowd.gif"));
		picLabel.setLayout(null);
		picLabel.setOpaque(false);
		
		
		pane.setBounds(10, 10, pane.getPreferredSize().width + 600, pane.getPreferredSize().height + 200);
		picLabel.add(pane);
		picLabel.add(goBack);
		goBack.setBounds(310, 250, goBack.getPreferredSize().width, goBack.getPreferredSize().height);
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.add(picLabel);
		
		this.setContentPane(mainPanel);
		this.pack();
		this.setSize(500, 340);
		this.setLocation(700, 330);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setFont(font);
	//	this.setVisible(true);
		this.setTitle("Warehouse");
	
	}
	public void addActionListener(ActionListener buttonListener) {
		goBack.addActionListener(buttonListener);
	}
	public void reset() {
		OrderView anotherView = new OrderView(new ClientBusiness(), new ProductBusiness());
		OrderController addClientController = new OrderController(anotherView, new OrdersBusiness(), new OrderDetailBusiness());
		anotherView.setVisible(true);
	}
	public JButton getGoBack() {
		return goBack;
	}
	public void setGoBack(JButton goBack) {
		this.goBack = goBack;
	}
	
	public static void main(String[] args) {
		ViewAllOrders view = new ViewAllOrders(new OrdersBusiness(), new OrderDetailBusiness());
		ViewAllOrdersController cont = new ViewAllOrdersController(view);
		view.setVisible(true);
	}
}
