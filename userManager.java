package swingex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class userManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static boolean validate (String password) {
		boolean validation=false;
		if(
				password.length()>=8 &&
				password.matches(".*[a-z]+.*") &&
				password.matches(".*[0-9]+.*")) {
		validation=true;
		}
				
		return validation;
	}
	
}
	

