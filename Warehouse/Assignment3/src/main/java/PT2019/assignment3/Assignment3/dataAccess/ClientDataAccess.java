package PT2019.assignment3.Assignment3.dataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import PT2019.assignment3.Assignment3.connection.ConnectionFactory;
import PT2019.assignment3.Assignment3.model.Client;

public class ClientDataAccess extends AbstractDataAccess<Client>{
	
	private final String createInsertQuery(Client client) {
		StringBuilder builder = new StringBuilder();
		builder.append("INSERT INTO Client(id, name, address, email, phoneNumber) " + "VALUES( ?, ?, ?, ?, ?)");
		System.out.println(builder.toString());
		return builder.toString();
	}
	public void insertClient(Client client) {
		Connection connection = null;
		PreparedStatement statement = null;
		String query = createInsertQuery(client);
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, client.getId());
			statement.setString(2, client.getName());
			statement.setString(3, client.getAddress());
			statement.setString(4, client.getEmail());
			statement.setString(5, client.getPhoneNumber());
			statement.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
	}
	
	private final String createUpdateQuery(Client client) {
		StringBuilder builder = new StringBuilder();
		builder.append("UPDATE Client SET name=?, address=?, email=?, phoneNumber=? WHERE id=?");
		System.out.println(builder.toString());
		return builder.toString();
	}
	
	public void updateClient(Client client) {
		Connection connection = null;
		PreparedStatement statement = null;
		String query = createUpdateQuery(client);
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setString(1, client.getName());
			statement.setString(2, client.getAddress());
			statement.setString(3, client.getEmail());
			statement.setString(4, client.getPhoneNumber());
			statement.setInt(5, client.getId());
			statement.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
	}
}
