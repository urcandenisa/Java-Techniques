package PT2019.assignment4.Assignment4.presentation;

import java.awt.event.*;
import java.util.*;

import PT2019.assignment4.Assignment4.businessLayer.*;

public class AddOrderViewController {
	private AddOrderView addOrderView;
	private Restaurant restaurant;
	boolean orderCreated;
	public AddOrderViewController(AddOrderView addOrderView, Restaurant restaurant, boolean orderCreated) {
		this.addOrderView = addOrderView;
		this.restaurant = restaurant;
		this.orderCreated = orderCreated;
		
		addOrderView.addActionListener(new ButtonListener());
	}

	class ButtonListener implements ActionListener {

		@SuppressWarnings("deprecation")
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String quant = "";
			int quantity = 0;
			boolean error = false;
			if (e.getSource() == addOrderView.getGoBack()) {

				addOrderView.setVisible(false);

				MainView mainView = new MainView(restaurant);
	
				mainView.setVisible(true);
				if(orderCreated == true) {
				mainView.getCloudForChef().setVisible(true);
				orderCreated = false;
				}
				MainViewController cont = new MainViewController(mainView, restaurant);
			}

			if (e.getSource() == addOrderView.getGo()) {
				
				orderCreated = true;
				MainView mainView = new MainView(restaurant);
				ChefView chefView = new ChefView(mainView);
				MainViewController cont = new MainViewController(mainView, restaurant);
				restaurant.addObserver(chefView);
				restaurant.notifyObservers();
				System.out.println(orderCreated);
				if(orderCreated == true) {
					System.out.println("TRUEEEEEEEEEEE");
					restaurant.notifyObservers();
				}
				
				ArrayList<MenuItem> menuItems = new ArrayList<>();
				int[] pos = addOrderView.getProductList().getSelectedIndices();
				List<MenuItem> list = restaurant.getList();
				
				for (int i = 0; i < pos.length; i++) {
					menuItems.add(list.get(pos[i]));
				}
				quant = addOrderView.getQuantity();
				try {
					quantity = Integer.parseInt(quant);
				} catch (NumberFormatException ex) {
					error = true;
					addOrderView.setVisible(false);
					ErrorClass er = new ErrorClass("Please introduce a number for quantity!", restaurant);
					ErrorController cont1 = new ErrorController(er, restaurant);
					er.setVisible(true);
					// ex.printStackTrace();
				}
				if (menuItems.isEmpty() == true) {
					if (error == false) {
						addOrderView.setVisible(false);
						ErrorClass er = new ErrorClass("Please choose a product!", restaurant);
						ErrorController cont1 = new ErrorController(er, restaurant);
						er.setVisible(true);
					}

				} else {
					if(error == false) {
					int id = restaurant.getOrders().size();
					Order order = new Order(id, new Date(), (int) (Math.random() * 6 + 1), quantity);

					System.out.println(order.toString());
					restaurant.createOrder(order, menuItems);
					restaurant.notifyObservers();
		
					System.out.println(restaurant.toString());

					addOrderView.setVisible(false);
					orderCreated = true;
					
					SuccessClass success = new SuccessClass("Order succesfully inserted!", restaurant);
					success.setVisible(true);
					SuccessController controller = new SuccessController(success, restaurant);
					}
					
			}
		}
		}
	}
}
