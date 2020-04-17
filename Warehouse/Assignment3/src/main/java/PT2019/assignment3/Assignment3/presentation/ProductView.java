package PT2019.assignment3.Assignment3.presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.event.ChangeListener;

import PT2019.assignment3.Assignment3.businessLogic.ClientBusiness;
import PT2019.assignment3.Assignment3.businessLogic.OrderDetailBusiness;
import PT2019.assignment3.Assignment3.businessLogic.OrdersBusiness;
import PT2019.assignment3.Assignment3.businessLogic.ProductBusiness;

public class ProductView extends JFrame {
	private final static Color TRANSPARENT = new Color(0, 0, 0, 0);
	private JLabel productName;
	private JTextField introduceProductName;
	private JLabel productPrice;
	private JTextField introduceProductPrice;
	private JLabel productQuantity;
	private JTextField introduceProductQuantity;
	private JButton go;
	private JLabel productName1;
	private JTextField introduceProductName1;
	private JLabel productPrice1;
	private JTextField introduceProductPrice1;
	private JLabel productQuantity1;
	private JTextField introduceProductQuantity1;
	private JButton go1;
	private JLabel errLabel;
	private JLabel productId;
	private JTextField introduceProductId;
	private JLabel productId1;
	private JTextField introduceProductId1;
	private JButton go2;
	private JTabbedPane tabbedPane;
	private Font font = new Font("Trebuchet MS", Font.PLAIN, 11);
	private JButton goBack;
	private JButton goBack1;
	private JButton goBack2;
	public ProductView() {

		UIManager.put("TabbedPane.contentOpaque", false);
		UIManager.put("TabbedPane.contentAreaColor", TRANSPARENT);
		UIManager.put("TabbedPane.selected", TRANSPARENT);
		UIManager.put("TabbedPane.background", TRANSPARENT);
		UIManager.put("TabbedPane.borderHightlightColor", TRANSPARENT);
		UIManager.put("TabbedPane.darkShadow", TRANSPARENT);
		UIManager.put("TabbedPane.focus", TRANSPARENT);
		
		goBack = new JButton("  Back  ");
		goBack.setOpaque(false);
		goBack.setBackground(new Color(0, 1, 0, 1));
		goBack.setFont(font);
		
		goBack1 = new JButton("  Back  ");
		goBack1.setOpaque(false);
		goBack1.setBackground(new Color(0, 1, 0, 1));
		goBack1.setFont(font);
		
		goBack2 = new JButton("  Back  ");
		goBack2.setOpaque(false);
		goBack2.setBackground(new Color(0, 1, 0, 1));
		goBack2.setFont(font);

		JPanel forAdd = new JPanel();
		forAdd.setLayout(new BoxLayout(forAdd, BoxLayout.Y_AXIS));
		forAdd.setOpaque(false);

		JPanel forEdit = new JPanel();
		forEdit.setLayout(new BoxLayout(forEdit, BoxLayout.Y_AXIS));
		forEdit.setOpaque(false);

		JPanel forDelete = new JPanel();
		forDelete.setLayout(new BoxLayout(forDelete, BoxLayout.Y_AXIS));
		forDelete.setOpaque(false);

		productName = new JLabel("Introduce product name: ");
		productName.setForeground(Color.LIGHT_GRAY);
		productName.setFont(font);
		productName.setOpaque(false);

		introduceProductName = new JTextField(10);
		introduceProductName.setOpaque(false);
		introduceProductName.setForeground(Color.LIGHT_GRAY);

		productPrice = new JLabel("Introduce product price: ");
		productPrice.setForeground(Color.LIGHT_GRAY);
		productPrice.setOpaque(false);
		productPrice.setFont(font);

		introduceProductPrice = new JTextField(10);
		introduceProductPrice.setOpaque(false);
		introduceProductPrice.setForeground(Color.LIGHT_GRAY);

		productQuantity = new JLabel("Introduce product quantity: ");
		productQuantity.setForeground(Color.LIGHT_GRAY);
		productQuantity.setOpaque(false);
		productQuantity.setFont(font);

		introduceProductQuantity = new JTextField(10);
		introduceProductQuantity.setForeground(Color.LIGHT_GRAY);
		introduceProductQuantity.setOpaque(false);

		go = new JButton("GO!");
		go.setOpaque(false);
		go.setBackground(new Color(0, 0, 0, 1));
		go.setFont(font);

		forAdd.add(Box.createRigidArea(new Dimension(10, 0)));
		forAdd.add(Box.createRigidArea(new Dimension(0, 4)));
		forAdd.add(productName);
		forAdd.add(Box.createRigidArea(new Dimension(0, 4)));
		forAdd.add(introduceProductName);
		forAdd.add(Box.createRigidArea(new Dimension(0, 4)));
		forAdd.add(productPrice);
		forAdd.add(Box.createRigidArea(new Dimension(0, 4)));
		forAdd.add(introduceProductPrice);
		forAdd.add(Box.createRigidArea(new Dimension(0, 4)));
		forAdd.add(productQuantity);
		forAdd.add(Box.createRigidArea(new Dimension(0, 4)));
		forAdd.add(introduceProductQuantity);
		forAdd.add(Box.createRigidArea(new Dimension(40, 4)));
		forAdd.add(go);
		
		errLabel = new JLabel();
		errLabel.setFont(font);
		errLabel.setOpaque(false);

		JLabel picLabel = new JLabel(new ImageIcon("add.gif"));
		picLabel.setLayout(null);
		picLabel.setOpaque(false);
		goBack.setBounds(213, 151, goBack.getPreferredSize().width, goBack.getPreferredSize().height);
		picLabel.add(forAdd);
		forAdd.setBounds(100, 20, forAdd.getPreferredSize().width, forAdd.getPreferredSize().height);
		picLabel.add(goBack);
		
		JPanel main = new JPanel();
		main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
		main.add(picLabel);

		tabbedPane = new JTabbedPane();
		tabbedPane.setOpaque(false);
		tabbedPane.setFont(font);

		productId1 = new JLabel("Introduce product id: ");
		productId1.setForeground(Color.LIGHT_GRAY);
		productId1.setFont(font);
		productId1.setOpaque(false);
		
		introduceProductId1 = new JTextField(10);
		introduceProductId1.setOpaque(false);
		introduceProductId1.setForeground(Color.LIGHT_GRAY);
		
		productName1 = new JLabel("Introduce product name: ");
		productName1.setForeground(Color.LIGHT_GRAY);
		productName1.setFont(font);
		productName1.setOpaque(false);

		introduceProductName1 = new JTextField(10);
		introduceProductName1.setOpaque(false);
		introduceProductName1.setForeground(Color.LIGHT_GRAY);

		productPrice1 = new JLabel("Introduce product price: ");
		productPrice1.setForeground(Color.LIGHT_GRAY);
		productPrice1.setOpaque(false);
		productPrice1.setFont(font);

		introduceProductPrice1 = new JTextField(10);
		introduceProductPrice1.setOpaque(false);
		introduceProductPrice1.setForeground(Color.LIGHT_GRAY);

		productQuantity1 = new JLabel("Introduce product quantity: ");
		productQuantity1.setForeground(Color.LIGHT_GRAY);
		productQuantity1.setOpaque(false);
		productQuantity1.setFont(font);

		introduceProductQuantity1 = new JTextField(10);
		introduceProductQuantity1.setForeground(Color.LIGHT_GRAY);
		introduceProductQuantity1.setOpaque(false);

		go1 = new JButton("GO!");
		go1.setOpaque(false);
		go1.setBackground(new Color(0, 1, 0, 1));
		go1.setFont(font);

		forEdit.add(Box.createRigidArea(new Dimension(10, 0)));
		forEdit.add(Box.createRigidArea(new Dimension(0, 4)));
		forEdit.add(productId1);
		forEdit.add(Box.createRigidArea(new Dimension(0, 4)));
		forEdit.add(introduceProductId1);
		forEdit.add(Box.createRigidArea(new Dimension(0, 4)));
		forEdit.add(productName1);
		forEdit.add(Box.createRigidArea(new Dimension(0, 4)));
		forEdit.add(introduceProductName1);
		forEdit.add(Box.createRigidArea(new Dimension(0, 4)));
		forEdit.add(productPrice1);
		forEdit.add(Box.createRigidArea(new Dimension(0, 4)));
		forEdit.add(introduceProductPrice1);
		forEdit.add(Box.createRigidArea(new Dimension(0, 4)));
		forEdit.add(productQuantity1);
		forEdit.add(Box.createRigidArea(new Dimension(0, 4)));
		forEdit.add(introduceProductQuantity1);
		forEdit.add(Box.createRigidArea(new Dimension(40, 4)));
		forEdit.add(go1);

		JLabel picEditLabel = new JLabel(new ImageIcon("add.gif"));
		picEditLabel.setLayout(null);
		picEditLabel.setOpaque(false);
		
		goBack1.setBounds(200, 192, goBack1.getPreferredSize().width, goBack1.getPreferredSize().height);
		picEditLabel.add(forEdit);
		forEdit.setBounds(100, 20, forEdit.getPreferredSize().width, forEdit.getPreferredSize().height);
		picEditLabel.add(goBack1);

		productId = new JLabel("Introduce product id: ");
		productId.setForeground(Color.LIGHT_GRAY);
		productId.setFont(font);
		productId.setOpaque(false);

		introduceProductId = new JTextField(10);
		introduceProductId.setOpaque(false);
		introduceProductId.setForeground(Color.LIGHT_GRAY);

		go2 = new JButton("GO!");
		go2.setOpaque(false);
		go2.setBackground(new Color(0, 1, 0, 1));
		go2.setFont(font);

		forDelete.add(Box.createRigidArea(new Dimension(10, 0)));
		forDelete.add(Box.createRigidArea(new Dimension(0, 4)));
		forDelete.add(productId);
		forDelete.add(Box.createRigidArea(new Dimension(0, 4)));
		forDelete.add(introduceProductId);
		forDelete.add(Box.createRigidArea(new Dimension(10, 4)));
		forDelete.add(go2);
		
		JLabel picDeleteLabel = new JLabel(new ImageIcon("add.gif"));
		picDeleteLabel.setLayout(null);
		goBack2.setBounds(165, 66, goBack2.getPreferredSize().width, goBack2.getPreferredSize().height);
		picDeleteLabel.setOpaque(false);
		forDelete.setBounds(100, 20, forDelete.getPreferredSize().width, forDelete.getPreferredSize().height);
		picDeleteLabel.add(goBack2);
		picDeleteLabel.add(forDelete);

		JPanel mainDelete = new JPanel();
		mainDelete.setLayout(new BoxLayout(mainDelete, BoxLayout.Y_AXIS));
		mainDelete.add(picDeleteLabel);

		JPanel mainEdit = new JPanel();
		mainEdit.setLayout(new BoxLayout(mainEdit, BoxLayout.Y_AXIS));
		mainEdit.add(picEditLabel);

		tabbedPane.add("Add product", main);
		tabbedPane.add("Edit product", mainEdit);
		tabbedPane.add("Delete product", mainDelete);
		this.setContentPane(tabbedPane);
		this.pack();
		this.setResizable(false);
		this.setSize(500, 340);
		this.setLocation(700, 330);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setFont(font);
		//this.setVisible(true);
		this.setTitle("Warehouse");
	}

	public void addGoListener(ActionListener goListener) {
		go.addActionListener(goListener);
		go1.addActionListener(goListener);
		go2.addActionListener(goListener);
		goBack.addActionListener(goListener);
		goBack1.addActionListener(goListener);
		goBack2.addActionListener(goListener);
	}

	public JButton getGoBack() {
		return goBack;
	}

	public void setGoBack(JButton goBack) {
		this.goBack = goBack;
	}

	public JButton getGoBack1() {
		return goBack1;
	}

	public void setGoBack1(JButton goBack1) {
		this.goBack1 = goBack1;
	}

	public JButton getGoBack2() {
		return goBack2;
	}

	public void setGoBack2(JButton goBack2) {
		this.goBack2 = goBack2;
	}

	public JTextField getIntroduceProductName() {
		return introduceProductName;
	}

	public void setIntroduceProductName(JTextField introduceClientName) {
		this.introduceProductName = introduceClientName;
	}

	public JTextField getIntroduceProductPrice() {
		return introduceProductPrice;
	}

	public void setIntroduceProductPrice(JTextField introduceProductPrice) {
		this.introduceProductPrice = introduceProductPrice;
	}

	public JTextField getIntroduceProductQuantity() {
		return introduceProductQuantity;
	}

	public void setIntroduceProductQuantity(JTextField introduceClientEmail) {
		this.introduceProductQuantity = introduceClientEmail;
	}

	public String getProductName() {
		return introduceProductName.getText();
	}

	public String getProductPrice() {
		return introduceProductPrice.getText();
	}

	public String getProductQuantity() {
		return introduceProductQuantity.getText();
	}

	
	public String getProductName1() {
		return introduceProductName1.getText();
	}

	public String getProductPrice1() {
		return introduceProductPrice1.getText();
	}

	public String getProductQuantity1() {
		return introduceProductQuantity1.getText();
	}

	public String getProductId1() {
		return introduceProductId1.getText();
	}
	
	public String getProductId() {
		return introduceProductId.getText();
	}

	public JButton getGo1() {
		return go1;
	}

	public void setGo1(JButton go1) {
		this.go1 = go1;
	}

	public JButton getGo2() {
		return go2;
	}

	public void setGo2(JButton go2) {
		this.go2 = go2;
	}

	public void showErrorMessage(String message) {
		errLabel.setText(message);
		JOptionPane.showMessageDialog(this, errLabel);
	}

	public JButton getGo() {
		return go;
	}

	public void setGo(JButton go) {
		this.go = go;
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
	
	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}

	public void setTabbedPane(JTabbedPane tabbedPane) {
		this.tabbedPane = tabbedPane;
	}
	
	public void AddChangeListener(ChangeListener tableListener) {
		tabbedPane.addChangeListener(tableListener);
	}

	public static void main(String[] args) {
		ProductView view = new ProductView();
		view.setVisible(true);
	}
}
