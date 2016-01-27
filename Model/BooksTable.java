package librarymanagementsystem;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 * This is the model for my books table,
 * it handles queries to the books table
 * it extends the Database Class
 * @author fafzal
 *
 */
public class BooksTable extends Database{
	
	// constructor calls the createBooksTable method
	public BooksTable(){
		
		// create a books table
		this.createBooksTable();
		
	}
	
	/*
	 * This method creates a books table, if there isn't one already
	 */
	public void createBooksTable(){
		
	    this.openConn();
		
	    try {

	      Statement state = this.conn.createStatement();
	      
	      String create = "CREATE TABLE IF NOT EXISTS BOOKS " +
	                   "(ID INTEGER PRIMARY KEY  AUTOINCREMENT," +
	                   " TITLE          TEXT    NOT NULL, " + 
	                   " AUTHOR         TEXT    NOT NULL, " + 
	                   " GENRE          TEXT	NOT NULL)";
	      
	      state.executeUpdate(create);
	      state.close();
	      
	    } catch (Exception e ) {
	    	
	    	System.out.println("Error: " + e);
	    	System.exit(0);
	    	
	    }
	    
	    this.closeConn();
	   
	}
	
	/*
	 * This method inserts a book, given title, author's name, and genre
	 */
	public void insertBook(String t, String a, String g){
		
		//checks if the title is already in the table
		if(this.containsTitle(t) == true){
			
			//if it is, return (No duplicates)
			return;
			
		}
		
		//open connection
		this.openConn();
		
	    try {

	      Statement state = this.conn.createStatement();
	      
	      String insert = "INSERT INTO BOOKS (TITLE,AUTHOR,GENRE)" +
	                   	  "VALUES ('" +t+ "','"+a+"','"+g+"');";
	      
	      state.executeUpdate(insert);
	
	      state.close();
	  
	    } catch ( Exception e ) {
	    	
	    	System.out.println("Error: " + e);
	    	System.exit(0);
	    	
	    }
	    
	    //close connection
	    this.closeConn();
		
	}
	
	/*
	 * This method checks to see if the title is in the table
	 */
	public boolean containsTitle(String t){
		
		boolean contains = false;
		
		this.openConn();
		
	    try {

	      Statement state = this.conn.createStatement();
	      
	      ResultSet len = state.executeQuery("SELECT COUNT(*) FROM BOOKS WHERE TITLE = '"+t+"'");
	      len.next();
	      if(len.getInt(1) > 0){
	    	  
	    	  contains = true;
	    	  
	      }
	      len.close();
	      state.close();
	 
	    } catch ( Exception e ) {
	    	
	    	System.out.println("Error: " + e);
	        System.exit(0);
	      
	    }
	   
		this.closeConn();
		
		return contains;
		
	}
	
	/*
	 * This method selects all titles for a specific genre
	 */
	public String[] selectTitles(String g){
		
		String[] titles = null;
		
		this.openConn();
		
	    try {

	      Statement state = this.conn.createStatement();
	      
	      ResultSet len = state.executeQuery("SELECT COUNT(*) FROM BOOKS WHERE GENRE = '"+g+"'");
	      len.next();
	      titles = new String[len.getInt(1)];
	      
	      ResultSet rs = state.executeQuery( "SELECT * FROM BOOKS WHERE GENRE = '"+g+"';");
	      
	      int index = 0;
	      
	      while ( rs.next() ) {
	    		  
	    	  titles[index] = rs.getString("title") + " By " + rs.getString("author");
	    	  index++;
	       
	      }
	      
	      len.close();
	      rs.close();
	      state.close();
	 
	    } catch ( Exception e ) {
	    	
	    	System.out.println("Error: " + e);
	        System.exit(0);
	      
	    }
	   
		this.closeConn();
		
		return titles;
		
	}
	
	/*
	 * This method selects all genres once
	 */
	public String[] selectAllGenres(){
		
		this.openConn();
		
		String[] genres = null;
		
	    try {

	      Statement state = this.conn.createStatement();
	      
	      ResultSet len = state.executeQuery("SELECT COUNT(*) FROM BOOKS");
	      len.next();
	      genres = new String[len.getInt(1)];
	      
	      ResultSet rs = state.executeQuery( "SELECT DISTINCT genre FROM BOOKS;" );
	      
	      int index = 0;
	      
	      while ( rs.next() ) {
	    		  
	    	 genres[index] = rs.getString("genre");	  
	    	 index++;
	       
	      }
	      
	      rs.close();
	      state.close();
	 
	    } catch ( Exception e ) {
	    	
	    	System.out.println("Error: " + e);
	        System.exit(0);
	      
	    }
	   
		this.closeConn();
		
		return genres;
		
	}

}
