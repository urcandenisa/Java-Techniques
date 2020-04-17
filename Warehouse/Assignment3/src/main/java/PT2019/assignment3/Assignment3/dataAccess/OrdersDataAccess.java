package PT2019.assignment3.Assignment3.dataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import PT2019.assignment3.Assignment3.connection.ConnectionFactory;
import PT2019.assignment3.Assignment3.model.Orders;

public class OrdersDataAccess extends AbstractDataAccess<Orders> {
	private final String createInsertQuery(Orders order) {
		StringBuilder builder = new StringBuilder();
		builder.append("INSERT INTO Orders(id, name)" + "VALUES(?, ?)");
		return builder.toString();
	}
	
	public void insertOrder(Orders order) {
		Connection connection = null;
		PreparedStatement statement = null;
		String query = createInsertQuery(order);
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, order.getId());
			statement.setString(2, order.getName());
			statement.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
	}
	
	private final String createUpdateQuery(Orders order) {
		StringBuilder builder = new StringBuilder();
		builder.append("UPDATE Orders SET name=? WHERE id=?");
		return builder.toString();
	}
	
	public void updateOrder(Orders order) {
		Connection connection = null;
		PreparedStatement statement = null;
		String query = createUpdateQuery(order);
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, order.getName());
			statement.setInt(2, order.getId());
			statement.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
	}
}
