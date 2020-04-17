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
import PT2019.assignment3.Assignment3.businessLogic.ProductBusiness;

public class ViewAllProducts extends JFrame{
	private JTable table;
	List<? extends Object> list;
	private JScrollPane scrollPane;
	private Font font = new Font("Trebuchet MS", Font.PLAIN, 11);
	private JButton goBack;
	public ViewAllProducts(ProductBusiness productBusiness) {
		
		table = new JTable();
		
		goBack = new JButton("  Back  ");
		goBack.setOpaque(false);
		goBack.setBackground(new Color(0, 1, 0, 1));
		goBack.setFont(font);
		
		
		list = productBusiness.selectAll();
		table = productBusiness.createTable(list);
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
		
		JPanel pane = new JPanel();
		pane.setOpaque(false);
		pane.setLayout(new FlowLayout());
		
		scrollPane.setBounds(50, 10, scrollPane.getPreferredSize().width, scrollPane.getPreferredSize().height);
		pane.add(scrollPane);
		
		JLabel picLabel = new JLabel(new ImageIcon("crowd.gif"));
		picLabel.setLayout(null);
		picLabel.setOpaque(false);
		
		
		pane.setBounds(50, 10, pane.getPreferredSize().width + 30, pane.getPreferredSize().height + 30);
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
		ProductView anotherView = new ProductView();
		ProductController productController = new ProductController(anotherView, new ProductBusiness());
		anotherView.setVisible(true);
	}
	public JButton getGoBack() {
		return goBack;
	}
	public void setGoBack(JButton goBack) {
		this.goBack = goBack;
	}
	public static void main(String[] args) {
		ViewAllProducts view = new ViewAllProducts(new ProductBusiness());
		view.setVisible(true);
	}
}
