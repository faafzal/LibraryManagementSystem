package librarymanagementsystem;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * This is the Controller Class for the Register Screen
 * @author fafzal
 *
 */
public class RegisterController {
	
	//Global Variables
	private MainFrame mainFrame;
	private RegisterPanel registerPanel;

	public RegisterController(MainFrame mf){
		
		this.mainFrame = mf;
		
		//Create new instance of Register Panel
		this.registerPanel = new RegisterPanel(new Listener());
		
		//set the main frame layout
		this.mainFrame.setLayout(new GridBagLayout());
		
		//add Register Panel to the Main Frame
		this.mainFrame.add(this.registerPanel.getPanel());
		
		//revalidate the main frame
		this.mainFrame.revalidate();
		
	}
	
	/*
	 * This method is called when the register button is clicked.
	 */
	public void onRegister(){
		
		//create new instance of Users Table
		UsersTable usersTable = new UsersTable();
		
		/*
		 * Store the text field into variables, make them lowercase.
		 */
		String first = this.registerPanel.getFirstField().getText().toLowerCase();
		String last = this.registerPanel.getLastField().getText().toLowerCase();
		String user = this.registerPanel.getUserField().getText().toLowerCase();
		String pass = new String(this.registerPanel.getPassField().getPassword().clone()).toLowerCase();
		
		//get the user id from the users table
		int id = usersTable.findUser(user);
		
		//check to makae suere the text fields are not empty
		if(!(first.equals("") || last.equals("") || user.equals("") || pass.equals(""))){
			
			//check if id is 0 or if user is registered
			if(id == 0){
				
				//if it is not registered, register the user, NO for regular user, YES for admin
				usersTable.insertUser(first, last, user, pass, "YES");
				//show success message
				this.registerPanel.successMesage();
				//refresh
				this.mainFrame.revalidate();
				
			}else if(id > 0){
				
				//show fail message
				this.registerPanel.failMessage();
				//refresh
				this.mainFrame.revalidate();
				
			}
			
		}
		
	}
	
	/*
	 * This method is called when the back button is clicked
	 */
	public void onBack(){
		
		//remove current panel
		this.mainFrame.remove(this.registerPanel.getPanel());
		//call controller for home panel
		new HomeController(this.mainFrame);
		
	}
	
	/*
	 * Action Listener Helper Class
	 */
	private class Listener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			JButton btn = (JButton) e.getSource();
			
			/*
			 * Checks which btn that was clicked, and calls appropriate method.
			 */
			if(btn == registerPanel.getRegisterBtn()){
				
				onRegister();
				
			}else if(btn == registerPanel.getBackBtn()){
				
				onBack();
				
			}
			
		}
		
	}
	
	
}
