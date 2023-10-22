
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Stack;
import javax.sound.sampled.*;
import javax.swing.border.EmptyBorder;
public class CupcakeMaker extends JFrame {
	private Stack<String> toppingsStack = new Stack<>();
	private JTextArea toppingList;
	  private Clip clip;
	  private boolean isMuted = false;
	  
	public CupcakeMaker() {
		setTitle("Cupcake Maker");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1440, 810);
		getContentPane().setLayout(null);
		
		JButton muteButton = new JButton("mute");
		muteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toggleMute();
			}
		});
		toppingList = new JTextArea(5, 6);
		toppingList.setEditable(false);
		toppingList.setTabSize(5);
		toppingList.setFont(new Font("Monospaced", Font.BOLD, 43));
		toppingList.setOpaque(false);
		toppingList.setForeground(Color.BLACK);

		// Add custom line spacing between items
		StringBuilder toppingsText = new StringBuilder();
		for (String topping : toppingsStack) {
		    toppingsText.append(topping).append("\n\n"); // Add extra newline for spacing
		}
		toppingList.setText(toppingsText.toString());

		toppingList.setBounds(28, 145, 389, 572);
		getContentPane().add(toppingList);

		
		JLabel list = new JLabel("");
		list.setIcon(new ImageIcon(CupcakeMaker.class.getResource("/PictureProject/list.png")));
		list.setBounds(10, 11, 420, 728);
		getContentPane().add(list);
		
		muteButton.setBounds(1217, 37, 89, 23);
		getContentPane().add(muteButton);
		JButton strawberriesButton = new JButton("");
		strawberriesButton.setBorder(null);
		strawberriesButton.setBackground(new Color(94, 53, 38));
		strawberriesButton.setIcon(new ImageIcon(CupcakeMaker.class.getResource("/PictureProject/Strawberry_button.png")));
		strawberriesButton.setBounds(471, 103, 284, 262);
		getContentPane().add(strawberriesButton);
		
		
				strawberriesButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						toppingsStack.push("Strawberries");
						updateToppingList();
					}
				});
		JButton vanillaicingButton = new JButton("");
		vanillaicingButton.setBorder(null);
		vanillaicingButton.setBackground(new Color(94, 53, 38));
		vanillaicingButton.setIcon(new ImageIcon(CupcakeMaker.class.getResource("/PictureProject/VanillaIcing_button.png")));
		vanillaicingButton.setBounds(797, 413, 284, 262);
		getContentPane().add(vanillaicingButton);
		JButton deleteToppingButton = new JButton("");
		deleteToppingButton.setIcon(new ImageIcon(CupcakeMaker.class.getResource("/PictureProject/Delete_button.png")));
		deleteToppingButton.setBounds(630, 686, 190, 73);
		getContentPane().add(deleteToppingButton);
		JButton doneButton = new JButton("");
		doneButton.setIcon(new ImageIcon(CupcakeMaker.class.getResource("/PictureProject/Done_button.png")));
		doneButton.setBounds(933, 686, 190, 73);
		getContentPane().add(doneButton);

		// Create buttons for each topping
		JButton chocolateSprinklesButton = new JButton("");
		chocolateSprinklesButton.setBorder(null);
		chocolateSprinklesButton.setBackground(new Color(94, 53, 38));
		chocolateSprinklesButton.setIcon(new ImageIcon(CupcakeMaker.class.getResource("/PictureProject/Chocolate_button.png")));
		chocolateSprinklesButton.setBounds(797, 103, 284, 262);
		getContentPane().add(chocolateSprinklesButton);
		JButton blueberryButton = new JButton("");
		blueberryButton.setBorder(null);
		blueberryButton.setBackground(new Color(94, 53, 38));
		blueberryButton.setIcon(new ImageIcon(CupcakeMaker.class.getResource("/PictureProject/Blueberry_button.png")));
		blueberryButton.setBounds(471, 413, 284, 262);
		getContentPane().add(blueberryButton);
		JButton cherryButton = new JButton("");
		cherryButton.setBorder(null);
		cherryButton.setBackground(new Color(94, 53, 38));
		cherryButton.setIcon(new ImageIcon(CupcakeMaker.class.getResource("/PictureProject/Cherry_button.png")));
		cherryButton.setBounds(1104, 103, 284, 262);
		getContentPane().add(cherryButton);
		JButton chocolateicingButton = new JButton("");
		chocolateicingButton.setBorder(null);
		chocolateicingButton.setBackground(new Color(94, 53, 38));
		chocolateicingButton.setIcon(new ImageIcon(CupcakeMaker.class.getResource("/PictureProject/ChocolateIcing_button.png")));
		chocolateicingButton.setBounds(1104, 413, 284, 262);
		getContentPane().add(chocolateicingButton);
		
		JLabel makerbg = new JLabel("");
		makerbg.setBounds(0, 0, 1434, 797);
		getContentPane().add(makerbg);
		makerbg.setIcon(new ImageIcon(CupcakeMaker.class.getResource("/PictureProject/CupcakeMakerBackground.png")));

		chocolateicingButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				toppingsStack.push("Chocolate Icing");
				updateToppingList();
			}
		});

		cherryButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				toppingsStack.push("Cherry");
				updateToppingList();
			}
		});

		blueberryButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				toppingsStack.push("Blueberry");
				updateToppingList();
			}
		});

		// Action listeners for topping buttons
		chocolateSprinklesButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				toppingsStack.push("Chocolate Bar");
				updateToppingList();
			}
		});

		doneButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayFinalProduct();
			}
		});
		deleteToppingButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!toppingsStack.isEmpty()) {
					toppingsStack.pop();
					updateToppingList();
				}
			}
		});

		vanillaicingButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				toppingsStack.push("Vanilla Icing");
				updateToppingList();
			}
		});

		updateToppingList();
	}

	private void updateToppingList() {
		StringBuilder toppingsText = new StringBuilder();
		for (String topping : toppingsStack) {
			toppingsText.append(topping).append("\n");
		}
		toppingList.setText(toppingsText.toString());
	}
	 private void playBackgroundMusic() {
	        try {
	        	File audioFile = new File("C:\\Users\\matt\\eclipse-workspace\\DSAProject\\src\\bgMusics\\bgMusicCupcake.wav");
	            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
	            clip = AudioSystem.getClip();
	            clip.open(audioInputStream);
	            clip.loop(Clip.LOOP_CONTINUOUSLY);
	            clip.start();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    }

	    private void toggleMute() {
	        if (isMuted) {
	            clip.start();
	        } else {
	            clip.stop();
	        }
	        isMuted = !isMuted;
	    }
	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	            	CupcakeMaker simulator = new CupcakeMaker();
	                simulator.setVisible(true);
	                simulator.playBackgroundMusic();
	            }
	        });
	    }
	



	private void displayFinalProduct() {
		JFrame finalProductFrame = new JFrame("Final Product");
		finalProductFrame.setSize(1440, 810);
		finalProductFrame.getContentPane().setLayout(new BorderLayout());

		ImageIcon imageIcon;

		// Construct the selected toppings string
		String selectedTopping = String.join(" + ", toppingsStack);

		// Add image display logic based on selectedToppings here
		if ("Blueberry + Strawberries + Vanilla Icing".equals(selectedTopping)) {
			imageIcon = new ImageIcon(
					"C:\\Users\\matt\\eclipse-workspace\\DSAProject\\src\\PictureProject\\strawberry_blueberry.png");
		} else if ("Vanilla Icing + Strawberries".equals(selectedTopping)) {
			imageIcon = new ImageIcon(
					"C:\\Users\\matt\\eclipse-workspace\\DSAProject\\src\\PictureProject\\StrawberryFinish.png");
		} else if ("Vanilla Icing + Cherry".equals(selectedTopping)) {
			imageIcon = new ImageIcon(
					"C:\\Users\\matt\\eclipse-workspace\\DSAProject\\src\\PictureProject\\CherryFinish.png");
		} else if ("Vanilla Icing + Chocolate Icing + Blueberry + Strawberries + Cherry".equals(selectedTopping)) {
			imageIcon = new ImageIcon(
					"C:\\Users\\matt\\eclipse-workspace\\DSAProject\\src\\PictureProject\\Vanilla_Chocolate_Blueberry_Strawberry_Cherry.png");
		} else if ("Vanilla Icing + Chocolate Icing + Blueberry + Strawberries + Cherry + Chocolate Bar".equals(selectedTopping)) {
			imageIcon = new ImageIcon(
					"C:\\Users\\matt\\eclipse-workspace\\DSAProject\\src\\PictureProject\\AllToppings.png");
		} else if ("Chocolate Icing + Cherry".equals(selectedTopping)) {
			imageIcon = new ImageIcon(
					"C:\\Users\\matt\\eclipse-workspace\\DSAProject\\src\\PictureProject\\Chocolate_threecherry.png");
		} else if ("Vanilla Icing + Chocolate Bar".equals(selectedTopping)) {
			imageIcon = new ImageIcon(
					"C:\\Users\\matt\\eclipse-workspace\\DSAProject\\src\\PictureProject\\ChocolateFinish.png");
		} else if ("Blueberry + Chocolate Icing".equals(selectedTopping)) {
			imageIcon = new ImageIcon(
					"C:\\Users\\matt\\eclipse-workspace\\DSAProject\\src\\PictureProject\\Blueberry_Chocolate Icing.png");
		} else if ("Chocolate Icing + Blueberry".equals(selectedTopping)) {
			imageIcon = new ImageIcon(
					"C:\\Users\\matt\\eclipse-workspace\\DSAProject\\src\\PictureProject\\Chocolate Icing_Blueberry.png");
		} else if ("Chocolate Icing + Blueberry + Cherry".equals(selectedTopping)) {
			imageIcon = new ImageIcon(
					"C:\\Users\\matt\\eclipse-workspace\\DSAProject\\src\\PictureProject\\Chocolate Icing_Blueberry_Cherry.png");
		} else if ("Vanilla Icing + Vanilla Icing + Vanilla Icing".equals(selectedTopping)) {
			imageIcon = new ImageIcon(
					"C:\\Users\\matt\\eclipse-workspace\\DSAProject\\src\\PictureProject\\threelayersofvanilla.png");
		} else if ("Chocolate Icing + Chocolate Icing + Chocolate Icing".equals(selectedTopping)) {
			imageIcon = new ImageIcon(
					"C:\\Users\\matt\\eclipse-workspace\\DSAProject\\src\\PictureProject\\threelayersofchocolate.png");
		} else if ("Chocolate Icing + Vanilla Icing + Chocolate Icing".equals(selectedTopping)) {
			imageIcon = new ImageIcon(
					"C:\\Users\\matt\\eclipse-workspace\\DSAProject\\src\\PictureProject\\Chocolate_Vanilla_Chocolate.png");
		} else if ("Vanilla Icing + Chocolate Icing + Chocolate Icing".equals(selectedTopping)) {
			imageIcon = new ImageIcon(
					"C:\\Users\\matt\\eclipse-workspace\\DSAProject\\src\\PictureProject\\Vanilla_Chocolate_Chocolate.png");
		} else if ("Chocolate Icing + Blueberry + Cherry + Chocolate Bar".equals(selectedTopping)) {
			imageIcon = new ImageIcon(
					"C:\\Users\\matt\\eclipse-workspace\\DSAProject\\src\\PictureProject\\Chocolate Icing_Blueberry_Cherry_Chocolate Bar.png");
		} else if ("Blueberry + Vanilla Icing".equals(selectedTopping)) {
			imageIcon = new ImageIcon(
					"C:\\Users\\matt\\eclipse-workspace\\DSAProject\\src\\PictureProject\\Blueberry_Vanilla Icing.png");
		} else if ("Strawberries + Vanilla Icing".equals(selectedTopping)) {
			imageIcon = new ImageIcon(
					"C:\\Users\\matt\\eclipse-workspace\\DSAProject\\src\\PictureProject\\Strawberry_Vanilla Icing.png");
		}else if ("Chocolate Icing + Strawberries".equals(selectedTopping)) {
				imageIcon = new ImageIcon(
						"C:\\Users\\matt\\eclipse-workspace\\DSAProject\\src\\PictureProject\\ChocolateIcingStrawberry.png");
		}else if ("Vanilla Icing + Cherry + Chocolate Bar".equals(selectedTopping)) {
			imageIcon = new ImageIcon(
					"C:\\Users\\matt\\eclipse-workspace\\DSAProject\\src\\PictureProject\\Vanilla Icing_Cherry_Chocolate Bar.png");
		}else if ("Vanilla Icing + Cherry + Strawberries".equals(selectedTopping)) {
			imageIcon = new ImageIcon(
					"C:\\Users\\matt\\eclipse-workspace\\DSAProject\\src\\PictureProject\\Vanilla Icing_Cherry_Strawberry.png");
		} else if ("Strawberries".equals(selectedTopping)) {
			imageIcon = new ImageIcon(
					"C:\\Users\\matt\\eclipse-workspace\\DSAProject\\src\\PictureProject\\StrawberryCupcake.png");
		} else if ("Vanilla Icing".equals(selectedTopping)) {
			imageIcon = new ImageIcon(
					"C:\\Users\\matt\\eclipse-workspace\\DSAProject\\src\\PictureProject\\VanillaFinish.png");
		} else if ("Blueberry".equals(selectedTopping)) {
			imageIcon = new ImageIcon(
					"C:\\Users\\matt\\eclipse-workspace\\DSAProject\\src\\PictureProject\\BlueberryFinish.png");
		} else if ("Cherry".equals(selectedTopping)) {
			imageIcon = new ImageIcon(
					"C:\\Users\\matt\\eclipse-workspace\\DSAProject\\src\\PictureProject\\CherryCupcake.png");
		} else if ("Chocolate Icing".equals(selectedTopping)) {
			imageIcon = new ImageIcon(
					"C:\\Users\\matt\\eclipse-workspace\\DSAProject\\src\\PictureProject\\ChocolateIcingFinish.png");
		} else if ("Chocolate Bar".equals(selectedTopping)) {
			imageIcon = new ImageIcon(
					"C:\\Users\\matt\\eclipse-workspace\\DSAProject\\src\\PictureProject\\ChocolateBar.png");
		} else {
			// Load a default image for other toppings
			imageIcon = new ImageIcon(
					"C:\\Users\\matt\\eclipse-workspace\\DSAProject\\src\\PictureProject\\default-image.jpg");
		}

		JLabel finalProductLabel = new JLabel(imageIcon);
		finalProductFrame.getContentPane().add(finalProductLabel, BorderLayout.CENTER);
		finalProductFrame.setVisible(true);
	}

}