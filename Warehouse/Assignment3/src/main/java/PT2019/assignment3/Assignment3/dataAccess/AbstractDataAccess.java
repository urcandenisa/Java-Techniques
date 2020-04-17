package PT2019.assignment3.Assignment3.dataAccess;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import PT2019.assignment3.Assignment3.connection.ConnectionFactory;

public class AbstractDataAccess<T> {
	protected static final Logger LOGGER = Logger.getLogger(AbstractDataAccess.class.getName());

	private final Class<T> type;

	@SuppressWarnings("unchecked")
	public AbstractDataAccess() {
		this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	private String createSelectQuery(String field) {
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT ");
		builder.append("*");
		builder.append(" FROM ");
		builder.append(type.getSimpleName());
		builder.append(" WHERE " + field + "=?");
		System.out.println(builder.toString());
		return builder.toString();
	}

	public T findById(int id) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = createSelectQuery("id");
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			List<T> list = createObjects(resultSet);
			if (list.isEmpty())
				return null;
			else {
				System.out.println(list);
				return list.get(0);
			}

		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, type.getName() + "DAO: findById " + e.getMessage());
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
	}

	private String createSelectAllQuery() {
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT * FROM " + type.getSimpleName() + ";");
		System.out.println(builder.toString());
		return builder.toString();
	}

	public List<T> selectAll() {

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = createSelectAllQuery();
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();
			return createObjects(resultSet);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, type.getSimpleName() + "DAO: SELECT ALL" + e.getMessage());
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
	}

	private String createDeleteQuery(String field) {
		StringBuilder builder = new StringBuilder();
		builder.append("DELETE FROM " + type.getSimpleName() + " WHERE " + field + "=?" + ";");
		System.out.println(builder.toString());
		return builder.toString();
	}

	public void delete(int id) {
		Connection connection = null;
		PreparedStatement statement = null;
		String query = createDeleteQuery("id");
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			statement.executeUpdate();
			System.out.println("row deleted");
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, type.getSimpleName() + "DAO: delete" + e.getMessage());
		} finally {
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
	}

	private List<T> createObjects(ResultSet resultSet) {
		List<T> list = new ArrayList<T>();
		try {
			while (resultSet.next()) {
				T instance = type.newInstance();
				for (Field field : type.getDeclaredFields()) {
					field.setAccessible(true);
					Object value = resultSet.getObject(field.getName());
					PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), type);
					Method method = propertyDescriptor.getWriteMethod();
					method.invoke(instance, value);
				}
				list.add(instance);
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IntrospectionException e) {
			e.printStackTrace();
		}
		return list;
	}

	public JList<String>createJComboBox(List<? extends Object> list) {
		DefaultListModel<String>l2 = new DefaultListModel<>();
		List<Object> columnNames = new ArrayList<Object>();
		int length = 0;
		if(list.isEmpty() == true) return new JList<>();
		for (Field field : list.get(0).getClass().getDeclaredFields()) {
			field.setAccessible(true);
			length++;
			columnNames.add(field.getName().toString());
		}

		int i = 0;
		int j = 0;
		for (Object obj : list) {
			i = 0;
			String string = new String();
			for (Field field : list.get(i).getClass().getDeclaredFields()) {
				field.setAccessible(true);
				Object value;
				try {
					value = field.get(obj);
					string += field.getName() + ":" + value + " ";
					i++;
					if(i > 1) break;
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
			l2.addElement(string);
		}
		JList<String>list1 = new JList<>(l2);
	return list1;
	}
	
	public JList<String>createJList(List<? extends Object> list) {
			DefaultListModel<String>l2 = new DefaultListModel<>();
			List<Object> columnNames = new ArrayList<Object>();
			int length = 0;
			for (Field field : list.get(0).getClass().getDeclaredFields()) {
				field.setAccessible(true);
				length++;
				columnNames.add(field.getName().toString());
			}

			int i = 0;
			int j = 0;
			for (Object obj : list) {
				i = 0;
				String string = new String();
				for (Field field : list.get(i).getClass().getDeclaredFields()) {
					field.setAccessible(true);
					Object value;
					try {
						value = field.get(obj);
						string += field.getName() + ":" + value + " ";
						i++;
						if(i > 1) break;
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
				}
				l2.addElement(string);
			}
			JList<String>list1 = new JList<>(l2);
		return list1;
	}

	public JTable createJTable(List<? extends Object> list) {
		JTable table;
		List<Object[]> rowData = new ArrayList<Object[]>();
		List<Object> columnNames = new ArrayList<Object>();
		int length = 0;
		for (Field field : list.get(0).getClass().getDeclaredFields()) {
			field.setAccessible(true);
			length++;
			columnNames.add(field.getName().toString());
		}

		int i = 0;
		for (Object obj : list) {
			i = 0;
			String[] string = new String[length];
			for (Field field : list.get(i).getClass().getDeclaredFields()) {
				field.setAccessible(true);
				Object value;
				try {
					value = field.get(obj);
					string[i] = " " + value;
					i++;
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
			rowData.add(string);
		}
		Object[][] row = rowData.toArray(new Object[][] {});
		Object[] column = columnNames.toArray();
		DefaultTableModel model = new DefaultTableModel(row, column);
		table = new JTable(model);
		return table;
		// return new JTable(rowData, columnNames);
	}

}
