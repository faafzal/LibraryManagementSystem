package librarymanagementsystem;

import java.awt.Component;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * This is the view for my home screen
 * @author fafzal
 *
 */
public class HomePanel{
	
	//Global Variables
	private JButton registerBtn;
	private JButton loginBtn;
	private JPanel panel;

	public HomePanel(ActionListener a){
		
		//Create text
		JLabel text = new JLabel("The Online Library");
		//set the text's border
		text.setBorder(new EmptyBorder(9, 1, 9, 0));
		//set text alignment
		text.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		
		// create register button
		this.registerBtn = new JButton("Register");
		//set focus painted to false
		this.registerBtn.setFocusPainted(false);
		//add action listener
		this.registerBtn.addActionListener(a);
		//set button alignment 
		this.registerBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		// create login button
		this.loginBtn = new JButton("Login");
		//set focus painted to false
		this.loginBtn.setFocusPainted(false);
		//add action listener
		this.loginBtn.addActionListener(a);
		//set button alignment to center
		this.loginBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
	
		//create a new panel
		this.panel = new JPanel();
		//create new layout
		BoxLayout bl = new BoxLayout(this.panel, BoxLayout.Y_AXIS);
		//set panel to box layout
		this.panel.setLayout(bl);
		
		//add text and buttons
		this.panel.add(text);
		this.panel.add(this.registerBtn);
		this.panel.add(this.loginBtn);
		
	}
	
	/*
	 * Getters Below
	 */
	public JButton getRegisterBtn(){
		
		return this.registerBtn;
		
	}
	
	public JButton getLoginBtn(){
		
		return this.loginBtn;
		
	}
	
	public JPanel getPanel(){
		
		return this.panel;
		
	}
	
}
