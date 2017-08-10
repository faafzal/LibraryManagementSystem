package librarymanagementsystem;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * This is the view class for my books screen
 * @author fafzal
 *
 */
public class BooksPanel{
	//Global Variables
	private JList bookList;
	private JButton borrowBtn;
	private JButton backBtn;
	private JButton profileBtn;
	private JButton logoutBtn;
	private JPanel mainPanel;
	private JPanel southPanel;
	
	public BooksPanel(ActionListener a, String[] titles){
		//create a new main panel
		this.mainPanel = new JPanel();
		//create a new layout
		BoxLayout bl = new BoxLayout(this.mainPanel, BoxLayout.Y_AXIS);
		//set new layout to main panel
		this.mainPanel.setLayout(bl);
	
		//create JLabel
		JLabel bookTxt = new JLabel("Please Choose A Book");
		bookTxt.setAlignmentX(Component.CENTER_ALIGNMENT);
		bookTxt.setBorder(new EmptyBorder(55, 1, 25,0));

		//create a list of titles
		this.bookList = new JList(titles);
		this.bookList.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//create a borrow button
		this.borrowBtn = new JButton("Borrow");
		this.borrowBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.borrowBtn.addActionListener(a);
		
		//create a back button
		this.backBtn = new JButton("Back");
		this.backBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.backBtn.addActionListener(a);
		
		//add to main panel
		this.mainPanel.add(bookTxt);
		this.mainPanel.add(this.bookList);
		this.mainPanel.add(this.borrowBtn);
		this.mainPanel.add(this.backBtn);
		
		//create a profile button
		this.profileBtn = new JButton("Profile");
		this.profileBtn.addActionListener(a);
		
		//create a logout button
		this.logoutBtn = new JButton("Logout");
		this.logoutBtn.addActionListener(a);
		
		//create a new layout
		FlowLayout flow = new FlowLayout();
		//set south panel layout to flow
		this.southPanel = new JPanel(flow);
		
		//add buttons
		this.southPanel.add(this.profileBtn);
		this.southPanel.add(this.logoutBtn);
	}
	
	/*
	 * Getters Below
	 */
	public JList getBookList(){
		return this.bookList;
	}
	
	public JButton getBorrowBtn(){
		return this.borrowBtn;
	}
	
	public JButton getProfileBtn(){
		return this.profileBtn;
	}
	
	public JButton getLogoutBtn(){
		return this.logoutBtn;
	}
	
	public JButton getBackBtn(){
		return this.backBtn;
	}
	
	public JPanel getMainPanel(){
		return this.mainPanel;
	}
	
	public JPanel getSouthPanel(){
		return this.southPanel;
	}
}
