import java.sql.*;

public class DBConnectivity {
    public static void main(String[] args) {
        try {
            // Step 1: Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection to the database
            String url = "C:\\Users\\pc\\OneDrive\\Desktop\\project\\myDatabase";
            String name = "name";
            String email = "email";
            Connection conn = DriverManager.getConnection(url, name, email);

            // Step 3: Execute a SQL statement
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM employees";
            ResultSet rs = stmt.executeQuery(sql);

            // Step 4: Process the result set
            while (rs.next()) {
                int id = rs.getInt("id");
                String country = rs.getString("country");
                double salary = rs.getDouble("salary");
                System.out.println("ID: " + id + ", Country: " + country + ", Salary: " + salary);
            }

            // Step 5: Close the connection and release resources
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
