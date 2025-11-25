import javax.swing.*;
setSize(350,200);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLayout(new GridLayout(4,1));


tfUser = new JTextField();
pfPass = new JPasswordField();


add(new JLabel("Username:")); add(tfUser);
add(new JLabel("Password:")); add(pfPass);


JPanel panel = new JPanel();
JButton login = new JButton("Login");
JButton register = new JButton("Register");
panel.add(login); panel.add(register);
add(panel);


login.addActionListener(e -> {
String user = tfUser.getText();
String pass = new String(pfPass.getPassword());
User u = UserDAO.findByUsernameAndPassword(user, pass);
if (u != null) {
dispose();
new Dashboard(u).setVisible(true);
} else {
JOptionPane.showMessageDialog(this, "Invalid credentials", "Error", JOptionPane.ERROR_MESSAGE);
}
});


register.addActionListener(e -> {
// simple registration dialog
JTextField ru = new JTextField();
JPasswordField rp = new JPasswordField();
JTextField age = new JTextField();
JTextField h = new JTextField();
JTextField w = new JTextField();
JTextField goal = new JTextField();
Object[] fields = {
"Username:", ru,
"Password:", rp,
"Age:", age,
"Height (cm):", h,
"Weight (kg):", w,
"Goal:", goal
};
int option = JOptionPane.showConfirmDialog(this, fields, "Register", JOptionPane.OK_CANCEL_OPTION);
if (option == JOptionPane.OK_OPTION) {
User nu = new User();
nu.setUsername(ru.getText());
nu.setPassword(new String(rp.getPassword()));
nu.setAge(Integer.parseInt(age.getText()));
nu.setHeightCm(Double.parseDouble(h.getText()));
nu.setWeightKg(Double.parseDouble(w.getText()));
nu.setGoal(goal.getText());
boolean ok = UserDAO.save(nu);
if (ok) JOptionPane.showMessageDialog(this, "Registered! Now login.");
else JOptionPane.showMessageDialog(this, "Registration failed.");
}
});
}
}
