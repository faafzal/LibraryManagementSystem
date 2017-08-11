package librarymanagementsystem;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormatSymbols;
import java.util.Calendar;

import javax.swing.JButton;

/**
 * This is the Controller for the Books Panel
 * @author fafzal
 *
 */
public class BooksController {
	//Global Variables
	private MainFrame mainFrame;
	private BooksPanel booksPanel;
	private User loggedUser;
	
	public BooksController(MainFrame mf, User u, String g){
		//store the main frame that is passed in
		this.mainFrame = mf;
		//store the user object that is passed in
		this.loggedUser = u;
		//create Books Table object
		BooksTable booksTable = new BooksTable();
		//create Books Panel object
		this.booksPanel = new BooksPanel(new Listener(), booksTable.selectTitles(g));
		
		//set mainframe layout to border layout
		this.mainFrame.setLayout(new BorderLayout());
		//add main panel and south panel
		this.mainFrame.add(this.booksPanel.getMainPanel(), BorderLayout.CENTER);
		this.mainFrame.add(this.booksPanel.getSouthPanel(), BorderLayout.SOUTH);
		//revalidate the main frame
		this.mainFrame.revalidate();
	}
	
	/*
	 * This method is called wehn the orrow button is clicked
	 */
	public void onBorrow(){
		//checks to see if user has selected a value, if current user is not currently borrowing the book, and user is borrowing less than five books
		if(this.booksPanel.getBookList().getSelectedValue() != null && this.loggedUser.borrowing(this.booksPanel.getBookList().getSelectedValue().toString()) == false && this.loggedUser.getBooks().length < 5){
			//create user table object
			UsersTable usersTable = new UsersTable();

			/*
			 * Set Values For Due Date
			 */
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DAY_OF_MONTH, 7);
			int m = cal.get(Calendar.MONTH);
			int d = cal.get(Calendar.DAY_OF_MONTH);
		    
			DateFormatSymbols dfs = new DateFormatSymbols();
			String[] months = dfs.getMonths();
			
			// updates user's borrowing field
			usersTable.updateBorrowing(this.loggedUser.getLoggedID(), usersTable.selectUser(this.loggedUser.getLoggedID())[3]+this.booksPanel.getBookList().getSelectedValue().toString()+ " " + months[m] + " " + d + ",");
			
			//fetch logged user's data again
			this.loggedUser.fetchData();
			
			//removes panels
			this.mainFrame.remove(this.booksPanel.getMainPanel());
			this.mainFrame.remove(this.booksPanel.getSouthPanel());
			
			//call profile controller
			new ProfileController(this.mainFrame, this.loggedUser);
		}
	}
	
	/*
	 * This method gets called when the back button is clicked
	 */
	public void onBack(){
		//remove both panels
		this.mainFrame.remove(this.booksPanel.getMainPanel());
		this.mainFrame.remove(this.booksPanel.getSouthPanel());
		
		//create new Genre Controller
		new GenreController(this.mainFrame, this.loggedUser);
	}
	
	/*
	 * This method gets called when the profile button is clicked
	 */
	public void onProfile(){
		//removes both panels
		this.mainFrame.remove(this.booksPanel.getMainPanel());
		this.mainFrame.remove(this.booksPanel.getSouthPanel());
		
		//calls profile controller
		new ProfileController(this.mainFrame, this.loggedUser);	
	}
	
	/*
	 * This method gets called when the logout button is clicked
	 */
	public void onLogout(){
		//removes both panels
		this.mainFrame.remove(this.booksPanel.getMainPanel());
		this.mainFrame.remove(this.booksPanel.getSouthPanel());
		
		//calls home controller
		new HomeController(this.mainFrame);
	}
	
	/*
	 * Helper Class for Action Events
	 */
	private class Listener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			JButton btn = (JButton) e.getSource();
			
			/*
			 * Checks to see which button is clicked, then calls appropriate method
			 */
			if(btn == booksPanel.getBorrowBtn()){
				onBorrow();
			}else if(btn == booksPanel.getBackBtn()){
				onBack();
			}else if(btn == booksPanel.getProfileBtn()){
				onProfile();
			}else if(btn == booksPanel.getLogoutBtn()){
				onLogout();
			}
		}
	}	
}
