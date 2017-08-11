package librarymanagementsystem;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * This is the Controller Class for the 
 * Genre Panel
 * @author fafzal
 *
 */
public class GenreController{
	//Global variables
	private MainFrame mainFrame;
	private GenrePanel genrePanel;
	private User loggedUser;
	private BooksTable booksTable;
	
	public GenreController(MainFrame mf, User u){
		//store the main frame that is passed through
		this.mainFrame = mf;
		//store user object that is passed through
		this.loggedUser = u;
		//create new BooksTable object
		this.booksTable = new BooksTable();
		//create new GenrePanel
		this.genrePanel = new GenrePanel(new Listener(), this.booksTable.selectAllGenres());
		
		//set main frame layout to border layout
		this.mainFrame.setLayout(new BorderLayout());
		//add main panel and south panel
		this.mainFrame.add(this.genrePanel.getMainPanel(), BorderLayout.CENTER);
		this.mainFrame.add(this.genrePanel.getSouthPanel(), BorderLayout.SOUTH);
		//revalidate the main frame
		this.mainFrame.revalidate();
	}
	
	/*
	 * This method is called when the Choose Button is clicked
	 */
	public void onChoose(){
		//make sure user selected a genre
		if(this.genrePanel.getGenreList().getSelectedValue() != null){
			//remove panels
			this.mainFrame.remove(this.genrePanel.getMainPanel());
			this.mainFrame.remove(this.genrePanel.getSouthPanel());
			
			//call Controller for the Books Panel
			new BooksController(this.mainFrame, this.loggedUser, this.genrePanel.getGenreList().getSelectedValue().toString());
		}	
	}
	
	/*
	 * This method is called when the Profile Button is clicked
	 */
	public void onProfile(){
		//remove panels
		this.mainFrame.remove(this.genrePanel.getMainPanel());
		this.mainFrame.remove(this.genrePanel.getSouthPanel());
		
		//call Controller for the Profile Panel
		new ProfileController(this.mainFrame, this.loggedUser);	
	}
	
	/*
	 * This method is called wehn the Logout Button is clicked
	 */
	public void onLogout(){
		//remove panels
		this.mainFrame.remove(this.genrePanel.getMainPanel());
		this.mainFrame.remove(this.genrePanel.getSouthPanel());
		
		//call Controller for Home Panel
		new HomeController(this.mainFrame);
	}

	/*
	 * Helper Class For Action Events
	 */
	private class Listener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			JButton btn = (JButton) e.getSource();
			
			/*
			 * Check to see which button is clicked and call the appropriate method
			 */
			if(btn == genrePanel.getChooseBtn()){
				onChoose();
			}else if(btn == genrePanel.getProfileBtn()){
				onProfile();
			}else if(btn == genrePanel.getLogoutBtn()){
				onLogout();
			}
		}
	}
}
