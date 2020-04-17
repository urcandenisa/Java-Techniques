package PT2019.assignment4.Assignment4.presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import PT2019.assignment4.Assignment4.businessLayer.MenuItem;
import PT2019.assignment4.Assignment4.businessLayer.Order;
import PT2019.assignment4.Assignment4.businessLayer.Restaurant;

public class ComputePriceViewController {
	ComputePriceView computePriceView;
	Restaurant restaurant;
	
	public ComputePriceViewController(ComputePriceView computePriceView, Restaurant restaurant) {
		this.computePriceView = computePriceView;
		this.restaurant = restaurant;
		
		computePriceView.addActionListener(new ButtonListener());
	}

	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String idd = "";
			int err = 0;
			int id = 0;
			try {
				idd = computePriceView.getIntroduceOrderId();
			} catch (NullPointerException ex) {
				ex.printStackTrace();
			}
			if (e.getSource() == computePriceView.getGoBack()) {
				computePriceView.setVisible(false);
				MainView mainView = new MainView(restaurant);
				MainViewController cont = new MainViewController(mainView, restaurant);
				mainView.setVisible(true);
			} else if (e.getSource() == computePriceView.getGo()) {
				try {
					id = Integer.parseInt(idd);
				} catch (NumberFormatException nfex) {
					err = 1;
					ErrorClass2 errView = new ErrorClass2("Please choose a product!", restaurant);
					ErrorController2 errController = new ErrorController2(errView, restaurant, 1);
					computePriceView.setVisible(false);
					errView.setVisible(true);
				}
				if (err == 0) {

					id--;
					int i = 0;
					int totalPrice = 0;
					Iterator<Entry<Order, List<MenuItem>>> it = restaurant.getOrders().entrySet().iterator();
					while (it.hasNext()) {
						if (i == id) {
							Map.Entry pair = (Map.Entry) it.next();
							Order ord = (Order) pair.getKey();
							String itemuri = "";
							List<MenuItem> menuItems = (List<MenuItem>) pair.getValue();
							for (MenuItem itemm : menuItems) {
								totalPrice += itemm.getPrice();
							}
							totalPrice *= ord.getQuantity();
							break;
						}
						i++;
					}
					System.out.println(totalPrice);
					if (totalPrice == 0) {
						if (err != 1) {
							ErrorClass2 errView = new ErrorClass2("The order is no longer available", restaurant);
							ErrorController2 errController = new ErrorController2(errView, restaurant, 0);
							computePriceView.setVisible(false);
							errView.setVisible(true);
						}
					} else {
						ShowTotalPrice view = new ShowTotalPrice("Total price for order" + id + " is: " + totalPrice, restaurant);
						ShowTotalPriceController cont = new ShowTotalPriceController(view, restaurant);
						view.setVisible(true);
					}

				}
			}
		}

	}
}
