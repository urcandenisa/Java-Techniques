package PT2019.assignment3.Assignment3.model;

public class Orders {
	private int id;
	private String name;
	
	public Orders() {
		this.id = 0;
		this.name = "";
	}
	
	public Orders(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Order " + this.id + "name= " + this.name + "\n";
	}
}
