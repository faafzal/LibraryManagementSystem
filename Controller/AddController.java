package librarymanagementsystem;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * This is the Controller for the screen that allows
 * an admin to add books
 * @author fafzal
 *
 */
public class AddController{
	//Global Variables
	private MainFrame mainFrame;
	private AddPanel addPanel;
	private User loggedUser;

	public AddController(MainFrame mf, User u){
		//stores the mainframe that was passed through
		this.mainFrame = mf;
		//stores the user object that was passed through
		this.loggedUser = u;
		//creates a new Add Panel, passes the action listener
		this.addPanel = new AddPanel(new Listener());
		
		//sets mainframe layout to border layout
		this.mainFrame.setLayout(new BorderLayout());
		
		//adds main panel and south panel
		this.mainFrame.add(this.addPanel.getMainPanel(), BorderLayout.CENTER);
		this.mainFrame.add(this.addPanel.getSouthPanel(), BorderLayout.SOUTH);
		
		//revalidates main frame
		this.mainFrame.revalidate();
	}
	
	/*
	 * This method is called when the enter button is clicked
	 */
	public void onEnter(){
		/*
		 * Stores the add panel text fields in local variables
		 */
		String t = this.addPanel.getTitleField().getText();
		String a  = this.addPanel.getAuthorField().getText();
		String g = this.addPanel.getGenreField().getText();
		
		//checks to make sure text fields are not empty
		if(!(t.equals("") || a.equals("") || g.equals(""))){
			//creates a new books table object
			BooksTable booksTable = new BooksTable();
			//inserts books
			booksTable.insertBook(t, a, g);
			
			//remove panels
			this.mainFrame.remove(this.addPanel.getMainPanel());
			this.mainFrame.remove(this.addPanel.getSouthPanel());
			
			//call new instance of current class
			new AddController(this.mainFrame, this.loggedUser);
		}
	}
	
	/*
	 * This method is called when the profile button is clicked
	 */
	public void onProfile(){
		//remove both panels
		this.mainFrame.remove(this.addPanel.getMainPanel());
		this.mainFrame.remove(this.addPanel.getSouthPanel());
		
		//call the controller for the Profile Panel
		new ProfileController(this.mainFrame, this.loggedUser);
	}
	
	/*
	 * This method is called when the logout button is clicked
	 */
	public void onLogout(){
		//remove both panels
		this.mainFrame.remove(this.addPanel.getMainPanel());
		this.mainFrame.remove(this.addPanel.getSouthPanel());
		
		//call the controller for the Home Panel
		new HomeController(this.mainFrame);
	}
	
	/*
	 * Helper Class for action events
	 */
	private class Listener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			JButton btn = (JButton) e.getSource();
			
			/*
			 * Checks which button is clicked and calls appropriate methods
			 */
			if(btn == addPanel.getEnterBtn()){
				onEnter();
			}else if(btn == addPanel.getProfileBtn()){
				onProfile();
			}else if(btn == addPanel.getLogoutBtn()){
				onLogout();
			}
		}
	}
}
