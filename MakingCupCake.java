import java.awt.EventQueue;

import javax.swing.JFrame;

public class MakingCupCake {

	JFrame MakingFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MakingCupCake window = new MakingCupCake();
					window.MakingFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MakingCupCake() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		MakingFrame = new JFrame();
		MakingFrame.setBounds(100, 100, 851, 525);
		MakingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
