import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.activation.DataHandler;

import com.mysql.jdbc.PreparedStatement;

//import Helper.DBHandler;

// Do not import com.mysql.jdbc.*
// or you will have problems!

public class Main {

	//static private DBHandler dbHandler;
	//static private Connection connection;
	static private java.sql.PreparedStatement preparedStatement;
	
	
	
	public static void main(String[] args) throws SQLException,
			ClassNotFoundException {
		
		
		//DbCon();

//		dbHandler = new DBHandler();
//		connection = dbHandler.getDbConnection();

		// writeToDB();
		//readFromDB();
		//updateDB("yyyyyy","zzzzzz",8);
		updateDB("sri", "vasthav", 9);
	}
	
	
	

	   public static void DbCon() throws SQLException {
	        try {
	            Class.forName("com.mysql.jdbc.Driver").newInstance();
	        } catch (Exception ex) {
	        }
	    

	        Connection connection = 
					DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","manager");
			
			System.out.println("Database is connected: " + connection.getCatalog());
			
	   }
	   
//	   public Connection dbConnection() throws SQLException{
//		   
//		   
//		   Connection dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","manager");
//		   
//		   return dbConnection();
//	   }
			

	public static void writeToDB() throws SQLException {
		String insert = "INSERT INTO users (firstname, lastname)"
				+ "VALUES(?,?)";
		Connection connection = 
				DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","manager");

	
		preparedStatement = connection.prepareStatement(insert);

		preparedStatement.setString(1, "llllll");
		preparedStatement.setString(2, "xxxxx");
		preparedStatement.executeUpdate();
	}

	public static void readFromDB() throws SQLException {
		String query = "SELECT * from users";
		Connection connection = 
				DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","manager");

		preparedStatement = connection.prepareStatement(query);

		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			System.out.println("Names: " + resultSet.getString("firstname")
					+ " " + resultSet.getString("lastname"));

		}
	}

	public static void updateDB(String firstname, String lastname, int id)
			throws SQLException {

		String query = "UPDATE users SET firstname= ?, lastname= ?"
				+ "where userid= ?";
		Connection connection = 
				DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","manager");
		
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, firstname);
		preparedStatement.setString(2, lastname);
		preparedStatement.setInt(3, id);
		
		preparedStatement.executeUpdate();

	}
	
	public static void deleteDB(int id) throws SQLException{
	
	     String query = "DELETE FROM users where userid= ?";
	     
	     Connection connection = 
					DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","manager");
	     try {
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setInt(1, id);
			
			preparedStatement.execute();
			
			connection.close();
			
		} catch (SQLException e) {
			
			System.err.println("Got an exception! ");
		    System.err.println(e.getMessage());
		}
	     
	}
}
	
	
