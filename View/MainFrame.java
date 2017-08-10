package librarymanagementsystem;

import javax.swing.JFrame;

/**
 * Main Frame Class,
 * it extends JFrame
 * It is the Container for my views
 * @author fafzal
 *
 */
public class MainFrame extends JFrame {

	public MainFrame(){
		//call the JFrame constructor, and set the title
		super("Library");
		//close program when user clicks escape
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//set the size
		this.setSize(600, 500);
		//set the screen location
		this.setLocation(475, 175);
		//show the main frame
		this.setVisible(true);
	}
	
	/*
	 * Helper Method for repainting the screen
	 */
	public void revalidate(){
		this.invalidate();
		this.validate();
		this.repaint();
	}
}
