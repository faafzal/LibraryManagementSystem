package librarymanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This it the database class, 
 * it opens and closes a connection to the database,
 * and deletes tables
 * @author fafzal
 *
 */
public class Database{
	
	//protected connection variable
	protected Connection conn = null;

	/*
	 * Open a connection to the sqlite database
	 */
	public void openConn(){
		try{
			Class.forName("org.sqlite.JDBC").newInstance();
			this.conn = DriverManager.getConnection("jdbc:sqlite:libraryDB.db");
		}catch(Exception e){
			System.out.println("Error: " + e);
			System.exit(0);
		}
	}
	
	/*
	 * Close the connection
	 */
	public void closeConn(){
		try{
			this.conn.close();
		} catch (SQLException e) {
			System.out.println("Error: " + e);
			System.exit(0);

		}
	}
	
	/*
	 * Delete a table
	 */
	public void delete(String table){
		this.openConn();

		try {
			Statement state = this.conn.createStatement();
			String del = "DROP TABLE "+table+";";
			state.executeUpdate(del);
			state.close();
		} catch ( Exception e ) {
			System.out.println("Error: " + e);
			System.exit(0);
		}

		this.closeConn();	
	}
}
