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
 * This is the view for the register screen
 * @author fafzal
 *
 */
public class RegisterPanel{
	
	//Global Variables
	private JTextField firstField;
	private JTextField lastField;
	private JTextField userField;
	private JPasswordField passField;
	private JButton registerBtn;
	private JButton backBtn;
	private JPanel panel;
	private JLabel message;

	public RegisterPanel(ActionListener a){
		
		// create a jpanel
		this.panel = new JPanel();
		// create layout
		BoxLayout bl = new BoxLayout(this.panel, BoxLayout.Y_AXIS);
		//set panel layout to box layout
		this.panel.setLayout(bl);
		
		/*
		 * Create JLabels
		 */
		JLabel firstTxt = new JLabel("First Name");
		JLabel lastTxt = new JLabel("Last Name");
		JLabel usernameTxt = new JLabel("Username");
		JLabel passwordTxt = new JLabel("Password");
		
		/*
		 * Align JLabels
		 */
		firstTxt.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lastTxt.setAlignmentX(Component.RIGHT_ALIGNMENT);
		usernameTxt.setAlignmentX(Component.RIGHT_ALIGNMENT);
		passwordTxt.setAlignmentX(Component.RIGHT_ALIGNMENT);
		
		/*
		 * Create JTextFields
		 */
		this.firstField = new JTextField();
		this.lastField = new JTextField();
		this.userField = new JTextField();
		this.passField = new JPasswordField();
		
		/*
		 * Create Register Button
		 */
		this.registerBtn = new JButton("Register");
		this.registerBtn.setFocusPainted(false);
		this.registerBtn.addActionListener(a);
		
		/*
		 * Create Back Button
		 */
		this.backBtn = new JButton("Back");
		this.backBtn.setFocusPainted(false);
		this.backBtn.addActionListener(a);
		
		/*
		 * Create Button Panel
		 */
		JPanel btnPanel = new JPanel(new FlowLayout());
		btnPanel.add(this.backBtn);
		btnPanel.add(this.registerBtn);
		
		/*
		 * Add everything to the Panel. 
		 */
		this.panel.add(firstTxt);
		this.panel.add(this.firstField);
		this.panel.add(lastTxt);
		this.panel.add(lastField);
		this.panel.add(usernameTxt);
		this.panel.add(this.userField);
		this.panel.add(passwordTxt);
		this.panel.add(this.passField);
		this.panel.add(btnPanel);

	}
	
	/*
	 * Helper method to empty text fields
	 */
	public void emptyFields(){
		
		this.firstField.setText("");
		this.lastField.setText("");
		this.userField.setText("");
		this.passField.setText("");
		
	}
	
	/*
	 * This is shown to users if the registration was successful
	 */
	public void successMesage(){
		
		// If message was already set, then remove it
		if(this.message != null){
			
			this.panel.remove(message);
			
		}

		//empty fields
		this.emptyFields();
		//create the message
		this.message = new JLabel("You are now a member.");
		//set message alignment
		this.message.setAlignmentX(Component.CENTER_ALIGNMENT);
		//add message to the panel
		this.panel.add(this.message);
		
	}
	
	/*
	 * This is shown to the users if the registration was unsuccessful
	 */
	public void failMessage(){
		
		// If message was already set, then remove it
		if(this.message != null){
			
			this.panel.remove(this.message);
			
		}
		
		this.emptyFields();
		this.message = new JLabel("This username is taken.");
		this.message.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.panel.add(this.message);
		
	}
	
	/*
	 * Getters Below
	 */
	public JTextField getFirstField(){
		
		return this.firstField;
		
	}
	
	public JTextField getLastField(){
		
		return this.lastField;
		
	}
	
	public JTextField getUserField(){
		
		return this.userField;
		
	}
	
	public JPasswordField getPassField(){
		
		return this.passField;
		
	}
	
	public JButton getRegisterBtn(){
		
		return this.registerBtn;
		
	}
	
	public JButton getBackBtn(){
		
		return this.backBtn;
		
	}
	
	public JPanel getPanel(){
		
		return this.panel;
		
	}
	
}
