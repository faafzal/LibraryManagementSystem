package librarymanagementsystem;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * This is the Controller Class for the Login Screen
 * @author fafzal
 *
 */
public class LoginController{
	//Global Variables
	private MainFrame mainFrame;
	private LoginPanel loginPanel;
	
	public LoginController(MainFrame mf){
		//store main frame that is passed in
		this.mainFrame = mf;
		
		//create instance of login panel
		this.loginPanel = new LoginPanel(new Listener());
	
		//set mainframe layout to GridBag
		this.mainFrame.setLayout(new GridBagLayout());
		
		//add login panel to main frame
		this.mainFrame.add(this.loginPanel.getPanel());
		
		//revalidate the mainframe
		this.mainFrame.revalidate();
	}
	
	/*
	 * This method is called if login button is clicked
	 */
	public void onLogin(){
		//create an instance of UsersTable
		UsersTable usersTable =  new UsersTable();
		
		//store what was in the text fields into variables
		String user = this.loginPanel.getUserField().getText().toLowerCase(); 
		String pass = new String(this.loginPanel.getPassField().getPassword().clone()).toLowerCase();

		//store login state
		boolean loginSuccess = usersTable.checkLogin(user, pass);
		
		//Make sure text field was not empty
		if(!(user.equals("") || pass.equals(""))){
			//check if login was a succcess
			if(loginSuccess){
				//if it was, remove current panel
				this.mainFrame.remove(this.loginPanel.getPanel());
				
				// create a new user object given the appropriate ID
				User u = new User(usersTable.findUser(user));
				
				//call the controller for profile panel
				new ProfileController(this.mainFrame, u);
			}else{
				//else, show fail message
				this.loginPanel.failMessage();
				//revalidate main frame
				this.mainFrame.revalidate();	
			}	
		}
	}
	
	/*
	 * This method is called if back button is clicked
	 */
	public void onBack(){
		//remove current panel
		this.mainFrame.remove(this.loginPanel.getPanel());
		//call controller for home panel
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
			 * Checks which button was clicked and calls the appropriate method
			 */
			if(btn == loginPanel.getLoginBtn()){	
				onLogin();
			}else if(btn == loginPanel.getBackBtn()){
				onBack();
			}
		}
	}
}
