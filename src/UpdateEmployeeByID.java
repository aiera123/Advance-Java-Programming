import java.sql.*;
import java.util.Scanner;

public class UpdateEmployeeByID {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/companydb", "root", ""
            );
            System.out.print("Enter Employee ID to retrieve: ");
            int empId = sc.nextInt();
            sc.nextLine();
            pstmt = con.prepareStatement(
                "SELECT * FROM emp WHERE id = ?",
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE
            );
            pstmt.setInt(1, empId);

            rs = pstmt.executeQuery();

            if (!rs.next()) {
                System.out.println("No employee found with ID " + empId);
            } else {
                System.out.println("\nBefore Update:");
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Designation: " + rs.getString("designation"));
                System.out.println("Salary: " + rs.getDouble("salary"));
                System.out.print("\nEnter new name: ");
                String newName = sc.nextLine();

    
                rs.updateString("name", newName);
                rs.updateRow();

                System.out.println("\nRecord Updated Successfully!");
                System.out.println("\nAfter Update:");
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Designation: " + rs.getString("designation"));
                System.out.println("Salary: " + rs.getDouble("salary"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (pstmt != null) pstmt.close(); } catch (Exception e) {}
            try { if (con != null) con.close(); } catch (Exception e) {}
        }
    }
}


