import java.sql.*;

public class TestDB {
    public static void main(String[] args) {
        try {
            DriverManager.setLoginTimeout(5);

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studentdb?connectTimeout=5000&socketTimeout=5000&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC",
                "root",
                "root@123"
            );

            System.out.println("Connected Successfully!");
            con.close();

        } catch (SQLException e) {
            System.out.println("DB Connection Failed");
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("ErrorCode: " + e.getErrorCode());
            System.out.println("Message: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
