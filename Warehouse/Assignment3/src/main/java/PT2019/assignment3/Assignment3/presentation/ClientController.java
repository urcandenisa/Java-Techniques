package PT2019.assignment3.Assignment3.presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;
import java.util.List;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import PT2019.assignment3.Assignment3.ReflectionExample;
import PT2019.assignment3.Assignment3.businessLogic.ClientBusiness;
import PT2019.assignment3.Assignment3.model.Client;

public class ClientController {
	private ClientView addClientView;
	private ClientBusiness clientBusiness;

	public ClientController(final ClientView addClientView, ClientBusiness clientBusiness) {
		this.addClientView = addClientView;
		this.clientBusiness = clientBusiness;
		addClientView.addGoListener(new GoListener());
		addClientView.AddChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				System.out.println("TAB " + addClientView.getTabbedPane().getSelectedIndex());

			}

		});

	}

	class GoListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String name = "";
			String address = "";
			String email = "";
			String phoneNumber = "";
			String editName = "";
			String editAddress = "";
			String editEmail = "";
			String editPhoneNumber = "";
			int id = 0;
			int ide = -1;
			int idd = -1;
			boolean error = false;
			boolean error1 = false;
			try {
				name = addClientView.getClientName();
				address = addClientView.getClientAddress();
				email = addClientView.getClientEmail();
				phoneNumber = addClientView.getClientPhoneNumber();
				editName = addClientView.getClientName1();
				editAddress = addClientView.getClientAddress1();
				editEmail = addClientView.getClientEmail1();
				editPhoneNumber = addClientView.getClientPhoneNumber1();
				System.out.println(name + " " + address + " " + editName + " ");

			} catch (InputMismatchException ex) {
				addClientView.showErrorMessage("BAD INPUT");
			}
			if (addClientView.getTabbedPane().getSelectedIndex() == 0) {
				if (e.getSource() == addClientView.getGo()) {
					if (name.compareTo("") != 0 && address.compareTo("") != 0 && email.compareTo("") != 0
							&& address.compareTo("") != 0) {
						List<? extends Object> list = clientBusiness.selectAll();
						System.out.println(list);
						id = ReflectionExample.retrieveId(list);
						System.out.println(id);
						id++;
						clientBusiness.insertClient(new Client(id, name, address, email, phoneNumber));
						SuccessClass success = new SuccessClass("Client succesfully inserted!");
						addClientView.setVisible(false);
						success.setVisible(true);
						SuccessController succContr = new SuccessController(success, 0);
					} else {
						ErrorClass err = new ErrorClass("You did not complete all fields!");
						addClientView.setVisible(false);
						err.setVisible(true);
						ErrorController cont = new ErrorController(err, 0);
					}
				}
			}
			if (e.getSource() == addClientView.getGo1()) {
				System.out.println("GO edit");
				try {
					ide = Integer.parseInt(addClientView.getClientId1());
				} catch (NumberFormatException nfex) {
					ErrorClass err = new ErrorClass("BAD INPUT!");
					addClientView.setVisible(false);
					err.setVisible(true);
					ErrorController cont = new ErrorController(err, 0);
					error = true;
				}
				Client client = clientBusiness.findClientById(ide);
				if (client == null && error == false) {
					ErrorClass err = new ErrorClass("The client no longer exists!");
					addClientView.setVisible(false);
					err.setVisible(true);
					ErrorController cont = new ErrorController(err, 0);
				} else {
					if (error == false) {
						if (ide != -1 && (editName.compareTo("") != 0 || editAddress.compareTo("") != 0
								|| editEmail.compareTo("") != 0 || editAddress.compareTo("") != 0)) {
							clientBusiness
									.updateClient(new Client(ide, editName, editAddress, editEmail, editPhoneNumber));
							SuccessClass success = new SuccessClass("Client succesfully updated!");
							addClientView.setVisible(false);
							success.setVisible(true);
							SuccessController succContr = new SuccessController(success, 0);
						}
					}
				}
			}
			if (addClientView.getTabbedPane().getSelectedIndex() == 2) {
				System.out.println("TAB " + addClientView.getTabbedPane().getSelectedIndex());
				if (e.getSource() == addClientView.getGo2()) {
					try {
						idd = Integer.parseInt(addClientView.getClientId());
						System.out.println(idd);
					} catch (NumberFormatException nfex) {
						ErrorClass err = new ErrorClass("BAD INPUT!");
						addClientView.setVisible(false);
						err.setVisible(true);
						error1 = true;
						ErrorController cont = new ErrorController(err, 0);
					}
					Client client = clientBusiness.findClientById(idd);
					if (client == null && error1 == false) {
						ErrorClass err = new ErrorClass("The client no longer exists!");
						addClientView.setVisible(false);
						err.setVisible(true);
						ErrorController cont = new ErrorController(err, 0 );
					} else {
						if (error1 == false) {
							System.out.println("GO DELETE");
							clientBusiness.delete(idd);
							SuccessClass success = new SuccessClass("Client succesfully deleted");
							addClientView.setVisible(false);
							success.setVisible(true);
							SuccessController succContr = new SuccessController(success, 0);
						}
					}
				}
			}
			if (addClientView.getGoBack() == e.getSource()) {
				addClientView.setVisible(false);
				addClientView.reset();
			}
			if (addClientView.getGoBack1() == e.getSource()) {
				addClientView.setVisible(false);
				addClientView.reset();
			}
			if (addClientView.getGoBack2() == e.getSource()) {
				addClientView.setVisible(false);
				addClientView.reset();
			}

		}

	}

	public static void main(String[] args) {
		ClientView view = new ClientView();
		view.setVisible(true);
		ClientController cont = new ClientController(view, new ClientBusiness());
	}
}
