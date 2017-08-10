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
 * This is the view class for my profile screen
 * @author fafzal
 *
 */
public class ProfilePanel{
	//Global Variables
	private JList myBooks;
	private JButton returnBtn;
	private JButton addBtn;
	private JButton findBtn;
	private JButton logoutBtn;
	private JPanel mainPanel;
	private JPanel southPanel;
	
	public ProfilePanel(ActionListener a, String first, String last, String[] books, String isAdmin){
		//create a new main panel
		this.mainPanel = new JPanel();
		//create layout 
		BoxLayout bl = new BoxLayout(this.mainPanel, BoxLayout.Y_AXIS);
		//set main panel layout
		this.mainPanel.setLayout(bl);
		
		/*
		 * Create Welcome Text and add it to the main panel
		 */
		JLabel welcomeTxt = new JLabel("Welcome, "+first +" "+last+".");
		welcomeTxt.setBorder(new EmptyBorder(55, 1, 9, 0));
		welcomeTxt.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.mainPanel.add(welcomeTxt);
		
		// check if books borrowed is empty
		if(books[0].equals("")){
		
			/*
			 * if so, inform the user he can borrow up to five
			 */
			JLabel noBooks = new JLabel("You can borrow up to 5 books at once.");
			noBooks.setBorder(new EmptyBorder(5, 1, 25, 0));
			noBooks.setAlignmentX(Component.CENTER_ALIGNMENT);
		
			this.mainPanel.add(noBooks);
			
		}else{
			
			/*
			 * else show the books borrowed, and how many he is borrowing
			 */
			
			//set text to books
			String txt = "books";
			// if there is only one book, set text to book
			if(books.length == 1){
				
				txt = "book";
				
			}
			//tell the user how many books he is borrowing
			JLabel booksTxt = new JLabel("You are currently borrowing "+books.length+" "+txt);
			booksTxt.setBorder(new EmptyBorder(5, 1, 25, 0));
			booksTxt.setAlignmentX(Component.CENTER_ALIGNMENT);
		
			this.mainPanel.add(booksTxt);
			
			//create a JList and show the user which books he is borrowing
			this.myBooks = new JList(books);
			this.myBooks.setAlignmentX(Component.CENTER_ALIGNMENT);
			this.mainPanel.add(this.myBooks);
			
			//create a return button
			this.returnBtn = new JButton("Return");
			this.returnBtn.addActionListener(a);
			this.returnBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
			this.mainPanel.add(this.returnBtn);	
		}
		
		//create a button to find more books
		this.findBtn = new JButton("Find Books");
		this.findBtn.addActionListener(a);
		
		//create a log out button
		this.logoutBtn = new JButton("Logout");
		this.logoutBtn.addActionListener(a);
		
		//create layout for south panel
		FlowLayout flow = new FlowLayout();
		this.southPanel = new JPanel(flow);
		
		//add find button to south panel
		this.southPanel.add(this.findBtn);
		
		//if the user is an admin, add an add titles button
		if(isAdmin.equals("YES")){
			this.addBtn = new JButton("Add Titles");
			this.addBtn.addActionListener(a);
			this.southPanel.add(this.addBtn);
		}
		
		//add logout button
		this.southPanel.add(this.logoutBtn);
	}
	
	/*
	 * Getters Below
	 */
	public JList getMyBooks(){
		return this.myBooks;
	}
	
	public JButton getReturnBtn(){
		return this.returnBtn;
	}
	
	public JButton getAddBtn(){
		return this.addBtn;
	}
	
	public JButton getFindBtn(){
		return this.findBtn;
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
