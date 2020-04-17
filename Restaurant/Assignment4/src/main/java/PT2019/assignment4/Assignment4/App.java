package PT2019.assignment4.Assignment4;

import java.util.ArrayList;

import PT2019.assignment4.Assignment4.businessLayer.*;
import PT2019.assignment4.Assignment4.dataLayer.RestaurantSerialization;
import PT2019.assignment4.Assignment4.presentation.*;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		
		Restaurant restaurant = new Restaurant();
		restaurant.setList(RestaurantSerialization.deserialization());
		MainView mainView = new MainView(restaurant);
		mainView.setVisible(true);
		
		MainViewController controller = new MainViewController(mainView, restaurant);
		
		ArrayList<MenuItem>menuItems=  new ArrayList<MenuItem>();
		menuItems.add(new CompositeProduct("a",1,1,"b"));
		//RestaurantSerialization.serialization(menuItems);
		ArrayList<MenuItem> m = RestaurantSerialization.deserialization();
		System.out.println(m);
	}

}
