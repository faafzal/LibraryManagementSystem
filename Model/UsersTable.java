package librarymanagementsystem;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 * This is the model for my users table,
 * it extends database and handles all the database
 * queries to the Users Table
 * @author fafzal
 *
 */
public class UsersTable extends Database{
	
	//constructor calls the create table method
	public UsersTable(){
		this.createUserTable();
	}
	
	/*
	 * This method creates a Users Table if there is not one already
	 */
	public void createUserTable(){
		this.openConn();

		try {
			Statement state = this.conn.createStatement();

			String create = "CREATE TABLE IF NOT EXISTS USERS " +
					"(ID INTEGER PRIMARY KEY  AUTOINCREMENT," +
					" FIRST           TEXT    NOT NULL, " + 
					" LAST            TEXT     NOT NULL, " + 
					" USERNAME         TEXT	   NOT NULL, " + 
					" PASSWORD         CHAR(50) NOT NULL, "+
					" BOOKS			  TEXT		NOT NULL, "+
					" ADMIN			  CHAR(50)	NOT NULL)";

			state.executeUpdate(create);
			state.close();
		} catch (Exception e ) {
			System.out.println("Error: " + e);
			System.exit(0);
		}

		this.closeConn();
	}
	
	/*
	 * This method inserts a user in to the users table, given first name,
	 * last name, user name, password, and admin value
	 */
	public void insertUser(String f, String l, String u, String p, String a){
		this.openConn();

		try {
			Statement state = this.conn.createStatement();

			String insert = "INSERT INTO USERS (FIRST,LAST,USERNAME,PASSWORD,BOOKS,ADMIN)" +
					  "VALUES ('" +f+ "','"+l+"','"+u+"','"+p+"','','"+a+"')";

			state.executeUpdate(insert);

			state.close();
		} catch ( Exception e ) {
			System.out.println("Error: " + e);
			System.exit(0);
		}

		this.closeConn();
	}
	
	/*
	 * This method selects data for the user by id
	 */
	public String[] selectUser(int id){
		String[] info = new String[5];

		this.openConn();

		try {
			Statement state = this.conn.createStatement();

			ResultSet rs = state.executeQuery( "SELECT * FROM USERS where ID = "+id+";" );

			while ( rs.next() ) {
				info[0] = rs.getString("first");
				info[1] = rs.getString("last");
				info[2] = rs.getString("username");
				info[3] = rs.getString("books");
				info[4] = rs.getString("admin");
			}

			rs.close();
			state.close();
		} catch ( Exception e ) {
			System.out.println("Error: " + e);
			System.exit(0);
		}

		this.closeConn();

		return info;
	}
	
	/*
	 * This method adds a title to the users book borrowing list
	 */
	public void updateBorrowing(int id, String title){
		this.openConn();

		try {
			Statement state = this.conn.createStatement();
			String update = "UPDATE USERS set BOOKS = '"+title+"' WHERE ID = '"+id+"'";
			state.executeUpdate(update);

			state.close();
		} catch (Exception e) {
			System.err.println("Error " + e.getMessage());
			System.exit(0);
		}

		this.closeConn();
	}
	
	/*
	 * This methods checks login, given a username and password
	 */
	public boolean checkLogin(String user, String pass){
		this.openConn();

		boolean found = false;

		try {
			Statement state = this.conn.createStatement();

			ResultSet rs = state.executeQuery("SELECT ID FROM USERS where USERNAME = '"+user+"'" + 
							  "AND PASSWORD = '"+pass+"';");

			if(rs.next() == true){
				found = true;
			}

			rs.close();
			state.close();
		} catch ( Exception e ) {
			System.out.println("Error: " + e);
			System.exit(0);
		}

		this.closeConn();

		return found;
	}
	
	/*
	 * This method finds a user, given username and returns the id
	 */
	public int findUser(String user){
		this.openConn();

		int id = 0;

		try {
			Statement state = this.conn.createStatement();

			ResultSet rs = state.executeQuery("SELECT ID FROM USERS where USERNAME = '"+user+"';");

			if(rs.next() == true){
				id = rs.getInt("id");
			}

			rs.close();
			state.close();
		} catch ( Exception e ) {
			System.out.println("Error: " + e);
			System.exit(0);
		}

		this.closeConn();

		return id;
	}
}
