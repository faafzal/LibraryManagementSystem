package librarymanagementsystem;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * This is the view for my login screen
 * @author fafzal
 *
 */
public class LoginPanel{
	//Global Variables
	private JTextField userField;
	private JPasswordField passField;
	private JButton loginBtn;
	private JButton backBtn;
	private JLabel message;
	private JPanel panel;
	
	public LoginPanel(ActionListener a){
		//create new JPanel
		this.panel = new JPanel();
		//create box layout
		BoxLayout bl = new BoxLayout(this.panel, BoxLayout.Y_AXIS);
		//set panel layout to box layout
		this.panel.setLayout(bl);
		
		/*
		 * Create JLabels
		 */
		JLabel usernameTxt = new JLabel("Username");
		JLabel passwordTxt = new JLabel("Password");
		
		/*
		 * Set Alignments For JLabels
		 */
		usernameTxt.setAlignmentX(Component.RIGHT_ALIGNMENT);
		passwordTxt.setAlignmentX(Component.RIGHT_ALIGNMENT);
		
		// create user JTextField
		this.userField = new JTextField();
		//create pass JPasswordFIeld
		this.passField = new JPasswordField();
		
		/*
		 * Create login button
		 */
		this.loginBtn = new JButton("Login");
		this.loginBtn.setFocusPainted(false);
		this.loginBtn.addActionListener(a);
		
		/*
		 * Create Back Button
		 */
		this.backBtn = new JButton("Back");
		this.backBtn.setFocusPainted(false);
		this.backBtn.addActionListener(a);
		
		/*
		 * create new button panel, and add buttons
		 */
		JPanel btnPanel = new JPanel(new FlowLayout());
		btnPanel.add(this.backBtn);
		btnPanel.add(this.loginBtn);
		
		/*
		 * add everything to the main panel
		 */
		this.panel.add(usernameTxt);
		this.panel.add(this.userField);
		this.panel.add(passwordTxt);
		this.panel.add(this.passField);
		this.panel.add(btnPanel);	
	}
	
	/*
	 * Helper method to empty fields
	 */
	public void emptyFields(){
		this.userField.setText("");
		this.passField.setText("");
	}
	
	/*
	 * This is shown if login is unsuccessful
	 */
	public void failMessage(){
		if(this.message != null){
			this.panel.remove(this.message);
		}
		
		this.emptyFields();
		this.message = new JLabel("Please try again.");
		this.message.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.panel.add(this.message);
	}
	
	/*
	 * Getters Below
	 */
	public JTextField getUserField(){
		return this.userField;
	}
	
	public JPasswordField getPassField(){
		return this.passField;
	}
	
	public JButton getLoginBtn(){
		return this.loginBtn;
	}
	
	public JButton getBackBtn(){
		return this.backBtn;
	}
	
	public JPanel getPanel(){
		return this.panel;
	}
}
