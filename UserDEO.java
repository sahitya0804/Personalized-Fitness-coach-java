import java.sql.*;


/**
CREATE TABLE users (
id INT PRIMARY KEY AUTO_INCREMENT,
username VARCHAR(100) UNIQUE,
password VARCHAR(100),
age INT,
height_cm DOUBLE,
weight_kg DOUBLE,
goal VARCHAR(100)
);
*/


public class UserDAO {


public static User findByUsernameAndPassword(String username, String password) {
String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
try (Connection c = DBConnection.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
ps.setString(1, username);
ps.setString(2, password);
ResultSet rs = ps.executeQuery();
if (rs.next()) {
User u = new User();
u.setId(rs.getInt("id"));
u.setUsername(rs.getString("username"));
u.setPassword(rs.getString("password"));
u.setAge(rs.getInt("age"));
u.setHeightCm(rs.getDouble("height_cm"));
u.setWeightKg(rs.getDouble("weight_kg"));
u.setGoal(rs.getString("goal"));
return u;
}
} catch (SQLException e) {
e.printStackTrace();
}
return null;
}


public static boolean save(User user) {
String sql = "INSERT INTO users (username,password,age,height_cm,weight_kg,goal) VALUES (?,?,?,?,?,?)";
try (Connection c = DBConnection.getConnection(); PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
ps.setString(1, user.getUsername());
ps.setString(2, user.getPassword());
ps.setInt(3, user.getAge());
ps.setDouble(4, user.getHeightCm());
ps.setDouble(5, user.getWeightKg());
ps.setString(6, user.getGoal());
int affected = ps.executeUpdate();
return affected == 1;
} catch (SQLException e) {
e.printStackTrace();
return false;
}
}
}
