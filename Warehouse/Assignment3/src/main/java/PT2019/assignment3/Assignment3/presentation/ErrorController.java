package PT2019.assignment3.Assignment3.presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import PT2019.assignment3.Assignment3.businessLogic.ClientBusiness;
import PT2019.assignment3.Assignment3.businessLogic.OrderDetailBusiness;
import PT2019.assignment3.Assignment3.businessLogic.OrdersBusiness;
import PT2019.assignment3.Assignment3.businessLogic.ProductBusiness;

public class ErrorController {
	private ErrorClass errorView;
	private int var;
	public ErrorController(ErrorClass errorView, int var) {
		this.errorView = errorView;
		this.var = var;
		errorView.addActionListener(new ButtonListener());
	}

	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == errorView.getGoBack()) {
				errorView.setVisible(false);
				errorView.reset(var);
			}
			if (e.getSource() == errorView.getViewAll()) {
				errorView.setVisible(false);
				if(var == 0) {
					ViewAll view = new ViewAll(new ClientBusiness());
					ViewAllController cont = new ViewAllController(view);
					view.setVisible(true);
					}else if(var == 1) {
						ViewAllProducts view = new ViewAllProducts(new ProductBusiness());
						ViewAllProductsController cont = new ViewAllProductsController(view);
						view.setVisible(true);
					}else if(var == 3) {
						ViewAllOrders view = new ViewAllOrders(new OrdersBusiness(), new OrderDetailBusiness());
						ViewAllOrdersController cont = new ViewAllOrdersController(view);
						view.setVisible(true);
					}
			}
		}

	}

}
