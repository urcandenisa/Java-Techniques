package PT2019.assignment3.Assignment3.businessLogic.validators;

import java.util.regex.Pattern;

import PT2019.assignment3.Assignment3.model.OrderDetail;

public class IdODetailValidator implements Validator<OrderDetail>{
	private static final String ID = "[a-zA-Z]+";

	public void validate(OrderDetail order) {
		Pattern pattern = Pattern.compile(ID);
		if(!pattern.matcher(String.valueOf(order.getIdO())).matches()) {
			throw new IllegalArgumentException("ID is not a valid ID");
		}
	}
}