package PT2019.assignment4.Assignment4.presentation;
import javax.swing.*;

import PT2019.assignment4.Assignment4.businessLayer.Restaurant;

import java.awt.*;
import java.awt.event.ActionListener;

import PT2019.assignment4.Assignment4.businessLayer.CompositeProduct;
import PT2019.assignment4.Assignment4.businessLayer.MenuItem;
public class AddOrderView extends JFrame{
	private Font font = new Font("Trebuchet MS", Font.PLAIN, 11);
	private JButton go;
	private JList<String> productList;
	private JScrollPane scrollPane;
	private JButton goBack;
	private JTextField quantity;
	private Restaurant restaurant;
	DefaultListModel<String> model = new DefaultListModel<>();

	@SuppressWarnings({ "serial" })
	public AddOrderView(Restaurant restaurant) {
		go = new JButton("GO!");
		this.restaurant = restaurant;
		go.setOpaque(false);
		go.setBackground(new Color(0, 0, 0, 1));
		go.setFont(font);
		go.setForeground(Color.LIGHT_GRAY);
		
		model = new DefaultListModel<>();
		goBack = new JButton("Back");
		goBack.setOpaque(false);
		goBack.setBackground(new Color(0, 0, 0, 1));
		goBack.setFont(font);
		goBack.setForeground(Color.LIGHT_GRAY);
		
		JLabel picLabel = new JLabel(new ImageIcon("add.gif"));
		picLabel.setLayout(null);
		
		quantity = new JTextField(10);
		quantity.setOpaque(false);
		quantity.setFont(font);
		quantity.setBounds(285, 45, quantity.getPreferredScrollableViewportSize().width, quantity.getPreferredScrollableViewportSize().height);
		
		JLabel choice3 = new JLabel("Choose quantity: ");
		choice3.setOpaque(false);
		choice3.setBounds(280, 20, choice3.getPreferredSize().width + 20, choice3.getPreferredSize().height);
		choice3.setFont(font);
		choice3.setForeground(Color.white);
		picLabel.add(choice3);
		picLabel.add(quantity);
		
		JLabel choice2 = new JLabel("Choose a product: ");
		choice2.setOpaque(false);
		choice2.setFont(font);
		choice2.setForeground(Color.white);
		choice2.setBounds(40, 20, choice2.getPreferredSize().width + 20, choice2.getPreferredSize().height);
		//choice2.setForeground(Color.white);
		picLabel.add(choice2);
		
		//ErrorClass2 err = new ErrorClass2("", restaurant, mainView);
	//	err.reset(0);
		System.out.println("LIST" + restaurant.getList());
		
		for(MenuItem item : restaurant.getList()) {
			model.addElement(item.toString());
		}
		
		productList = new JList<>(model);
		SwingUtilities.updateComponentTreeUI(productList);
		validate();

		productList.setOpaque(false);
		productList.setForeground(Color.white);
		productList.setFont(font);
		productList.setCellRenderer(new DefaultListCellRenderer() {
			 @Override
			    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
			        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
			        this.setOpaque(false);
			        return this;
			    }
		});
		
		SwingUtilities.updateComponentTreeUI(productList);

		scrollPane = new JScrollPane(productList);
		scrollPane.setFont(font);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		
		scrollPane.setBounds(45, 45, 220, 130);
		picLabel.add(scrollPane);
		
		go.setBounds(90, 190, go.getPreferredSize().width + 20, go.getPreferredSize().height);
		goBack.setBounds(300, 190, goBack.getPreferredSize().width + 20, goBack.getPreferredSize().height);
		picLabel.add(go);
		picLabel.add(goBack);
		JPanel pane = new JPanel();
		pane.setLayout(null);
		picLabel.setBounds(0, 0, picLabel.getPreferredSize().width, picLabel.getPreferredSize().height);
		pane.add(picLabel);
		
		this.setContentPane(pane);
		this.pack();
		this.setSize(500, 340);
		this.setLocation(700, 330);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setFont(font);
		this.setVisible(false);
		this.setTitle("Restaurant");
	}
	
	public JList<String> getProductList() {
		return productList;
	}

	public void setProductList(JList<String> productList) {
		this.productList = productList;
	}

	public JButton getGo() {
		return go;
	}

	public void setGo(JButton go) {
		this.go = go;
	}

	public void addActionListener(ActionListener buttonListener) {
		goBack.addActionListener(buttonListener);
		go.addActionListener(buttonListener);
	}
	
	public String getQuantity() {
		return quantity.getText();
	}

	public void setQuantity(JTextField quantity) {
		this.quantity = quantity;
	}

	public void reset() {
		
	}
	public JButton getGoBack() {
		return goBack;
	}

	public void setGoBack(JButton goBack) {
		this.goBack = goBack;
	}

}
