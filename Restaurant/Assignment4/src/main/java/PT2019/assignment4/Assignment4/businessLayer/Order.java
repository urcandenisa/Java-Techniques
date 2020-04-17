package PT2019.assignment4.Assignment4.businessLayer;

import java.util.Date;

public class Order {
	private int orderId;
	private Date date;
	private int tableNumber;
	private int quantity;
	
	public Order() {
		this.orderId = 0;
		this.date = new Date();
		this.tableNumber = 0;
		this.setQuantity(0);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + orderId;
		result = prime * result + quantity;
		result = prime * result + tableNumber;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (orderId != other.orderId)
			return false;
		if (quantity != other.quantity)
			return false;
		if (tableNumber != other.tableNumber)
			return false;
		return true;
	}

	public Order(int orderId, Date date, int tableNumber, int quantity) {
		this.orderId = orderId;
		this.date = date;
		this.setQuantity(quantity);
		this.tableNumber = tableNumber;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getTableNumber() {
		return tableNumber;
	}

	public void setTableNumber(int tableNumber) {
		this.tableNumber = tableNumber;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", date=" + date + ", tableNumber=" + tableNumber + ", quantity="
				+ quantity + "]";
	}
	
	
}
