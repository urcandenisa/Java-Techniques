package PT2019.assignment3.Assignment3.businessLogic;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.swing.JTable;

import PT2019.assignment3.Assignment3.businessLogic.validators.IdOValidator;
import PT2019.assignment3.Assignment3.businessLogic.validators.NameOValidator;
import PT2019.assignment3.Assignment3.businessLogic.validators.Validator;
import PT2019.assignment3.Assignment3.dataAccess.OrdersDataAccess;
import PT2019.assignment3.Assignment3.model.Orders;

public class OrdersBusiness {
	private List<Validator<Orders>> validators;
	private OrdersDataAccess orderDataAccess;

	public OrdersBusiness() {
		validators = new ArrayList<Validator<Orders>>();
		validators.add(new IdOValidator());
		validators.add(new NameOValidator());
		orderDataAccess = new OrdersDataAccess();
	}

	public Orders findOrderById(int id) {
		Orders order = orderDataAccess.findById(id);
		if (order == null) {
			throw new NoSuchElementException("The order with id " + id + " was not found");
		}
		return order;
	}

	public List<Orders> selectAll() {
		List<Orders> list = orderDataAccess.selectAll();
		if (list == null) {
			throw new NoSuchElementException("LIST IS EMPTY");
		}
		return list;
	}
	
	public JTable createTable(List<? extends Object> list) {
		JTable table = orderDataAccess.createJTable(list);
		return table;
	}
	public void delete(int id) {
		orderDataAccess.delete(id);
	}
	
	public void insertOrder(Orders order) {
		orderDataAccess.insertOrder(order);
	}
	
	public void updateOrder(Orders order) {
		orderDataAccess.updateOrder(order);
	}
}
