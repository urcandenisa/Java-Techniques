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

public class ClientView extends JFrame {
	private final static Color TRANSPARENT = new Color(0, 0, 0, 0);
	private JLabel clientName;
	private JTextField introduceClientName;
	private JLabel clientAddress;
	private JTextField introduceClientAddress;
	private JLabel clientEmail;
	private JTextField introduceClientEmail;
	private JLabel clientPhoneNumber;
	private JTextField introduceClientPhoneNumber;
	private JButton go;
	private JLabel clientName1;
	private JTextField introduceClientName1;
	private JLabel clientAddress1;
	private JTextField introduceClientAddress1;
	private JLabel clientEmail1;
	private JTextField introduceClientEmail1;
	private JLabel clientPhoneNumber1;
	private JTextField introduceClientPhoneNumber1;
	private JButton go1;
	private JLabel errLabel;
	private JLabel clientId;
	private JTextField introduceClientId;
	private JLabel clientId1;
	private JTextField introduceClientId1;
	private JButton go2;
	private JTabbedPane tabbedPane;
	private Font font = new Font("Trebuchet MS", Font.PLAIN, 11);
	private JButton goBack;
	private JButton goBack1;
	private JButton goBack2;
	public ClientView() {

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

		clientName = new JLabel("Introduce client name: ");
		clientName.setForeground(Color.LIGHT_GRAY);
		clientName.setFont(font);
		clientName.setOpaque(false);

		introduceClientName = new JTextField(10);
		introduceClientName.setOpaque(false);
		introduceClientName.setForeground(Color.LIGHT_GRAY);

		clientAddress = new JLabel("Introduce client address: ");
		clientAddress.setForeground(Color.LIGHT_GRAY);
		clientAddress.setOpaque(false);
		clientAddress.setFont(font);

		introduceClientAddress = new JTextField(10);
		introduceClientAddress.setOpaque(false);
		introduceClientAddress.setForeground(Color.LIGHT_GRAY);

		clientEmail = new JLabel("Introduce client email: ");
		clientEmail.setForeground(Color.LIGHT_GRAY);
		clientEmail.setOpaque(false);
		clientEmail.setFont(font);

		introduceClientEmail = new JTextField(10);
		introduceClientEmail.setForeground(Color.LIGHT_GRAY);
		introduceClientEmail.setOpaque(false);

		clientPhoneNumber = new JLabel("Introduce client phone number: ");
		clientPhoneNumber.setForeground(Color.LIGHT_GRAY);
		clientPhoneNumber.setOpaque(false);
		clientPhoneNumber.setFont(font);

		introduceClientPhoneNumber = new JTextField(20);
		introduceClientPhoneNumber.setOpaque(false);
		introduceClientPhoneNumber.setForeground(Color.LIGHT_GRAY);

		go = new JButton("GO!");
		go.setOpaque(false);
		go.setBackground(new Color(0, 0, 0, 1));
		go.setFont(font);

		forAdd.add(Box.createRigidArea(new Dimension(10, 0)));
		forAdd.add(Box.createRigidArea(new Dimension(0, 4)));
		forAdd.add(clientName);
		forAdd.add(Box.createRigidArea(new Dimension(0, 4)));
		forAdd.add(introduceClientName);
		forAdd.add(Box.createRigidArea(new Dimension(0, 4)));
		forAdd.add(clientAddress);
		forAdd.add(Box.createRigidArea(new Dimension(0, 4)));
		forAdd.add(introduceClientAddress);
		forAdd.add(Box.createRigidArea(new Dimension(0, 4)));
		forAdd.add(clientEmail);
		forAdd.add(Box.createRigidArea(new Dimension(0, 4)));
		forAdd.add(introduceClientEmail);
		forAdd.add(Box.createRigidArea(new Dimension(0, 4)));
		forAdd.add(clientPhoneNumber);
		forAdd.add(Box.createRigidArea(new Dimension(0, 4)));
		forAdd.add(introduceClientPhoneNumber);
		forAdd.add(Box.createRigidArea(new Dimension(40, 4)));
		forAdd.add(go);
		
		errLabel = new JLabel();
		errLabel.setFont(font);
		errLabel.setOpaque(false);

		JLabel picLabel = new JLabel(new ImageIcon("add.gif"));
		picLabel.setLayout(null);
		picLabel.setOpaque(false);
		goBack.setBounds(250, 190, goBack.getPreferredSize().width, goBack.getPreferredSize().height);
		picLabel.add(forAdd);
		forAdd.setBounds(100, 20, forAdd.getPreferredSize().width, forAdd.getPreferredSize().height);
		picLabel.add(goBack);
		
		JPanel main = new JPanel();
		main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
		main.add(picLabel);

		tabbedPane = new JTabbedPane();
		tabbedPane.setOpaque(false);
		tabbedPane.setFont(font);

		clientId1 = new JLabel("Introduce client id: ");
		clientId1.setForeground(Color.LIGHT_GRAY);
		clientId1.setFont(font);
		clientId1.setOpaque(false);
		
		introduceClientId1 = new JTextField(10);
		introduceClientId1.setOpaque(false);
		introduceClientId1.setForeground(Color.LIGHT_GRAY);
		
		clientName1 = new JLabel("Introduce client name: ");
		clientName1.setForeground(Color.LIGHT_GRAY);
		clientName1.setFont(font);
		clientName1.setOpaque(false);

		introduceClientName1 = new JTextField(10);
		introduceClientName1.setOpaque(false);
		introduceClientName1.setForeground(Color.LIGHT_GRAY);

		clientAddress1 = new JLabel("Introduce client address: ");
		clientAddress1.setForeground(Color.LIGHT_GRAY);
		clientAddress1.setOpaque(false);
		clientAddress1.setFont(font);

		introduceClientAddress1 = new JTextField(10);
		introduceClientAddress1.setOpaque(false);
		introduceClientAddress1.setForeground(Color.LIGHT_GRAY);

		clientEmail1 = new JLabel("Introduce client email: ");
		clientEmail1.setForeground(Color.LIGHT_GRAY);
		clientEmail1.setOpaque(false);
		clientEmail1.setFont(font);

		introduceClientEmail1 = new JTextField(10);
		introduceClientEmail1.setForeground(Color.LIGHT_GRAY);
		introduceClientEmail1.setOpaque(false);

		clientPhoneNumber1 = new JLabel("Introduce client phone number: ");
		clientPhoneNumber1.setForeground(Color.LIGHT_GRAY);
		clientPhoneNumber1.setOpaque(false);
		clientPhoneNumber1.setFont(font);

		introduceClientPhoneNumber1 = new JTextField(20);
		introduceClientPhoneNumber1.setOpaque(false);
		introduceClientPhoneNumber1.setForeground(Color.LIGHT_GRAY);

		go1 = new JButton("GO!");
		go1.setOpaque(false);
		go1.setBackground(new Color(0, 1, 0, 1));
		go1.setFont(font);

		forEdit.add(Box.createRigidArea(new Dimension(10, 0)));
		forEdit.add(Box.createRigidArea(new Dimension(0, 4)));
		forEdit.add(clientId1);
		forEdit.add(Box.createRigidArea(new Dimension(0, 4)));
		forEdit.add(introduceClientId1);
		forEdit.add(Box.createRigidArea(new Dimension(0, 4)));
		forEdit.add(clientName1);
		forEdit.add(Box.createRigidArea(new Dimension(0, 4)));
		forEdit.add(introduceClientName1);
		forEdit.add(Box.createRigidArea(new Dimension(0, 4)));
		forEdit.add(clientAddress1);
		forEdit.add(Box.createRigidArea(new Dimension(0, 4)));
		forEdit.add(introduceClientAddress1);
		forEdit.add(Box.createRigidArea(new Dimension(0, 4)));
		forEdit.add(clientEmail1);
		forEdit.add(Box.createRigidArea(new Dimension(0, 4)));
		forEdit.add(introduceClientEmail1);
		forEdit.add(Box.createRigidArea(new Dimension(0, 4)));
		forEdit.add(clientPhoneNumber1);
		forEdit.add(Box.createRigidArea(new Dimension(0, 4)));
		forEdit.add(introduceClientPhoneNumber1);
		forEdit.add(Box.createRigidArea(new Dimension(40, 4)));
		forEdit.add(go1);

		JLabel picEditLabel = new JLabel(new ImageIcon("add.gif"));
		picEditLabel.setLayout(null);
		picEditLabel.setOpaque(false);
		
		goBack1.setBounds(250, 233, goBack1.getPreferredSize().width, goBack1.getPreferredSize().height);
		picEditLabel.add(forEdit);
		forEdit.setBounds(100, 20, forEdit.getPreferredSize().width, forEdit.getPreferredSize().height);
		picEditLabel.add(goBack1);

		clientId = new JLabel("Introduce client Id: ");
		clientId.setForeground(Color.LIGHT_GRAY);
		clientId.setFont(font);
		clientId.setOpaque(false);

		introduceClientId = new JTextField(10);
		introduceClientId.setOpaque(false);
		introduceClientId.setForeground(Color.LIGHT_GRAY);

		go2 = new JButton("GO!");
		go2.setOpaque(false);
		go2.setBackground(new Color(0, 1, 0, 1));
		go2.setFont(font);

		forDelete.add(Box.createRigidArea(new Dimension(10, 0)));
		forDelete.add(Box.createRigidArea(new Dimension(0, 4)));
		forDelete.add(clientId);
		forDelete.add(Box.createRigidArea(new Dimension(0, 4)));
		forDelete.add(introduceClientId);
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

		tabbedPane.add("Add client", main);
		tabbedPane.add("Edit client", mainEdit);
		tabbedPane.add("Delete client", mainDelete);
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

	public JTextField getIntroduceClientName() {
		return introduceClientName;
	}

	public void setIntroduceClientName(JTextField introduceClientName) {
		this.introduceClientName = introduceClientName;
	}

	public JTextField getIntroduceClientAddress() {
		return introduceClientAddress;
	}

	public void setIntroduceClientAddress(JTextField introduceClientAddress) {
		this.introduceClientAddress = introduceClientAddress;
	}

	public JTextField getIntroduceClientEmail() {
		return introduceClientEmail;
	}

	public void setIntroduceClientEmail(JTextField introduceClientEmail) {
		this.introduceClientEmail = introduceClientEmail;
	}

	public JTextField getIntroduceClientPhoneNumber() {
		return introduceClientPhoneNumber;
	}

	public void setIntroduceClientPhoneNumber(JTextField introduceClientPhoneNumber) {
		this.introduceClientPhoneNumber = introduceClientPhoneNumber;
	}

	public String getClientName() {
		return introduceClientName.getText();
	}

	public String getClientEmail() {
		return introduceClientEmail.getText();
	}

	public String getClientAddress() {
		return introduceClientAddress.getText();
	}

	public String getClientPhoneNumber() {
		return introduceClientPhoneNumber.getText();
	}
	
	public String getClientName1() {
		return introduceClientName1.getText();
	}

	public String getClientEmail1() {
		return introduceClientEmail1.getText();
	}

	public String getClientAddress1() {
		return introduceClientAddress1.getText();
	}

	public String getClientPhoneNumber1() {
		return introduceClientPhoneNumber1.getText();
	}
	public String getClientId1() {
		return introduceClientId1.getText();
	}
	
	public String getClientId() {
		return introduceClientId.getText();
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
		ClientView view = new ClientView();
		view.setVisible(true);
	}
}
