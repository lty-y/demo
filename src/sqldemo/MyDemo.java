package sqldemo;

import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String user = "postgres";
		String password = "ltyang";
		DButil dbu = new DButil();
		dbu.connection = DriverManager.getConnection(url, user, password);
		String sql = "insert into student(name,age,sex) values('俊翔',25,'男')";
		// dbu.zsg(sql);
		sql = "select * from student where age=25";
		dbu.query(sql);
		sql = "update student set sex='女' where name='俊翔'";
		dbu.zsg(sql);
		sql = "select distinct name from student";
		dbu.query(sql);

	}

}
