package PT2019.assignment3.Assignment3.presentation;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

import PT2019.assignment3.Assignment3.businessLogic.ClientBusiness;
import PT2019.assignment3.Assignment3.businessLogic.OrderDetailBusiness;
import PT2019.assignment3.Assignment3.businessLogic.OrdersBusiness;
import PT2019.assignment3.Assignment3.businessLogic.ProductBusiness;

public class OrderView extends JFrame{
	
	private Font font = new Font("Trebuchet MS", Font.PLAIN, 11);
	private JList listClients;
	private ClientBusiness clientBusiness;
	private ProductBusiness productBusiness;
	private JButton go;
	private JList productList;
	private JScrollPane scrollPane;
	private JButton goBack;
	private JTextField quantity;
	@SuppressWarnings({ "unchecked", "serial" })
	public OrderView(ClientBusiness clientBusiness, ProductBusiness productBusiness) {
		
		this.clientBusiness = clientBusiness;
		this.productBusiness = productBusiness;
		go = new JButton("GO!");
		go.setOpaque(false);
		go.setBackground(new Color(0, 0, 0, 1));
		go.setFont(font);
		
		goBack = new JButton("Back");
		goBack.setOpaque(false);
		goBack.setBackground(new Color(0, 0, 0, 1));
		goBack.setFont(font);
		
		listClients = clientBusiness.createCombo(clientBusiness.selectAll());
		listClients.setOpaque(false);
		listClients.setForeground(Color.white);
		listClients.setCellRenderer(new BasicComboBoxRenderer(){
		    @SuppressWarnings("rawtypes")
			@Override
		    public Component getListCellRendererComponent(JList list, Object value,
		            int index, boolean isSelected, boolean cellHasFocus) {
		    	super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		    	this.setOpaque(false);
		        return this;
		    }});
		
		JLabel picLabel = new JLabel(new ImageIcon("order.gif"));
		picLabel.setLayout(null);
		
		JLabel choice = new JLabel("Choose a client:");
		choice.setOpaque(false);
		choice.setBounds(10, 20, choice.getPreferredSize().width + 20, choice.getPreferredSize().height);
	//	choice.setForeground(Color.white);
		picLabel.add(choice);
		choice.setFont(font);
		
		quantity = new JTextField(10);
		quantity.setOpaque(false);
		quantity.setFont(font);
		quantity.setBounds(345, 45, quantity.getPreferredScrollableViewportSize().width, quantity.getPreferredScrollableViewportSize().height);
		
		JLabel choice3 = new JLabel("Choose quantity: ");
		choice3.setOpaque(false);
		choice3.setBounds(350, 20, choice.getPreferredSize().width + 20, choice.getPreferredSize().height);
		choice3.setFont(font);
		picLabel.add(choice3);
		picLabel.add(quantity);
		
		listClients.setBounds(25, 45, listClients.getPreferredSize().width + 80, listClients.getPreferredSize().height);
		picLabel.add(listClients);
		listClients.setFont(font);
		JLabel choice2 = new JLabel("Choose a product: ");
		choice2.setOpaque(false);
		choice2.setFont(font);
		choice2.setBounds(120, 20, choice.getPreferredSize().width + 20, choice.getPreferredSize().height);
		//choice2.setForeground(Color.white);
		picLabel.add(choice2);
		

		productList = clientBusiness.createJList(productBusiness.selectAll());
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
		//productList.setBounds(100, 100, productList.getPreferredScrollableViewportSize().width, productList.getPreferredScrollableViewportSize().height);
		scrollPane = new JScrollPane(productList);
		scrollPane.setFont(font);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		
		scrollPane.setBounds(115, 45, 220, 130);
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
	//	this.setVisible(true);
		this.setTitle("Warehouse");
	}
	
	public void AddActionListener(ActionListener buttonListener) {
		go.addActionListener(buttonListener);
		goBack.addActionListener(buttonListener);
	}
	
	public void reset() {
		InsideView view = new InsideView();
		ClientView addClientView = new ClientView();
		ProductView productView = new ProductView();
		ClientBusiness client = new ClientBusiness();
		OrdersBusiness ord = new OrdersBusiness();
		OrderDetailBusiness order = new OrderDetailBusiness();
		ProductBusiness prod = new ProductBusiness();
		OrderView orderView = new OrderView(client, prod);
		ClientController cl = new ClientController(addClientView, client);
		ProductController pr = new ProductController(productView, prod);
		OrderController or = new OrderController(orderView, ord, order);
		InsideController cont = new InsideController(view, addClientView, productView, orderView);
		view.setVisible(true);

	}
	public JList getListClients() {
		return listClients;
	}

	public void setListClients(JList listClients) {
		this.listClients = listClients;
	}

	public JList getProductList() {
		return productList;
	}

	public void setProductList(JList productList) {
		this.productList = productList;
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
	
	public String getQuantity() {
		return quantity.getText();
	}


	public static void main(String[] args) {
		OrderView view = new OrderView(new ClientBusiness(), new ProductBusiness());
		view.setVisible(true);
		
	}
}
