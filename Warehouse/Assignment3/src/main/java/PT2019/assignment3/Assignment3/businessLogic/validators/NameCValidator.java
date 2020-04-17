package PT2019.assignment3.Assignment3.businessLogic.validators;

import PT2019.assignment3.Assignment3.model.Client;

public class NameCValidator implements Validator<Client> {

	public void validate(Client client) {

		if (client.getName().toString().compareTo("") == 0)
			throw new IllegalArgumentException("Name is not a valid name");

	}
}
