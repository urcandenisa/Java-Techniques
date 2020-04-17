package PT2019.assignment3.Assignment3.businessLogic.validators;

import PT2019.assignment3.Assignment3.model.Product;

public class NamePValidator implements Validator<Product> {
	public void validate(Product product) {

		if (product.getName().toString().compareTo("") == 0)
			throw new IllegalArgumentException("Name is not a valid name");

	}
}
