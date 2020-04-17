package PT2019.assignment4.Assignment4.presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import PT2019.assignment4.Assignment4.businessLayer.Restaurant;

public class MenuViewController2 {
	private MenuView2 menuView2;
	private Restaurant restaurant;
	int var;

	public MenuViewController2(MenuView2 menuView2, Restaurant restaurant, int var) {
		this.menuView2 = menuView2;
		this.var = var;
		this.restaurant = restaurant;
		
		menuView2.addActionListener(new ButtonListener());
	}

	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == menuView2.getGoBack()) {

				menuView2.setVisible(false);

				if (var == 0) {
					MenuItemView menuItemView = new MenuItemView(restaurant);
					menuItemView.setVisible(true);
					MenuItemViewController cont = new MenuItemViewController(menuItemView, restaurant);
				} else {
					MainView mainView = new MainView(restaurant);
					mainView.setVisible(true);
					MainViewController cont = new MainViewController(mainView, restaurant);
				}
			}
		}

	}
}
