package PT2019.assignment3.Assignment3.presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import PT2019.assignment3.Assignment3.businessLogic.ClientBusiness;
import PT2019.assignment3.Assignment3.businessLogic.ProductBusiness;

public class SuccessClass extends JFrame {
	private JLabel successLabel;
	private Font font = new Font("Trebuchet MS", Font.PLAIN, 30);
	private Font font2 = new Font("Trebuchet MS", Font.PLAIN, 12);
	private JButton viewAll;
	private JButton goBack;

	public SuccessClass(String success) {

		JLabel picLabel = new JLabel(new ImageIcon("success.gif"));
		picLabel.setOpaque(false);
		picLabel.setLayout(null);

		viewAll = new JButton("View all");
		viewAll.setOpaque(false);
		viewAll.setBackground(new Color(0, 1, 0, 1));
		viewAll.setFont(font2);
		viewAll.setSize(new Dimension(10, 20));

		goBack = new JButton("  Back  ");
		goBack.setOpaque(false);
		goBack.setBackground(new Color(0, 1, 0, 1));
		goBack.setFont(font2);

		successLabel = new JLabel(success);
		successLabel.setFont(font);
		successLabel.setOpaque(false);
		successLabel.setForeground(Color.white);

		JPanel succes = new JPanel();
		succes.setOpaque(false);
		succes.setLayout(new FlowLayout());
		succes.setSize(new Dimension(30, 40));
		succes.add(successLabel);

		picLabel.add(succes);
		picLabel.add(viewAll);
		picLabel.add(goBack);
		succes.setBounds(60, 20, succes.getPreferredSize().width, succes.getPreferredSize().height);
		viewAll.setBounds(335, 210, viewAll.getPreferredSize().width, viewAll.getPreferredSize().height);
		goBack.setBounds(70, 210, goBack.getPreferredSize().width, goBack.getPreferredSize().height);
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.add(picLabel);

		this.setContentPane(mainPanel);
		this.pack();
		// this.setResizable(false);
		this.setSize(500, 340);
		this.setLocation(700, 330);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setFont(font);
		//this.setVisible(true);
		this.setTitle("Warehouse");
	}

	public void addActionListener(ActionListener buttonListener) {
		goBack.addActionListener(buttonListener);
		viewAll.addActionListener(buttonListener);
	}

	public JButton getViewAll() {
		return viewAll;
	}

	public void setViewAll(JButton viewAll) {
		this.viewAll = viewAll;
	}

	public JButton getGoBack() {
		return goBack;
	}

	public void setGoBack(JButton goBack) {
		this.goBack = goBack;
	}
	
	public void reset(int var) {
		if(var == 0) {
		ClientView anotherView = new ClientView();
		ClientController addClientController = new ClientController(anotherView, new ClientBusiness());
		anotherView.setVisible(true);
		} else if(var == 1) {
			ProductView view = new ProductView();
			ProductController productController = new ProductController(view, new ProductBusiness());
			view.setVisible(true);
		}
	}

}
