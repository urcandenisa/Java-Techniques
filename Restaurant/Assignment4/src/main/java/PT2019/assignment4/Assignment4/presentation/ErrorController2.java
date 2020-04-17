package PT2019.assignment4.Assignment4.presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import PT2019.assignment4.Assignment4.businessLayer.Restaurant;

public class ErrorController2 {
	private ErrorClass2 errorView;
	private Restaurant restaurant;
	int var;

	public ErrorController2(ErrorClass2 errorView, Restaurant restaurant, int var) {
		this.errorView = errorView;
		this.var = var;
		this.restaurant = restaurant;
		
		errorView.addActionListener(new ButtonListener());
	}

	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == errorView.getGoBack()) {
				if(var == 0) {
				errorView.setVisible(false);
				MenuItemView menuItemView = new MenuItemView(restaurant);
				menuItemView.setVisible(true);
				MenuItemViewController cont = new MenuItemViewController(menuItemView, restaurant );}
				else if(var == 1) {
					errorView.setVisible(false);
					MainView mainView = new MainView(restaurant);
					mainView.setVisible(true);
					MainViewController cont = new MainViewController(mainView, restaurant);
				}
			} else if (e.getSource() == errorView.getViewAll()) {
				if(var == 0) {
				errorView.setVisible(false);
				MenuView2 menuView = new MenuView2(restaurant);
				MenuViewController2 menuViewController = new MenuViewController2(menuView, restaurant, var);
				
				menuView.setVisible(true);}
				else {
					ViewAllOrders viewAllOrders = new ViewAllOrders(restaurant);
					errorView.setVisible(false);
					ViewAllOrdersController cont = new ViewAllOrdersController(viewAllOrders, restaurant);
					viewAllOrders.setVisible(true);
				}
			}
		}

	}

}
