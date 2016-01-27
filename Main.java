package librarymanagementsystem;

/**
 * This is the Main Driver
 * 
 * It creates the MainFrame (container),
 * passes it to the Home Controller,
 * and makes the frame visible
 * 
 * @author fafzal
 *
 */
public class Main{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MainFrame frame = new MainFrame();
		new HomeController(frame);
		frame.setVisible(true);

	}

}
