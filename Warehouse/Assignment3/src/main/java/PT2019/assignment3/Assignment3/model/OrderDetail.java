package PT2019.assignment3.Assignment3.model;

public class OrderDetail {
	private int idO;
	private int idP; // de la orderul cu idO luam idP
	private int quantity;
	
	public OrderDetail() {
		this.idO = 0;
		this.idP = 0;
		this.quantity = 0;
	}
	
	public OrderDetail(int idO, int idP, int quantity) {
		this.idO = idO;
		this.idP = idP;
		this.quantity = quantity;
	}

	public int getIdO() {
		return idO;
	}

	public void setIdO(int idO) {
		this.idO = idO;
	}

	public int getIdP() {
		return idP;
	}

	public void setIdP(int idP) {
		this.idP = idP;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderDetail idO=" + idO + ", idP=" + idP + ", quantity=" + quantity + "\n";
	}
	
}
