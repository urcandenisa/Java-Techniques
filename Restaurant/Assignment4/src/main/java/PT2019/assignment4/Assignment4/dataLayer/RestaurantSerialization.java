package PT2019.assignment4.Assignment4.dataLayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import PT2019.assignment4.Assignment4.businessLayer.MenuItem;

public abstract class RestaurantSerialization {
	@SuppressWarnings("unchecked")
	public static ArrayList<MenuItem> deserialization(){
		ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();
		String fileName = "ser.txt";
		try {
			FileInputStream file = new FileInputStream(new File(fileName));
			ObjectInputStream input = new ObjectInputStream(file);
			menuItems = (ArrayList<MenuItem>)input.readObject();
			input.close();
			file.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("File not found");
		}catch(IOException e1) {
			e1.printStackTrace();
			System.out.println("Can not deserialize");
		}catch(ClassNotFoundException e3) {
			System.out.println("Class not found");
		}
		return menuItems;
	}
	
	public static void serialization(ArrayList<MenuItem>menuItems) {
		String fileName = "ser.txt";
		try {
			FileOutputStream file = new FileOutputStream(new File(fileName));
			ObjectOutputStream output = new ObjectOutputStream(file);
			output.writeObject(menuItems);
			output.close();
			file.close();
		}catch(FileNotFoundException e) {
			System.out.println("File not found");
		}catch(IOException e1) {
			e1.printStackTrace();
			System.out.println("Can not serialize");
		}
	}
}
