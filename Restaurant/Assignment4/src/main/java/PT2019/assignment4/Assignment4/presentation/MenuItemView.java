package PT2019.assignment4.Assignment4.presentation;
import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

import PT2019.assignment4.Assignment4.businessLayer.CompositeProduct;
import PT2019.assignment4.Assignment4.businessLayer.Restaurant;


public class MenuItemView extends JFrame{
	private final static Color TRANSPARENT = new Color(0, 0, 0, 0);
	private JLabel menuItemName;
	private JTextField introduceMenuItemName;
	private JLabel menuItemPrice;
	private JTextField introduceMenuItemPrice;
	private JLabel menuItemWeight;
	private JTextField introduceMenuItemWeight;
	private JLabel menuItemComposite;
	private JTextField introduceMenuItemComposite;
	private JButton go;
	private JLabel menuItemName1;
	private JTextField introduceMenuItemName1;
	private JLabel menuItemPrice1;
	private JTextField introduceMenuItemPrice1;
	private JLabel menuItemWeight1;
	private JTextField introduceMenuItemWeight1;
	private JLabel menuItemComposite1;
	private JTextField introduceMenuItemComposite1;
	private JButton go1;
	private JLabel errLabel;
	private JLabel menuItemId;
	private JTextField introduceMenuItemId;
	private JLabel menuItemId1;
	private JTextField introduceMenuItemId1;
	private JButton go2;
	private JTabbedPane tabbedPane;
	private Font font = new Font("Trebuchet MS", Font.PLAIN, 11);
	private JButton goBack;
	private JButton goBack1;
	private JButton goBack2;
	private Restaurant restaurant;
	MainView mainView;
	public MenuItemView(Restaurant restaurant) {
	
		UIManager.put("TabbedPane.contentOpaque", false);
		UIManager.put("TabbedPane.contentAreaColor", TRANSPARENT);
		UIManager.put("TabbedPane.selected", TRANSPARENT);
		UIManager.put("TabbedPane.background", TRANSPARENT);
		UIManager.put("TabbedPane.borderHightlightColor", TRANSPARENT);
		UIManager.put("TabbedPane.darkShadow", TRANSPARENT);
		UIManager.put("TabbedPane.focus", TRANSPARENT);
		
		this.restaurant = restaurant;
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
		
		menuItemName = new JLabel("Introduce item's name: ");
		menuItemName.setForeground(Color.LIGHT_GRAY);
		menuItemName.setFont(font);
		menuItemName.setOpaque(false);

		introduceMenuItemName = new JTextField(10);
		introduceMenuItemName.setOpaque(false);
		introduceMenuItemName.setForeground(Color.LIGHT_GRAY);
		
		menuItemPrice = new JLabel("Introduce item's price: ");
		menuItemPrice.setForeground(Color.LIGHT_GRAY);
		menuItemPrice.setOpaque(false);
		menuItemPrice.setFont(font);

		introduceMenuItemPrice = new JTextField(10);
		introduceMenuItemPrice.setOpaque(false);
		introduceMenuItemPrice.setForeground(Color.LIGHT_GRAY);
		
		menuItemWeight = new JLabel("Introduce item's weight: ");
		menuItemWeight.setForeground(Color.LIGHT_GRAY);
		menuItemWeight.setOpaque(false);
		menuItemWeight.setFont(font);

		introduceMenuItemWeight = new JTextField(10);
		introduceMenuItemWeight.setForeground(Color.LIGHT_GRAY);
		introduceMenuItemWeight.setOpaque(false);
		
		menuItemComposite = new JLabel("Introduce item's composite: ");
		menuItemComposite.setForeground(Color.LIGHT_GRAY);
		menuItemComposite.setOpaque(false);
		menuItemComposite.setFont(font);

		introduceMenuItemComposite = new JTextField(20);
		introduceMenuItemComposite.setOpaque(false);
		introduceMenuItemComposite.setForeground(Color.LIGHT_GRAY);

		go = new JButton("GO!");
		go.setOpaque(false);
		go.setBackground(new Color(0, 0, 0, 1));
		go.setFont(font);
		go.setForeground(Color.LIGHT_GRAY);

		forAdd.add(Box.createRigidArea(new Dimension(10, 0)));
		forAdd.add(Box.createRigidArea(new Dimension(0, 4)));
		forAdd.add(menuItemName);
		forAdd.add(Box.createRigidArea(new Dimension(0, 4)));
		forAdd.add(introduceMenuItemName);
		forAdd.add(Box.createRigidArea(new Dimension(0, 4)));
		forAdd.add(menuItemPrice);
		forAdd.add(Box.createRigidArea(new Dimension(0, 4)));
		forAdd.add(introduceMenuItemPrice);
		forAdd.add(Box.createRigidArea(new Dimension(0, 4)));
		forAdd.add(menuItemWeight);
		forAdd.add(Box.createRigidArea(new Dimension(0, 4)));
		forAdd.add(introduceMenuItemWeight);
		forAdd.add(Box.createRigidArea(new Dimension(0, 4)));
		forAdd.add(menuItemComposite);
		forAdd.add(Box.createRigidArea(new Dimension(0, 4)));
		forAdd.add(introduceMenuItemComposite);
		forAdd.add(Box.createRigidArea(new Dimension(40, 4)));
		forAdd.add(go);
		
		errLabel = new JLabel();
		errLabel.setFont(font);
		errLabel.setOpaque(false);
		
		JLabel picLabel = new JLabel(new ImageIcon("add.gif"));
		picLabel.setLayout(null);
		picLabel.setOpaque(false);
		goBack.setBounds(250, 190, goBack.getPreferredSize().width, goBack.getPreferredSize().height);
		goBack.setForeground(Color.LIGHT_GRAY);
		picLabel.add(forAdd);
		forAdd.setBounds(100, 20, forAdd.getPreferredSize().width, forAdd.getPreferredSize().height);
		picLabel.add(goBack);
		
		JPanel main = new JPanel();
		main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
		main.add(picLabel);

		tabbedPane = new JTabbedPane();
		tabbedPane.setOpaque(false);
		tabbedPane.setFont(font);

		menuItemId1 = new JLabel("Introduce item's id: ");
		menuItemId1.setForeground(Color.LIGHT_GRAY);
		menuItemId1.setFont(font);
		menuItemId1.setOpaque(false);
		
		introduceMenuItemId1 = new JTextField(10);
		introduceMenuItemId1.setOpaque(false);
		introduceMenuItemId1.setForeground(Color.LIGHT_GRAY);
		
		menuItemName1 = new JLabel("Introduce item's name: ");
		menuItemName1.setForeground(Color.LIGHT_GRAY);
		menuItemName1.setFont(font);
		menuItemName1.setOpaque(false);

		introduceMenuItemName1 = new JTextField(10);
		introduceMenuItemName1.setOpaque(false);
		introduceMenuItemName1.setForeground(Color.LIGHT_GRAY);

		menuItemPrice1 = new JLabel("Introduce item's price: ");
		menuItemPrice1.setForeground(Color.LIGHT_GRAY);
		menuItemPrice1.setOpaque(false);
		menuItemPrice1.setFont(font);

		introduceMenuItemPrice1 = new JTextField(10);
		introduceMenuItemPrice1.setOpaque(false);
		introduceMenuItemPrice1.setForeground(Color.LIGHT_GRAY);

		menuItemWeight1 = new JLabel("Introduce item's weight: ");
		menuItemWeight1.setOpaque(false);
		menuItemWeight1.setForeground(Color.LIGHT_GRAY);
		menuItemWeight1.setFont(font);

		//introduceMenuItemWeight1 = new JTextField(10);
		introduceMenuItemWeight1 = new JTextField(10);
		introduceMenuItemWeight1.setForeground(Color.LIGHT_GRAY);
		introduceMenuItemWeight1.setOpaque(false);

		menuItemComposite1 = new JLabel("Introduce item's composite: ");
		menuItemComposite1.setForeground(Color.LIGHT_GRAY);
		menuItemComposite1.setOpaque(false);
		menuItemComposite1.setFont(font);

		introduceMenuItemComposite1 = new JTextField(20);
		introduceMenuItemComposite1.setOpaque(false);
		introduceMenuItemComposite1.setForeground(Color.LIGHT_GRAY);
		
		goBack.setForeground(Color.LIGHT_GRAY);
		go1 = new JButton("GO!");
		go1.setOpaque(false);
		go1.setBackground(new Color(0, 1, 0, 1));
		go1.setFont(font);
		go1.setForeground(Color.LIGHT_GRAY);
		
		forEdit.add(Box.createRigidArea(new Dimension(10, 0)));
		forEdit.add(Box.createRigidArea(new Dimension(0, 4)));
		forEdit.add(menuItemId1);
		forEdit.add(Box.createRigidArea(new Dimension(0, 4)));
		forEdit.add(introduceMenuItemId1);
		forEdit.add(Box.createRigidArea(new Dimension(0, 4)));
		forEdit.add(menuItemName1);
		forEdit.add(Box.createRigidArea(new Dimension(0, 4)));
		forEdit.add(introduceMenuItemName1);
		forEdit.add(Box.createRigidArea(new Dimension(0, 4)));
		forEdit.add(menuItemPrice1);
		forEdit.add(Box.createRigidArea(new Dimension(0, 4)));
		forEdit.add(introduceMenuItemPrice1);
		forEdit.add(Box.createRigidArea(new Dimension(0, 4)));
		forEdit.add(menuItemWeight1);
		forEdit.add(Box.createRigidArea(new Dimension(0, 4)));
		forEdit.add(introduceMenuItemWeight1);
		forEdit.add(Box.createRigidArea(new Dimension(0, 4)));
		forEdit.add(menuItemComposite1);
		forEdit.add(Box.createRigidArea(new Dimension(0, 4)));
		forEdit.add(introduceMenuItemComposite1);
		forEdit.add(Box.createRigidArea(new Dimension(40, 4)));
		forEdit.add(go1);
		
		JLabel picEditLabel = new JLabel(new ImageIcon("add.gif"));
		picEditLabel.setLayout(null);
		picEditLabel.setOpaque(false);
		
		goBack1.setBounds(250, 233, goBack1.getPreferredSize().width, goBack1.getPreferredSize().height);
		picEditLabel.add(forEdit);
		forEdit.setBounds(100, 20, forEdit.getPreferredSize().width, forEdit.getPreferredSize().height);
		picEditLabel.add(goBack1);
		goBack1.setForeground(Color.LIGHT_GRAY);
		menuItemId = new JLabel("Introduce item's id: ");
		menuItemId.setForeground(Color.LIGHT_GRAY);
		menuItemId.setFont(font);
		menuItemId.setOpaque(false);

		introduceMenuItemId = new JTextField(10);
		introduceMenuItemId.setOpaque(false);
		introduceMenuItemId.setForeground(Color.LIGHT_GRAY);

		go2 = new JButton("GO!");
		go2.setOpaque(false);
		go2.setBackground(new Color(0, 1, 0, 1));
		go2.setFont(font);
		go2.setForeground(Color.LIGHT_GRAY);

		forDelete.add(Box.createRigidArea(new Dimension(10, 0)));
		forDelete.add(Box.createRigidArea(new Dimension(0, 4)));
		forDelete.add(menuItemId);
		forDelete.add(Box.createRigidArea(new Dimension(0, 4)));
		forDelete.add(introduceMenuItemId);
		forDelete.add(Box.createRigidArea(new Dimension(10, 4)));
		forDelete.add(go2);
		
		JLabel picDeleteLabel = new JLabel(new ImageIcon("add.gif"));
		picDeleteLabel.setLayout(null);
		goBack2.setBounds(165, 66, goBack2.getPreferredSize().width, goBack2.getPreferredSize().height);
		picDeleteLabel.setOpaque(false);
		forDelete.setBounds(100, 20, forDelete.getPreferredSize().width, forDelete.getPreferredSize().height);
		picDeleteLabel.add(goBack2);
		picDeleteLabel.add(forDelete);
		goBack2.setForeground(Color.LIGHT_GRAY);
		JPanel mainDelete = new JPanel();
		mainDelete.setLayout(new BoxLayout(mainDelete, BoxLayout.Y_AXIS));
		mainDelete.add(picDeleteLabel);

		JPanel mainEdit = new JPanel();
		mainEdit.setLayout(new BoxLayout(mainEdit, BoxLayout.Y_AXIS));
		mainEdit.add(picEditLabel);
 
		tabbedPane.add("Add item", main);
		tabbedPane.add("Edit item", mainEdit);
		tabbedPane.add("Delete item      ", mainDelete);
		this.setContentPane(tabbedPane);
		this.pack();
		this.setResizable(false);
		this.setSize(500, 340);
		this.setLocation(700, 330);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setFont(font);
		this.setVisible(false);
		this.setTitle("Restaurant");
		
	}
	
	public void addActionListener(ActionListener buttonListener) {
		go.addActionListener(buttonListener);
		go1.addActionListener(buttonListener);
		go2.addActionListener(buttonListener);
		goBack.addActionListener(buttonListener);
		goBack1.addActionListener(buttonListener);
		goBack2.addActionListener(buttonListener);
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

	public JButton getGoBack() {
		return goBack;
	}
	
	public void reset() {
		
	}
	
	public String getName() {
		return introduceMenuItemName.getText();
	}
	
	public String getPrice() {
		return introduceMenuItemPrice.getText();
	}
	
	public String getWeight() {
		return introduceMenuItemWeight.getText();
	}
	
	public String getComposite() {
		return introduceMenuItemComposite.getText();
	}
	
	public String getName1() {
		return introduceMenuItemName1.getText();
	}
	
	public String getPrice1() {
		return introduceMenuItemPrice1.getText();
	}
	
	public String getWeight1() {
		return introduceMenuItemWeight1.getText();
	}
	
	public String getComposite1() {
		return introduceMenuItemComposite1.getText();
	}

	public String getID1() {
		return introduceMenuItemId1.getText();
	}
	
	public String getID() {
		return introduceMenuItemId.getText();
	}
	public JButton getGo() {
		return go;
	}

	public void setGo(JButton go) {
		this.go = go;
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

	public void setGoBack(JButton goBack) {
		this.goBack = goBack;
	}
	
}
