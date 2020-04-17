package PT2019.assignment3.Assignment3.businessLogic.validators;

import java.util.regex.Pattern;

import PT2019.assignment3.Assignment3.model.Client;

public class IdCValidator implements Validator<Client>{
	private static final String ID = "[a-zA-Z]+";

	public void validate(Client client) {
		Pattern pattern = Pattern.compile(ID);
		if(!pattern.matcher(String.valueOf(client.getId())).matches()) {
			throw new IllegalArgumentException("ID is not a valid ID");
		}
	}
}
