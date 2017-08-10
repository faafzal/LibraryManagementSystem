package librarymanagementsystem;

/**
 * This is the view class for finding genres
 * @author fafzal
 *
 */
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GenrePanel{
	//Global Variables
	private JList genreList;
	private JButton chooseBtn;
	private JButton profileBtn;
	private JButton logoutBtn;
	private JPanel mainPanel;
	private JPanel southPanel;
	
	public GenrePanel(ActionListener a, String[] genre){
		//create a main panel
		this.mainPanel = new JPanel();
		//create a new layout
		BoxLayout bl = new BoxLayout(this.mainPanel, BoxLayout.Y_AXIS);
		//set main panel to box layout
		this.mainPanel.setLayout(bl);
		
		//Create a label 
		JLabel genreTxt = new JLabel("Please Choose A Genre");
		genreTxt.setAlignmentX(Component.CENTER_ALIGNMENT);
		genreTxt.setBorder(new EmptyBorder(55, 1, 25,0));

		//create a JList of genres
		this.genreList = new JList(genre);
		this.genreList.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//create a choose button
		this.chooseBtn = new JButton("Choose");
		this.chooseBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.chooseBtn.addActionListener(a);
		
		//add to the main panel
		this.mainPanel.add(genreTxt);
		this.mainPanel.add(this.genreList);
		this.mainPanel.add(this.chooseBtn);
		
		//create a profile button
		this.profileBtn = new JButton("Profile");
		this.profileBtn.addActionListener(a);
		
		//create a logout button
		this.logoutBtn = new JButton("Logout");
		this.logoutBtn.addActionListener(a);
		
		//create a layout
		FlowLayout flow = new FlowLayout();
		//set south panel layout to flow
		this.southPanel = new JPanel(flow);
		
		//add buttons to south panel
		this.southPanel.add(this.profileBtn);
		this.southPanel.add(this.logoutBtn);
	}
	
	/*
	 * Getters Below
	 */
	public JButton getChooseBtn(){
		return this.chooseBtn;
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
	
	public JList getGenreList(){
		return this.genreList;
	}
}
