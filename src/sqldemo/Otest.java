package sqldemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Otest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		// 1、加载驱动
		Class.forName("org.postgresql.Driver");

		// 2、准�?连接数据参数
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username = "postgres";
		String password = "ltyang";

		// 3、连接数据�?
		Connection connection = DriverManager.getConnection(url, username, password);

		// 4、查询sql
		String sql = "select * from demo2";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();

		// 5、�?查询出�?数据 添�?到�?合中
		List<String> datas = new ArrayList<>();
		while (resultSet.next()) {
			String id = resultSet.getString("id");
			String name = resultSet.getString("name");
			String sex = resultSet.getString("sex");
			String phone = resultSet.getString("phone");
			String birthday = resultSet.getString("birthday");
			String age = resultSet.getString("age");
			String line = id + "," + name + "," + sex + "," + phone + "," + birthday + "," + age;
			datas.add(line);
		}

		// 6、�?�?合中�?数据 写�?��?件

		File file = new File("D://a.csv");
		FileOutputStream outputStream = new FileOutputStream(file);

		for (String data : datas) {
			if (data != null && !data.equals("")) {
				outputStream.write(data.getBytes());
			}

		}

	}
}
