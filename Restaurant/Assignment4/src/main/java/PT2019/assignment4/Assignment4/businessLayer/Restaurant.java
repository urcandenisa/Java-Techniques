package PT2019.assignment4.Assignment4.businessLayer;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Observable;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import PT2019.assignment4.Assignment4.dataLayer.RestaurantSerialization;
import PT2019.assignment4.Assignment4.presentation.ChefView;
import PT2019.assignment4.Assignment4.presentation.MainView;
import PT2019.assignment4.Assignment4.presentation.MainViewController;

@SuppressWarnings("deprecation")

public class Restaurant extends Observable implements RestaurantProcessing {
	private ArrayList<MenuItem> list;
	private HashMap<Order, List<MenuItem>> orders = new HashMap<Order, List<MenuItem>>();
	//private RestaurantSerialization restaurantSerialization;
	public Restaurant() {//) {
		//this.restaurantSerialization = restaurantSerialization;
	//list = restaurantSerialization.deserialization();
		list = new ArrayList<MenuItem>();
		list = RestaurantSerialization.deserialization();
		System.out.println(list);
		orders = new HashMap<>();
	}
	
	public boolean isWellFormed() {
		int numberOfElements = 0;
		for(MenuItem item: this.list) {
			if(item.getName().compareTo("") == 0 && item.getComposite().compareTo("") == 0 && item.getPrice() == 0 && item.getWeight() == 0) {
				numberOfElements ++;
			}
		}
		if(numberOfElements == list.size()) {
			return true;
		}
		
		return false;
	}
	
	public ArrayList<MenuItem> getList() {
		return list;
	}
	
	public void setList(ArrayList<MenuItem> list) {
		this.list = list;
	}

	@Override
	public void addItem(MenuItem menuItem) {
		// TODO Auto-generated method stub
		assert menuItem != null : "MenuItem is null! Can not be added";
		int length = list.size();
		list.add(menuItem);
		assert length != list.size() : "MenuItem could not be added";
	}

	@Override
	public void deleteItem(MenuItem menuItem) {
		// TODO Auto-generated method stub
		assert menuItem != null  : "MenuItem is null! Can not be deleted";
		assert list.size() > 0 : "List is empty! ";
		assert list.contains(menuItem) == true : "The item no longer exists! Can not be deleted";
		int length = list.size();
		list.remove(menuItem);
		assert length != list.size() : "MenuItem can not be deleted";
	}

	@Override
	public void editItem(MenuItem menuItem, MenuItem newItem) {
		// TODO Auto-generated method stub
		assert menuItem != null  : "MenuItem is null! Can not be edited";
		assert newItem != null  : "NewMenuItem is null! Can not be edited";
		menuItem.setName(newItem.getName());
		menuItem.setPrice(newItem.getPrice());
		menuItem.setWeight(newItem.getWeight());
		menuItem.setComposite(newItem.getComposite());
		assert menuItem != newItem : "MenuItem could not be edited";
	}

	public HashMap<Order, List<MenuItem>> getOrders() {
		return orders;
	}

	public void setOrders(HashMap<Order, List<MenuItem>> orders) {
		this.orders = orders;
	}

	@Override
	public void createOrder(Order order, List<MenuItem> items) {
		// TODO Auto-generated method stub
		assert order != null : "Order is null! Can not be created";
		assert items != null : "There is no items up to date";
		int length = orders.size();
		orders.put(order, items);
		setChanged();
		notifyObservers();
		System.out.println(length + " " + orders.size());
		assert length != orders.size() : "Could not create order";
		
	}
	
	@Override
	public String toString() {
		Iterator<MenuItem> it = list.iterator();
		String result = "";
		while(it.hasNext()) {
			result += it.next().toString();
		}
		result += "\n";
		return result;
	}
}
