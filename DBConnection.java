package swingex;
import java.sql.*;
public class DBConnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public Connection getDBConnection() {
		Connection con=null;
		try {
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sampledb", "root", "tima123");
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}
