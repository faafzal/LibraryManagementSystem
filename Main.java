package librarymanagementsystem;

/**
 * This is the Main Driver
 * 
 * It creates the MainFrame (container) and
 * passes it to a new instance of the Home Controller
 * 
 * @author fafzal
 *
 */
public class Main{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MainFrame frame = new MainFrame();
		new HomeController(frame);

	}

}
