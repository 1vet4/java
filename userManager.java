package swingex;

import java.sql.*;

public class userManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	public boolean validate (String password) {
		boolean validation=false;
		if(
				password.length()>=8 &&
				password.matches(".*[a-z]+.*") &&
				password.matches(".*[0-9]+.*")) {
			
						validation=true;
		}
				
		return validation;
	}
	public boolean checkIfUsernameAvailable(Connection con,String occ, String us) { 
		
		boolean val=true;
		
			try {
				
				String query="SELECT * FROM "+occ+" WHERE username=?";
				PreparedStatement ps=con.prepareStatement(query);
				ps.setString(1,us);
				ResultSet num=ps.executeQuery();
					if(num.next()!=false) {
						
						val=false;
						
					}
					
				ps.close();
				num.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		return val;
	}
	public boolean checkIfEmailAvailable(Connection con, String occ, String em) {
		boolean val=true;
		
		try {
			
			PreparedStatement ps=con.prepareStatement("SELECT * FROM "+occ+" WHERE email = ?");
			ps.setString(1,em);
			ResultSet num=ps.executeQuery();
				if(num.next()!=false) {
					
					val=false;
					
				}
			ps.close();
			num.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	return val;
		
	}
	public boolean matchingPassword(String pass,String passRepeat) {
		
		boolean val=false;
			if(pass.equals(passRepeat)) {
				
				val=true;
				
			}
		return val;
	}
	
	public void insertData(Connection con,String occ,String pass, String us, String em) {
		
		try {
		
		String sql="INSERT INTO "+occ+" (username,password,email)"+"VALUES (?,?,?)";
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setString(1, us);
		statement.setString(2, pass);
		statement.setString(3, em);
		int rows=statement.executeUpdate();
		if(rows>0) {
			System.out.println("new user");
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
public void insertIntoTeachers(Connection con,String pass, String us, String em) {
		
		try {
		
		String sql="INSERT INTO teachers (username,password,email)"+"VALUES (?,?,?)";
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setString(1, us);
		statement.setString(2, pass);
		statement.setString(3, em);
		int rows=statement.executeUpdate();
		if(rows>0) {
			System.out.println("new user");
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}

	

