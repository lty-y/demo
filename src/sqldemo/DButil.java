package sqldemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DButil {

	static Connection connection = null;
	public static void zsg(String sql) throws SQLException, ClassNotFoundException {
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		if (sql != null) {
			preparedStatement.execute();
		}
	}

	public static List<String> query(String sql) throws SQLException, ClassNotFoundException {
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		List<String> list = new ArrayList<>();
		while (resultSet.next()) {
			String line = "id:" + resultSet.getInt("id") + "name:" + resultSet.getString("name").trim()
						+ "age:"+ resultSet.getInt("age") + "sex:" + resultSet.getString("sex").trim();
			list.add(line);
		}
		System.out.println(list);
		return list;
	}
}