package PT2019.assignment4.Assignment4.presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import PT2019.assignment4.Assignment4.businessLayer.Restaurant;

public class ViewAllOrdersController {

	private ViewAllOrders viewAllOrders;
	private Restaurant restaurant;
	public ViewAllOrdersController(ViewAllOrders viewAllOrders, Restaurant restaurant) {
		// TODO Auto-generated constructor stub
		this.viewAllOrders = viewAllOrders;
		this.restaurant = restaurant;
		
		viewAllOrders.addActionListener(new ButtonListener());
	}
	
	class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == viewAllOrders.getGoBack()) {
				
				viewAllOrders.setVisible(false);
				
				AddOrderView addOrderView = new AddOrderView(restaurant);
				AddOrderViewController addOrderViewController = new AddOrderViewController(addOrderView, restaurant, true);
				addOrderView.setVisible(true);
			}
		
		}
		
	}

}
