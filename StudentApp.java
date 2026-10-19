import java.sql.*;
import java.util.Scanner;

public class StudentApp {

    static final String URL = "jdbc:mysql://localhost:3306/studentdb";
    static final String USER = "root";
    static final String PASS = "root@123";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            Connection con = DriverManager.getConnection(URL, USER, PASS);

            while (true) {
                System.out.println("\n--- STUDENT MENU ---");
                System.out.println("1. Add Student");
                System.out.println("2. Update Student");
                System.out.println("3. Delete Student");
                System.out.println("4. View All Students");
                System.out.println("5. Exit");

                System.out.print("Enter choice: ");
                int ch = sc.nextInt();


                switch (ch) {

                    // 🔹 ADD STUDENT
                    case 1:
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Course: ");
                        String course = sc.nextLine();

                        System.out.print("Enter Marks: ");
                        double marks = sc.nextDouble();

                        PreparedStatement ps1 = con.prepareStatement(
                                "INSERT INTO students VALUES (?, ?, ?, ?)");
                        ps1.setInt(1, id);
                        ps1.setString(2, name);
                        ps1.setString(3, course);
                        ps1.setDouble(4, marks);

                        ps1.executeUpdate();
                        System.out.println("Student Added!");
                        break;

                    // 🔹 UPDATE STUDENT
                    case 2:
                        System.out.print("Enter Student ID to update: ");
                        int uid = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter New Name: ");
                        String newName = sc.nextLine();

                        System.out.print("Enter New Course: ");
                        String newCourse = sc.nextLine();

                        System.out.print("Enter New Marks: ");
                        double newMarks = sc.nextDouble();

                        PreparedStatement ps2 = con.prepareStatement(
                                "UPDATE students SET name=?, course=?, marks=? WHERE id=?");
                        ps2.setString(1, newName);
                        ps2.setString(2, newCourse);
                        ps2.setDouble(3, newMarks);
                        ps2.setInt(4, uid);

                        int rows = ps2.executeUpdate();
                        if (rows > 0)
                            System.out.println("Student Updated!");
                        else
                            System.out.println("Student Not Found!");
                        break;

                    // 🔹 DELETE STUDENT
                    case 3:
                        System.out.print("Enter Student ID to delete: ");
                        int did = sc.nextInt();

                        PreparedStatement ps3 = con.prepareStatement(
                                "DELETE FROM students WHERE id=?");
                        ps3.setInt(1, did);

                        int del = ps3.executeUpdate();
                        if (del > 0)
                            System.out.println("Student Deleted!");
                        else
                            System.out.println("Student Not Found!");
                        break;

                    // 🔹 VIEW ALL STUDENTS
                    case 4:
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery("SELECT * FROM students");

                        System.out.println("\n--- STUDENT LIST ---");
                        while (rs.next()) {
                            System.out.println(
                                    rs.getInt("id") + " | " +
                                    rs.getString("name") + " | " +
                                    rs.getString("course") + " | " +
                                    rs.getDouble("marks"));
                        }
                        break;

                    // 🔹 EXIT
                    case 5:
                        System.out.println("Thank you!");
                        con.close();
                        sc.close();
                        System.exit(0);

                    default:
                        System.out.println("Invalid Choice!");
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
