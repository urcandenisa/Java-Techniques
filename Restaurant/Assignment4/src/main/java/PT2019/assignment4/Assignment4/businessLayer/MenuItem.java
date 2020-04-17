package PT2019.assignment4.Assignment4.businessLayer;

import java.io.Serializable;

public abstract class MenuItem implements Serializable {
	private String name;
	private int weight;
	private int price;
	
	public MenuItem(String name, int weight, int price) {
		this.name = name;
		this.weight = weight;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public abstract int computePrice();
	
	@Override
	public String toString() {
		return name.toString() + " " + weight + " " + price + "\n";
		
	}

	public abstract String getComposite();
	
	public abstract void setComposite(String composite);
}
