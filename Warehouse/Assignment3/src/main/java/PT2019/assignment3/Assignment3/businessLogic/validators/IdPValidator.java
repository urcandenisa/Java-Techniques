package PT2019.assignment3.Assignment3.businessLogic.validators;

import java.util.regex.Pattern;

import PT2019.assignment3.Assignment3.model.Product;

public class IdPValidator implements Validator<Product>{
	private static final String ID = "[a-zA-Z]+";

	public void validate(Product product) {
		Pattern pattern = Pattern.compile(ID);
		if(!pattern.matcher(String.valueOf(product.getId())).matches()) {
			throw new IllegalArgumentException("ID is not a valid ID");
		}
	}
}
