package PT2019.assignment3.Assignment3.presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;
import java.util.List;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import PT2019.assignment3.Assignment3.ReflectionExample;
import PT2019.assignment3.Assignment3.businessLogic.ProductBusiness;
import PT2019.assignment3.Assignment3.model.Product;

public class ProductController {
	private ProductView productView;
	private ProductBusiness productBusiness;

	public ProductController(final ProductView productView, ProductBusiness productBusiness) {
		this.productView = productView;
		this.productBusiness = productBusiness;
		productView.addGoListener(new GoListener());
		productView.AddChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				System.out.println("TAB " + productView.getTabbedPane().getSelectedIndex());

			}

		});

	}

	class GoListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String name = "";
			String price = "";
			String quantity = "";

			String editName = "";
			String editPrice = "";
			String editQuantity = "";

			int id = 0;
			int ide = -1;
			int idd = -1;

			int pr = -1;
			int q = -1;
			int pre = -1;
			int qe = -1;
			boolean error = false;
			boolean error1 = false;
			boolean error0 = false;
			try {
				name = productView.getProductName();
				price = productView.getProductPrice();
				quantity = productView.getProductQuantity();

				editName = productView.getProductName1();
				editPrice = productView.getProductPrice1();
				editQuantity = productView.getProductQuantity1();
			} catch (InputMismatchException ex) {
				productView.showErrorMessage("BAD INPUT");
			}
			if (productView.getTabbedPane().getSelectedIndex() == 0) {
				if (e.getSource() == productView.getGo()) {
					if (name.compareTo("") != 0 && price.compareTo("") != 0 && quantity.compareTo("") != 0) {
						List<? extends Object> list = productBusiness.selectAll();
						System.out.println(list);
						id = ReflectionExample.retrieveId(list);
						id++;
						try {
							pr = Integer.parseInt(price);
							q = Integer.parseInt(quantity);
						} catch (NumberFormatException nfex) {
							ErrorClass err = new ErrorClass("BAD INPUT!");
							productView.setVisible(false);
							err.setVisible(true);
							ErrorController cont = new ErrorController(err, 1);
							error0 = true;
						}
						if (error0 == false) {
							productBusiness.insertProduct(new Product(id, name, pr, q));
							SuccessClass success = new SuccessClass("Product succesfully inserted!");
							productView.setVisible(false);
							success.setVisible(true);
							SuccessController succContr = new SuccessController(success, 1);
						}

					} else {
						if (error0 == false) {
							ErrorClass err = new ErrorClass("You did not complete all fields!");
							productView.setVisible(false);
							err.setVisible(true);
							ErrorController cont = new ErrorController(err, 1);
						}
					}
				}
			}
			if (e.getSource() == productView.getGo1()) {
				
				try {
					
					ide = Integer.parseInt(productView.getProductId1());
				} catch (NumberFormatException nfex) {
					ErrorClass err = new ErrorClass("BAD INPUT!");
					productView.setVisible(false);
					err.setVisible(true);
					ErrorController cont = new ErrorController(err, 1);
					error = true;
				}
				Product product = productBusiness.findProductById(ide);
				if (product == null && error == false) {
					ErrorClass err = new ErrorClass("The product no longer exists!");
					productView.setVisible(false);
					err.setVisible(true);
					ErrorController cont = new ErrorController(err, 1);
				} else {
					if (error == false) {
						if (ide != -1 && (editName.compareTo("") != 0 || editPrice.compareTo("") != 0
								|| editQuantity.compareTo("") != 0)) {
							if(editPrice.compareTo("") != 0) {
								try {
									pre = Integer.parseInt(editPrice);
								}catch (NumberFormatException nfex) {
									ErrorClass err = new ErrorClass("BAD INPUT!");
									productView.setVisible(false);
									err.setVisible(true);
									ErrorController cont = new ErrorController(err, 1);
									error = true;
								}
							}
							else if(editQuantity.compareTo("") != 0) {
								try {
									qe = Integer.parseInt(editQuantity);
								}catch (NumberFormatException nfex) {
									ErrorClass err = new ErrorClass("BAD INPUT!");
									productView.setVisible(false);
									err.setVisible(true);
									ErrorController cont = new ErrorController(err, 1);
									error = true;
								}
							}
							productBusiness.updateProduct(new Product(ide, editName, pre, qe));
							SuccessClass success = new SuccessClass("Product succesfully updated!");
							productView.setVisible(false);
							success.setVisible(true);
							SuccessController succContr = new SuccessController(success, 1);
						}
					}
				}
			}
			if (productView.getTabbedPane().getSelectedIndex() == 2) {
				System.out.println("TAB " + productView.getTabbedPane().getSelectedIndex());
				if (e.getSource() == productView.getGo2()) {
					try {
						idd = Integer.parseInt(productView.getProductId());
						System.out.println(idd);
					} catch (NumberFormatException nfex) {
						ErrorClass err = new ErrorClass("BAD INPUT!");
						productView.setVisible(false);
						err.setVisible(true);
						error1 = true;
						ErrorController cont = new ErrorController(err, 1);
					}
					Product product = productBusiness.findProductById(idd);
					if (product == null && error1 == false) {
						ErrorClass err = new ErrorClass("The product no longer exists!");
						productView.setVisible(false);
						err.setVisible(true);
						ErrorController cont = new ErrorController(err, 1);
					} else {
						if (error1 == false) {
							System.out.println("GO DELETE");
							productBusiness.delete(idd);
							SuccessClass success = new SuccessClass("Product succesfully deleted");
							productView.setVisible(false);
							success.setVisible(true);
							SuccessController succContr = new SuccessController(success, 1);
						}
					}
				}
			}
			if (productView.getGoBack() == e.getSource()) {
				productView.setVisible(false);
				productView.reset();
			}
			if (productView.getGoBack1() == e.getSource()) {
				productView.setVisible(false);
				productView.reset();
			}
			if (productView.getGoBack2() == e.getSource()) {
				productView.setVisible(false);
				productView.reset();
			}

		}
	}
}
