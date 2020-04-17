package PT2019.assignment3.Assignment3.dataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import PT2019.assignment3.Assignment3.connection.ConnectionFactory;
import PT2019.assignment3.Assignment3.model.OrderDetail;

public class OrderDetailDataAccess extends AbstractDataAccess<OrderDetail>{
	private final String createInsertQuery(OrderDetail order) {

		StringBuilder builder = new StringBuilder();
		builder.append("INSERT INTO OrderDetail(idO, idP, quantity)" + "VALUES(?, ?, ?)");
		return builder.toString();
	}

	public void insertDetailOrder(OrderDetail order) {
		Connection connection = null;
		PreparedStatement statement = null;
		String query = createInsertQuery(order);
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, order.getIdO());
			statement.setInt(2, order.getIdP());
			statement.setInt(3, order.getQuantity());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
	}

	private final String createUpdateQuery(OrderDetail order) {
		StringBuilder builder = new StringBuilder();
		builder.append("UPDATE OrderDetail SET quantity=? WHERE idO=? AND idP = ?");
		return builder.toString();
	}

	public void updateDetailOrder(OrderDetail order) {
		Connection connection = null;
		PreparedStatement statement = null;
		String query = createUpdateQuery(order);
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, order.getQuantity());
			statement.setInt(2, order.getIdO());
			statement.setInt(3, order.getIdP());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
	}
	
	private String createSelectQuery(String field) {
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT * FROM OrderDetail WHERE " + field + "=?");
		return builder.toString();
	}
		
	public List<OrderDetail> findByIdO(int idO) {
		List<OrderDetail> list = new ArrayList<OrderDetail>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = createSelectQuery("idO");
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, idO);
			resultSet = statement.executeQuery();
		    while(resultSet.next()) {
		    	list.add(new OrderDetail(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3)));
		    }
		    return list;
		}catch(SQLException e) {
			LOGGER.log(Level.WARNING, "OrderDetail" + "DAO: findById " + e.getMessage());
		}
		finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
	}
	
	private final String createSelectAllQuery() {
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT * FROM OrderDetail" + ";");
		System.out.println(builder.toString());
		return builder.toString();
	}
	
	public List<OrderDetail> selectAll(){
		List<OrderDetail> list = new ArrayList<OrderDetail>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = createSelectAllQuery();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();
			 while(resultSet.next()) {
			    	list.add(new OrderDetail(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3)));
			    }
			    return list;
		}catch(SQLException e) {
			LOGGER.log(Level.WARNING, "OrderDetail"+ "DAO: SELECT ALL" + e.getMessage());
		}
		finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
	}
	
	private String createDeleteQuery(String field) {
		StringBuilder builder = new StringBuilder();
		builder.append("DELETE FROM OrderDetail" + " WHERE " + field + "=?" + ";");
		System.out.println(builder.toString());
		return builder.toString();
	}
	
	public void delete(int id){
		Connection connection = null;
		PreparedStatement statement = null;
		String query = createDeleteQuery("idO");
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			statement.executeUpdate();
			System.out.println("row deleted");
		}catch(SQLException e) {
			LOGGER.log(Level.WARNING, "OrderDetail"+ "DAO: delete" + e.getMessage());
		}
		finally {
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
	}
}
