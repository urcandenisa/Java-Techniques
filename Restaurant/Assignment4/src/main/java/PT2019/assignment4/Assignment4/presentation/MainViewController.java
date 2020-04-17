package PT2019.assignment4.Assignment4.presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import PT2019.assignment4.Assignment4.businessLayer.MenuItem;
import PT2019.assignment4.Assignment4.businessLayer.Restaurant;
import PT2019.assignment4.Assignment4.dataLayer.FileWriter;
import PT2019.assignment4.Assignment4.dataLayer.RestaurantSerialization;

public class MainViewController {
	MainView mainView;
	Restaurant restaurant;
	@SuppressWarnings("deprecation")
	public MainViewController(MainView mainView, Restaurant restaurant) {
		this.mainView = mainView;
		mainView.addActionListener(new ButtonListener());
		mainView.addMouseListener(new MouseListenerEx());
		this.restaurant = restaurant;
		
	}

	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == mainView.getCreateOrder()) {
				mainView.setVisible(false);
				
				AddOrderView addOrderView = new AddOrderView(restaurant);
				addOrderView.setVisible(true);
				AddOrderViewController addOrderViewController = new AddOrderViewController(addOrderView, restaurant, false);
				
				
			} else if (e.getSource() == mainView.getComputePriceForOrder()) {
				mainView.setVisible(false);
				
				ComputePriceView computePriceView = new ComputePriceView(restaurant);
				computePriceView.setVisible(true);
				ComputePriceViewController cont = new ComputePriceViewController(computePriceView, restaurant);
				//computePriceView.setVisible(true);
			}else if(e.getSource() == mainView.getCreateBill()) {
				FileWriter.write(restaurant);
			}
		}

	}

	class MouseListenerEx implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			//System.out.println(e.getX() + " " + e.getY());
			if (e.getX() >= 480 && e.getX() <= 520 && e.getY() >= 328 && e.getY() <= 502) {
			//	System.out.println(e.getX() + " " + e.getY());
				mainView.getCloudLabel().setVisible(true);
			} else if (e.getX() >= 215 && e.getX() <= 502 && e.getY() >= 234 && e.getY() <= 275) {
				//System.out.println("Menu item");
				mainView.setVisible(false);
				mainView.dispose();
				
				MenuItemView menuItemView = new MenuItemView(restaurant);
				menuItemView.setVisible(true);
				MenuItemViewController menuItemCont = new MenuItemViewController(menuItemView, restaurant);
				//menuItemView.setVisible(true);
			} else if (e.getX() >= 95 && e.getX() <= 160 && e.getY() >= 385 && e.getY() <= 410) {
				mainView.setVisible(false);
				mainView.dispose();
				
				MenuView2 menuView = new MenuView2(restaurant);
				menuView.setVisible(true);
				MenuViewController2 cont = new MenuViewController2(menuView, restaurant, 1);
			}

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}

}
