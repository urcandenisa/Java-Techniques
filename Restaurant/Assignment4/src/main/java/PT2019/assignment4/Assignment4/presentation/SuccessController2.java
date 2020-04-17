package PT2019.assignment4.Assignment4.presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import PT2019.assignment4.Assignment4.businessLayer.Restaurant;

public class SuccessController2 {
	
	private SuccessClass2 successView;
	private Restaurant restaurant;
	int var;
	public SuccessController2(SuccessClass2 successView, Restaurant restaurant, int var) {
		this.successView = successView;
		this.var = var;
		this.restaurant = restaurant;
		
		successView.addActionListener(new ButtonListener());
	}

	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == successView.getGoBack()) {
				
				successView.setVisible(false);
				
				MenuItemView menuItemView = new MenuItemView(restaurant);
				MenuItemViewController menuItemViewController = new MenuItemViewController(menuItemView, restaurant);
				menuItemView.setVisible(true);
			}
			if(e.getSource() == successView.getViewAll()) {
				
				successView.setVisible(false);
				
				MenuView2 menuView = new MenuView2(restaurant);
				MenuViewController2 menuViewController = new MenuViewController2(menuView, restaurant, var);
				
				menuView.setVisible(true);
				
			}
		}

	}

}
