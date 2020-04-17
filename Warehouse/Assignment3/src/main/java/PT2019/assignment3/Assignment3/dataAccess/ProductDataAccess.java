package PT2019.assignment3.Assignment3.dataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import PT2019.assignment3.Assignment3.connection.ConnectionFactory;
import PT2019.assignment3.Assignment3.model.Product;

public class ProductDataAccess extends AbstractDataAccess<Product> {
	private final String createInsertQuery(Product product) {
		StringBuilder builder = new StringBuilder();
		builder.append("INSERT INTO Product(id, name, quantity, price)" + "VALUES(?, ?, ?, ?)");
		
		return builder.toString();
	}
	
	public void insertProduct(Product product) {
		Connection connection = null;
		PreparedStatement statement = null;
		String query = createInsertQuery(product);
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, product.getId());
			statement.setString(2, product.getName());
			statement.setInt(3, product.getQuantity());
			statement.setInt(4, product.getPrice());
			statement.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
	}
	
	private final String createUpdateQuery(Product product) {
		StringBuilder builder = new StringBuilder();
		builder.append("UPDATE Product SET name=?, quantity=?, price=? WHERE id=?");
		return builder.toString();
	}
	
	public void updateProduct(Product product) {
		Connection connection = null;
		PreparedStatement statement = null;
		String query = createUpdateQuery(product);
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, product.getName());
			statement.setInt(2, product.getQuantity());
			statement.setInt(3, product.getPrice());
			statement.setInt(4, product.getId());
			statement.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
	}
}
