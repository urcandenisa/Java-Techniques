package PT2019.assignment4.Assignment4.presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import PT2019.assignment4.Assignment4.businessLayer.BaseProduct;
import PT2019.assignment4.Assignment4.businessLayer.CompositeProduct;
import PT2019.assignment4.Assignment4.businessLayer.MenuItem;
import PT2019.assignment4.Assignment4.businessLayer.Restaurant;
import PT2019.assignment4.Assignment4.dataLayer.RestaurantSerialization;

public class MenuItemViewController {
	MenuItemView menuItemView;
	Restaurant restaurant;

	public MenuItemViewController(MenuItemView menuItemView, Restaurant restaurant) {
		this.menuItemView = menuItemView;
		this.restaurant = restaurant;
		
		menuItemView.addActionListener(new ButtonListener());
	}

	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			String name = "";
			String weight = "";
			String price = "";
			String composite = "";
			int weigh = 0;
			int pric = 0;
			String id1 = "";
			String name1 = "";
			String weight1 = "";
			String price1 = "";
			String composite1 = "";
			int weigh1 = 0;
			int pric1 = 0;
			int idd1 = 0;
			String id2 = "";
			int idd2 = 0;
			boolean err1 = false, err2 = false, err3 = false, err4 = false, err5 = false, err6 = false, err7 = false;
			if (e.getSource() == menuItemView.getGoBack() || e.getSource() == menuItemView.getGoBack1() || e.getSource() == menuItemView.getGoBack2()) {
				MainView mainView = new MainView(restaurant);
				menuItemView.setVisible(false);
				mainView.setVisible(true);
				MainViewController contr = new MainViewController(mainView, restaurant);
			}
			if (e.getSource() == menuItemView.getGo()) {

				try {
					name = menuItemView.getName();
					weight = menuItemView.getWeight();
					price = menuItemView.getPrice();
					composite = menuItemView.getComposite();
				} catch (NullPointerException ex) {

					ErrorClass2 er = new ErrorClass2("Please complete all fields!", restaurant);
					ErrorController2 cont = new ErrorController2(er, restaurant, 0);
					menuItemView.setVisible(false);
					er.setVisible(true);
					// ex.printStackTrace();
				}
				if (name.compareTo("") == 0) {
					ErrorClass2 er = new ErrorClass2("Please introduce a name for item!", restaurant);
					ErrorController2 cont = new ErrorController2(er, restaurant, 0);
					menuItemView.setVisible(false);
					er.setVisible(true);
				} else {
					try {
						weigh = Integer.parseInt(weight);
						pric = Integer.parseInt(price);
					} catch (NumberFormatException exc) {
						err1 = true;
						if (weight.compareTo("") == 0) {
							ErrorClass2 er = new ErrorClass2("Please introduce a number for weight!", restaurant);
							ErrorController2 cont = new ErrorController2(er, restaurant, 0);
							menuItemView.setVisible(false);
							er.setVisible(true);
						} else {
							ErrorClass2 er = new ErrorClass2("Please introduce a number for price!", restaurant);
							ErrorController2 cont = new ErrorController2(er, restaurant, 0);
							menuItemView.setVisible(false);
							er.setVisible(true);
						}
						// exc.printStackTrace();
					}
					if (err1 == false) {
						System.out.println(
								"name + " + name + "wight" + weigh + "price" + pric + " composite " + composite);
						
						System.out.println(restaurant.toString());

						menuItemView.setVisible(false);
						
						CompositeProduct comp = new CompositeProduct(name, pric, weigh, composite);
						int ok = 1;
						if (composite.compareTo("") != 0) {
							
							String[] array = composite.split(",");
							for(int i = 0; i < array.length; i++) {
								if(comp.search(array[i]).compareTo("") != 0 ) {
									ErrorClass2 er = new ErrorClass2("Please introduce a base", restaurant);
									ErrorController2 cont = new ErrorController2(er, restaurant, 0);
									menuItemView.setVisible(false);
									er.setVisible(true);
								}
								else {
									restaurant.addItem(comp);
									SuccessClass2 success = new SuccessClass2("[Composite]Item succesfully inserted!",
											restaurant);
									SuccessController2 cont = new SuccessController2(success, restaurant, 0);
									success.setVisible(true);}
							}
							
						} else {
							SuccessClass2 success = new SuccessClass2("[Base]Item succesfully inserted!", restaurant);
							SuccessController2 cont = new SuccessController2(success, restaurant, 0);
							success.setVisible(true);

						}
					}
				}
			}
			if (e.getSource() == menuItemView.getGo1()) {

				try {
					id1 = menuItemView.getID1();
					name1 = menuItemView.getName1();
					price1 = menuItemView.getPrice1();
					weight1 = menuItemView.getWeight1();
					composite1 = menuItemView.getComposite1();
				} catch (NullPointerException ex) {
					// ex.printStackTrace();
					ErrorClass2 er = new ErrorClass2("Please complete all fields!", restaurant);
					ErrorController2 cont = new ErrorController2(er, restaurant, 0);
					menuItemView.setVisible(false);
					er.setVisible(true);
				}

				try {
					if (id1.compareTo("") != 0)
						idd1 = Integer.parseInt(id1);
					if (price1.compareTo("") != 0)
						pric1 = Integer.parseInt(price1);
					if (weight1.compareTo("") != 0)
						weigh1 = Integer.parseInt(weight1);
				} catch (NumberFormatException ex) {
					// ex.printStackTrace();
					err2 = true;
					if (weight1.compareTo("") == 0) {
						ErrorClass2 er = new ErrorClass2("Please introduce a number for weight!", restaurant);
						ErrorController2 cont = new ErrorController2(er, restaurant, 0);
						menuItemView.setVisible(false);
						er.setVisible(true);
					} else if (price1.compareTo("") == 0) {
						ErrorClass2 er = new ErrorClass2("Please introduce a number for price!", restaurant);
						ErrorController2 cont = new ErrorController2(er, restaurant, 0);
						menuItemView.setVisible(false);
						er.setVisible(true);
					} else {
						ErrorClass2 er = new ErrorClass2("Please introduce a number for id!", restaurant);
						ErrorController2 cont = new ErrorController2(er, restaurant, 0);
						menuItemView.setVisible(false);
						er.setVisible(true);
					}
				}
				if (err2 == false) {
					idd1--;

					if (id1.compareTo("") != 0) {
						try {
							if (name1.compareTo("") != 0) {
								restaurant.getList().get(idd1).setName(name1);
							}
							if (price1.compareTo("") != 0) {
								restaurant.getList().get(idd1).setPrice(pric1);
							}
							if (weight1.compareTo("") != 0) {
								restaurant.getList().get(idd1).setWeight(weigh1);
							}
							if (composite1.compareTo("") != 0) {
								restaurant.getList().get(idd1).setComposite(composite1);
							}

							menuItemView.setVisible(false);
							SuccessClass2 success = new SuccessClass2("Item succesfully updated", restaurant);
							SuccessController2 cont = new SuccessController2(success, restaurant, 0);
							success.setVisible(true);
						} catch (IndexOutOfBoundsException ex) {
							err3 = true;
							ErrorClass2 er = new ErrorClass2("Please introduce a valid number for id", restaurant);
							ErrorController2 cont = new ErrorController2(er, restaurant, 0);
							menuItemView.setVisible(false);
							er.setVisible(true);
						}
					} else {
						if (err3 == false) {
							ErrorClass2 er = new ErrorClass2("Please introduce a number for id", restaurant);
							ErrorController2 cont = new ErrorController2(er, restaurant, 0);
							menuItemView.setVisible(false);
							er.setVisible(true);
						}
					}
				}
			}

			if (e.getSource() == menuItemView.getGo2()) {

				try {
					id2 = menuItemView.getID();
				} catch (NullPointerException ex) {
					// ex.printStackTrace();
					ErrorClass2 er = new ErrorClass2("Please introduce a number for id", restaurant);
					ErrorController2 cont = new ErrorController2(er, restaurant, 0);
					menuItemView.setVisible(false);
					er.setVisible(true);
				}

				try {
					idd2 = Integer.parseInt(id2);
				} catch (NumberFormatException ex) {
					// ex.printStackTrace();
					err4 = true;
					ErrorClass2 er = new ErrorClass2("Please introduce a valid number for id", restaurant);
					ErrorController2 cont = new ErrorController2(er, restaurant, 0);
					menuItemView.setVisible(false);
					er.setVisible(true);
				}
				if (err4 == false) {
					try {
						//restaurant.setList(RestaurantSerialization.deserialization());
						System.out.println("RESTA " + restaurant.toString() + restaurant.getList());
						
						restaurant.deleteItem(restaurant.getList().get(idd2 - 1));
					} catch (IndexOutOfBoundsException ex) {
						// ex.printStackTrace();
						err5 = true;
						ErrorClass2 er = new ErrorClass2("Please introduce a valid number for id", restaurant);
						ErrorController2 cont = new ErrorController2(er, restaurant, 0);
						menuItemView.setVisible(false);
						er.setVisible(true);
					}
					if (err5 == false) {
						menuItemView.setVisible(false);
						SuccessClass2 success = new SuccessClass2("Item succesfully deleted", restaurant);
						SuccessController2 cont = new SuccessController2(success, restaurant, 0);
						success.setVisible(true);
					}
				}
			}
		}
	}

}
