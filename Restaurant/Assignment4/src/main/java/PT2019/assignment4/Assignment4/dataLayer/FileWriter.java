package PT2019.assignment4.Assignment4.dataLayer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import PT2019.assignment4.Assignment4.businessLayer.MenuItem;
import PT2019.assignment4.Assignment4.businessLayer.Order;
import PT2019.assignment4.Assignment4.businessLayer.Restaurant;

public abstract class FileWriter {
	public static void write(Restaurant restaurant) {
		ArrayList<MenuItem> menuItems = restaurant.getList();
		HashMap<Order, List<MenuItem>> orders = restaurant.getOrders();
		int i = 0;
		String bill = "bill";
		try {
			int totalPrice = 0;
			for(List<MenuItem> items: orders.values())
			for (MenuItem item : items) {
				File fout = new File(bill + i + ".txt");
				FileOutputStream fos = new FileOutputStream(fout);
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
				bw.write("[Bill] You have to pay...");
				i++;
				bw.newLine();
				String toWrite = "";
				toWrite = item.getName() + ", price " + item.getPrice() + ", weight " + item.getWeight()
						+ ", containing " + item.getComposite() + "\n";
				bw.write(toWrite);
				bw.newLine();
				totalPrice += item.getPrice();
				System.out.println("Succesfully wrote into file " + toWrite);
				bw.write("Total price:" + totalPrice);
				bw.close();
			}
			
		} catch (FileNotFoundException ex) {
			// File was not found
			ex.printStackTrace();
		} catch (IOException ex) {
			// Problem when writing to the file
			ex.printStackTrace();
		}
	}
}
