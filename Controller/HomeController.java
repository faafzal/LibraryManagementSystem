package librarymanagementsystem;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * Controller For The Home Screen
 * @author fafzal
 *
 */
public class HomeController{
	
	//Global Variables
	private MainFrame mainFrame;
	private HomePanel homePanel;
	
	public HomeController(MainFrame mf){
		this.mainFrame = mf;
		
		//Create Home Panel. This it the view for the first screen
		this.homePanel = new HomePanel(new Listener());
		
		//set Main Frame layout
		this.mainFrame.setLayout(new GridBagLayout());
		
		//add Home Panel to Main Frame
		this.mainFrame.add(this.homePanel.getPanel());
		
		//Revalidate the Main Frame, basically a repaint
		this.mainFrame.revalidate();
	}
	
	/*
	 * This gets called when the register button is clicked.
	 */
	public void onRegister(){
		//Remove current Panel
		mainFrame.remove(homePanel.getPanel());
		//Call the Controller for Register Panel
		new RegisterController(this.mainFrame);
	}
	
	/*
	 * This gets called when the login button is clicked.
	 */
	public void onLogin(){
		//Remove current Panel
		mainFrame.remove(homePanel.getPanel());
		// Call Controller for Login Panel
		new LoginController(this.mainFrame);
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
			if(btn == homePanel.getRegisterBtn()){
				onRegister();
			}else if(btn == homePanel.getLoginBtn()){
				onLogin();
			}
		}
	}
}
