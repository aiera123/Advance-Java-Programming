import java.sql.*;

public class DisplayEmployee {
    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/companydb", "root", ""
            );
            stmt = con.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY
            );

            rs = stmt.executeQuery("SELECT * FROM emp");

            System.out.println("---- First Record ----");
            if (rs.first()) {
                System.out.println(
                    rs.getInt("id") + "\t" +
                    rs.getString("name") + "\t" +
                    rs.getString("designation") + "\t" +
                    rs.getDouble("salary")
                );
            }

            System.out.println("\n---- Last Record ----");
            if (rs.last()) {
                System.out.println(
                    rs.getInt("id") + "\t" +
                    rs.getString("name") + "\t" +
                    rs.getString("designation") + "\t" +
                    rs.getDouble("salary")
                );
            }

            System.out.println("\n---- Previous Record ----");
            if (rs.previous()) {
                System.out.println(
                    rs.getInt("id") + "\t" +
                    rs.getString("name") + "\t" +
                    rs.getString("designation") + "\t" +
                    rs.getDouble("salary")
                );
            }

            System.out.println("\n---- Next Record ----");
            if (rs.next()) {
                System.out.println(
                    rs.getInt("id") + "\t" +
                    rs.getString("name") + "\t" +
                    rs.getString("designation") + "\t" +
                    rs.getDouble("salary")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
