package PT2019.assignment4.Assignment4.presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import PT2019.assignment4.Assignment4.businessLayer.Restaurant;

public class ErrorController {
	private ErrorClass errorView;
	private Restaurant restaurant;

	public ErrorController(ErrorClass errorView, Restaurant restaurant) {
		this.errorView = errorView;
		this.restaurant = restaurant;
		
		errorView.addActionListener(new ButtonListener());
	}

	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == errorView.getGoBack()) {
				errorView.setVisible(false);
				
				AddOrderView addOrderView = new AddOrderView(restaurant);
				addOrderView.setVisible(true);
				AddOrderViewController cont = new AddOrderViewController(addOrderView, restaurant, true);
				
			}
			else if(e.getSource() == errorView.getViewAll()) {
				errorView.setVisible(false);
			
				ViewAllOrders viewAllOrders = new ViewAllOrders(restaurant);
				viewAllOrders.setVisible(true);
				ViewAllOrdersController contr = new ViewAllOrdersController(viewAllOrders, restaurant);
			}
		}

	}

}
