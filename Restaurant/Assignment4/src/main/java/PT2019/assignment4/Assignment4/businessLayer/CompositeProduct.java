package PT2019.assignment4.Assignment4.businessLayer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class CompositeProduct extends MenuItem {

	private List<MenuItem>list;
	private String composite;
	
	public CompositeProduct(String name, int price, int weight, String composite) {
		super(name, price, weight);
		/*his.name = name;
		this.price = price;
		this.weight = weight;*/
		this.composite = composite;
		this.list = new ArrayList<MenuItem>();
	}
	

	public List<MenuItem> getList() {
		return this.list;
	}
	public void setList(List<MenuItem> list) {
		this.list = list;
	}
	
	public void addItem(MenuItem menuItem) {
		list.add(menuItem);
	}
	
	@Override
	public int computePrice() {
		// TODO Auto-generated method stub
		return this.getPrice();
	}
	/*
	public void addItem(MenuItem item) {
		list.add(item);
	}
	
	public void deleteItem(MenuItem item) {
		list.remove(item);
	}
	
	public void editItem(MenuItem item, MenuItem newItem) {
		item.setName(newItem.getName());
		item.setPrice(newItem.getPrice());
		item.setWeight(newItem.getWeight());
	}
	*/
	@Override
	public String toString() {
		String result = "";
		result += this.getName() + " " + this.composite + " " + this.getPrice() + " " + this.getWeight();
		return result;
	}
	public String getComposite() {
		return composite;
	}
	
	public String search(String name) {
		String c = "";
		for(MenuItem item: this.list) {
			if(item.getName().compareTo(name) == 0) {
				c = name;
			}
		}
		return c;
	}
	
	
	public static void main(String[] args) {
		CompositeProduct compositeProduct = new CompositeProduct("cartofi prahiti cu pui", 30, 230, "cartofi prajiti, pui");
		compositeProduct.addItem(compositeProduct);
		System.out.println(compositeProduct.toString());
	}


	@Override
	public void setComposite(String composite) {
		// TODO Auto-generated method stub
		this.composite = composite;
		
	}
}
