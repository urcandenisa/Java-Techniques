package PT2019.assignment3.Assignment3.presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import PT2019.assignment3.Assignment3.ReflectionExample;
import PT2019.assignment3.Assignment3.businessLogic.ClientBusiness;
import PT2019.assignment3.Assignment3.businessLogic.OrderDetailBusiness;
import PT2019.assignment3.Assignment3.businessLogic.OrdersBusiness;
import PT2019.assignment3.Assignment3.businessLogic.ProductBusiness;
import PT2019.assignment3.Assignment3.model.OrderDetail;
import PT2019.assignment3.Assignment3.model.Orders;
import PT2019.assignment3.Assignment3.model.Product;
public class OrderController {
	private OrderView view;
	private OrdersBusiness orderBusiness;
	private OrderDetailBusiness orderDetailBusiness;

	public OrderController(OrderView view, OrdersBusiness orderBusiness, OrderDetailBusiness orderDetailBusiness) {
		this.view = view;
		this.orderDetailBusiness = orderDetailBusiness;
		this.orderBusiness = orderBusiness;
		view.AddActionListener(new ButtonListener());
	}

	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			ProductBusiness productBusiness = new ProductBusiness();
			String quantity = "";
			int q = -1;
			int id = -1, idO = 0;
			quantity = view.getQuantity();
			if (e.getSource() == view.getGoBack()) {
				view.setVisible(false);
				view.reset();
			} else {
				if (e.getSource() == view.getGo()) {
					if (view.getProductList().isSelectionEmpty() == false
							&& view.getListClients().isSelectionEmpty() == false && quantity.compareTo("") != 0) {
						try {
							q = Integer.parseInt(quantity);
						} catch (NumberFormatException nfex) {
							ErrorClass err = new ErrorClass("BAD INPUT!");
							view.setVisible(false);
							err.setVisible(true);
							ErrorController cont = new ErrorController(err, 3);
						}
						id = ReflectionExample.retrieveId(orderBusiness.selectAll());
						id++;
						idO = ReflectionExample.retrieveId(orderDetailBusiness.selectAll());

						Object idC = view.getListClients().getSelectedValue();
						Object[] idP = view.getProductList().getSelectedValues();

						for (Object obj : idP) {
							System.out.println(obj);
							int ip = obj.toString().charAt(4) == ' ' ? Integer.parseInt(obj.toString().substring(3, 4))
									: Integer.parseInt(obj.toString().substring(3, 5));
							int i = view.getListClients().getSelectedIndex();
							String s = view.getListClients().getModel().getElementAt(i).toString();
							System.out.println(s);
							int length = view.getListClients().getModel().getElementAt(i).toString().length();
							System.out.println(length);
							System.out.println(s.substring(10, length - 1));
							Orders order = new Orders(id, s.substring(10, length - 1));
							OrderDetail orderDetail = new OrderDetail(idO, ip, q);
							Product product = productBusiness.findProductById(ip);
							int qu = ReflectionExample.retrieveQuantity(product);
							if (qu < q) {
								ErrorClass err = new ErrorClass("There are not that many products!");
								view.setVisible(false);
								err.setVisible(true);
								ErrorController cont = new ErrorController(err, 3);
							} else {
								orderBusiness.insertOrder(order);
								orderDetailBusiness.insertOrderDetail(orderDetail);
								product.setQuantity(product.getQuantity() - qu);
								SuccessClass success = new SuccessClass("Order succesfully inserted!");
								view.setVisible(false);
								success.setVisible(true);
								SuccessController succContr = new SuccessController(success, 3);
							}
						}

					} else {
						ErrorClass err = new ErrorClass("YOU DID NOT COMPLETE ALL FIELDS!");
						view.setVisible(false);
						err.setVisible(true);
						ErrorController cont = new ErrorController(err, 3);
					}
				}
			}
		}

	}

	public static void main(String[] args) {
		OrderView view = new OrderView(new ClientBusiness(), new ProductBusiness());
		OrderController con = new OrderController(view, new OrdersBusiness(), new OrderDetailBusiness());
		view.setVisible(true);
	}
}
