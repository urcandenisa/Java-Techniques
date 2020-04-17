package PT2019.assignment3.Assignment3.businessLogic.validators;
import java.util.regex.Pattern;
import PT2019.assignment3.Assignment3.model.Product;

public class QuantityValidator implements Validator<Product> {
	private static final String QUANTITY = "[a-zA-Z]+";

	public void validate(Product product) {
		Pattern pattern = Pattern.compile(QUANTITY);
		if(!pattern.matcher(String.valueOf(product.getQuantity())).matches()) {
			throw new IllegalArgumentException("Quantity is not a valid quantity");
		}
	}
}
