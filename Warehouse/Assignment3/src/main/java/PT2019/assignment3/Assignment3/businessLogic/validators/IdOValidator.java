package PT2019.assignment3.Assignment3.businessLogic.validators;

import java.util.regex.Pattern;

import PT2019.assignment3.Assignment3.model.Orders;

public class IdOValidator implements Validator<Orders>{
	private static final String ID = "[a-zA-Z]+";

	public void validate(Orders order) {
		Pattern pattern = Pattern.compile(ID);
		if(!pattern.matcher(String.valueOf(order.getId())).matches()) {
			throw new IllegalArgumentException("ID is not a valid ID");
		}
	}
}
