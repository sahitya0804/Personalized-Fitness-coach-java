import javax.swing.*;
import java.awt.*;


public class WelcomeScreen extends JFrame {
public WelcomeScreen() {
setTitle("Personalized Fitness Coach");
setSize(400, 300);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLocationRelativeTo(null);


JLabel label = new JLabel("Welcome to Personalized Fitness Coach", SwingConstants.CENTER);
label.setFont(new Font("Arial", Font.BOLD, 16));
add(label, BorderLayout.CENTER);


JButton start = new JButton("Get Started");
start.addActionListener(e -> {
dispose();
new LoginUI().setVisible(true);
});
add(start, BorderLayout.SOUTH);
}
}
