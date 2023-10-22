import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class CupcakeMaker2 extends JFrame {
    private Stack<String> toppingsStack = new Stack<>();
    private JLabel cupcakeImageLabel;

    public CupcakeMaker2() {
        setTitle("Cupcake Maker");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel toppingsPanel = new JPanel(new FlowLayout());
        cupcakeImageLabel = new JLabel("Cupcake Image");

        JButton pushButton = new JButton("Add Topping");
        JButton popButton = new JButton("Delete Topping");
        JButton doneButton = new JButton("Done");

        pushButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String topping = JOptionPane.showInputDialog("Enter Topping Name:");
                if (topping != null) {
                    toppingsStack.push(topping);
                    updateImage();
                }
            }
        });

        popButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!toppingsStack.isEmpty()) {
                    toppingsStack.pop();
                    updateImage();
                }
            }
        });

        doneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!toppingsStack.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Cupcake with Toppings: " + toppingsStack);
                } else {
                    JOptionPane.showMessageDialog(null, "Plain Cupcake");
                }
            }
        });



        toppingsPanel.add(pushButton);
        toppingsPanel.add(popButton);
        toppingsPanel.add(doneButton);

        mainPanel.add(toppingsPanel, BorderLayout.NORTH);
        mainPanel.add(cupcakeImageLabel, BorderLayout.CENTER);

        getContentPane().add(mainPanel);
    }

    private void updateImage() {
        if (toppingsStack.isEmpty()) {
            cupcakeImageLabel.setText("Cupcake Image");
        } else {
            cupcakeImageLabel.setText("Cupcake with Toppings: " + toppingsStack);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CupcakeMaker2 app = new CupcakeMaker2();
            app.setVisible(true);
        });
    }
}
