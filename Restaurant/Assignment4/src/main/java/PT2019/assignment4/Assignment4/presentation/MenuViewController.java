package PT2019.assignment4.Assignment4.presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import PT2019.assignment4.Assignment4.businessLayer.Restaurant;

public class MenuViewController {
	private MenuView menuView;
	private Restaurant restaurant;
	public MenuViewController(MenuView menuView, Restaurant restaurant) {
		this.menuView = menuView;
		this.restaurant = restaurant;
		
		menuView.addActionListener(new ButtonListener());
	}
	
	class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == menuView.getGoBack()) {

				menuView.setVisible(false);
				
				AddOrderView addOrderView = new AddOrderView(restaurant);
				AddOrderViewController addOrderViewController = new AddOrderViewController(addOrderView, restaurant, false);
				addOrderView.setVisible(true);
			}
			
		
		}
		
	}
}
