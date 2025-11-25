public class User {
private int id;
private String username;
private String password;
private int age;
private double heightCm;
private double weightKg;
private String goal; // e.g., "weight loss", "muscle gain"


public User() {}


// getters and setters
public int getId() { return id; }
public void setId(int id) { this.id = id; }
public String getUsername() { return username; }
public void setUsername(String username) { this.username = username; }
public String getPassword() { return password; }
public void setPassword(String password) { this.password = password; }
public int getAge() { return age; }
public void setAge(int age) { this.age = age; }
public double getHeightCm() { return heightCm; }
public void setHeightCm(double heightCm) { this.heightCm = heightCm; }
public double getWeightKg() { return weightKg; }
public void setWeightKg(double weightKg) { this.weightKg = weightKg; }
public String getGoal() { return goal; }
public void setGoal(String goal) { this.goal = goal; }
}
