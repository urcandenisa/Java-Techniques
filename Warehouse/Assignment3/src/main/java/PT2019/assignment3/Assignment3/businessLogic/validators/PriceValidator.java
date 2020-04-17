package PT2019.assignment3.Assignment3.businessLogic.validators;

import java.util.regex.Pattern;

import PT2019.assignment3.Assignment3.model.Product;

public class PriceValidator implements Validator<Product>{
	private static final String PRICE = "[a-zA-Z]+";

	public void validate(Product product) {
		Pattern pattern = Pattern.compile(PRICE);
		if(!pattern.matcher(String.valueOf(product.getPrice())).matches()) {
			throw new IllegalArgumentException("Price is not a valid price");
		}
	}
}
