package librarymanagementsystem;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * This is the Controller Class for the Profile Screen
 * @author fafzal
 *
 */
public class ProfileController{
	
	//Global Variables
	private MainFrame mainFrame;
	private ProfilePanel profilePanel;
	private User loggedUser;
	
	public ProfileController(MainFrame mf, User u){
		//stores the main frame that is passed through
		this.mainFrame = mf;
		//stores the user object that is passed through
		this.loggedUser = u;
		//create a new profile panel object
		this.profilePanel = new ProfilePanel(new Listener(), this.loggedUser.getFirstName(), this.loggedUser.getLastName(), this.loggedUser.getBooks(), this.loggedUser.getIsAdmin());

		//set main frame's layout to BorderLayout
		this.mainFrame.setLayout(new BorderLayout());
		//add main panel to main frame
		this.mainFrame.add(this.profilePanel.getMainPanel(), BorderLayout.CENTER);
		//add south panel to main frame
		this.mainFrame.add(this.profilePanel.getSouthPanel(), BorderLayout.SOUTH);
		//revalidate mainframe
		this.mainFrame.revalidate();
	}
	
	/*
	 * This method is called when the user clicks the return button
	 */
	public void onReturn(){
		// checks to make sure user has selected a book
		if(this.profilePanel.getMyBooks().getSelectedValue() != null){
			//create new instance of user table
			UsersTable usersTable = new UsersTable();
			
			// updates the user's borrowing field in the database
			usersTable.updateBorrowing(this.loggedUser.getLoggedID(), this.loggedUser.removeBook(this.profilePanel.getMyBooks().getSelectedValue().toString()));
			//fetches the data again for the logged in user
			this.loggedUser.fetchData();
			
			//removes panels
			this.mainFrame.remove(this.profilePanel.getMainPanel());
			this.mainFrame.remove(this.profilePanel.getSouthPanel());
			
			//calls controller for profile class, refreshing current page
			new ProfileController(this.mainFrame, this.loggedUser);
		}
	}
	
	/*
	 * This method is called when the user clicks the add button
	 */
	public void onAdd(){
		//removes both panels from main frame
		this.mainFrame.remove(this.profilePanel.getMainPanel());
		this.mainFrame.remove(this.profilePanel.getSouthPanel());
		
		//calls controller for the Add Panel
		new AddController(this.mainFrame, this.loggedUser);
	}
	
	/*
	 * This method is called when the user clicks the find button
	 */
	public void onFind(){
		//removes both panels from main frame
		this.mainFrame.remove(this.profilePanel.getMainPanel());
		this.mainFrame.remove(this.profilePanel.getSouthPanel());
		
		//calls controller for Genre Panel
		new GenreController(this.mainFrame, this.loggedUser);
	}
	
	/*
	 * This method is called when the user clicks the logout button
	 */
	public void onLogout(){
		this.mainFrame.remove(this.profilePanel.getMainPanel());
		this.mainFrame.remove(this.profilePanel.getSouthPanel());
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
			 * Checks which button is clicked, then calls appropriate methods
			 */
			if(btn == profilePanel.getReturnBtn()){
				onReturn();
			}else if(btn == profilePanel.getAddBtn()){
				onAdd();
			}else if(btn == profilePanel.getFindBtn()){
				onFind();
			}else if(btn == profilePanel.getLogoutBtn()){
				onLogout();
			}
		}
	}
}
