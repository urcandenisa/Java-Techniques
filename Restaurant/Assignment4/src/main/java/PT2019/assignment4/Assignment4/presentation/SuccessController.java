package PT2019.assignment4.Assignment4.presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import PT2019.assignment4.Assignment4.businessLayer.Restaurant;

public class SuccessController {
	private SuccessClass successView;
	private Restaurant restaurant;

	public SuccessController(SuccessClass successView, Restaurant restaurant) {
		this.successView = successView;
		this.restaurant = restaurant;
		
		successView.addActionListener(new ButtonListener());
	}

	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == successView.getGoBack()) {
				successView.setVisible(false);

				AddOrderView addOrderView = new AddOrderView(restaurant);
				AddOrderViewController cont = new AddOrderViewController(addOrderView, restaurant, true);
				addOrderView.setVisible(true);
			}
			if (e.getSource() == successView.getViewAll()) {
				successView.setVisible(false);

				ViewAllOrders viewAllOrders = new ViewAllOrders(restaurant);
				viewAllOrders.setVisible(true);
				ViewAllOrdersController contr = new ViewAllOrdersController(viewAllOrders, restaurant);

			}
		}

	}

}
