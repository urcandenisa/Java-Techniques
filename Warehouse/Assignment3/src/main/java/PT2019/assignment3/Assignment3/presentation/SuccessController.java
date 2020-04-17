package PT2019.assignment3.Assignment3.presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import PT2019.assignment3.Assignment3.businessLogic.ClientBusiness;
import PT2019.assignment3.Assignment3.businessLogic.OrderDetailBusiness;
import PT2019.assignment3.Assignment3.businessLogic.OrdersBusiness;
import PT2019.assignment3.Assignment3.businessLogic.ProductBusiness;

public class SuccessController {
	private SuccessClass successView;
	private int var;
	public SuccessController(SuccessClass successView, int var) {
		this.successView = successView;
		this.var = var;
		successView.addActionListener(new ButtonListener());
	}

	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == successView.getGoBack()) {
				successView.setVisible(false);
				successView.reset(var);
			}
			if (e.getSource() == successView.getViewAll()) {
				successView.setVisible(false);
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
