package librarymanagementsystem;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 * This is the view class for adding books
 * @author fafzal
 *
 */
public class AddPanel{
	
	//Global Variables
	private JTextField titleField;
	private JTextField authorField;
	private JTextField genreField;
	private JButton enterBtn;
	private JButton profileBtn;
	private JButton logoutBtn;
	private JPanel mainPanel;
	private JPanel southPanel;
	
	public AddPanel(ActionListener a){
		
		//create a main panel
		this.mainPanel = new JPanel();
		//set main panel layout to flow
		this.mainPanel.setLayout(new FlowLayout());
		
		//create JLabel
		JLabel titleTxt = new JLabel("Title");
		titleTxt.setAlignmentX(Component.CENTER_ALIGNMENT);
		titleTxt.setBorder(new EmptyBorder(85,5,85,1));
		
		//create author label
		JLabel authorTxt = new JLabel("Author");
		authorTxt.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//create genre label
		JLabel genreTxt = new JLabel("Genre");
		genreTxt.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//create enter button
		this.enterBtn = new JButton("Enter");
		this.enterBtn.addActionListener(a);
		
		//create text fields
		this.titleField = new JTextField(8);
		this.authorField = new JTextField(8);
		this.genreField = new JTextField(8);

		//add to main panel
		this.mainPanel.add(titleTxt);
		this.mainPanel.add(this.titleField);
		this.mainPanel.add(authorTxt);
		this.mainPanel.add(this.authorField);
		this.mainPanel.add(genreTxt);
		this.mainPanel.add(this.genreField);
		this.mainPanel.add(this.enterBtn);
		
		//create profile button
		this.profileBtn = new JButton("Profile");
		this.profileBtn.addActionListener(a);
		
		//create flow layout
		FlowLayout flow = new FlowLayout();
		//set south panel layout to flow
		this.southPanel = new JPanel(flow);
		
		//create logout button
		this.logoutBtn = new JButton("Logout");
		this.logoutBtn.addActionListener(a);
		
		//add buttons to south panel
		this.southPanel.add(this.profileBtn);
		this.southPanel.add(this.logoutBtn);
		
	}
	
	/*
	 * Getters Below
	 */
	public JTextField getTitleField(){
		
		return this.titleField;
		
	}
	
	public JTextField getAuthorField(){
		
		return this.authorField;
		
	}
	
	public JTextField getGenreField(){
		
		return this.genreField;
		
	}
	
	public JButton getEnterBtn(){
		
		return this.enterBtn;
		
	}
	
	public JButton getProfileBtn(){
		
		return this.profileBtn;
		
	}
	
	public JButton getLogoutBtn(){
		
		return this.logoutBtn;
		
	}
	
	public JPanel getMainPanel(){
		
		return this.mainPanel;
		
	}
	
	public JPanel getSouthPanel(){
		
		return this.southPanel;
		
	}

}
