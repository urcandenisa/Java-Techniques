package PT2019.assignment3.Assignment3.businessLogic;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.swing.JTable;

import PT2019.assignment3.Assignment3.businessLogic.validators.IdODetailValidator;
import PT2019.assignment3.Assignment3.businessLogic.validators.Validator;
import PT2019.assignment3.Assignment3.dataAccess.OrderDetailDataAccess;
import PT2019.assignment3.Assignment3.model.OrderDetail;


public class OrderDetailBusiness {
	private List<Validator<OrderDetail>> validators;
	private OrderDetailDataAccess orderDetailDataAccess;

	public OrderDetailBusiness() {
		validators = new ArrayList<Validator<OrderDetail>>();
		validators.add(new IdODetailValidator());
		orderDetailDataAccess = new OrderDetailDataAccess();
	}

	public List<OrderDetail> findOrderByIdO(int id) {
		List<OrderDetail> order = orderDetailDataAccess.findByIdO(id);
		if (order == null) {
			throw new NoSuchElementException("The order with id " + id + " was not found");
		}
		return order;
	}
	
	public JTable createTable(List<? extends Object> list) {
		JTable table = orderDetailDataAccess.createJTable(list);
		return table;
	}

	public List<OrderDetail> selectAll() {
		List<OrderDetail> list = orderDetailDataAccess.selectAll();
		if (list == null) {
			throw new NoSuchElementException("LIST IS EMPTY");
		}
		return list;
	}

	public void delete(int id) {
		orderDetailDataAccess.delete(id);
	}
	
	public void insertOrderDetail(OrderDetail order) {
		orderDetailDataAccess.insertDetailOrder(order);
	}
	
	public void updateOrder(OrderDetail order) {
		orderDetailDataAccess.updateDetailOrder(order);
	}
}
