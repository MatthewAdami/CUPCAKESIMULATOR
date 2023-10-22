import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class HomePage {

    private JFrame homeFrame;
    private Clip clip;
    private boolean isMuted = false;

    public HomePage() {
        initialize();
    }

    private void initialize() {
        homeFrame = new JFrame();
        homeFrame.setBounds(100, 100, 1440, 810);
        homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        homeFrame.getContentPane().setLayout(null);

        JButton muteButton = new JButton("Mute");
        muteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                toggleMute();
            }
        });
        muteButton.setBounds(1217, 37, 89, 23);
        homeFrame.getContentPane().add(muteButton);

        JButton exitButton = new JButton("");
        exitButton.setIcon(new ImageIcon(HomePage.class.getResource("/PictureProject/ExitButton.png")));
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                homeFrame.dispose();
            }
        });
        exitButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        exitButton.setBackground(new Color(255, 255, 255));
        exitButton.setBounds(738, 462, 394, 151);
        homeFrame.getContentPane().add(exitButton);

        JButton startButton = new JButton("");
        startButton.setIcon(new ImageIcon(HomePage.class.getResource("/PictureProject/StartButton.png")));
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CupcakeMaker simulator = new CupcakeMaker();
                simulator.setVisible(true);
                homeFrame.dispose();
            }
        });
        startButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        startButton.setBackground(new Color(255, 255, 255));
        startButton.setBounds(320, 462, 394, 151);
        homeFrame.getContentPane().add(startButton);

        JLabel bg = new JLabel("");
        bg.setIcon(new ImageIcon(HomePage.class.getResource("/PictureProject/Homepage.png")));
        bg.setBounds(0, 0, 1424, 771);
        homeFrame.getContentPane().add(bg);
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
                HomePage simulator = new HomePage();
                simulator.homeFrame.setVisible(true);
                simulator.playBackgroundMusic();
            }
        });
    }
}
