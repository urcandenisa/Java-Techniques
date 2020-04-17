package PT2019.assignment3.Assignment3.businessLogic;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextField;

import PT2019.assignment3.Assignment3.businessLogic.validators.EmailValidator;
import PT2019.assignment3.Assignment3.businessLogic.validators.IdCValidator;
import PT2019.assignment3.Assignment3.businessLogic.validators.NameCValidator;
import PT2019.assignment3.Assignment3.businessLogic.validators.PhoneNumberValidator;
import PT2019.assignment3.Assignment3.businessLogic.validators.Validator;
import PT2019.assignment3.Assignment3.dataAccess.ClientDataAccess;
import PT2019.assignment3.Assignment3.model.Client;

public class ClientBusiness {
	private List<Validator<Client>> validators;
	private ClientDataAccess clientDataAccess;

	public ClientBusiness() {
		validators = new ArrayList<Validator<Client>>();
		validators.add(new EmailValidator());
		validators.add(new IdCValidator());
		validators.add(new NameCValidator());
		validators.add(new PhoneNumberValidator());

		clientDataAccess = new ClientDataAccess();
	}

	public Client findClientById(int id) {
		Client client = clientDataAccess.findById(id);
		/*if (client == null) {
			throw new NoSuchElementException("The client with id " + id + " was not found");
		}*/
		return client;
	}

	public List<Client> selectAll() {
		List<Client> list = clientDataAccess.selectAll();
		if (list == null) {
			throw new NoSuchElementException("LIST IS EMPTY");
		}
		return list;
	}

	public void delete(int id) {
		clientDataAccess.delete(id);
	}
	
	public void insertClient(Client client) {
		clientDataAccess.insertClient(client);
	}
	
	public void updateClient(Client client) {
		clientDataAccess.updateClient(client);
	}
	
	public JTable createTable(List<? extends Object> list) {
		JTable table = clientDataAccess.createJTable(list);
		return table;
	}
	
	public JList createCombo(List<? extends Object> list) {
		JList combo = clientDataAccess.createJComboBox(list);
		return combo;
	}
	
	public JList createJList(List<? extends Object> list) {
		return clientDataAccess.createJList(list);
	}
	
	public static void main(String[] args) {
		ClientBusiness clientBusiness = new ClientBusiness();
		System.out.println(clientBusiness.findClientById(13));
		System.out.println(clientBusiness.findClientById(11));
	}
}
