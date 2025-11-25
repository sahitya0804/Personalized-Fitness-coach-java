import javax.swing.*;
import java.awt.*;


public class Dashboard extends JFrame {
private User user;


public Dashboard(User user) {
this.user = user;
setTitle("Dashboard - " + user.getUsername());
setSize(600,400);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


setLayout(new BorderLayout());
JPanel top = new JPanel(new GridLayout(2,1));
top.add(new JLabel("Hello, " + user.getUsername()));
top.add(new JLabel(String.format("Age: %d Height: %.1f cm Weight: %.1f kg Goal: %s", user.getAge(), user.getHeightCm(), user.getWeightKg(), user.getGoal())));
add(top, BorderLayout.NORTH);


JTextArea plan = new JTextArea(generatePlan(user));
plan.setEditable(false);
add(new JScrollPane(plan), BorderLayout.CENTER);
}


private String generatePlan(User u) {
// VERY simple plan generator — replace with better logic
StringBuilder sb = new StringBuilder();
if (u.getGoal().toLowerCase().contains("loss")) {
sb.append("Weekly plan: Cardio 5x, Strength 2x, Calorie deficit 300 kcal/day\n");
} else if (u.getGoal().toLowerCase().contains("muscle")) {
sb.append("Weekly plan: Strength training 4x, Protein 1.6g/kg, Calorie surplus\n");
} else {
sb.append("Weekly plan: Mix of cardio and strength 3-4x/week\n");
}
sb.append("\nSample exercises:\n- Jumping jacks 3x30s\n- Pushups 3x10\n- Squats 3x12\n");
return sb.toString();
}
}
