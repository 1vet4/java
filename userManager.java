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
	
	public int insertNewUser(Connection con,String occ,String pass, String us, String em) {
		int rows=0;
		try {
		
		String sql="INSERT INTO "+occ+" (username,password,email)"+"VALUES (?,?,?)";
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setString(1, us);
		statement.setString(2, pass);
		statement.setString(3, em);
		rows=statement.executeUpdate();
		if(rows>0) {
			System.out.println("new user");
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rows;
	}
	public boolean insertCourse(Connection con,String name) {
		boolean val=false;
		try {
			
			String sql="INSERT INTO course (name) VALUES (?)";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, name);
			int rows=statement.executeUpdate();
			if(rows>0) {
				System.out.println("new course");
				val=true;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return val;
	}
	public boolean updatePassword( Connection con, String newPass, String us,String occ) {
		boolean val=false;
		try {
			
			String sql="UPDATE "+occ+" SET password=? WHERE username=?";
			PreparedStatement statement=con.prepareStatement(sql);
			statement.setString(1,newPass);
			statement.setString(2,us);
			int rows=statement.executeUpdate();
			if(rows>0) {
				val=true;
			}
		
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		return val;
}
		
	public boolean validateLogin(Connection con, String us, String pass, String occ) {
	boolean validation=false;
	try {
		
		PreparedStatement ps=con.prepareStatement("SELECT * FROM "+occ+" WHERE username = ?"+" AND password= ?");
		ps.setString(1,us);
		ps.setString(2,pass);
		ResultSet num=ps.executeQuery();
			if(num.next()!=false) {
				
				validation=true;
				
			}
		ps.close();
		num.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	
	return validation;
}
}

	

