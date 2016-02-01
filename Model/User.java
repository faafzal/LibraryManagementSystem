package librarymanagementsystem;

/**
 * This is an object for one particular user
 * It stores gets the data from the database and stores
 * the user's first name, last name, username, books list, and
 * isAdmin value. The class is called when a user logs in
 * @author fafzal
 *
 */
public class User{
	
	//Global Variables
	private int loggedID = 0;
	private String firstName;
	private String lastName;
	private String username;
	private String[] books;
	private String isAdmin;
	private UsersTable usersTable;
	
	public User(int id){
		
		//create a new users table object
		this.usersTable = new UsersTable();
		// Set loggedID to id that is passed in
		this.loggedID = id;
		//fetch the users data
		this.fetchData();
		
	}
	
	/*
	 * This method will fetch the users data from the database and store the
	 * values
	 */
	public void fetchData(){
		
		String[] info = this.usersTable.selectUser(this.loggedID);
		this.firstName = Character.toUpperCase(info[0].charAt(0)) + info[0].substring(1);;
		this.lastName = Character.toUpperCase(info[1].charAt(0)) + info[1].substring(1);
		this.username = info[2];
		this.books = info[3].split(",");
		this.isAdmin = info[4];
		
	}
	
	/*
	 * This method checks to see if the given value is in the given array
	 */
	public boolean isInArray(String val, String[] arr){
		
		for(int i = 0; i < arr.length; i++){
			
			if(arr[i].contains(val)){
				
				return true;
				
			}
			
		}
		
		return false;
	}
	
	/*
	 * This method removes a book from the books list
	 */
	public String removeBook(String b){
		
		String stringBooks = "";
		
		for(int i = 0; i < this.books.length; i++){
			
			if(this.books[i] != b){
				
				stringBooks += this.books[i] + ",";
				
			}
			
		}
		
		return stringBooks;
		
	}
	
	/*
	 * Getters Below
	 */
	public int getLoggedID(){
		
		return this.loggedID;
		
	}
	
	public String getIsAdmin(){
		
		return this.isAdmin;
		
	}
	
	public String getFirstName(){
		
		return this.firstName;
		
	}
	
	public String getLastName(){
		
		return this.lastName;
		
	}
	
	public String getUsername(){
		
		return this.username;
		
	}
	
	public String[] getBooks(){
		
		return this.books;
		
	}

}
