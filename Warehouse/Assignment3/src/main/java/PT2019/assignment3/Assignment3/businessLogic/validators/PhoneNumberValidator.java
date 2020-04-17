package PT2019.assignment3.Assignment3.businessLogic.validators;

import java.util.regex.Pattern;

import PT2019.assignment3.Assignment3.model.Client;

public class PhoneNumberValidator implements Validator<Client>{
	private static final String PHONE_NUMBER_PATTERN = "[a-zA-Z]+";

	public void validate(Client client) {
		Pattern pattern = Pattern.compile(PHONE_NUMBER_PATTERN);
		if(!pattern.matcher(client.getPhoneNumber()).matches()) {
			throw new IllegalArgumentException("Phone number is not a valid phone number");
		}
	}
}
