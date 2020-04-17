package PT2019.assignment3.Assignment3.businessLogic;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.swing.JTable;

import PT2019.assignment3.Assignment3.businessLogic.validators.*;
import PT2019.assignment3.Assignment3.businessLogic.validators.Validator;
import PT2019.assignment3.Assignment3.dataAccess.ProductDataAccess;
import PT2019.assignment3.Assignment3.model.Product;

public class ProductBusiness {
	private List<Validator<Product>> validators;
	private ProductDataAccess productDataAccess;

	public ProductBusiness() {
		validators = new ArrayList<Validator<Product>>();
		validators.add(new IdPValidator());
		validators.add(new NamePValidator());
		validators.add(new QuantityValidator());
		validators.add(new PriceValidator());

		productDataAccess = new ProductDataAccess();
	}
	
	public Product findProductById(int id) {
		Product product = productDataAccess.findById(id);
		/*if(product == null) {
			throw new NoSuchElementException("The product with id " + id + " was not found");
		}*/
		return product;
	}
	
	public List<Product> selectAll() {
		List<Product> list = productDataAccess.selectAll();
		if (list == null) {
			throw new NoSuchElementException("LIST IS EMPTY");
		}
		return list;
	}

	public void delete(int id) {
		productDataAccess.delete(id);
	}
	
	public void insertProduct(Product product) {
		productDataAccess.insertProduct(product);
	}
	
	public void updateProduct(Product product) {
		productDataAccess.updateProduct(product);
	}
	
	public JTable createTable(List<? extends Object> list) {
		JTable table = productDataAccess.createJTable(list);
		return table;
	}
	public static void main(String[] args) {
		ProductBusiness product = new ProductBusiness();
		System.out.println(product.selectAll());
		System.out.println(product.findProductById(24));
	}
}
