package PT2019.assignment3.Assignment3.businessLogic.validators;

import PT2019.assignment3.Assignment3.model.Orders;

public class NameOValidator implements Validator<Orders> {

	public void validate(Orders order) {

		if (order.getName().toString().compareTo("") == 0)
			throw new IllegalArgumentException("Name is not a valid name");

	}
}
